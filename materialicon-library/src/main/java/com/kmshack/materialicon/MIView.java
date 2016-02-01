package com.kmshack.materialicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by kmshack on 2016. 1. 29..
 */
public class MIView extends TextView {

    private static Typeface sTypeface;

    public MIView(Context context) {
        super(context);
        init(context);
    }

    public MIView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MIView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context){
        if(sTypeface == null)
            sTypeface = Typeface.createFromAsset(context.getAssets(), "MaterialIcons-Regular.ttf");
    }

    private void init(Context context, AttributeSet attrs){
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MIView);

        String name = array.getString(R.styleable.MIView_iconName);
        setIcon(name);

        int color = array.getColor(R.styleable.MIView_iconColor, Color.BLACK);
        setColor(color);

        int size = array.getDimensionPixelSize(R.styleable.MIView_iconSize, -1);

        if(size >= 0)
            setSize(size);

        array.recycle();


        setTypeface(sTypeface);

    }

    public void setIcon(String name){
        this.setText(name);
    }

    public void setColor(int color){
        this.setTextColor(color);
    }

    public void setSize(int dp){
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, dp);
    }

}
