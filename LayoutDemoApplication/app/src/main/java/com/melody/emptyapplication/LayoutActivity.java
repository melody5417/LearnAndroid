package com.melody.emptyapplication;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

public class LayoutActivity extends AppCompatActivity {

    private static final String TAG = "LayoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.buttonFragment, new ButtonFragment()).commitNow();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btn = (Button)findViewById(R.id.fragmentBtn);
        if (btn != null) {
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick");
                    LayoutActivity.this.finish();
                }
            });
        }

        Button changeBtn = (Button)findViewById(R.id.fragmentChangeBtn);
        if (changeBtn != null) {
            changeBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView txtView = findViewById(R.id.fragmentTitle);
                    txtView.setText(R.string.new_blank_fragment);
                }
            });
        }
    }
}