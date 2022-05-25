public class Main {

    //vytvořit a zobrazit jedinečné trojciferné číslo pomocí 1, 2, 3, 4. Také spočítejte, kolik je to trojciferných čísel

    public static void main(String[] args) {
        int pocet = 0;

        for (int i=1;i<=4; i++){
            for (int j =1; j<=4; j++){
                for (int k = 1; k<=4; k++){
                    if (k!=i && k!= j && i!=j) {
                        pocet++;
                        System.out.println(i + " " +k+" "+j);
                    }
                }
            }
        }
        System.out.println("Celkový počet čísel je: "+pocet);
    }
}
