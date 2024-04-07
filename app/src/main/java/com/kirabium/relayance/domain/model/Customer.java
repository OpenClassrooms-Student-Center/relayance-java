package com.kirabium.relayance.domain.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Customer {
    private int id;
    private String name;
    private String email;
    private Date createdAt;

    public Customer(int id, String name, String email, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public boolean isNewCustomer() {
        Calendar today = Calendar.getInstance();
        Calendar createdAtCalendar = Calendar.getInstance();
        createdAtCalendar.setTime(createdAt);
        today.add(Calendar.MONTH, -3);
        return !createdAtCalendar.before(today);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String toHumanDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createdAt);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }
}
