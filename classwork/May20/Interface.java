// // defining the interface
// interface Callback {
//     void callback(int val);
// }

// interface glaxo {
//     void panadol(int val);
// }

// interface smithkline {
//     void calpol(int val);
// }

// // implementing Callback interface
// class Client implements Callback {
//     public void callback(int p) {
//         System.out.println("Client: We have to arrange a callback at " + p);
//     }
// }

// // another class implementing the same interface Callback
// class AnotherClient implements Callback {
//     public void callback(int p) {
//         System.out.println("AnotherClient: Another version of callback");
//         System.out.println("AnotherClient: Squared of value is " + (p * p));
//     }
// }

// // implementing multiple interfaces
// class MyMergerClient implements glaxo, smithkline {
//     public void calpol(int val) {
//         System.out.println("MyMergerClient: Revenue generated for Calpol is " + val + "ml");
//     }

//     public void panadol(int val) {
//         System.out.println("MyMergerClient: Top most sale of the year for Panadol will be " + val + "mg");
//     }
// }


// // main class to run everything
// public class Interface{
//     public static void main(String[] args) {

//         glaxo c = new MyMergerClient();
//         smithkline d = new MyMergerClient();
//         MyMergerClient obj = new MyMergerClient();
//         d.calpol(10);
//         c.panadol(500);
//         obj.panadol(500);
//         obj.calpol(10);

//         // Demonstrating the Callback interface
//         Client clientObj = new Client();
//         AnotherClient anotherClientObj = new AnotherClient();

//         // You would typically pass these client objects to another class
//         // that would then call the callback method. For this example,
//         // we'll just call them directly.
//         System.out.println("\nDemonstrating Callback Interface:");
//         clientObj.callback(100);
//         anotherClientObj.callback(200);
//     }
// }


package interfaces;


interface Callback{
	
	void callback(int val);
	}

interface glaxo{
	
	void panadol(int val);
	}

interface smithkline{
	
	void calpol(int val);
	}

class client implements Callback{
	public void callback(int p){
		System.out.println("We have to arange a call back at "+ p);
		}
}
class anotherclient implements Callback{
	public void callback(int p){
		System.out.println("Deadline will end at this hour "+ p);
		System.out.println("Sqaure of value is "+ (p*p));
		}
}

class Mymergerclient implements glaxo,smithkline{
	public void calpol(int val){
		System.out.println("Revenue generated is "+ val);
		
	}
	public void panadol(int val){
		
		System.out.println("Top most sale of the year will be "+ val);
	}

	
}
public class mydemointerface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	glaxo c = new Mymergerclient();
	smithkline d = new Mymergerclient();
	Mymergerclient obj = new Mymergerclient();
    d.calpol(28);
    c.panadol(40);
	obj.panadol(40);
	obj.calpol(40);
	}

}