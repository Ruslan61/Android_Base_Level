package com.geekbrains.a1l1_helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView helloWorldTextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnButtonClickListener();
    }

    private void initView(){
        helloWorldTextView = findViewById(R.id.helloWorldTextView);
        button = findViewById(R.id.button);
    }

    private void setOnButtonClickListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getString(R.string.hello_first_lesson);
                int color = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDark);
                helloWorldTextView.setText(text);
                helloWorldTextView.setTextColor(color);
            }
        });
    }

}
