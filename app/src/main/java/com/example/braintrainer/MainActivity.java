package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button start;
    Button play_again;
    TextView number1;
    TextView number2;
    TextView number3;
    TextView number4;
    TextView digit1;
    TextView digit2;
    TextView time;
    TextView score;
    TextView answer_text;
    TextView symbol1;
    TextView symbol2;
    Random random;
    String x;
    int success=0;
    int Total=-1;
    Boolean time_start = true;
    Boolean game_start = true;

    public void click(View view){
        if(time_start) {
            count_down();
        }
        String tag = view.getTag().toString();
        if(tag.equals(x)){
            answer_text.setVisibility(View.VISIBLE);
            success++;
            answer_text.setText("CORRECT:)");
        }
        else if(tag.equals("5")){
            answer_text.setVisibility(View.INVISIBLE);
        }
        else{
            answer_text.setVisibility(View.VISIBLE);
            answer_text.setText("WRONG:(");
        }
        Total++;
        if(game_start) {
            score.setText(Integer.toString(success) + "/" + Integer.toString(Total));
        }
        time.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        digit1.setVisibility(View.VISIBLE);
        digit2.setVisibility(View.VISIBLE);
        number1.setVisibility(View.VISIBLE);
        number2.setVisibility(View.VISIBLE);
        number3.setVisibility(View.VISIBLE);
        number4.setVisibility(View.VISIBLE);
        symbol1.setVisibility(View.VISIBLE);
        symbol2.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);

        random = new Random();
        int randomNumber1 = random.nextInt(50);
        int randomNumber2 = random.nextInt(50);
        int randomNumber3 = random.nextInt(100);
        int randomNumber4 = random.nextInt(100);
        int randomNumber5 = random.nextInt(100);
        int randomNumber6 = random.nextInt(100);
        int rand = random.nextInt(4)+1;

        int ans = randomNumber1+randomNumber2;

        digit1.setText(Integer.toString(randomNumber1));
        digit2.setText(Integer.toString(randomNumber2));
        number1.setText(Integer.toString(randomNumber3));
        number2.setText(Integer.toString(randomNumber4));
        number3.setText(Integer.toString(randomNumber5));
        number4.setText(Integer.toString(randomNumber6));

        switch(rand){
            case 1:
                number1.setText(Integer.toString(ans));
                break;
            case 2:
                number2.setText(Integer.toString(ans));
                break;
            case 3:
                number3.setText(Integer.toString(ans));
                break;
            case 4:
                number4.setText(Integer.toString(ans));
                break;
            default:
                break;
        }
        x = Integer.toString(rand);
    }

    public void count_down(){
        CountDownTimer timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long remaining = millisUntilFinished/1000;
                time.setText(Long.toString(remaining));
                time_start=false;
            }
            @Override
            public void onFinish() {
                Log.i("FINISH CONFIRMATION: ","FINISHED");
                game_start=false;
                digit1.setVisibility(View.INVISIBLE);
                digit2.setVisibility(View.INVISIBLE);
                symbol1.setVisibility(View.INVISIBLE);
                symbol2.setVisibility(View.INVISIBLE);
                number1.setVisibility(View.INVISIBLE);
                number2.setVisibility(View.INVISIBLE);
                number3.setVisibility(View.INVISIBLE);
                number4.setVisibility(View.INVISIBLE);
                answer_text.setText("WELL DONE!!");
                play_again.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void play_again(View view){
        success=0;
        Total=-1;
        time_start = true;
        game_start = true;
        click(view);
        score.setText("0/0");
        play_again.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.time_text);
        score = findViewById(R.id.score_text);
        digit1 = findViewById(R.id.digit_1_text);
        digit2 = findViewById(R.id.digit_2_text);
        number1 = findViewById(R.id.number_1);
        number2 = findViewById(R.id.number_2);
        number3 = findViewById(R.id.number_3);
        number4 = findViewById(R.id.number_4);
        start = findViewById(R.id.start_button);
        play_again = findViewById(R.id.play_again);
        answer_text = findViewById(R.id.answer_text);
        symbol1 = findViewById(R.id.symbol1);
        symbol2 = findViewById(R.id.symbol2);
    }
}