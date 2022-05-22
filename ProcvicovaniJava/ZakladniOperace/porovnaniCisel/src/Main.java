import java.util.Scanner;

public class Main {
//Napište Java program pro porovnání dvou čísel.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First int number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Second int number: ");
        int secondNumber = scanner.nextInt();

        if (firstNumber== secondNumber){
            System.out.println(firstNumber + " == " +secondNumber);
        }
        if (firstNumber< secondNumber){
            System.out.println(firstNumber + " < " +secondNumber);
        }
        if (firstNumber> secondNumber){
            System.out.println(firstNumber + " > " +secondNumber);
        }
        if (firstNumber!= secondNumber){
            System.out.println(firstNumber + " != " +secondNumber);
        }
    }
}
