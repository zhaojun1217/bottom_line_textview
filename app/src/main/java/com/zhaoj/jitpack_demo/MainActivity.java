package com.zhaoj.jitpack_demo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zhaoj.bottom_line_textview.BottomLineTextView;

public class MainActivity extends AppCompatActivity {

    private BottomLineTextView bltTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bltTest = findViewById(R.id.bltTest);

//        bltTest.setText("测试的文本ss");
//        bltTest.setLineColor(0xff00ff00);
//        bltTest.setShowLine(true);
//        bltTest.setTextSize(20);
//        bltTest.setLineSize(4);
//        bltTest.setTextBold(true);
//        bltTest.setTextColor(0xff00ff00);

        bltTest.setText("测试的文本_测试的文本_测试的文本")  // 设置文本        string
                .setTextColor(0xff770000)                // 设置文本颜色    int
                .setLineColor(0xff000044)                // 设置下划线颜色  int
                .setTextBold(true)                       // 是否加粗文本    bool
                .setShowLine(true)                       // 是否隐藏下划线  bool
                .setTextSize(20)                         // 设置文本字号    int
                .setLineSize(0.5f)                       // 设置下划线宽度  float
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,
                                bltTest.getText() + "\n" +
                                        bltTest.getLineColor() + "\n" +
                                        bltTest.getLineSize() + "\n" +
                                        bltTest.getTextColor() + "\n" +
                                        bltTest.getTextSize(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
