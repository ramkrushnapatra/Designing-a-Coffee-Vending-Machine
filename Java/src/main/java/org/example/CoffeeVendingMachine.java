package org.example;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CoffeeVendingMachine {
    private static CoffeeVendingMachine instance;
    private Map<CoffeeType,Coffee>coffeeList;

    public static synchronized CoffeeVendingMachine getInstance(){
        if(instance == null){
            instance = new CoffeeVendingMachine();
        }
        return instance;
    }
    public CoffeeVendingMachine(){
        coffeeList =new ConcurrentHashMap<>();
        initializeCoffee();
    }

    private void initializeCoffee(){
        coffeeList.put(CoffeeType.AMERICANO,new Coffee(CoffeeType.AMERICANO,3.5,new Ingridients(9.5)));
        coffeeList.put(CoffeeType.COLD_BREW,new Coffee(CoffeeType.COLD_BREW,4.5,new Ingridients(6.5)));
        coffeeList.put(CoffeeType.CAPPUCIANO,new Coffee(CoffeeType.CAPPUCIANO,4.5,new Ingridients(6.5)));
        coffeeList.put(CoffeeType.FLAT_WHITE,new Coffee(CoffeeType.FLAT_WHITE,4.5,new Ingridients(6.5)));

    }

    public void displayCoffeeMenu(){
        synchronized (this){
           for (Map.Entry<CoffeeType, Coffee>coffee:coffeeList.entrySet()) {
               System.out.println(coffee.getValue());
           }
        }
    }

    public void dispenseCoffee(CoffeeType coffeeType,Payment payment) {
        isAvailableCoffee(coffeeType);
        if(coffeeList.get(coffeeType).getAmount() > payment.getAmount()){
            throw  new RuntimeException("inSufficient amount");
        }
        else {
            isIngridientsAvailable(coffeeType,payment);
            System.out.println("coffee dispense successfully");
            Double changeAmount =  payment.getAmount()- coffeeList.get(coffeeType).getAmount();
            if(changeAmount > 0.0) {
                System.out.println("collect your change " + changeAmount);
            }
        }


    }

    private void isIngridientsAvailable(CoffeeType coffeeType,Payment payment){
        Coffee coffee = coffeeList.get(coffeeType);
        if(coffee.getIngridients().getQuantity() < coffee.getAmount()){
            throw new RuntimeException("Alert, low Ingridients");
        }
        coffee.getIngridients().setQuantity(coffee.getIngridients().getQuantity() - coffee.getAmount());
        coffeeList.put(coffeeType, coffee);
    }

    private void isAvailableCoffee(CoffeeType coffeeType) {
        if(!coffeeList.containsKey(coffeeType)){
            throw new RuntimeException("selected coffee is not available");
        }
    }


}
