package lab8Task2.smarthome;

public class Light implements SmartDevice {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.println("The light in " + location + " is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("The light in " + location + " is now OFF.");
    }
}
