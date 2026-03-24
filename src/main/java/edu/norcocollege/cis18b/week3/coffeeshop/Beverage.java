package edu.norco.cis18b.week3.coffeeshop;

import edu.norco.cis18b.week3.coffeeshop.MenuItem;

import java.math.BigDecimal;

abstract class Beverage extends MenuItem
{
    Size size;
    
    public enum Size
    {
        SMALL, MEDIUM, LARGE
    }

    public Beverage(String sku, String name, BigDecimal basePrice, Size size)
    {
        super(sku, name, basePrice);

        this.size = size;
    }

    BigDecimal sizeMultiplier()
    {
        if (size == Size.SMALL)
        {
            BigDecimal mult = new BigDecimal("1.00");

            return mult;
        }

        else if (size == Size.MEDIUM)
        {
            BigDecimal mult = new BigDecimal("1.20");

            return mult;
        }

        else if (size == Size.LARGE)
        {
            BigDecimal mult = new BigDecimal("1.40");

            return mult;
        }

        else
        {
            BigDecimal mult = new BigDecimal("0.00");

            return mult;
        }
    }
}