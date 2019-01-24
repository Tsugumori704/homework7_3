package by.itstep.vasilevskij.machines;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Espresso;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.coffee.Cappuccino;
import by.itstep.vasilevskij.exceptions.CoffeeMachineException;
import by.itstep.vasilevskij.exceptions.NoCoffeeException;
import by.itstep.vasilevskij.exceptions.NoMilkException;
import by.itstep.vasilevskij.exceptions.NoWaterException;

public class BusinessCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 10000;
    private static final int COFFEE_LIMIT = 2000;
    private static final int MILK_LIMIT = 2000; //task02

    public BusinessCoffeeMachine() {
        super();
    }

    public BusinessCoffeeMachine(int coffee, int water, int milk) {
        super(coffee, water, milk);
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    }

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    int getMilkLimit() {
        return MILK_LIMIT;
    } //task02

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 50) {
            throw new NoWaterException();
        }
        // use 50 gramm coffee
        // use 50 ml water
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 50);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee
        // use 150 ml water
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 150) {
            throw new NoWaterException();
        }
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 150);
        return new Americano();
    }

    //task02
    public Latte makeLatte() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee
        // use 50 ml water
        // use 50 ml milk
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 50) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < 50) {
            throw new NoMilkException();
        }
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 50);
        setCurrentMilk(getMilkLimit() - 50);
        return new Latte();
    }

    //task02
    public Cappuccino makeСappuccino() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee
        // use 50 ml water
        // use 25 ml milk
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 50) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < 25) {
            throw new NoMilkException();
        }
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 50);
        setCurrentMilk(getMilkLimit() - 25);
        return new Cappuccino();
    }


}
