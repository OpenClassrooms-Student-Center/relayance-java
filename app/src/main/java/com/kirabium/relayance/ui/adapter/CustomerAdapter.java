package com.kirabium.relayance.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kirabium.relayance.databinding.CustomerItemBinding;
import com.kirabium.relayance.domain.model.Customer;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {
    private final List<Customer> customers;
    private final OnCustomerClickListener onClickListener;

    public interface OnCustomerClickListener {
        void onCustomerClick(Customer customer);
    }

    public CustomerAdapter(List<Customer> customers, OnCustomerClickListener onClickListener) {
        this.customers = customers;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomerItemBinding binding = CustomerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomerViewHolder(binding, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.bind(customer);
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder {
        private final CustomerItemBinding binding;
        private Customer currentCustomer;

        CustomerViewHolder(CustomerItemBinding binding, OnCustomerClickListener onClickListener) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(v -> {
                if (currentCustomer != null) {
                    onClickListener.onCustomerClick(currentCustomer);
                }
            });
        }

        void bind(Customer customer) {
            this.currentCustomer = customer;
            binding.nameTextView.setText(customer.getName());
            binding.emailTextView.setText(customer.getEmail());
        }
    }
}
