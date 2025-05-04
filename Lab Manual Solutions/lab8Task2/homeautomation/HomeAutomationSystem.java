package lab8Task2.homeautomation;

import lab8Task2.smarthome.SmartDevice;
import lab8Task2.smarthome.Light;
import lab8Task2.smarthome.Thermostat;
import lab8Task2.smarthome.SecurityCamera;

public class HomeAutomationSystem {
    public static void main(String[] args) {
        // Create instances of different smart devices
        SmartDevice livingRoomLight = new Light("Living Room");
        SmartDevice bedroomThermostat = new Thermostat(22);
        SmartDevice frontDoorCamera = new SecurityCamera("Front Door");

        // Simulate user interactions by turning on and off devices
        livingRoomLight.turnOn();
        bedroomThermostat.turnOn();
        frontDoorCamera.turnOn();

        livingRoomLight.turnOff();
        bedroomThermostat.turnOff();
        frontDoorCamera.turnOff();
    }
}
