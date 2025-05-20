// defining the interface
interface Callback {
    void callback(int val);
}

interface glaxo {
    void panadol(int val);
}

interface smithkline {
    void calpol(int val);
}

// implementing Callback interface
class Client implements Callback {
    public void callback(int p) {
        System.out.println("Client: We have to arrange a callback at " + p);
    }
}

// another class implementing the same interface Callback
class AnotherClient implements Callback {
    public void callback(int p) {
        System.out.println("AnotherClient: Another version of callback");
        System.out.println("AnotherClient: Squared of value is " + (p * p));
    }
}

// implementing multiple interfaces
class MyMergerClient implements glaxo, smithkline {
    public void calpol(int val) {
        System.out.println("MyMergerClient: Revenue generated for Calpol is " + val + "ml");
    }

    public void panadol(int val) {
        System.out.println("MyMergerClient: Top most sale of the year for Panadol will be " + val + "mg");
    }
}


// main class to run everything
public class Interface{
    public static void main(String[] args) {

        glaxo c = new MyMergerClient();
        smithkline d = new MyMergerClient();
        MyMergerClient obj = new MyMergerClient();
        d.calpol(10);
        c.panadol(500);
        obj.panadol(500);
        obj.calpol(10);

        // Demonstrating the Callback interface
        Client clientObj = new Client();
        AnotherClient anotherClientObj = new AnotherClient();

        // You would typically pass these client objects to another class
        // that would then call the callback method. For this example,
        // we'll just call them directly.
        System.out.println("\nDemonstrating Callback Interface:");
        clientObj.callback(100);
        anotherClientObj.callback(200);
    }
}