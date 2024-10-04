package aerolina2;

import aerolina.FechaConverter;
import aerolina.PasajesService;

public class ReservasService2 {

    public ReservasService2() {

    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) {
        if (PasajesServiceGlobal.existenPasajes(destino, cantidad)) {
            String diaSemana = FechaConverterGlobal.getDay(dia, mes, gestion);
            String mesString = obtenerNombreMes(mes);
            return "el dia " + diaSemana + " " + dia + " " + mesString + " " + gestion +
                    " existen " + cantidad + " pasajes para " + destino;
        } else {
            return "no existen suficientes pasajes para " + destino;
        }
    }

    private String obtenerNombreMes(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes - 1];
    }


}
