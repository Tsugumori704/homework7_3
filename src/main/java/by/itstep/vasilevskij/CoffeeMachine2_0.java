package by.itstep.vasilevskij;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.exceptions.CoffeeMachineException;

public interface CoffeeMachine2_0 {
    void enable();

    void disable();

    void cleanUp();

    void fillWithWater(int quantityInMl);

    void fillWithCoffee(int quantityInGrans);

    void fillWithCoffeeBeans(int quantityInGrans);

    void fillWithMilk(int quantityInMl);

    Americano makeAmericano() throws CoffeeMachineException;

    Latte makeLatte() throws CoffeeMachineException;
}
