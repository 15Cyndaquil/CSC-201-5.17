package com.example.cynda.csc_201_517;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button triangleBT = (Button) findViewById(R.id.triangleBT);

        final TextView outputTV = (TextView) findViewById(R.id.outputTV);

        final EditText inputET = (EditText) findViewById(R.id.inputET);

        triangleBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    outputTV.setText(createTriangle(Integer.parseInt(inputET.getText().toString())));
                }catch(Exception e){outputTV.setText("Invalid Input Type");}
            }
        });
    }

    private static String createTriangle(int input){
        int length = input;
        int setup = 0;
        StringBuffer currentLine = new StringBuffer("");
        StringBuffer output = new StringBuffer("");

        for(int c=1; c<length; length--){
            currentLine.append(length+" ");
        }
        for(int c=input; c>=length; length++){
            currentLine.append(length+" ");
        }
        length = currentLine.length();


        for(int i=1; i<=input; i++) {
            int pyramid = i;

            currentLine.replace(0, currentLine.length(), "");
            for (int c = 1; c < pyramid; pyramid--) {
                currentLine.append(pyramid + " ");
            }
            for (int c = i; c >= pyramid; pyramid++) {
                currentLine.append(pyramid + " ");
            }
            currentLine.replace(currentLine.length() - 1, currentLine.length(), "");


            setup = (length - currentLine.length()) / 2;

            for (int c = 0; c < setup; c++) {
                currentLine.insert(0, " ");
                currentLine.append(" ");
            }
            output.append(currentLine.toString()+"\n");
        }
        return output.toString();
    }
}
