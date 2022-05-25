import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    String zadejText;
        System.out.println("Zadejte číslo (řetezec):");
        Scanner scanner = new Scanner(System.in);
        zadejText = scanner.nextLine();
        int prevod = Integer.parseInt(zadejText);


        System.out.println("Zkouška převodu 2xzadané číslo = "+prevod*2);
    }
}
