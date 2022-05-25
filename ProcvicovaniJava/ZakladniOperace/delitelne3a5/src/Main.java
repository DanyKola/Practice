import java.util.Scanner;

public class Main {
    //program pro tisk čísel od 1 do 100, která jsou dělitelná 3, 5 a oběma.

    public static void main(String[] args) {
        System.out.println("\n\nČísla dělitelná 3:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
               System.out.printf(i + ", ");
            }
        }
        System.out.println("\n\n dělitelná 5:");
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                System.out.printf(i + ", ");
            }
        }
        System.out.println("\n\n Čísla dělitelná 3 a 5:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i%5==0) {
                System.out.printf(i + ", ");
            }
        }
    }
}
