import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//program, který přijme číslo a ověří, zda je číslo sudé nebo liché

        int number;
        System.out.println("Zadej kladné číslo:");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();


        if (number%2==0){
            System.out.println("Číslo "+number+" je sudé.");
        } else if (number%2>0) {
            System.out.println("Číslo "+number+" je liché.");
        } else {
            System.out.println("Zadal si špatné číslo");
        }


    }

}
