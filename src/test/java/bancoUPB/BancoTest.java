package bancoUPB;

import banco.AfpService;
import banco.AsfiService;
import banco.BancoUPB;
import banco.SegipService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
public class BancoTest {
    AfpService afpService = Mockito.mock(AfpService.class);
    SegipService segipService = Mockito.mock(SegipService.class);
    AsfiService asfiService = Mockito.mock(AsfiService.class);

    @ParameterizedTest
    @CsvSource({
            "888999, true, true, 1000, se le puede realizar el prestamo: 3000",
            "888999, true, false, 1000, usted no esta habilitado para prestamos",
            "888999, false, true, 1000, debe revisar su carnet de identidad"
    })
    public void verifyFact(int ci, boolean isRealPerson, boolean isAbleToGetCredit, int amount, String expectedMessage) {

        Mockito.when(segipService.isRealPerson(ci)).thenReturn(isRealPerson);
        Mockito.when(asfiService.isAbleToGetCredit(ci)).thenReturn(isAbleToGetCredit);
        Mockito.when(afpService.getAmount(ci)).thenReturn(amount);

        BancoUPB bancoUPB = new BancoUPB();
        bancoUPB.setAsfiService(asfiService);
        bancoUPB.setAfpService(afpService);
        bancoUPB.setSegipService(segipService);
        Assertions.assertEquals(expectedMessage,
                bancoUPB.getAmountMoney(ci, amount*3),
                "ERROR el prestamo es incorrecto");

        Mockito.verify(segipService).isRealPerson(ci);
        if (isRealPerson){
            Mockito.verify(asfiService).isAbleToGetCredit(ci);
        }
        if (isRealPerson && isAbleToGetCredit) {
            Mockito.verify(afpService).getAmount(ci);
        }
    }
}