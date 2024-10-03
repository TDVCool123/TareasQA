package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorAddParamTest {
    @ParameterizedTest
    @CsvSource({
            "0,10,10",
            "5,6,11",
            "7,7,14",
            "0,0,0",
            "-5,0,-5",
            "-2,-2,-4",
            "-10,9,-1"
    })
    public void verifyAddPositiveNumber(int number1, int number2, int expectedResult){
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(number1,number2);
        Assertions.assertEquals(expectedResult,actualResult,
                "ERROR las suma es incorrecta, revise el codigo!");

    }
}
