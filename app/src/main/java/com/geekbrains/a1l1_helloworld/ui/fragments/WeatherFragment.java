package com.geekbrains.a1l1_helloworld.ui.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.geekbrains.a1l1_helloworld.R;
import com.geekbrains.a1l1_helloworld.ui.activities.MainActivity;

public class WeatherFragment extends Fragment {
    boolean isExistCityFragment;
    private Button chooseACityButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isExistCityFragment = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;

        if (isExistCityFragment) {
            showCityFragment();
        }
    }

    public void showCityFragment() {
        chooseACityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).replaceToCityFragment();
                }
            }
        });
    }

    public void initViews(@NonNull View view) {
        chooseACityButton = view.findViewById(R.id.chooseACityButton);
    }
}
