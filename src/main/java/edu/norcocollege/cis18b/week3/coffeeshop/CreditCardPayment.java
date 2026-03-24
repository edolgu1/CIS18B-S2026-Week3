package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

import edu.norco.cis18b.week3.coffeeshop.PaymentMethod;
import edu.norco.cis18b.week3.coffeeshop.PaymentReceipt;

public class CreditCardPayment implements PaymentMethod
{
    String last4;

    CreditCardPayment(String last4)
    {
        if (!(last4.length() == 4))
        {
            throw new IllegalArgumentException("Must provide the last 4 numbers of credit card.\n");
        }

        this.last4 = last4;
    }

    public PaymentReceipt pay(String orderId, BigDecimal amount)
    {
        return new PaymentReceipt(orderId, amount, "CREDIT_CARD(****" + last4 + ")", Instant.now());
    }
}