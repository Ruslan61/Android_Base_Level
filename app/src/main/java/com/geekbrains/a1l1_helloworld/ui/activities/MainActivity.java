package com.geekbrains.a1l1_helloworld.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.geekbrains.a1l1_helloworld.R;
import com.geekbrains.a1l1_helloworld.ui.fragments.CityFragment;
import com.geekbrains.a1l1_helloworld.ui.fragments.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
    }

    public void replaceToWeatherFragment() {
        WeatherFragment weatherFragment = new WeatherFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainScreenContainer, weatherFragment);
        transaction.commit();
    }

    public void replaceToCityFragment() {
        CityFragment cityFragment = new CityFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainScreenContainer, cityFragment);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
