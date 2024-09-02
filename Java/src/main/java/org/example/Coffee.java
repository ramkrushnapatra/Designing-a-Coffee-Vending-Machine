package org.example;

import java.util.Map;

public class Coffee {
    private CoffeeType coffeeName;
    private Double amount;
    private Ingridients ingridients;

    public Coffee(CoffeeType coffeeName, Double amount, Ingridients ingridients) {
        this.coffeeName = coffeeName;
        this.amount = amount;
        this.ingridients = ingridients;
    }

    public CoffeeType getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(CoffeeType coffeeName) {
        this.coffeeName = coffeeName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Ingridients getIngridients() {
        return ingridients;
    }

    public void setIngridientsMap(Ingridients ingridients) {
        this.ingridients = ingridients;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeName=" + coffeeName +
                ", amount=" + amount +
                ", ingridients=" + ingridients +
                '}';
    }
}
