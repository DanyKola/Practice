import java.util.Scanner;
// program, kterı od uivatele pøijme tøi celá èísla a vrátí hodnotu true,
// pokud je druhé èíslo vìtší ne první èíslo a tøetí èíslo vìtší ne druhé èíslo.
// Pokud je "abc" pravdivé, druhé èíslo nemusí bıt vìtší ne první èíslo.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte první èíslo:");
        int number1 = scanner.nextInt();

        System.out.println("Zadej druhé èíslo:");
        int number2 = scanner.nextInt();

        System.out.println("Zadej tøetí èíslo:");
        int number3 = scanner.nextInt();

        System.out.println("Vısledek je :"+vysedek(number1, number2, number3));


    }
    public static boolean vysedek(int a, int b, int c){

        return (a+b == c || a+c ==b || b+c==a) ;
    }
}
