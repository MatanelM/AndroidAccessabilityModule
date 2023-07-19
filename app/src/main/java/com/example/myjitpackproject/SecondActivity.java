package com.example.myjitpackproject;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.textaccessability.AccessibleTextView;
import com.example.textaccessability.TextSizeFragment;

public class SecondActivity extends AppCompatActivity {

    private AccessibleTextView accessibleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        accessibleTextView = findViewById(R.id.second_access_text_view);

        TextSizeFragment fragment = new TextSizeFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, fragment, "TextSizeFragment")
                .commit();
    }
}