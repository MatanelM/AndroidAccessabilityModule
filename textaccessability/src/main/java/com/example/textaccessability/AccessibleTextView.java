package com.example.textaccessability;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

import java.util.ArrayList;


public class AccessibleTextView extends androidx.appcompat.widget.AppCompatTextView {

    private static final int[] textSizeArray = new int[]{16, 20, 24};
    private final int mTextSize = 0;

    public AccessibleTextView(Context context) {
        super(context);
    }

    public AccessibleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AccessibleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AccessibleTextView);
        try {
            int textSizeType = a.getInteger(R.styleable.AccessibleTextView_textSizeType, 0);
//            setTextSizeFromType(textSizeType);
            setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeArray[getSavedTextSizeType()]);

        } finally {
            a.recycle();
        }

        float textSizeNormal = getResources().getDimension(R.dimen.text_size_normal);
        float textSizeBig = getResources().getDimension(R.dimen.text_size_big);
        float textSizeHuge = getResources().getDimension(R.dimen.text_size_huge);
    }
    public static void updateAccessabilityTexts(ArrayList<AccessibleTextView> texts, int type){
        texts.forEach(t -> t.setTextSizeFromType(type));
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
