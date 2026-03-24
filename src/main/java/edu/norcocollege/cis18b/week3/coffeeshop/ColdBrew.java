package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

import edu.norco.cis18b.week3.coffeeshop.Beverage;
import edu.norco.cis18b.week3.coffeeshop.MenuItem;

public class ColdBrew extends Beverage
{
    public ColdBrew(String sku, String name, Size size)
    {
        super(sku, name, new BigDecimal("4.00"), size);

        BigDecimal coldBrewPrice;

        coldBrewPrice = new BigDecimal("4.00").multiply(sizeMultiplier());

        this.price = coldBrewPrice;
    }
}