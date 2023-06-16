package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharges(List<AccountRecord> charges){
        this.charges = charges;
    }

    public int getBalance() {
        int sum = 0;
        for(AccountRecord nums: charges) {
            sum += nums.getCharge();
        }
        return sum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return "Customer ID: " + id + " Customer Name: " + name + " Balance: " + getBalance();
    }
}
