package calcServiceMock;

import calcService.CalcAWS;
import calcService.CalcService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorAWSTestMock {

    //Paso 2 Mocks (Crear el Objeto Falso en el test)
    CalcService calcService = Mockito.mock(CalcService.class);

    @Test
    public void verifyFact(){
        //Paso 3
        Mockito.when(calcService.mul(1,1)).thenReturn(1);
        Mockito.when(calcService.mul(1,2)).thenReturn(2);
        Mockito.when(calcService.mul(2,3)).thenReturn(6);

        // Paso 4
        CalcAWS calcAWS = new CalcAWS();
        calcAWS.setCalcService(calcService);
        Assertions.assertEquals(6, calcAWS.getFact(3),"ERROR el factorial esta");

        // Paso 5
        Mockito.verify(calcService).mul(1,1);
        Mockito.verify(calcService).mul(1,2);
        Mockito.verify(calcService).mul(2,3);


    }
}






