import java.util.Scanner;

public class Main {
//Napište Java program a vypočítejte součet číslic celého čísla.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Napíš číslo: ");
        long i = scanner.nextLong();
        System.out.println("Součet čísla "+i+ " je "+suma(i));
    }

    public static int suma(long i){
        int sum = 0;
        while (i!=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
}
