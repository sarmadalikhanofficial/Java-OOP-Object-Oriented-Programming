package lab9Task3.Transport;

public class Car implements Drivable {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void drive() {
        System.out.println(model + " is driving.");
    }

    @Override
    public void stop() {
        System.out.println(model + " has stopped.");
    }
}
