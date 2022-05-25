import java.util.Scanner;

public class Main {
//Napište Java program pro tisk součtu (sčítání), násobení, odečítání, dělení a zbytku dvou čísel.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("First number: ");
        int numberFirst = scanner.nextInt();

        System.out.println("Second number: ");
        int numberSecond = scanner.nextInt();

        System.out.println( numberFirst+" + "+numberSecond+" = " +(numberFirst+numberSecond) );
        System.out.println( numberFirst+" * "+numberSecond+" = " +(numberFirst*+numberSecond) );
        System.out.println( numberFirst+" - "+numberSecond+" = " +(numberFirst-numberSecond) );
        System.out.println( numberFirst+" / "+numberSecond+" = " +(numberFirst/numberSecond) );
        System.out.println( numberFirst+" modulo "+numberSecond+" = " +(numberFirst%numberSecond) );
    }
}
