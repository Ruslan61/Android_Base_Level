package com.geekbrains.a1l1_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityActivity extends AppCompatActivity {
    //
    public final static String cityActivityDataKey = "cityActivityDataKey";

    private Button select;
    private EditText inputCity;
    private TextView moscow;
    private TextView st_petersburg;
    private TextView rostov_na_donu;
    private TextView stavropol;
    private TextView vladivostok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        setContentView(R.layout.activity_city);
        setOnClickListenerForSelectBtn();
    }

    private void setOnClickListenerForSelectBtn() {
        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(cityActivityDataKey, (Parcelable) inputCity);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    private void initViews() {
        select = findViewById(R.id.select);
        inputCity = findViewById(R.id.inputCity);
        moscow = findViewById(R.id.textViewMoscow);
        st_petersburg = findViewById(R.id.textViewPeter);
        rostov_na_donu = findViewById(R.id.textViewRostov);
        stavropol = findViewById(R.id.textViewStavropol);
        vladivostok = findViewById(R.id.textViewVladivostok);
    }
}
