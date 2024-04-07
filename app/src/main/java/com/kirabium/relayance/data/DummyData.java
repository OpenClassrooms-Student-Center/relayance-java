package com.kirabium.relayance.data;

import com.kirabium.relayance.domain.model.Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DummyData {
    public static Date generateDate(int monthsBack) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -monthsBack);
        return calendar.getTime();
    }

    public static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Alice Wonderland", "alice@example.com", generateDate(12)));
        customers.add(new Customer(2, "Bob Builder", "bob@example.com", generateDate(6)));
        customers.add(new Customer(3, "Charlie Chocolate", "charlie@example.com", generateDate(3)));
        customers.add(new Customer(4, "Diana Dream", "diana@example.com", generateDate(1)));
        customers.add(new Customer(5, "Evan Escape", "evan@example.com", generateDate(0)));
    }
}
