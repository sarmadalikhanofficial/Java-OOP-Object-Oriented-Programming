// Abstract class Appliance
abstract class Appliance {
    // Abstract methods for turning on and off
    public abstract void turnOn();
    public abstract void turnOff();

    // Non-abstract method to display the appliance status
    public void displayStatus(String status) {
        System.out.println("Appliance Status: " + status);
    }
}

// Concrete class Fan extends Appliance
class Fan extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Fan is now ON.");
        displayStatus("Fan is running");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is now OFF.");
        displayStatus("Fan is off");
    }
}

// Concrete class WashingMachine extends Appliance
class WashingMachine extends Appliance {
    private boolean isWashing;

    @Override
    public void turnOn() {
        System.out.println("Washing Machine is now ON.");
        displayStatus("Washing Machine is ready");
    }

    @Override
    public void turnOff() {
        System.out.println("Washing Machine is now OFF.");
        displayStatus("Washing Machine is off");
    }

    // Additional functionality to start and stop wash cycles
    public void startWashCycle() {
        isWashing = true;
        System.out.println("Washing cycle started.");
        displayStatus("Washing cycle in progress");
    }

    public void stopWashCycle() {
        isWashing = false;
        System.out.println("Washing cycle stopped.");
        displayStatus("Washing cycle stopped");
    }
}

// Main class to test the functionality
public class lab7HomeTask3 {
    public static void main(String[] args) {
        // Create Fan object and test functionality
        Fan fan = new Fan();
        fan.turnOn();
        fan.turnOff();

        System.out.println();

        // Create WashingMachine object and test functionality
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.turnOn();
        washingMachine.startWashCycle();
        washingMachine.stopWashCycle();
        washingMachine.turnOff();
    }
}
