import java.util.Scanner;

public class Main {

    //Napište Java program pro obsah a obvod kruhu.

    public static void main(String[] args) {

        double obsah;
        double obvod;
        double polomer;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadej polomer kruhu: ");
        polomer = scanner.nextDouble();
        obvod = 2* Math.PI * polomer;
        obsah = Math.PI * polomer*polomer;

        System.out.println( "Obsah kruhu je: "+obsah);
        System.out.println("Obvod kruhu je: "+obvod);
    }

}
