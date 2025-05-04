package lab8Task2.smarthome;

public class SecurityCamera implements SmartDevice {
    private String cameraId;

    public SecurityCamera(String cameraId) {
        this.cameraId = cameraId;
    }

    @Override
    public void turnOn() {
        System.out.println("The security camera " + cameraId + " is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("The security camera " + cameraId + " is now OFF.");
    }
}
