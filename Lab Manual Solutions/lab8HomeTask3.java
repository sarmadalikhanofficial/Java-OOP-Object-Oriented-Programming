// File: EventListener.java
public interface EventListener {
    // Method that is called when an event occurs
    void onClick(String eventSource);
}


// File: Button.java
public class Button {
    private EventListener eventListener;

    // Constructor accepts an EventListener
    public Button(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    // Simulate a button click event
    public void click() {
        // Trigger the onClick method of the EventListener
        eventListener.onClick("Button");
    }
}



// File: UserAction.java
public class UserAction implements EventListener {

    // Implement the onClick method from the EventListener interface
    @Override
    public void onClick(String eventSource) {
        // Handle the event
        System.out.println("Event triggered from: " + eventSource);
        System.out.println("User Action handled!");
    }
}


// File: Main.java
public class lab8HomeTask3 {
    public static void main(String[] args) {
        // Create an instance of UserAction to handle the event
        UserAction userAction = new UserAction();
        
        // Create a Button and pass the UserAction instance as the EventListener
        Button button = new Button(userAction);
        
        // Simulate a button click event
        button.click();
    }
}
