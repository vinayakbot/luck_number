package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView welcomeTxt , luckyNumberText;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent i = getIntent();
        String userName = i.getStringExtra("name");


        setContentView(R.layout.activity_main2);

        welcomeTxt = findViewById(R.id.textView2);

        luckyNumberText = findViewById(R.id.luckyNumber);


        btn = findViewById(R.id.luckNumberButton);
welcomeTxt.setText( userName.toString() +  " lucky number is");

        int data =  generateRandomNumber();

luckyNumberText.setText(""+data);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        shareData(userName, data);
    }
});

    }

    public  int generateRandomNumber(){
            Random random = new Random();
            int uperLimit = 10;
            int randomNumberGenerated = random.nextInt(uperLimit);

            return  randomNumberGenerated;
    }

    public void shareData( String userName , int num ){


        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, num);

        startActivity(Intent.createChooser(i , "Choose Platform"));
    }

}