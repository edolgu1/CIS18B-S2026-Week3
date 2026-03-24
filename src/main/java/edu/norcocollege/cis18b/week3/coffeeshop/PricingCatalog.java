package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class PricingCatalog
{
    private static PricingCatalog instance;

    private PricingCatalog()
    {
    }

    public static PricingCatalog getInstance()
    {
        if (instance == null)
        {
            instance = new PricingCatalog();
        }

        return instance;
    }

    public BigDecimal getBasePrice(String productKey)
    {
        BigDecimal result = switch(productKey)
        {
            case "LATTE" -> new BigDecimal("4.50");

            case "COLD_BREW" -> new BigDecimal("4.00");

            case "CUSTOM" -> new BigDecimal("4.25");

            default -> throw new IllegalArgumentException("Must choose between LATTE, COLD_BREW, or CUSTOM");
        };

        return result;
    }
}