import java.util.Scanner;

public class Main {
//Napište program, který vezme číslo jako vstup a vytiskne svou tabulku násobení až do 10.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");

        int number = scanner.nextInt();
        int result = 0;
        for (int i =1; i<= 10; i++){
            System.out.println(number +"*"+i+" = " +i*number);
        }
    }
}
