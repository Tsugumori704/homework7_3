package by.itstep.vasilevskij;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Espresso;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.coffee.Cappuccino;
import by.itstep.vasilevskij.exceptions.CoffeeMachineException;

public interface CoffeeMachine {

    void enable();

    void disable();

    void cleanUp();

    void fillWithWater(int quantityInMl);

    void fillWithCoffee(int quantityInGrans);

    void fillWithMilk(int quantityInMl); //task02

    Espresso makeEspresso() throws CoffeeMachineException;

    Americano makeAmericano() throws CoffeeMachineException;

    Latte makeLatte() throws CoffeeMachineException; //task02

    Cappuccino makeСappuccino() throws CoffeeMachineException; //task02

}
