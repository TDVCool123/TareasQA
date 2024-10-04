package bancoUPB2;


import banco2.BancoUPB2;

import banco2.AfpServiceGlobal;
import banco2.AsfiServiceGlobal;
import banco2.SegipServiceGlobal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class Banco2Test {
    private MockedStatic<AfpServiceGlobal> afpService;
    private MockedStatic<SegipServiceGlobal> segipService;

    private MockedStatic<AsfiServiceGlobal> asfiService;


    @BeforeEach
    public void setUp() {
        // Registering a static mock for UserService before each test
        afpService = Mockito.mockStatic(AfpServiceGlobal.class);
        segipService = Mockito.mockStatic(SegipServiceGlobal.class);
        asfiService = Mockito.mockStatic(AsfiServiceGlobal.class);
    }

    @AfterEach
    public void tearDown() {
        // Closing the mockStatic after each test
        afpService.close();
        segipService.close();
        asfiService.close();
    }



    @ParameterizedTest
    @CsvSource({
            "888999, true, true, 1000, se le puede realizar el prestamo: 3000",
            "888999, true, false, 1000, usted no esta habilitado para prestamos",
            "888999, false, true, 1000, debe revisar su carnet de identidad"
    })

    public void verifyFact(int ci, boolean isRealPerson, boolean isAbleToGetCredit, int amount, String expectedMessage) {


        segipService.when( ()-> SegipServiceGlobal.isRealPerson(ci)).thenReturn(isRealPerson);
        asfiService.when( ()-> AsfiServiceGlobal.isAbleToGetCredit(ci)).thenReturn(isAbleToGetCredit);
        afpService.when( ()-> AfpServiceGlobal.getAmount(ci)).thenReturn(amount);

        BancoUPB2 bancoUPB2 = new BancoUPB2();
        Assertions.assertEquals(expectedMessage,
                bancoUPB2.getAmountMoney(ci, amount*3),
                "ERROR el prestamo es incorrecto");

        /*Mockito.verify(segipService).isRealPerson(ci);
        if (isRealPerson){
            Mockito.verify(asfiService).isAbleToGetCredit(ci);
        }
        if (isRealPerson && isAbleToGetCredit) {
            Mockito.verify(afpService).getAmount(ci);
        }*/
    }
}