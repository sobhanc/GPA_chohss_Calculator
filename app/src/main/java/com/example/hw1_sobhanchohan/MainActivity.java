package com.example.hw1_sobhanchohan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables
    EditText c1, c2, c3, c4, c5;
    TextView gpa;
    Button button;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        c1 = (EditText)findViewById(R.id.c1);
        c2 = (EditText)findViewById(R.id.c2);
        c3 = (EditText)findViewById(R.id.c3);
        c4 = (EditText)findViewById(R.id.c4);
        c5 = (EditText)findViewById(R.id.c5);
        gpa = (TextView)findViewById(R.id.gpa);

        gpa.setBackgroundColor(Color.WHITE);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                double grade1, grade2, grade3, grade4, grade5;

                if (count % 2 == 0) {
                    if (c1.getText().toString().equals("") || c2.getText().toString().equals("") || c3.getText().toString().equals("") || c4.getText().toString().equals("") || c5.getText().toString().equals("")) {
                        gpa.setText("Please enter all grades");
                    } else {
                        grade1 = Double.parseDouble(c1.getText().toString());
                        grade2 = Double.parseDouble(c2.getText().toString());
                        grade3 = Double.parseDouble(c3.getText().toString());
                        grade4 = Double.parseDouble(c4.getText().toString());
                        grade5 = Double.parseDouble(c5.getText().toString());

                        //average calculation
                        Double average = grade1 + grade2 + grade3 + grade4 + grade5;
                        average = average / 5;

                        if(average < 60) {
                            gpa.setText(Double.toString(average));
                            gpa.setBackgroundColor(Color.RED);
                        } else if (average > 60 && average < 80) {
                            gpa.setText(Double.toString(average));
                            gpa.setBackgroundColor(Color.YELLOW);
                        } else if (average >= 80 && average <= 100) {
                            gpa.setText(Double.toString(average));
                            gpa.setBackgroundColor(Color.GREEN);
                        }

                        count++; //sets count value to 1
                        button.setText("Clear");

                    }
                } else {
                    //Clear fields
                    c1.setText("");
                    c2.setText("");
                    c3.setText("");
                    c4.setText("");
                    c5.setText("");
                    gpa.setText("");
                    gpa.setBackgroundColor(Color.WHITE);
                    button.setText("Compute GPA");
                    count++; //sets count value to 2
                }
            }
        });


    }
}