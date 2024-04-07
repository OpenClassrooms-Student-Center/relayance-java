package com.kirabium.relayance.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.kirabium.relayance.databinding.ActivityAddCustomerBinding;

public class AddCustomerActivity extends AppCompatActivity {

    private ActivityAddCustomerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBinding();
        setupToolbar();
    }

    private void setupToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupBinding() {
        binding = ActivityAddCustomerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
