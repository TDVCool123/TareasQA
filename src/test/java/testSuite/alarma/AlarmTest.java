package testSuite.alarma;


import activities.alarma.AddAlarmScreen;
import activities.alarma.AlarmMainScreen;
import activities.whendo.CreateTask;
import activities.whendo.MainScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testSuite.whenDo.WhendoTestBase;

public class AlarmTest extends WhendoTestBase {
    AlarmMainScreen alarmMainScreen = new AlarmMainScreen();
    AddAlarmScreen addAlarmScreen = new AddAlarmScreen();

    @Test
    public void addAlarm() {
        String hour = "5";
        String min = "30";
        String format = "a.m.";
        String timeToCheck = alarmMainScreen.timeLabel.getText();
        System.out.println(timeToCheck);
        alarmMainScreen.addAlarmButton.click();

        addAlarmScreen.saveAlarm.click();

        String timeToCheckFormated = removeSecondsAndFormat(timeToCheck);
        System.out.println(timeToCheckFormated);
        //String formattedFormat = format.replace("a.m.", "\u200Aa.\u00A0m.");

        //String expectedTime = "0"+hour+":"+min+formattedFormat;
        String actualTime = alarmMainScreen.getAlarmText(timeToCheckFormated);
        System.out.println(actualTime);

        Assertions.assertEquals(timeToCheckFormated, removeSecondsAndFormat(actualTime),
                "ERROR: La alarma no se creo");

    }

    public static String removeSecondsAndFormat(String time) {
        // Encuentra la posición del segundo ':' que separa minutos y segundos
        int secondColonIndex = time.indexOf(":", time.indexOf(":") + 1);

        // Si se encuentran segundos, cortamos la cadena hasta los minutos
        String formattedTime;
        if (secondColonIndex != -1) {
            formattedTime = time.substring(0, secondColonIndex) + time.substring(time.indexOf(" ", secondColonIndex));
        } else {
            formattedTime = time;
        }

        // Reemplazamos " a. m." o " p. m." con los valores Unicode especificados
        return formattedTime
                .replace(" a.\u00A0m.", "\u200Aa.\u00A0m.")
                .replace(" p.\u00A0m.", "\u200Ap.\u00A0m.");
    }
/*02:34:54 p. m.
        02:43:06 p. m.
        new UiSelector().text("08:30 a. m.")*/
}