package aerolina2;

import aerolina.FechaConverter;
import aerolina.PasajesService;
import aerolina.ReservasService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class TestReservas2 {
    private MockedStatic<PasajesServiceGlobal> pasajesService;
    private MockedStatic<FechaConverterGlobal> fechaConverter;

    @BeforeEach
    public void setUp() {
        // Registering a static mock for UserService before each test
        pasajesService = Mockito.mockStatic(PasajesServiceGlobal.class);
        fechaConverter = Mockito.mockStatic(FechaConverterGlobal.class);
    }

    @AfterEach
    public void tearDown() {
        // Closing the mockStatic after each test
        pasajesService.close();
        fechaConverter.close();
    }

    @Test
    public void checkReservationIsAvailable() {
        // Datos de entrada
        String destino = "La Paz";
        int cantidad = 2;
        int dia = 29;
        int mes = 5;
        int gestion = 2023;

        // Mockeando los métodos
        pasajesService.when(()->PasajesServiceGlobal.existenPasajes(destino, cantidad)).thenReturn(true);
        fechaConverter.when(()->FechaConverterGlobal.getDay(dia, mes, gestion)).thenReturn("Lunes");

        ReservasService2 reservasService2 = new ReservasService2();

        String expectedMessage = "el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz";
        String actualMessage = reservasService2.reservaVuelo(destino, cantidad, dia, mes, gestion);

        Assertions.assertEquals(expectedMessage, actualMessage, "ERROR: Mensaje incorrecto cuando existen pasajes.");


    }

    @Test
    public void checkThereIsNoReservations() {
        String destino = "La Paz";
        int cantidad = 2;
        int dia = 29;
        int mes = 5;
        int gestion = 2023;

        pasajesService.when(()->PasajesServiceGlobal.existenPasajes(destino, cantidad)).thenReturn(false);

        ReservasService2 reservasService2 = new ReservasService2();


        String expectedMessage = "no existen suficientes pasajes para La Paz";
        String actualMessage = reservasService2.reservaVuelo(destino, cantidad, dia, mes, gestion);

        Assertions.assertEquals(expectedMessage, actualMessage, "ERROR: Mensaje incorrecto cuando no existen suficientes pasajes.");

    }
}
