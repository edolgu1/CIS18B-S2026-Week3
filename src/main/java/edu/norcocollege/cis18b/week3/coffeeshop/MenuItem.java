package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class MenuItem 
{
    String sku;
    String name;
    protected BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price)
    {
        int num = 0;
        BigDecimal zero = new BigDecimal(num);

        if (sku == null || sku.isBlank())
        {
            throw new IllegalArgumentException("sku cannot be null or blank.\n");
        }

        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or blank.\n");
        }

        if (price == null)
        {
            throw new IllegalArgumentException("Price cannot be null.\n");
        }

        if (price.compareTo(zero) < 0)
        {
            throw new IllegalArgumentException("Price has to be greater than 0.\n");
        }

        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku()
    {
        return sku;
    }

    public String getName()
    {
        return name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String toString()
    {
        return "SKU: " + sku + "Name: " + name + "Price: " + price + "\n";
    }
}