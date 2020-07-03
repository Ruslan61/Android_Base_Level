package com.geekbrains.a1l1_helloworld.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geekbrains.a1l1_helloworld.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class CityActivity extends AppCompatActivity {
    public final static String cityActivityDataKey = "cityActivityDataKey";
    private RecyclerView recyclerView;
    private TextInputEditText inputCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_layout);
        initViews();
        setupRecyclerView();
        setOnClickListenerForSelectBtn();
        showSelectedCity();
    }

    private void checkCityField() {
        inputCity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) v;
            }
        });
    }

    private void setupRecyclerView() {
        String[] cityList = getResources().getStringArray(R.array.cities);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        RecyclerDataAdapter adapter = new RecyclerDataAdapter(cityList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void setOnClickListenerForSelectBtn() {
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

    private void showSelectedCity() {
        findViewById(R.id.outline_white).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Action Clicked",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }

    private void initViews() {
        inputCity = findViewById(R.id.inputCity);
        recyclerView = findViewById(R.id.recyclerView);
    }
}
