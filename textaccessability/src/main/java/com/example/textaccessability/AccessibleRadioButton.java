package com.example.textaccessability;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.content.res.TypedArray;
import androidx.appcompat.widget.AppCompatRadioButton;

import java.util.ArrayList;

public class AccessibleRadioButton extends AppCompatRadioButton {

    private static final int[] textSizeArray = new int[]{16, 20, 24};

    public AccessibleRadioButton(Context context) {
        super(context);
    }

    public AccessibleRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AccessibleRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeArray[getSavedTextSizeType()]);
    }
    public static void updateRadioButtons(ArrayList<AccessibleRadioButton> rbs, int type){
        rbs.forEach(rb -> rb.setTextSizeFromType(type));
    }
    public void setTextSizeFromType(int type) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("text_accessability_db", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("textSizeType", type);
        editor.apply();
        setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeArray[getSavedTextSizeType()]);
    }

    private int getSavedTextSizeType() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("text_accessability_db", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("textSizeType", 0); // default is 0 (normalHere are the continuation of the code for the remaining two components, Switch and Slider.
    }
}