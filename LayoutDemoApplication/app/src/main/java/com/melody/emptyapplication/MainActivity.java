package com.melody.emptyapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG + " LifeCycle", "onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG + " LifeCycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG + " LifeCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG + " LifeCycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG + " LifeCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG + " LifeCycle", "onDestroy");
    }

    public void handleClick(View v) {
        Log.d(TAG, "handleClick");

        if (v.getId() == R.id.send) {
            EditText editText = findViewById(R.id.input);
            String inputText = editText.getText().toString();
            Log.d(TAG, "Input is " + inputText);

            // 显示启动1 class跳转
//        Intent intent = new Intent(this, SecondActivity.class);

            // 显示启动2 包名.类名
//        Intent intent = new Intent();
//        intent.setClassName(this, "com.melody.emptyapplication.SecondActivity");

//        // 显示启动3 componentName
//        Intent intent = new Intent();
//        ComponentName cName = new ComponentName(this, SecondActivity.class);
//        intent.setComponent(cName);

            // 隐式启动 action 配置在manifest里
            // 只适用于 category 为 DEFAULT
            Intent intent = new Intent("action.secondAction");

            intent.putExtra("input", inputText);
            startActivity(intent);
        } else if (v.getId() == R.id.goLayout) {
            Intent intent = new Intent(this, LayoutActivity.class);
            startActivity(intent);
        }
    }
}