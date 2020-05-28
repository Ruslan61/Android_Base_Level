package com.geekbrains.a1l1_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityActivity extends AppCompatActivity {

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

//        Button selectCity = findViewById(R.id.select);
//        selectCity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText txtInputCity = CityActivity.this.findViewById(R.id.inputCity);
//                Intent intent = new Intent(CityActivity.this, MainActivity.class);
//                intent.putExtra(TEXT, txtInputCity.getText().toString());
//                startActivity(intent);
//            }
//        });
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

//    public interface Constants {
//        String TEXT = "TEXT";
//    }
}
