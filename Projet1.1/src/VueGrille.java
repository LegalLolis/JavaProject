import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class VueGrille extends JPanel implements Observer {
    private CModele modele;
    private final static int TAILLE = 60;

    public VueGrille(CModele modele) {
        this.modele = modele;
        modele.addObserver(this);

        Dimension dim = new Dimension(TAILLE * (CModele.LARGEUR),
                TAILLE * (CModele.HAUTEUR));
        this.setPreferredSize(dim);
    }

    public void update() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.repaint();
        /** Pour chaque cellule... */
        for (int i = 1; i <= CModele.LARGEUR; i++) {
            for (int j = 1; j <= CModele.HAUTEUR; j++) {
                /**
                 * ... Appeler une fonction d'affichage auxiliaire.
                 * On lui fournit les informations de dessin [g] et les
                 * coordonnées du coin en haut à gauche.
                 */
                paint(g, modele.getCellule(i, j), (i - 1) * TAILLE, (j - 1) * TAILLE);
            }
        }
    }

    private void paint(Graphics g, Cellule c, int x, int y) {
        /** Selection d'une couleur. */
        if (c.getEtat() == 1) {
            g.setColor(Color.WHITE);
        }
        if (c.getEtat() == 2) {
            g.setColor(Color.BLUE);
        }
        if (c.getEtat() == 3) {
            g.setColor(Color.BLACK);
        }

        /** Coloration d'un rectangle. */
        g.fillRect(x, y, TAILLE, TAILLE);

        /** Placement des joueurs. */

        for (int i = 0; i < this.modele.getJoueurs().length; i++) {
            /**System.out.println("test1");*/
            if (c.getX() == this.modele.getJoueurs()[i].getAbs() && c.getY() == this.modele.getJoueurs()[i].getOrd()) {
                g.setColor(modele.tableaucolor[i]);
                g.fillOval(x + c.getX() + 5, y + c.getY() + 5, 40, 40);
            }


        }

    }
}