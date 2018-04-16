import javafx.scene.control.Cell;

public class Cellule {

    private CModele modele;
    private int etat;
    private final int x, y;


    public Cellule(CModele modele, int x, int y) {
        this.modele = modele;
        this.etat = 1;
        this.x = x;
        this.y = y;
    }

    /** Modifications d'Etat */
    public void resetEtat() {
    	this.etat=1;
    }
    public void incrementEtat() {
    	this.etat+=1;
    }
    /** Getters */
    public int getX() {
    	return this.x;
    }
    public int getY() {
    	return this.y;
    }
    public int getEtat() {
        return this.etat;
    }
}