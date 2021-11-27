package com.example.pythonquiz;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class codingquiz extends AppCompatActivity {
    private String[] questions={"1.  Is this code executable?\n" +
                                    "=>\n" +
                                    "   printf(\"Hello, World!\")",
                                    "2. String variables can be declared either by using single or double quotes.As given below?\n" +
                                            "=> \n"+
                                    "   x = \"John\"\n" +
                                    "   x = 'John'",
                                    "3.\n" +
                                            "\n"+
                                            "    a = 4\n" +
                                        "    A = \"Sally\"\n" +
                                            "\n" +
                                    "Is this code Executable?",
                                    "4.\n " +
                                            "    i = 1\n" +
                                            "    while i < 6\n" +
                                            "      print(i)\n" +
                                            "      i += 1",
                                    "5."+   "try:\n" +
                                            "  f = open(\"demofile.txt\")\n" +
                                            "  try:\n" +
                                            "    f.write(\"Lorum Ipsum\")\n" +
                                            "  except:\n" +
                                            "    print(\"Something went wrong when writing to the file\")\n" +
                                            "  finally:\n" +
                                            "    f.close()\n" +
                                            "except:\n" +
                                            "  print(\"Something went wrong when opening the file\")\n" +
                                            "\n" +
                                            "\n" +
                                                ":->Executes with no Errors."};
    private Boolean[] answers={false,true,true,false,true};
    private int index = 0;
    private int score = 0;

    Button Yes;
    Button No;
    TextView question;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codingquiz);
        Yes=findViewById(R.id.Yes);
        No=findViewById(R.id.No);
        question=findViewById(R.id.question);
        question.setText(questions[index]);
        restart=findViewById(R.id.restart);
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
                        Toast.makeText(codingquiz.this, "your score is:" +score +"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(codingquiz.this, "Press Restart to try again!", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(codingquiz.this, "Your score is:" +score +"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(codingquiz.this, "Press Restart to try again!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(codingquiz.this, "Restart successful!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
                

            }
        });



    }
}