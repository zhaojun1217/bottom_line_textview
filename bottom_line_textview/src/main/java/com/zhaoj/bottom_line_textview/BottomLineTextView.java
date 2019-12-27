package com.zhaoj.bottom_line_textview;

import androidx.annotation.Nullable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zhaoj on 2019/11/11.
 */
public class BottomLineTextView extends LinearLayout {
    Context mContext;
    private TextView tvText;
    private View vLineView;

    private String defaultText = "";
    private int textColor = Color.BLACK;
    private int lineColor = Color.BLACK;
    private boolean showLine = true;
    private int textSize = 15;

    public BottomLineTextView(Context context) {
        super(context);
        mContext = context;
    }

    public BottomLineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.bottom_line_text);
        defaultText = ta.getString(R.styleable.bottom_line_text_bottomLineDefaultText);
        textSize = ta.getInteger(R.styleable.bottom_line_text_bottomLineTextSize, 15);
        textColor = ta.getColor(R.styleable.bottom_line_text_bottomLineTextColor, Color.BLACK);
        lineColor = ta.getColor(R.styleable.bottom_line_text_bottomLineLineColor, Color.BLACK);
        showLine = ta.getBoolean(R.styleable.bottom_line_text_bottomLineShowLine, true);
        initView();
        initStyle();
        initEvent();
    }

    public void setText(String str) {
        tvText.setText(str);
    }

    public void setTextColor(int color)
    {
        tvText.setTextColor(color);
    }

    public void setVLineColor(int color)
    {
        vLineView.setBackgroundColor(color);
    }

    private void initStyle() {
        tvText.setText(defaultText);
        tvText.setTextColor(textColor);
        tvText.setTextSize(textSize);
        vLineView.setVisibility(showLine ? VISIBLE : GONE);
        vLineView.setBackgroundColor(lineColor);
    }

    private void initEvent() {

    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_bottomlinetext, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvText = view.findViewById(R.id.tvText);
        vLineView = view.findViewById(R.id.vView);
        addView(view, lp);
    }


}
