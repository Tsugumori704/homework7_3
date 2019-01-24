package by.itstep.vasilevskij;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.exceptions.*;
import by.itstep.vasilevskij.machines.BusinessCoffeeMachine2_0;
import org.junit.Assert;
import org.junit.Test;

public class BusinessCoffeeMachineTest2_0 {


    @Test
    public void americanoPositiveTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(200);
        business.fillWithCoffeeBeans(150);
        business.fillWithWater(500);
        business.fillWithMilk(500);
        business.enable();
        //When
        Americano americano = business.makeAmericano();
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void lattePositiveTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(100);
        business.fillWithCoffeeBeans(50);
        business.fillWithWater(500);
        business.fillWithMilk(500);
        business.enable();
        //When
        Latte latte = business.makeLatte();
        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void americanoNoCoffeeBeansTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(10);
        business.fillWithWater(500);
        business.enable();
        //When
        Americano americano;
        try {
            americano = business.makeAmericano();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeBeansException) {
                business.fillWithCoffee(100);
            }
            americano = business.makeAmericano();
        }
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void latteNoCoffeeBeansTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(10);
        business.fillWithWater(500);
        business.fillWithMilk(100);
        business.enable();
        //When
        Latte latte;
        try {
            latte = business.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeBeansException) {
                business.fillWithCoffee(100);
            }
            latte = business.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }


    @Test
    public void americanoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(100);
        business.fillWithWater(30);
        business.enable();
        //When
        Americano americano;
        try {
            americano = business.makeAmericano();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                business.fillWithWater(200);
            }
            americano = business.makeAmericano();
        }
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void latteNoWaterTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(100);
        business.fillWithWater(30);
        business.fillWithMilk(50);
        business.enable();
        //When
        Latte latte;
        try {
            latte = business.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                business.fillWithWater(200);
            }
            latte = business.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }


    @Test
    public void americanoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(1000);
        business.fillWithWater(2000);
        business.enable();
        //When
        Americano americano;
        for (int i = 0; i < 10; i++) {

            try {
                americano = business.makeAmericano();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    business.cleanUp();
                }
            }
        }
        americano = business.makeAmericano();

        //Then
        Assert.assertNotNull(americano);
    }

    //task02
    @Test
    public void latteNoMilkTest() throws Exception {
        //Given
        CoffeeMachine2_0 business = new BusinessCoffeeMachine2_0();
        business.fillWithCoffee(200);
        business.fillWithWater(100);
        business.fillWithMilk(10);
        business.enable();
        //When
        Latte latte;
        try {
            latte = business.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoMilkException) {
                business.fillWithMilk(50);
            }
            latte = business.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }
}
