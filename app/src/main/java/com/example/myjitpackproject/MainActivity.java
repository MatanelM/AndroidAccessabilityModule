package com.example.myjitpackproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.textaccessability.AccessibleTextView;
import com.example.textaccessability.TextSizeFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private AccessibleTextView accessibleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextSizeFragment fragment = new TextSizeFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, fragment, "TextSizeFragment")
                .commit();

        accessibleTextView = findViewById(R.id.access_text_view);


        Button secondActivityButton = findViewById(R.id.second_activity_button);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}