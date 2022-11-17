package com.melody.emptyapplication;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("SecondActivity", "onCreate");

        Intent intent = getIntent();
        if (intent != null) {
            String input = intent.getStringExtra("input");
            TextView textView = findViewById(R.id.text_view_show);
            textView.setText(input);
        }
    }

}