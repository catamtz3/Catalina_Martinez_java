package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        // Traverse through the CustomerData and turn it into a list of unique Customers.
        // Make sure that their AccountRecord list holds all the charges that belong to the
        // proper company
        List<Customer> customerList = new ArrayList<>();
        List<Integer> customerIDs = new ArrayList<>();
        for(int i = 0; i < customerData.size(); i++){
            String[] curr = customerData.get(i);
            int current_ID = Integer.parseInt(curr[0]);
            if(!customerIDs.contains(current_ID)){
                Customer new_customer = new Customer();
                List<AccountRecord> accountRecords = new ArrayList<>();
                for(String[] current: customerData) {
                    if(Integer.parseInt(current[0]) == current_ID) {
                        AccountRecord temp = new AccountRecord();
                        temp.setCharge(Integer.parseInt(current[2]));
                        temp.setChargeDate(current[3]);
                        accountRecords.add(temp);
                    }
                }
                new_customer.setCharges(accountRecords);
                new_customer.setId(current_ID);
                new_customer.setName(curr[1]);
                customerList.add(new_customer);
                customerIDs.add(current_ID);
            }
        }

        // Traverse the customer list and figure out which customers are in the positive and whose is not
        List<Customer> positive_accounts = new ArrayList<>();
        List<Customer> negative_accounts = new ArrayList<>();
        for(Customer customers: customerList){
            if(customers.getBalance()>=0){
                positive_accounts.add(customers);
            } else {
                negative_accounts.add(customers);
            }
        }

        // Print out the customers with a positive balance
        System.out.println("Positive accounts:");
        for(Customer positives : positive_accounts){
            System.out.println(positives);
            System.out.println();
        }
        System.out.println();

        // Print out the customers with a negative balance
        System.out.println("Negative accounts:");
        for(Customer negative : negative_accounts){
            System.out.println(negative);
            System.out.println();
        }
    }
}
