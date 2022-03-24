package com.aom.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button bSpending,bAddList,bRecorded;
    ImageButton bSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        bSpending = findViewById(R.id.btSpending);
        bAddList = findViewById(R.id.btAddList);
        bRecorded = findViewById(R.id.btRecorded);
        bSetting = findViewById(R.id.btSetting);
        event();
    }

    private void event(){
        bSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSpending = new Intent(getApplicationContext(),SpendingActivity.class);
                startActivity(intentSpending);
            }
        });

        bAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddlist = new Intent(getApplicationContext(),AddlistActivity.class);
                startActivity(intentAddlist);
            }
        });

        bRecorded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecorded = new Intent(getApplicationContext(),RecordedActivity.class);
                startActivity(intentRecorded);
            }
        });

        bSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intentSetting);
            }
        });
    }
}