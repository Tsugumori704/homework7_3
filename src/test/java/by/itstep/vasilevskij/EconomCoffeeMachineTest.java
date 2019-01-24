package by.itstep.vasilevskij;

import by.itstep.vasilevskij.coffee.Americano;
import by.itstep.vasilevskij.coffee.Cappuccino;
import by.itstep.vasilevskij.coffee.Espresso;
import by.itstep.vasilevskij.coffee.Latte;
import by.itstep.vasilevskij.exceptions.*;
import by.itstep.vasilevskij.machines.BusinessCoffeeMachine;
import by.itstep.vasilevskij.machines.EconomCoffeeMachine;
import org.junit.Assert;
import org.junit.Test;

public class EconomCoffeeMachineTest {
    //task01

    @Test
    public void espressoPositiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(200);
        econom.fillWithWater(500);
        econom.enable();
        //When
        Espresso espresso = econom.makeEspresso();
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoPositiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(200);
        econom.fillWithWater(500);
        econom.enable();
        //When
        Americano americano = econom.makeAmericano();
        //Then
        Assert.assertNotNull(americano);
    }

    //task02
    @Test
    public void lattePositiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(200);
        econom.fillWithWater(500);
        econom.fillWithMilk(500);
        econom.enable();
        //When
        Latte latte = econom.makeLatte();
        //Then
        Assert.assertNotNull(latte);
    }

    //task02
    @Test
    public void capuccinoPositiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(200);
        econom.fillWithWater(500);
        econom.fillWithMilk(500);
        econom.enable();
        //When
        Cappuccino cappuccino = econom.makeСappuccino();
        //Then
        Assert.assertNotNull(cappuccino);
    }


    @Test
    public void espressoNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(10);
        econom.fillWithWater(500);
        econom.enable();
        //When
        Espresso espresso;
        try {
            espresso = econom.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                econom.fillWithCoffee(100);
            }
            espresso = econom.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(10);
        econom.fillWithWater(500);
        econom.enable();
        //When
        Americano americano;
        try {
            americano = econom.makeAmericano();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                econom.fillWithCoffee(100);
            }
            americano = econom.makeAmericano();
        }
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void latteNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(10);
        econom.fillWithWater(500);
        econom.fillWithMilk(100);
        econom.enable();
        //When
        Latte latte;
        try {
            latte = econom.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                econom.fillWithCoffee(100);
            }
            latte = econom.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void cappuccinoNoCoffeeTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(10);
        econom.fillWithWater(500);
        econom.fillWithMilk(100);
        econom.enable();
        //When
        Cappuccino cappuccino;
        try {
            cappuccino = econom.makeСappuccino();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                econom.fillWithCoffee(100);
            }
            cappuccino = econom.makeСappuccino();
        }
        //Then
        Assert.assertNotNull(cappuccino);
    }

    @Test
    public void espressoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(100);
        econom.fillWithWater(30);
        econom.enable();
        //When
        Espresso espresso;
        try {
            espresso = econom.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                econom.fillWithWater(200);
            }
            espresso = econom.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(100);
        econom.fillWithWater(30);
        econom.enable();
        //When
        Americano americano;
        try {
            americano = econom.makeAmericano();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                econom.fillWithWater(200);
            }
            americano = econom.makeAmericano();
        }
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void latteNoWaterTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(100);
        econom.fillWithWater(30);
        econom.fillWithMilk(50);
        econom.enable();
        //When
        Latte latte;
        try {
            latte = econom.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                econom.fillWithWater(200);
            }
            latte = econom.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void cappuccinoNoWaterTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(100);
        econom.fillWithWater(30);
        econom.fillWithMilk(50);
        econom.enable();
        //When
        Cappuccino cappuccino;
        try {
            cappuccino = econom.makeСappuccino();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                econom.fillWithWater(200);
            }
            cappuccino = econom.makeСappuccino();
        }
        //Then
        Assert.assertNotNull(cappuccino);
    }


    @Test
    public void espressoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(1000);
        econom.fillWithWater(2000);
        econom.enable();
        //When
        Espresso espresso;
        for (int i = 0; i < 10; i++) {

            try {
                espresso = econom.makeEspresso();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    econom.cleanUp();
                }
            }
        }
        espresso = econom.makeEspresso();

        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(1000);
        econom.fillWithWater(2000);
        econom.enable();
        //When
        Americano americano;
        for (int i = 0; i < 10; i++) {

            try {
                americano = econom.makeAmericano();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    econom.cleanUp();
                }
            }
        }
        americano = econom.makeAmericano();

        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void latteCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(1000);
        econom.fillWithWater(2000);
        econom.fillWithMilk(1000);
        econom.enable();
        //When
        Latte latte;
        for (int i = 0; i < 10; i++) {

            try {
                latte = econom.makeLatte();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    econom.cleanUp();
                }
            }
        }
        latte = econom.makeLatte();

        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void cappuccinoCrowdedMudTankTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(1000);
        econom.fillWithWater(2000);
        econom.fillWithMilk(1000);
        econom.enable();
        //When
        Cappuccino cappuccino;
        for (int i = 0; i < 10; i++) {

            try {
                cappuccino = econom.makeСappuccino();
            } catch (CoffeeMachineException exceptionVariableName) {
                if (exceptionVariableName instanceof NoTankCapacityException) {
                    econom.cleanUp();
                }
            }
        }
        cappuccino = econom.makeСappuccino();

        //Then
        Assert.assertNotNull(cappuccino);
    }

    //task02
    @Test
    public void latteNoMilkTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(200);
        econom.fillWithWater(100);
        econom.fillWithMilk(10);
        econom.enable();
        //When
        Latte latte;
        try {
            latte = econom.makeLatte();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoMilkException) {
                econom.fillWithMilk(30);
            }
            latte = econom.makeLatte();
        }
        //Then
        Assert.assertNotNull(latte);
    }

    @Test
    public void cappuccinoNoMilkTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(200);
        econom.fillWithWater(100);
        econom.fillWithMilk(10);
        econom.enable();
        //When
        Cappuccino cappuccino;
        try {
            cappuccino = econom.makeСappuccino();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoMilkException) {
                econom.fillWithMilk(15);
            }
            cappuccino = econom.makeСappuccino();
        }
        //Then
        Assert.assertNotNull(cappuccino);
    }
}
