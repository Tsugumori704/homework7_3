package by.itstep.vasilevskij;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Cappuccino;
import by.itstep.vasilevskij.coffee.Espresso;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.exceptions.*;
import by.itstep.vasilevskij.machines.BusinessCoffeeMachine;
import org.junit.Assert;
import org.junit.Test;

public class BusinessCoffeeMachineTest {

    //task01

    @Test
    public void espressoPositiveTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(200);
        business.fillWithWater(500);
        business.enable();
        //When
        Espresso espresso = business.makeEspresso();
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoPositiveTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(200);
        business.fillWithWater(500);
        business.enable();
        //When
        Americano americano = business.makeAmericano();
        //Then
        Assert.assertNotNull(americano);
    }

    //task02
    @Test
    public void lattePositiveTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(200);
        business.fillWithWater(500);
        business.fillWithMilk(500);
        business.enable();
        //When
        Latte latte = business.makeLatte();
        //Then
        Assert.assertNotNull(latte);
    }

    //task02
    @Test
    public void capuccinoPositiveTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(200);
        business.fillWithWater(500);
        business.fillWithMilk(500);
        business.enable();
        //When
        Cappuccino cappuccino = business.makeСappuccino();
        //Then
        Assert.assertNotNull(cappuccino);
    }


    @Test
    public void espressoNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(500);
        business.enable();
        //When
        Espresso espresso;
        try {
            espresso = business.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                business.fillWithCoffee(100);
            }
            espresso = business.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(500);
        business.enable();
        //When
        Americano americano;
        try {
            americano = business.makeAmericano();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                business.fillWithCoffee(100);
            }
            americano = business.makeAmericano();
        }
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void latteNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(500);
        business.fillWithMilk(100);
        business.enable();
        //When
        Latte latte;
        try {
            latte = business.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                business.fillWithCoffee(100);
            }
            latte = business.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void cappuccinoNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(500);
        business.fillWithMilk(100);
        business.enable();
        //When
        Cappuccino cappuccino;
        try {
            cappuccino = business.makeСappuccino();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                business.fillWithCoffee(100);
            }
            cappuccino = business.makeСappuccino();
        }
        //Then
        Assert.assertNotNull(cappuccino);
    }

    @Test
    public void espressoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(100);
        business.fillWithWater(30);
        business.enable();
        //When
        Espresso espresso;
        try {
            espresso = business.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                business.fillWithWater(200);
            }
            espresso = business.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
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
        CoffeeMachine business = new BusinessCoffeeMachine();
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
    public void cappuccinoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(100);
        business.fillWithWater(30);
        business.fillWithMilk(50);
        business.enable();
        //When
        Cappuccino cappuccino;
        try {
            cappuccino = business.makeСappuccino();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                business.fillWithWater(200);
            }
            cappuccino = business.makeСappuccino();
        }
        //Then
        Assert.assertNotNull(cappuccino);
    }


    @Test
    public void espressoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(1000);
        business.fillWithWater(2000);
        business.enable();
        //When
        Espresso espresso;
        for (int i = 0; i < 10; i++) {

            try {
                espresso = business.makeEspresso();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    business.cleanUp();
                }
            }
        }
        espresso = business.makeEspresso();

        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
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

    @Test
    public void latteCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(1000);
        business.fillWithWater(2000);
        business.fillWithMilk(1000);
        business.enable();
        //When
        Latte latte;
        for (int i = 0; i < 10; i++) {

            try {
                latte = business.makeLatte();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    business.cleanUp();
                }
            }
        }
        latte = business.makeLatte();

        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void cappuccinoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(1000);
        business.fillWithWater(2000);
        business.fillWithMilk(1000);
        business.enable();
        //When
        Cappuccino cappuccino;
        for (int i = 0; i < 10; i++) {

            try {
                cappuccino = business.makeСappuccino();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    business.cleanUp();
                }
            }
        }
        cappuccino = business.makeСappuccino();

        //Then
        Assert.assertNotNull(cappuccino);
    }

    //task02
    @Test
    public void latteNoMilkTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
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

    @Test
    public void cappuccinoNoMilkTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(200);
        business.fillWithWater(100);
        business.fillWithMilk(10);
        business.enable();
        //When
        Cappuccino cappuccino;
        try {
            cappuccino = business.makeСappuccino();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoMilkException) {
                business.fillWithMilk(50);
            }
            cappuccino = business.makeСappuccino();
        }
        //Then
        Assert.assertNotNull(cappuccino);
    }

}
