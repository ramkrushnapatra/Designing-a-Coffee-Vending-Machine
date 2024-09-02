package org.example;

public class Ingridients {
    private Double quantity;

    public Ingridients(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingridients{" +
                "quantity=" + quantity +
                '}';
    }
}
