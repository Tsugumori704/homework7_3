package by.itstep.vasilevskij.machines;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.exceptions.*;

public class BusinessCoffeeMachine2_0 extends AbstractCoffeeMachine2_0 {

    private static final int WATER_LIMIT = 10000;
    private static final int COFFEE_LIMIT = 2000;
    private static final int MILK_LIMIT = 2000;
    private static final int COFFEE_BEANS_LIMIT = 2000;

    public BusinessCoffeeMachine2_0() {
        super();
    }

    public BusinessCoffeeMachine2_0(int coffee, int water, int milk, int coffeeBeans) {
        super(coffee, water, milk, coffeeBeans);
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

    int getCoffeeBeansLimit() {
        return COFFEE_BEANS_LIMIT;
    } //task03

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee or coffeeBeans
        // use 150 ml water
        if (getCurrentWater() < 150) {
            throw new NoWaterException();
        }
        if ((getCurrentCoffee() + getCurrentCoffeeBeans()) < 50) {
            throw new NoCoffeeBeansException();
        }
        collectGarbage(50);
        if (getCurrentCoffee() < 50) {
            setCurrentCoffeeBeans(getCurrentCoffeeBeans() - 50);
        } else {
            setCurrentCoffee(getCurrentCoffee() - 50);
        }
        setCurrentWater(getCurrentWater() - 150);
        return new Americano();
    }

    //task02
    public Latte makeLatte() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee or coffeeBeans
        // use 50 ml water
        // use 50 ml milk
        if (getCurrentWater() < 50) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < 50) {
            throw new NoMilkException();
        }
        if ((getCurrentCoffee() + getCurrentCoffeeBeans()) < 50) {
            throw new NoCoffeeBeansException();
        }
        collectGarbage(50);
        if (getCurrentCoffee() < 50) {
            setCurrentCoffeeBeans(getCurrentCoffeeBeans() - 50);
        } else {
            setCurrentCoffee(getCurrentCoffee() - 50);
        }
        setCurrentWater(getCurrentWater() - 50);
        setCurrentMilk(getMilkLimit() - 50);
        return new Latte();
    }
}
