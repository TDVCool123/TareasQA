package school;

public class School {
    public String getMessage(int nota){
        String message = "";
        if (nota < 0 || nota > 100)
            message = "Valor no permitido";
        else if (nota >= 0 && nota <=59) {
            message = "necesitas poner mas atencion a las clases";
        }
        else if (nota >= 60 && nota <=70) {
            message = "necesitas estudiar mas";
        }
        else if (nota >= 71 && nota <=80) {
            message = "muy bien hecho";
        }
        else if (nota >= 81 && nota <=91) {
            message = "gano media beca";
        }
        else if (nota >= 91 && nota <=100) {
            message = "gano beca";
        }
        return message;
    }
}
