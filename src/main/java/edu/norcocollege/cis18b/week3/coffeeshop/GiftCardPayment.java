package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

import edu.norco.cis18b.week3.coffeeshop.PaymentMethod;
import edu.norco.cis18b.week3.coffeeshop.PaymentReceipt;

public class GiftCardPayment implements PaymentMethod
{
    BigDecimal balance;
    BigDecimal initialBalance;

    GiftCardPayment(BigDecimal initialBalance)
    {
        int num = 0;
        BigDecimal zero = new BigDecimal(num);

        if (initialBalance.compareTo(zero) < 0)
        {
            throw new IllegalArgumentException("Initial balance has to be greater than zero(0).\n");

            this.balance = initialBalance;
        }
    }

    public PaymentReceipt pay(String orderId, BigDecimal amount)
    {
        if (this.balance.compareTo(amount) < 0)
        {
            throw new IllegalStateException("Not enough balance.\n");
        }

        this.balance = this.balance.subtract(amount);

        return new PaymentReceipt(orderId, amount, "GIFT_CARD", Instant.now());
    }

    public BigDecimal getBalance()
    {
        return this.balance;
    }
}