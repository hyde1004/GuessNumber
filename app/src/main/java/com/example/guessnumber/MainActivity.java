package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int MIN_NUM = 1;
    private int MAX_NUM = 1000;
    private EditText mNumber;
    private TextView mResult;
    private int randomInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomInt = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
        mNumber = (EditText) findViewById(R.id.editTextNumber);
        mResult = (TextView) findViewById(R.id.textViewResult);

        Log.d("GuessNumber", "randomInt:" + randomInt);



    }

    public void inputNumber(View view) {
        int input_number = Integer.parseInt(mNumber.getText().toString());
        mResult.setTextColor(Color.parseColor("#0000ff"));
        if (randomInt > input_number ) {
            mResult.setText(input_number + "보다 더 큰 수입니다.");
        } else if ( randomInt < input_number) {
            mResult.setText(input_number + "보다 더 작은 수입니다.");
        } else {
            mResult.setText("정답입니다.");
        }

        mNumber.setText("");

    }
}