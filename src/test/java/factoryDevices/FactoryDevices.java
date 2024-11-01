package factoryDevices;

public class FactoryDevices {
    public static IDevice make (String deviceType){
        IDevice device;
        switch (deviceType.toLowerCase()){
            case "cloud":
                device = new AndroidCloud();
                break;
            case "ios":
                device = new Ios();
                break;
            default:
                device = new Android();
                break;
        }
        return device;
    }

}
