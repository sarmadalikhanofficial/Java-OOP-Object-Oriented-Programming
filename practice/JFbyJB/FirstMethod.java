import java.util.Scanner;

/*
 * OUR FIRST METHOD
 * Write a method that greets a user by name.
 */
public class FirstMethod {
    
    public static void greetUser(){
        System.out.println("Enter your name:");
        Scanner yusra = new Scanner(System.in);
        String name = yusra.next();
        System.out.println("Hi there, " + name);
    }
    public static void main(String args[]){
        greetUser();
    }

   
}