interface Callback {
    void callback(int val);
}

interface glaxo {
    void panadol(int val);
}

interface smithkline {
    void calpol(int val);
}

class Client implements Callback {
    public void callback(int p) {
        System.out.println("We have to arrange a callback at " + p);
    }
}

class AnotherClient implements Callback {
    public void callback(int p) {
        System.out.println("Another version of callback");
        System.out.println("p squared is " + (p * p));
    }
}

class MyMergerClient implements glaxo, smithkline {
    public void panadol(int val) {
        System.out.println("Glaxo: Panadol dose is " + val + "mg");
    }

    public void calpol(int val) {
        System.out.println("SmithKline: Calpol syrup dose is " + val + "ml");
    }
}

public class Interface {
    public static void main(String[] args) {
        // Callback interface test
        Callback c1 = new Client();
        c1.callback(10);

        Callback c2 = new AnotherClient();
        c2.callback(5);

        // Testing multiple interface implementation
        MyMergerClient merger = new MyMergerClient();
        merger.panadol(500);
        merger.calpol(10);
    }
}
