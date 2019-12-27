package com.zhaoj.jitpack_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zhaoj.bottom_line_textview.BottomLineTextView;

public class MainActivity extends AppCompatActivity {

    private BottomLineTextView bltTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bltTest = findViewById(R.id.bltTest);

        bltTest.setText("测试的文本ss");
        bltTest.setLineColor(0xff00ff00);
        bltTest.setShowLine(true);
        bltTest.setTextSize(20);
        bltTest.setLineSize(4);
        bltTest.setTextBold(true);
        bltTest.setTextColor(0xff00ff00);
    }
}
