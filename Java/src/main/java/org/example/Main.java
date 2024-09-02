package org.example;

public class Main {
    public static void main(String[] args) {
        CoffeeVendingMachine coffeeVendingMachine= CoffeeVendingMachine.getInstance();
        coffeeVendingMachine.displayCoffeeMenu();
        coffeeVendingMachine.dispenseCoffee(CoffeeType.AMERICANO,new Payment(3.5));
        coffeeVendingMachine.displayCoffeeMenu();
        coffeeVendingMachine.dispenseCoffee(CoffeeType.AMERICANO,new Payment(3.5));
        coffeeVendingMachine.displayCoffeeMenu();
        coffeeVendingMachine.dispenseCoffee(CoffeeType.AMERICANO,new Payment(3.5));
    }
}