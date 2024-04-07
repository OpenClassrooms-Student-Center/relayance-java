package com.kirabium.relayance.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.kirabium.relayance.R;
import com.kirabium.relayance.data.DummyData;
import com.kirabium.relayance.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    public static final String EXTRA_CUSTOMER_ID = "customer_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBinding();
        setupToolbar();
        setupUI();
    }

    private void setupUI() {
        int customerId = getIntent().getIntExtra(EXTRA_CUSTOMER_ID, -1);
        DummyData.customers.stream().filter(c -> c.getId() == customerId).findFirst().ifPresent(customer -> {
            binding.emailTextView.setText(customer.getEmail());
            binding.nameTextView.setText(customer.getName());
            binding.dateTextView.setText(getString(R.string.created_at, customer.toHumanDate()));
            if (customer.isNewCustomer()) {
                binding.newRibbonTextView.setVisibility(View.VISIBLE);
            } else {
                binding.newRibbonTextView.setVisibility(View.GONE);
            }
        });
    }

    private void setupBinding() {
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void setupToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
