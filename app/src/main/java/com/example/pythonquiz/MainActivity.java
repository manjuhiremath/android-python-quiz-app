package com.example.pythonquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions={"1.Python is a high-level, interpreted, general-purpose programming language?", "2.Wick van Rossum developed Python Programming Language?", "3.Does Python supports object oriented programming?", "4.Is '.py' is extension of Python file?", "5.Is seed() function is builtin function in Python?"};
    private Boolean[] answers={true,false,true,true,false};
    private int index = 0;
    private int score = 0;
    ImageView imageView;
    Button Yes;
    Button No;
    TextView question;
    Button restart;
    Button code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Yes=findViewById(R.id.Yes);
        No=findViewById(R.id.No);
        question=findViewById(R.id.question);
        question.setText(questions[index]);
        restart=findViewById(R.id.restart);
        imageView=findViewById(R.id.imageView);
        code=findViewById(R.id.code);

        
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1){
                    if (answers[index] == true) {
                        score++;
                    }
                    index++;
                        if(index <= questions.length -1){
                            question.setText(questions[index]);
                        }
                    else{
                        Toast.makeText(MainActivity.this, "your score is:" +score +"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                    else{
                    AlertDialog.Builder dm=new AlertDialog.Builder(MainActivity.this);
                    dm.setMessage("Press restart to try again");
                    AlertDialog a1 = dm.create();
                    a1.show();
                    }

            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index <= questions.length - 1){
                    if (answers[index]==false) {
                        score++;
                    }
                    index++;
                    if(index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is:" +score +"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart successful!", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Restart successful!", Toast.LENGTH_SHORT).show();


                finish();
                startActivity(getIntent());


            }
        });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Restart successful!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            });
            code.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent code = new Intent(MainActivity.this,codingquiz.class);
                    startActivity(code);
                }
            });
        }
}
