package com.example.textaccessability;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.content.res.TypedArray;
import androidx.appcompat.widget.AppCompatCheckBox;

import java.util.ArrayList;

public class AccessibleCheckBox extends AppCompatCheckBox {

    private static final int[] textSizeArray = new int[]{16, 20, 24};

    public AccessibleCheckBox(Context context) {
        super(context);
    }

    public AccessibleCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public static void updateCheckboxes(ArrayList<AccessibleCheckBox> cbs, int type) {
        cbs.forEach(cb -> cb.setTextSizeFromType(type));

    }
    public AccessibleCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeArray[getSavedTextSizeType()]);
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
        return sharedPreferences.getInt("textSizeType", 0); // default is 0 (normal)
    }

}
