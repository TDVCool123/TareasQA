package aerolina;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestReservas {
    PasajesService pasajesService = Mockito.mock(PasajesService.class);
    FechaConverter fechaConverter = Mockito.mock(FechaConverter.class);

    @Test
    public void checkReservationIsAvailable() {
        // Datos de entrada
        String destino = "La Paz";
        int cantidad = 2;
        int dia = 29;
        int mes = 5;
        int gestion = 2023;

        // Mockeando los métodos
        Mockito.when(pasajesService.existenPasajes(destino, cantidad)).thenReturn(true);
        Mockito.when(fechaConverter.getDay(dia, mes, gestion)).thenReturn("Lunes");

        ReservasService reservasService = new ReservasService();
        reservasService.setPasajesService(pasajesService);
        reservasService.setFechaConverter(fechaConverter);

        String expectedMessage = "el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz";
        String actualMessage = reservasService.reservaVuelo(destino, cantidad, dia, mes, gestion);

        Assertions.assertEquals(expectedMessage, actualMessage, "ERROR: Mensaje incorrecto cuando existen pasajes.");

        // Verificar que se llamaron los métodos correctos
        Mockito.verify(pasajesService).existenPasajes(destino, cantidad);
        Mockito.verify(fechaConverter).getDay(dia, mes, gestion);
    }

    @Test
    public void checkThereIsNoReservations() {
        // Datos de entrada
        String destino = "La Paz";
        int cantidad = 2;
        int dia = 29;
        int mes = 5;
        int gestion = 2023;

        // Mockeando los métodos
        Mockito.when(pasajesService.existenPasajes(destino, cantidad)).thenReturn(false);

        ReservasService reservasService = new ReservasService();
        reservasService.setPasajesService(pasajesService);
        reservasService.setFechaConverter(fechaConverter);

        String expectedMessage = "no existen suficientes pasajes para La Paz";
        String actualMessage = reservasService.reservaVuelo(destino, cantidad, dia, mes, gestion);

        Assertions.assertEquals(expectedMessage, actualMessage, "ERROR: Mensaje incorrecto cuando no existen suficientes pasajes.");

        // Verificar que se llamó el método correcto
        Mockito.verify(pasajesService).existenPasajes(destino, cantidad);
    }
}
