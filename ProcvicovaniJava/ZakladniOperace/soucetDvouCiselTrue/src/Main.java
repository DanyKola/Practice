import java.util.Scanner;
// program, kter� od u�ivatele p�ijme t�i cel� ��sla a vr�t� hodnotu true,
// pokud je druh� ��slo v�t�� ne� prvn� ��slo a t�et� ��slo v�t�� ne� druh� ��slo.
// Pokud je "abc" pravdiv�, druh� ��slo nemus� b�t v�t�� ne� prvn� ��slo.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte prvn� ��slo:");
        int number1 = scanner.nextInt();

        System.out.println("Zadej druh� ��slo:");
        int number2 = scanner.nextInt();

        System.out.println("Zadej t�et� ��slo:");
        int number3 = scanner.nextInt();

        System.out.println("V�sledek je :"+vysedek(number1, number2, number3));


    }
    public static boolean vysedek(int a, int b, int c){

        return (a+b == c || a+c ==b || b+c==a) ;
    }
}
