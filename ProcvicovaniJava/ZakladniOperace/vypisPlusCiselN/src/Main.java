import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //program, který akceptuje celé číslo (n) a vypočítá hodnotu n+nn+nnn.

        int cisloN;
        

        Scanner scanner = new Scanner(System.in);
        System.out.println("Napiš číslo N: ");

        cisloN = scanner.nextInt();
        System.out.printf("%d + %d%d+ %d%d%d\n", cisloN, cisloN, cisloN, cisloN, cisloN, cisloN );

    }
}
