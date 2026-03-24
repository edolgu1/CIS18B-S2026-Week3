package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

import edu.norco.cis18b.week3.coffeeshop.Beverage;
import edu.norco.cis18b.week3.coffeeshop.MenuItem;

public class Latte extends Beverage
{
    public Latte(String sku, String name, Size size)
    {
        super(sku, name, new BigDecimal("4.50"), size);

        BigDecimal lattePrice;

        lattePrice = new BigDecimal("4.50").multiply(sizeMultiplier());

        this.price = lattePrice;
    }
}