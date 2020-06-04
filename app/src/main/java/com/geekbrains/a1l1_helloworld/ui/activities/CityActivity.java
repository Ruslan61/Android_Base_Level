package com.geekbrains.a1l1_helloworld.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.geekbrains.a1l1_helloworld.R;

public class CityActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String cityActivityDataKey = "cityActivityDataKey";
    private EditText inputCity;
    private TextView moscow;
    private TextView stPetersburg;
    private TextView rostovNaDonu;
    private TextView stavropol;
    private TextView vladivostok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initViews();
        setOnClickListenerForSelectBtn();
    }

    private void setOnClickListenerForSelectBtn() {
        moscow.setOnClickListener(CityActivity.this);
        stPetersburg.setOnClickListener(CityActivity.this);
        rostovNaDonu.setOnClickListener(CityActivity.this);
        stavropol.setOnClickListener(CityActivity.this);
        vladivostok.setOnClickListener(CityActivity.this);

        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(cityActivityDataKey, inputCity.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewMoscow:
                inputCity.setText(R.string.city_moscow);
                break;
            case R.id.textViewPeter:
                inputCity.setText(R.string.city_st_petersburg);
                break;
            case R.id.textViewRostov:
                inputCity.setText(R.string.city_rostov_na_donu);
                break;
            case R.id.textViewStavropol:
                inputCity.setText(R.string.city_stavropol);
                break;
            case R.id.textViewVladivostok:
                inputCity.setText(R.string.city_vladivostok);
                break;
        }
    }

    private void initViews() {
        inputCity = findViewById(R.id.inputCity);
        moscow = findViewById(R.id.textViewMoscow);
        stPetersburg = findViewById(R.id.textViewPeter);
        rostovNaDonu = findViewById(R.id.textViewRostov);
        stavropol = findViewById(R.id.textViewStavropol);
        vladivostok = findViewById(R.id.textViewVladivostok);
    }
}
