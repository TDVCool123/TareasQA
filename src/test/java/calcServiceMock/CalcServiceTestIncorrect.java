package calcServiceMock;

import calcService.CalcAWS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcServiceTestIncorrect {
    CalcAWS calcAWS;


//Uso incorrecto de un test sin los metodos necesarios
    @Test
    public void verifyFact(){
        calcAWS = new CalcAWS();
        int expectedResult = 6;
        int actualResult = calcAWS.getFact(3);
        Assertions.assertEquals(expectedResult,actualResult,"ERROR el factorial es incorrecto");
    }
}
