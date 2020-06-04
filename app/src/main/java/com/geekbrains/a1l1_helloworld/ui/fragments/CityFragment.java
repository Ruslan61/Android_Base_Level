package com.geekbrains.a1l1_helloworld.ui.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.geekbrains.a1l1_helloworld.R;
import com.geekbrains.a1l1_helloworld.ui.activities.MainActivity;

public class CityFragment extends Fragment implements View.OnClickListener {
    boolean isExistWeatherFragment;
    private Button select;
    private EditText inputCity;
    private TextView moscow;
    private TextView stPetersburg;
    private TextView rostovNaDonu;
    private TextView stavropol;
    private TextView vladivostok;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setOnClickListenerForSelectBtn();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isExistWeatherFragment = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;

        if (isExistWeatherFragment) {
            showWeatherFragment();
        }
    }

    public void showWeatherFragment() {
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).replaceToWeatherFragment();
                }
            }
        });
    }

    private void setOnClickListenerForSelectBtn() {
        moscow.setOnClickListener(CityFragment.this);
        stPetersburg.setOnClickListener(CityFragment.this);
        rostovNaDonu.setOnClickListener(CityFragment.this);
        stavropol.setOnClickListener(CityFragment.this);
        vladivostok.setOnClickListener(CityFragment.this);
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

    private void initViews(@NonNull View view) {
        inputCity = view.findViewById(R.id.inputCity);
        select = view.findViewById(R.id.select);
        moscow = view.findViewById(R.id.textViewMoscow);
        stPetersburg = view.findViewById(R.id.textViewPeter);
        rostovNaDonu = view.findViewById(R.id.textViewRostov);
        stavropol = view.findViewById(R.id.textViewStavropol);
        vladivostok = view.findViewById(R.id.textViewVladivostok);
    }
}
