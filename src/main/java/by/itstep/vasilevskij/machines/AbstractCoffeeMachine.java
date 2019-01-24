package by.itstep.vasilevskij.machines;

import by.itstep.vasilevskij.CoffeeMachine;
import by.itstep.vasilevskij.exceptions.CoffeeMachineException;
import by.itstep.vasilevskij.exceptions.NoTankCapacityException;

public abstract class AbstractCoffeeMachine implements CoffeeMachine {

    private int currentCoffee;
    //private int currentCoffeeBeans;
    private int currentWater;
    private int currentMilk;
    private int mudTank;
    private boolean isRunning = false;

    public static final int TANK_CAPACITY = 500;

    /**
     * Creates EMPTY coffee machine
     */
    public AbstractCoffeeMachine() {
        this.currentCoffee = 0;
       // this.currentCoffeeBeans = 0;
        this.currentWater = 0;
        this.currentMilk = 0;

    }

    {
        mudTank = 0;
    }

    abstract int getCoffeeLimit();

 //   abstract int getCoffeeBeansLimit();

    abstract int getWaterLimit();

    abstract int getMilkLimit();
/*
    //task03
    public AbstractCoffeeMachine(int coffee,int coffeeBeans, int water, int milk) {
        if (coffee > this.getCoffeeLimit()) {
            this.currentCoffee = this.getCoffeeLimit();
        }
        if (coffeeBeans > this.getCoffeeBeansLimit()) {
            this.currentCoffee = this.getCoffeeBeansLimit();
        }
        if (water > this.getWaterLimit()) {
            this.currentWater = this.getWaterLimit();
        }
        if (milk > this.getMilkLimit()) {
            this.currentMilk = this.getMilkLimit();
        }
    }
    */
    //task02
    public AbstractCoffeeMachine(int coffee, int water, int milk) {
        if (coffee > this.getCoffeeLimit()) {
            this.currentCoffee = this.getCoffeeLimit();
        }
        if (water > this.getWaterLimit()) {
            this.currentWater = this.getWaterLimit();
        }
        if (milk > this.getMilkLimit()) {
            this.currentMilk = this.getMilkLimit();
        }
    }

    public void fillWithWater(int quantityInMl) {
        if (quantityInMl + currentWater > getWaterLimit()) {
            currentWater = getWaterLimit();
        } else {
            currentWater += quantityInMl;
        }
    }

    public void fillWithCoffee(int quantityInGrams) {
        if (quantityInGrams + currentCoffee > getCoffeeLimit()) {
            currentCoffee = getCoffeeLimit();
        } else {
            currentCoffee += quantityInGrams;
        }
    }

    //task02
    public void fillWithMilk(int quantityInMl) {
        if (quantityInMl + currentCoffee > getCoffeeLimit()) {
            currentMilk = getMilkLimit();
        } else {
            currentMilk += quantityInMl;
        }
    }
    /*
    //task03
    public void fillWithCoffeeBeans(int quantityInGrams) {
        if (quantityInGrams + currentCoffeeBeans > getCoffeeBeansLimit()) {
            currentCoffeeBeans = getCoffeeBeansLimit();
        } else {
            currentCoffeeBeans += quantityInGrams;
        }
    }
*/
    public void enable() {
        if (isRunning == false) {
            isRunning = true;
        }
    }

    public void disable() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void cleanUp() {
        mudTank = 0;
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public int getCurrentCoffee() {
        return currentCoffee;
    }

    //task02
    public int getCurrentMilk() {
        return currentMilk;
    }
    /*
    //task03
    public int getCurrentCoffeeBeans() {
        return currentCoffeeBeans;
    }
    */

    public void setCurrentCoffee(int currentCoffee) {
        this.currentCoffee = currentCoffee;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    //task02
    public void setCurrentMilk(int currentMilk) {
        this.currentMilk = currentMilk;
    }
    /*
    //task03
    public void setCurrentCoffeeBeans(int currentCoffeeBeans) {
        this.currentCoffeeBeans = currentCoffeeBeans;
    }
    */

    boolean availableTankCapacity(int valueAdd) {
        return mudTank + valueAdd < TANK_CAPACITY;
    }

    void collectGarbage(int valueToAdd) throws CoffeeMachineException {
        if (availableTankCapacity(valueToAdd)) {
            mudTank += valueToAdd;
        } else {
            throw new NoTankCapacityException();
        }
    }

}
