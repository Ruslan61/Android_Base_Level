package com.geekbrains.a1l1_helloworld.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.geekbrains.a1l1_helloworld.R;

public class CityActivity extends AppCompatActivity {
    public final static String cityActivityDataKey = "cityActivityDataKey";
    private EditText inputCity;
    private RecyclerView recyclerView;
    private String[] cityList = new String[] {"Samara", "Novgorod", "Omsk",
            "Arkhangelsk", "Novosibirsk", "Moscow",
            "St.Petersburg", "Rostov-na-Donu", "Stavropol", "Vladivostok"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_layout);
        initViews();
        setupRecyclerView();
        setOnClickListenerForSelectBtn();
    }

    private void setupRecyclerView() {
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

    private void initViews() {
        inputCity = findViewById(R.id.inputCity);
        recyclerView = findViewById(R.id.recyclerView);
    }
}
