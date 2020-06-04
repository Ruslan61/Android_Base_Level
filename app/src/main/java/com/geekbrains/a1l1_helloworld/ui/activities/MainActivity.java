package com.geekbrains.a1l1_helloworld.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.geekbrains.a1l1_helloworld.R;
import com.geekbrains.a1l1_helloworld.event_bus.EventBus;
import com.geekbrains.a1l1_helloworld.event_bus.events.ReplaceFragmentEvent;
import com.geekbrains.a1l1_helloworld.ui.fragments.CityFragment;
import com.geekbrains.a1l1_helloworld.ui.fragments.WeatherFragment;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    @Subscribe
    public void onReplaceFragmentEvent(ReplaceFragmentEvent event) {
        replaceToWeatherFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getBus().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getBus().unregister(this);
        super.onStop();
    }
}
