package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    Customer testCustomer;
    @BeforeEach
    public void setUp(){
        testCustomer = new Customer();
    }
    @Test
    public void testBalanceNegative(){
        AccountRecord AR1 = new AccountRecord();
        AR1.setCharge(100);
        AccountRecord AR2 = new AccountRecord();
        AR2.setCharge(-200);
        AccountRecord AR3 = new AccountRecord();
        AR3.setCharge(-900);
        List<AccountRecord> temporaryList = Arrays.asList(AR1, AR2, AR3);
        testCustomer.setCharges(temporaryList);
        assertEquals(-1000, testCustomer.getBalance());
    }

    @Test
    public void testBalanceZero(){
        AccountRecord AR1 = new AccountRecord();
        AR1.setCharge(-200);
        AccountRecord AR2 = new AccountRecord();
        AR2.setCharge(200);
        List<AccountRecord> temporaryList = Arrays.asList(AR1, AR2);
        testCustomer.setCharges(temporaryList);
        assertEquals(0, testCustomer.getBalance());
    }

    @Test
    public void testBalancePositive(){
        AccountRecord AR1 = new AccountRecord();
        AR1.setCharge(-200);
        AccountRecord AR2 = new AccountRecord();
        AR2.setCharge(300);
        AccountRecord AR3 = new AccountRecord();
        AR3.setCharge(900);
        List<AccountRecord> temporaryList = Arrays.asList(AR1, AR2,AR3);
        testCustomer.setCharges(temporaryList);
        assertEquals(1000, testCustomer.getBalance());
    }

    @Test
    public void testToStringNull(){
        assertEquals(testCustomer.toString(), "Customer ID: 0 Customer Name: null Balance: 0");
    }

    @Test
    public void testToStringRegular(){
        testCustomer.setId(1);
        testCustomer.setName("Netflix Pathways");
        AccountRecord AR1 = new AccountRecord();
        AR1.setCharge(900);
        List<AccountRecord> temporaryList = Arrays.asList(AR1);
        testCustomer.setCharges(temporaryList);
        assertEquals(testCustomer.toString(), "Customer ID: 1 Customer Name: Netflix Pathways Balance: 900");
    }
}
