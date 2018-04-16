import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CVue {
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes commandes;

    public CVue(CModele modele){
        frame = new JFrame();
        frame.setTitle("Jeu de l'ile interdite");
        frame.setLayout(new FlowLayout());
        grille = new VueGrille(modele);
        frame.add(grille);
        commandes = new VueCommandes(modele);
        frame.add(commandes);
        JTextArea Test = new VueAutres(modele).getTxt();
        frame.add(Test);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
