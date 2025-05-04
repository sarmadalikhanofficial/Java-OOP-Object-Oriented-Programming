package lab8Task2.smarthome;



public class Thermostat implements SmartDevice {
    private int temperature;

    public Thermostat(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        System.out.println("The thermostat is set to " + temperature + "°C.");
    }

    @Override
    public void turnOff() {
        System.out.println("The thermostat is now OFF.");
    }
}
