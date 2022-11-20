package com.melody.emptyapplication;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.melody.emptyapplication.InterfaceFragment.TitleClickedEvent;

public class SecondActivity extends AppCompatActivity implements TitleClickedEvent {

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

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, InterfaceFragment.class, null)
                    .commit();
        }

        Intent intent = getIntent();
        if (intent != null) {
            String input = intent.getStringExtra("input");
            TextView textView = findViewById(R.id.text_view_show);
            if (textView != null) {
                textView.setText(input);
            }
        }
    }

    /**
     * 界面初始化完成，事件监听等
     * 由activity进行fragment的事件处理
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

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof InterfaceFragment) {
            InterfaceFragment f = (InterfaceFragment)fragment;
            f.setEvent(this);
        }
    }

    @Override
    public void onTitleClickListener(String title) {
        Log.d(TAG, "onTitleClickListener " + title);
        TextView textView = findViewById(R.id.text_view_show);
        if (textView != null) {
            textView.setText(title);
        }
    }
}