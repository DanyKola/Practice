
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniela
 */

    public class Kinosal {

    /**
     * Sedadla
     */
    private boolean[][] sedadla = new boolean[30][15];
    /**
     * Velikost vykreslovaného sedadla
     */
    private static final int VELIKOST = 16;
    /**
     * Mezera mezi sedadly při vykreslení
     */
    private static final int MEZERA = 2;

    /**
     * Vykreslí sedadla
     *
     * @param g Plátno
     */
    public void vykresli(Graphics g) {
        for (int j = 0; j < sedadla[0].length; j++) {
            for (int i = 0; i < sedadla.length; i++) {
                if (sedadla[i][j]) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.GREEN);
                }
                g.fillRect(i * (VELIKOST + MEZERA), j * (VELIKOST + MEZERA), VELIKOST, VELIKOST);
            }
        }

    }
    //přepínač zelená/červená
    public void prepniStav(int x, int y){
    sedadla[x][y]=!sedadla[x][y];
    }
    
    public void klikni(int x, int y){
    int px = x/(VELIKOST + MEZERA);
    int py = y/(VELIKOST + MEZERA);
    if (px<sedadla.length && py<sedadla.length)
        prepniStav(px, py);
    }
    //nastavení ukládání volby - zbytek v buttonu
    public void uloz(String cesta) throws IOException{
    try(BufferedWriter bw = new BufferedWriter( new FileWriter(cesta))){
        int obsazenych = 0;
        for(int j = 0; j<sedadla[0].length; j++){
            String radek = "";
            for(int i = 0; i<sedadla[0].length; i ++){
                if (sedadla[i][j]){
                radek = "1";
                obsazenych++;
                } else
                    radek += "0";
            }
            bw.write(radek);
            bw.newLine();
        }
        bw.write("Obsazených: "+obsazenych);
        bw.newLine();
        
        int volnych = sedadla.length * sedadla[0].length - obsazenych;
        bw.write("Volných: " +volnych);
    }
    
    }

}
