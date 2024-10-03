package aerolina;

public class ReservasService {
    private PasajesService pasajesService;
    private FechaConverter fechaConverter;

    public ReservasService() {
        pasajesService = new PasajesService();
        fechaConverter = new FechaConverter();
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) {
        if (pasajesService.existenPasajes(destino, cantidad)) {
            String diaSemana = fechaConverter.getDay(dia, mes, gestion);
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

    // Setters para usar mocks
    public void setPasajesService(PasajesService pasajesService) {
        this.pasajesService = pasajesService;
    }

    public void setFechaConverter(FechaConverter fechaConverter) {
        this.fechaConverter = fechaConverter;
    }
}
