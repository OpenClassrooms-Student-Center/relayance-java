package com.kirabium.relayance.ui.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kirabium.relayance.R;
import com.kirabium.relayance.data.DummyData;
import com.kirabium.relayance.databinding.ActivityMainBinding;
import com.kirabium.relayance.ui.adapter.CustomerAdapter;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBinding();
        setupCustomerRecyclerView();
        setupFab();
    }

    private void setupFab() {
        binding.addCustomerFab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCustomerActivity.class);
            startActivity(intent);
        });
    }

    private void setupCustomerRecyclerView() {
        binding.customerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerAdapter = new CustomerAdapter(DummyData.customers, customer -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_CUSTOMER_ID, customer.getId());
            startActivity(intent);
        });
        binding.customerRecyclerView.setAdapter(customerAdapter);
    }

    private void setupBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
