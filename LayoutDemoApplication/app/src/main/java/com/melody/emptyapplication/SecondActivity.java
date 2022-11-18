package com.melody.emptyapplication;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    /**
     * 视图界面相关
     *
     * @param savedInstanceState
     */
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

    /**
     * 界面初始化完成，事件监听等
     */
    @Override
    protected void onStart() {
        super.onStart();

        Button btn = findViewById(R.id.btn_return);
        if (btn != null) {
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick");
                    SecondActivity.this.finish();
                }
            });
        }
    }
}