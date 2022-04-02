
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniela
 */
public class Platno extends JPanel {

    private Kinosal kinosal;

    public Platno(Kinosal kinosal)
    {
        super();
        this.kinosal = kinosal;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        kinosal.vykresli(g);
    }

}
