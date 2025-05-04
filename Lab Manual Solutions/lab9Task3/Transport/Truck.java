package lab9Task3.Transport;

public class Truck implements Drivable, Loadable {
    private String model;
    private int cargoWeight;

    public Truck(String model) {
        this.model = model;
        this.cargoWeight = 0;
    }

    @Override
    public void drive() {
        System.out.println(model + " is driving with cargo.");
    }

    @Override
    public void stop() {
        System.out.println(model + " has stopped.");
    }

    @Override
    public void loadCargo(int weight) {
        cargoWeight += weight;
        System.out.println("Loaded " + weight + "kg of cargo into the " + model + ".");
    }

    @Override
    public void unloadCargo() {
        if (cargoWeight > 0) {
            System.out.println("Unloaded " + cargoWeight + "kg of cargo from the " + model + ".");
            cargoWeight = 0;
        } else {
            System.out.println("No cargo to unload from the " + model + ".");
        }
    }
}
