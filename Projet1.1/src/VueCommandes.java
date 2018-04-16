import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
class VueCommandes extends JPanel {
    private CModele modele;


    public VueCommandes(CModele modele) {
        this.modele = modele;
        
        /** Fin de tour */
        
        JButton boutonAvance = new JButton(">");
        boutonAvance.setActionCommand("Avance");
        this.add(boutonAvance);
        
        /** Deplacements */
        
        JButton boutonHaut = new JButton("Haut");
        boutonHaut.setActionCommand("Haut");
        this.add(boutonHaut);
        JButton boutonBas = new JButton("Bas");
        boutonBas.setActionCommand("Bas");
        this.add(boutonBas);
        JButton boutonGauche = new JButton("Gauche");
        boutonGauche.setActionCommand("Gauche");
        this.add(boutonGauche);
        JButton boutonDroite = new JButton("Droite");
        boutonDroite.setActionCommand("Droite");
        this.add(boutonDroite);
        
        /** Assechement (Peut etre autre chose que des boutons, mais je sais faire que ca :D) */
        
        JButton AssecheHaut = new JButton("AssecheHaut");
        AssecheHaut.setActionCommand("AssecheHaut");
        this.add(AssecheHaut);
        JButton AssecheBas = new JButton("AssecheBas");
        AssecheBas.setActionCommand("AssecheBas");
        this.add(AssecheBas);
        JButton AssecheGauche = new JButton("AssecheGauche");
        AssecheGauche.setActionCommand("AssecheGauche");
        this.add(AssecheGauche);
        JButton AssecheDroite = new JButton("AssecheDroite");
        AssecheDroite.setActionCommand("AssecheDroite");
        this.add(AssecheDroite);
        JButton AssecheIci = new JButton("AssecheIci");
        AssecheIci.setActionCommand("AssecheIci");
        this.add(AssecheIci);
          

    Controleur ctrl = new Controleur(modele);
        boutonAvance.addActionListener(ctrl);
        boutonHaut.addActionListener(ctrl);
        boutonBas.addActionListener(ctrl);
        boutonGauche.addActionListener(ctrl);
        boutonDroite.addActionListener(ctrl);
        AssecheHaut.addActionListener(ctrl);
        AssecheBas.addActionListener(ctrl);
        AssecheGauche.addActionListener(ctrl);
        AssecheDroite.addActionListener(ctrl);
        AssecheIci.addActionListener(ctrl);
    }
}