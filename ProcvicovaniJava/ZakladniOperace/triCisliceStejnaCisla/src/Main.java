import java.util.Scanner;

public class Main {
//program, kterı pøijme od uivatele tøi celá èísla a vrátí true, pokud dvì nebo více z nich
// (celá èísla ) mají stejnou èíslici úplnì vpravo. Celá èísla jsou nezáporná.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte první èíslo:");
        int number1 = scanner.nextInt();

        System.out.println("Zadej druhé èíslo:");
        int number2 = scanner.nextInt();

        System.out.println("Zadej tøetí èíslo:");
        int number3 = scanner.nextInt();

        System.out.println(stejnaCislaVpravo(number1, number2, number3, true));
    }
    public static boolean stejnaCislaVpravo(int a, int b, int c, boolean abc){
        return (a%10 == b%10) || (a%10 == c%10) || (b%10 == c%10);
    }

}
