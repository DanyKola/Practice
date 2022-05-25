import java.util.Scanner;

public class Main {
//Napište Java program pro obrácení řetězce.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Napiš text: ");
        char[] text = scanner.nextLine().toCharArray();

        System.out.println("Obrácený text: ");
        for (int i = text.length-1; i>=0; i--){
            System.out.print(text[i]);
        }
       // System.out.print("/n");
    }

}