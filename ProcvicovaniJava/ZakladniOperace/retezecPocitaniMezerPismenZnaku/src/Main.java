import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a sentence:");
        String sentence = scanner.nextLine();

        System.out.println(sentence);
        result(sentence);
    }

    public static void result(String text){
        char[] chars = text.toCharArray();
        int letter = 0;
        int space =0;
        int number = 0;
        int other = 0;

        for (int i=0; i<text.length();i++){

            if (Character.isLetter(chars[i])){
                letter++;
            }else if (Character.isDigit(chars[i])){
                number++;
            }
            else if (Character.isSpaceChar(chars[i])){
                space++;
            }
            else {
                other++;
            }
        }
        System.out.println(" Letter = "+letter);
        System.out.println("Number = "+number);
        System.out.println("Spice = "+space);
        System.out.println("Other = "+other);
    }
}
