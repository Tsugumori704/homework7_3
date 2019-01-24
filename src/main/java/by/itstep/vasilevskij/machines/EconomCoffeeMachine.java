package by.itstep.vasilevskij.machines;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Cappuccino;
import by.itstep.vasilevskij.coffee.Espresso;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.exceptions.CoffeeMachineException;
import by.itstep.vasilevskij.exceptions.NoCoffeeException;
import by.itstep.vasilevskij.exceptions.NoMilkException;
import by.itstep.vasilevskij.exceptions.NoWaterException;

public class EconomCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 5000;
    private static final int COFFEE_LIMIT = 500;
    private static final int MILK_LIMIT = 500; //task02

    public EconomCoffeeMachine() {
        super();
    }

    public EconomCoffeeMachine(int coffee, int water, int milk) {
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
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        // use 20 gramm coffee
        // use 30 ml water
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 30);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 20 gramm coffee
        // use 100 ml water
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 100) {
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 100);
        return new Americano();
    }

    //task02
    public Latte makeLatte() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 30 gramm coffee
        // use 30 ml water
        // use 30 ml milk
        if (getCurrentCoffee() < 30) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < 30) {
            throw new NoMilkException();
        }
        collectGarbage(30);
        setCurrentCoffee(getCurrentCoffee() - 30);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getMilkLimit() - 30);
        return new Latte();
    }

    //task02
    public Cappuccino makeСappuccino() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 30 gramm coffee
        // use 30 ml water
        // use 15 ml milk
        if (getCurrentCoffee() < 30) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < 15) {
            throw new NoMilkException();
        }
        collectGarbage(30);
        setCurrentCoffee(getCurrentCoffee() - 30);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getMilkLimit() - 15);
        return new Cappuccino();
    }
}
