package edu.norco.cis18b.week3.coffeeshop;

import edu.norco.cis18b.week3.coffeeshop.MenuItem;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Order 
{
    String orderId;
    List<MenuItem> items = new ArrayList<>();

    public Order(String orderId)
    {
        if (orderId == null || orderId.isBlank())
        {
            throw new IllegalArgumentException("Order ID cannot be null or blank.\n");

            this.orderId = orderId;
        }
    }

    public void addItem(MenuItem item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("Item cannot be null.\n");

            items.add(item);
        }
    }

    public List<MenuItem> getItems()
    {
        return List.copyOf(items);
    }

    public BigDecimal total()
    {
        int num = 0;
        BigDecimal sum = new BigDecimal(num);

        for (MenuItem item : items)
        {
            sum = sum.add(item.getPrice());
        }

        return sum;
    }

    public String getOrderId()
    {
        return orderId;
    }
}