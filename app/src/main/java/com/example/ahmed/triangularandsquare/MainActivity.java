package com.example.ahmed.triangularandsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    class Number{

        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;
            } else {

                return false;

            }

        }

        public boolean isTriangular(){

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {

                return true;

            } else {
                return false;
            }

        }

    }


    public void provjeri (View view){


        EditText editText = (EditText) findViewById(R.id.userNumber);

        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.println("Please input an integer");
            //nextInt will throw InputMismatchException
            //if the next token does not match the Integer
            //regular expression, or is out of range

        }
        catch(InputMismatchException exception)
        {
            //Print "This is not an integer"
            //when user put other than integer
            System.out.println("This is not an integer");
        }


        String  message = editText.getText().toString();




        if(editText.getText().toString().isEmpty()){
            message = "Unesi broj";
        }else{

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(editText.getText().toString());

            if (myNumber.isSquare() && myNumber.isTriangular()) {

                message += " je kvadratni i triangularni.";
            } else if (myNumber.isSquare()) {
                message += " je kvadtratni ali ne triangularni.";
            } else if (myNumber.isTriangular()) {
                message += " je triangularni ali ne kvadratni.";
            } else {
                message += " nije ni kvadratni ni triangularni.";
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
