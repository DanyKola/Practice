import java.util.Scanner;

public class Main {
//program, kter� p�ijme od u�ivatele t�i cel� ��sla a vr�t� true, pokud dv� nebo v�ce z nich
// (cel� ��sla ) maj� stejnou ��slici �pln� vpravo. Cel� ��sla jsou nez�porn�.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte prvn� ��slo:");
        int number1 = scanner.nextInt();

        System.out.println("Zadej druh� ��slo:");
        int number2 = scanner.nextInt();

        System.out.println("Zadej t�et� ��slo:");
        int number3 = scanner.nextInt();

        System.out.println(stejnaCislaVpravo(number1, number2, number3, true));
    }
    public static boolean stejnaCislaVpravo(int a, int b, int c, boolean abc){
        return (a%10 == b%10) || (a%10 == c%10) || (b%10 == c%10);
    }

}
