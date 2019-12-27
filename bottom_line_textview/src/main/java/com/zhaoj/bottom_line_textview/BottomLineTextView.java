package com.zhaoj.bottom_line_textview;

import androidx.annotation.Nullable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
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
    private boolean textBold = false;
    private int textSize = 15;
    private int lineSize = 1;

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
        lineSize = ta.getInteger(R.styleable.bottom_line_text_bottomLineLineSize, 1);
        textColor = ta.getColor(R.styleable.bottom_line_text_bottomLineTextColor, Color.BLACK);
        lineColor = ta.getColor(R.styleable.bottom_line_text_bottomLineLineColor, Color.BLACK);
        showLine = ta.getBoolean(R.styleable.bottom_line_text_bottomLineShowLine, true);
        textBold = ta.getBoolean(R.styleable.bottom_line_text_bottomLineTextBold, false);
        initView();
        initStyle();
        initEvent();
    }

    /**
     * 设置文本
     *
     * @param str 文本
     */
    public void setText(String str) {
        tvText.setText(str);
    }

    /**
     * 设置文本颜色
     *
     * @param color 文本颜色
     */
    public void setTextColor(int color) {
        tvText.setTextColor(color);
    }

    /**
     * 设置下划线颜色
     *
     * @param color 下划线颜色
     */
    public void setLineColor(int color) {
        vLineView.setBackgroundColor(color);
    }

    /**
     * 设置是否隐藏下划线
     *
     * @param setShowLine 是否隐藏下划线
     */
    public void setShowLine(boolean setShowLine) {
        this.showLine = setShowLine;
        vLineView.setVisibility(showLine ? VISIBLE : GONE);
    }

    /**
     * 粗体设置
     *
     * @param setTextBold bool值 是否加粗文本
     */
    public void setTextBold(boolean setTextBold) {
        this.textBold = setTextBold;
        tvText.getPaint().setFakeBoldText(textBold);//加粗
    }

    /**
     * 设置文本字号
     *
     * @param setTextSize 文本字号
     */
    public void setTextSize(int setTextSize) {
        this.textSize = setTextSize;
        tvText.setTextSize(textSize);
    }

    /**
     * 设置下划线宽度
     *
     * @param setLineSize 下划线宽度
     */
    public void setLineSize(int setLineSize) {
        this.lineSize = setLineSize;
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(mContext, lineSize));
        vLineView.setLayoutParams(params);
    }


    private void initStyle() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(mContext, lineSize));
        tvText.setText(defaultText);
        tvText.setTextColor(textColor);
        tvText.setTextSize(textSize);
//        tvText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
        tvText.getPaint().setFakeBoldText(textBold);//加粗
        vLineView.setVisibility(showLine ? VISIBLE : GONE);
        vLineView.setBackgroundColor(lineColor);
        vLineView.setLayoutParams(params);
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

    //dp转px
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //px转dp
    public static int px2dip(Context context, int pxValue) {
        return ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pxValue, context.getResources().getDisplayMetrics()));
    }

}
