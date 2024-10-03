package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorMulTest {

    //Positive / acceptance
    @Test
    public void verifyMult(){
        Calculator calculator = new Calculator();
        int expectedResult = 9;
        int actualResult = calculator.mult(3,3);
        Assertions.assertEquals(expectedResult,actualResult,
                "ERROR la multiplicacion es incorrecta, revise el codigo!");

    }

    // disable
    @Test
    @Disabled
    public void verifyMulNegative(){
        Calculator calculator = new Calculator();
        int expectedResult = 9;
        int actualResult = calculator.mult(-3,-3);
        Assertions.assertEquals(expectedResult,actualResult,
                "ERROR la multiplicacion es incorrecta, revise el codigo!");
    }

    //que pasa si tenemos varios datos para hacer el test
    //se usa un datadriven
    //y se usa un test parametrizado



}














