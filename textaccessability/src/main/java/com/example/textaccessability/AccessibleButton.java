package com.example.textaccessability;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.content.res.TypedArray;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;

public class AccessibleButton extends AppCompatButton {

    private static final int[] textSizeArray = new int[]{16, 20, 24};
    private final int mTextSize = 0;

    public AccessibleButton(Context context) {
        super(context);
    }

    public AccessibleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AccessibleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeArray[getSavedTextSizeType()]);

        float textSizeNormal = getResources().getDimension(R.dimen.text_size_normal);
        float textSizeBig = getResources().getDimension(R.dimen.text_size_big);
        float textSizeHuge = getResources().getDimension(R.dimen.text_size_huge);
    }
    public static void updateButtons(ArrayList<AccessibleButton> buttons, int type) {
        buttons.forEach(b -> b.setTextSizeFromType(type));

    }
    public void setTextSizeFromType(int type) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("text_accessability_db", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("textSizeType", type);
        editor.apply();
        editor.commit();
        setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeArray[getSavedTextSizeType()]);
    }

    private int getSavedTextSizeType() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("text_accessability_db", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("textSizeType", 0); // default is 0 (normal)
    }

}
