package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage
{
    Size size;
    Milk milk;
    Syrup syrup;
    Temperature temperature;
    int espressoShots = 1;

    List<String> extras = new ArrayList<>();

    CustomDrink(Builder builder)
    {
        super("CUSTOM", "Custom Drink", new BigDecimal("4.25"), builder.size);

        this.size = builder.size;
        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = new ArrayList<>(builder.extras);
    }

    public static enum Milk
    {
        WHOLE, OAT, ALMOND, SKIM
    }

    public enum Syrup
    {
        VANILLA, CARAMEL, HAZELNUT, NONE
    }

    public enum Temperature
    {
        HOT, ICED
    }

    public static class builder
    {
        Size size = Size.MEDIUM;
        Milk milk = Milk.WHOLE;
        Syrup syrup = Syrup.NONE;
        Temperature temperature = Temperature.HOT;
        int espressoShots = 1;

        List<String> extras = new ArrayList<>();

        public Builder size(Size size)
        {
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk)
        {
            this.milk = milk;
            return milk;
        }

        public Builder syrup(Syrup syrup)
        {
            this.syrup = syrup;
            return syrup;
        }

        public Builder temperature(Temperature temperature)
        {
            this.temperature = temperature;
            return temperature;
        }

        public Builder addExtra(String extra)
        {
            if (extra == null || extra.isBlank())
            {
                throw new IllegalArgumentException("Extra cannot be null or blank.\n");
            }

            this.extras.add(extra);

            return this;
        }

        public Builder espressoShots(int shots)
        {
            if (shots < 1)
            {
                throw new IllegalArgumentException("Espresso shots should be one(1) or more.\n");
            }

            this.espressoShots = shots;

            return this;
        }

        public CustomDrink build()
        {
            return new CustomDrink(this);
        }
    }

    public BigDecimal getPrice()
    {
        BigDecimal newPrice = super.getPrice();

        if (espressoShots > 1)
        {
            int quantity;
            BigDecimal product;
            BigDecimal newQuantity;

            quantity = espressoShots - 1;

            newQuantity = new BigDecimal(quantity);

            product = newQuantity.multiply(new BigDecimal("0.75"));
            
            newPrice = newPrice.add(product);
        }

        if (!(syrup.equals(syrup.NONE)))
        {
            newPrice = newPrice.add(new BigDecimal("0.50"));
        }

        if (extras.size() >= 1)
        {
            int count;
            BigDecimal answer;
            BigDecimal newCount;

            newCount = new BigDecimal(count);
            
            answer = newCount.multiply(new BigDecimal("0.25"));

            newPrice = newPrice.add(answer);

            return newPrice;
        }

        return newPrice;
    }
}