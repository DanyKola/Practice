package oop.diar.teorie;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Databaze {
    private ArrayList<Zaznam> zaznamy;

    public Databaze(){
        zaznamy = new ArrayList<>();  //private ArrayList<Zaznam> zaznamy = new ArrayList<>();

    }

    public void pridejZaznam(LocalDateTime datumCas, String text){
        zaznamy.add(new Zaznam(datumCas, text));
    }

    public ArrayList<Zaznam> najdiSeznamy(LocalDateTime datum, boolean dleCasu){
    ArrayList<Zaznam> nalezene = new ArrayList<>();
    for (Zaznam z : zaznamy){
        if ((dleCasu&& z.getDatumCas().equals(datum)) || (!dleCasu && z.getDatumCas().toLocalDate().equals(datum.toLocalDate()) )){
            nalezene.add(z);
        }
    }
    return nalezene;
    }

    public void vymazZaznam(LocalDateTime datum){
        ArrayList<Zaznam> nalezeno = najdiSeznamy(datum, true);
        for (Zaznam z:nalezeno){
            zaznamy.remove(z);
        }
    }

}
