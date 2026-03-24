package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

import edu.norco.cis18b.week3.coffeeshop.PaymentReceipt;

public interface PaymentMethod 
{
    PaymentReceipt pay(String orderId, BigDecimal amount);
}