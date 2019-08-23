package com.example.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView v1, v2, v3, v4, questionShow, result;
    private Question question;
    private String answer;
    private int number = 0, rightAnswers = 0, allQuestions = 0;
    private Button restart;
    private LinearLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = findViewById(R.id.v1);
        v1.setOnClickListener(this);
        v2 = findViewById(R.id.v2);
        v2.setOnClickListener(this);
        v3 = findViewById(R.id.v3);
        v3.setOnClickListener(this);
        v4 = findViewById(R.id.v4);
        v4.setOnClickListener(this);

        questionShow = findViewById(R.id.question);
        result = findViewById(R.id.result);
        restart = findViewById(R.id.restart);
        mainlayout = findViewById(R.id.main_layout);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = 0;
                rightAnswers = 0;
                allQuestions = 0;
                mainlayout.setVisibility(View.VISIBLE);
                result.setVisibility(View.INVISIBLE);
                restart.setVisibility(View.INVISIBLE);
                showQuestion(number);
                System.out.println(number);
            }
        });
        question = new Question(getQuestionsAndAnswersFromFile(), getVariantsFromFile());
        showQuestion(number);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.v1:
                if (v1.getText().equals(answer)) {
                    rightAnswers++;
                    allQuestions++;
                    showQuestion(number);
                } else {
                    showQuestion(number);
                    allQuestions++;
                }
                break;
            case R.id.v2:
                if (v2.getText().equals(answer)) {
                    rightAnswers++;
                    allQuestions++;
                    showQuestion(number);
                } else {
                    showQuestion(number);
                    allQuestions++;
                }
                break;
            case R.id.v3:
                if (v3.getText().equals(answer)) {
                    rightAnswers++;
                    allQuestions++;
                    showQuestion(number);
                } else {
                    showQuestion(number);
                    allQuestions++;
                }
                break;
            case R.id.v4:
                if (v4.getText().equals(answer)) {
                    rightAnswers++;
                    allQuestions++;
                    showQuestion(number);
                } else {
                    showQuestion(number);
                    allQuestions++;
                }
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void showQuestion(int gbc) {

        if (number < getVariantsFromFile().length) {
            v1.setText(question.getVariant1(gbc));
            v2.setText(question.getVariant2(gbc));
            v3.setText(question.getVariant3(gbc));
            v4.setText(question.getVariant4(gbc));

            questionShow.setText(question.getQuestions(gbc));
            answer = question.getCorrectAnswer(gbc);
            number++;
        } else {
            result.setText("Test is finished \n Your result: " + rightAnswers + "/" + allQuestions);
            mainlayout.setVisibility(View.INVISIBLE);
            result.setVisibility(View.VISIBLE);
            restart.setVisibility(View.VISIBLE);
        }
    }

    //---------------------------------------------------
    private String[][] getQuestionsAndAnswersFromFile() {
        InputStream inputStream;
        inputStream = this.getResources().openRawResource(R.raw.lilpeep);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String fileAsString;
        try {
            String info = br.readLine();
            while (info != null) {
                sb.append(info).append("\n");
                info = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("THERE IS ERROR");
        }
        fileAsString = sb.toString();

        return takeArray(fileAsString);
    }

    private String[][] getVariantsFromFile() {
        InputStream inputStream;
        inputStream = this.getResources().openRawResource(R.raw.lilpeep_variants);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String fileAsString;
        try {
            String info = br.readLine();
            while (info != null) {
                sb.append(info).append("\n");
                info = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("THERE IS ERROR");
        }
        fileAsString = sb.toString();

        return takeArray(fileAsString);
    }

    private String[][] takeArray(String input) {
        String[] firstSplit = input.split("\n");
        String[][] allInfo = new String[firstSplit.length][firstSplit[0].length()];
        for (int i = 0; i < firstSplit.length; i++) {
            for (int j = 0; j < firstSplit[i].split(" / ").length; j++) {
                allInfo[i][j] = firstSplit[i].split(" / ")[j];
            }
        }
        return allInfo;
    }
}
