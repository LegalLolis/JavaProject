import javax.sound.midi.Soundbank;
import java.awt.*;
import java.util.Random;

public class CModele extends Observable {
    public static final int HAUTEUR=9,LARGEUR=9;
    public final int[] tableauabs = new int[4];
    public final int[] tableauord=new int[4];
    public final Color[] tableaucolor= new Color[4];
    Color[] lol;
    private Cellule[][] cellules;
    private Joueur[] joueurs;
    private int currentPlayer = 0;
    private int x;
/** Constructeur */
    public CModele(int x){
        tableauabs[0]=4;
        tableauabs[1]=4;
        tableauabs[2]=5;
        tableauabs[3]=5;

        tableauord[0]=4;
        tableauord[1]=5;
        tableauord[2]=4;
        tableauord[3]=5;

        tableaucolor[0]=Color.MAGENTA;
        tableaucolor[1]=Color.RED;
        tableaucolor[2]=Color.CYAN;
        tableaucolor[3]=Color.GREEN;

        this.x=x;
        this.joueurs=new Joueur[x];
        cellules = new Cellule[LARGEUR+2][HAUTEUR+2];
        for(int i=0;i<=LARGEUR;i++){
            for (int j=0;j<=HAUTEUR;j++){
                cellules[i][j]=new Cellule(this,i,j);
            }
        }

        //init();
        for (int i=0;i<this.x;i++){
            this.joueurs[i]= new Joueur(tableauabs[i],tableauord[i],i);
        }
        
    }
/** Pas besoin de Init car le constructeur de Cellule les initialise deja */
	/**public void init(){
        for (int i=1;i<=LARGEUR;i++){
            for (int j=1;j<=HAUTEUR;j++){
                cellules[i][j].etat=1;
            }
        }
    }*/

/** Fin de tour */
    public void avance() {
    	/** Gestion joueurs */
    	joueurs[currentPlayer].resetActions();
    	if (joueurs[currentPlayer].getId() == this.x-1) {
    		currentPlayer = 0;
    	}
    	else {
    		currentPlayer+=1;
    	}
    	
    	/** Gestion Innondation */
        Random r = new Random();
        int valeur1 = 1+r.nextInt(HAUTEUR);
        int valeur2 = 1+r.nextInt(LARGEUR);

        int valeur3 = 1+r.nextInt(HAUTEUR);
        int valeur4 = 1+r.nextInt(LARGEUR);

        int valeur5 = 1+r.nextInt(HAUTEUR);
        int valeur6 = 1+r.nextInt(LARGEUR);

        while(valeur1==valeur3 && valeur2==valeur4){
            valeur3 = 1+r.nextInt(HAUTEUR);
            valeur4 = 1+r.nextInt(LARGEUR);
        }
        while(valeur5==valeur3 && valeur6==valeur4 || valeur5==valeur1 && valeur6==valeur2) {
            valeur5 = 1+r.nextInt(HAUTEUR);
            valeur6 = 1+r.nextInt(LARGEUR);
        }




    	Cellule cellule1=cellules[valeur1][valeur2];


        while(cellule1.getEtat()==3){
            valeur1 = 1+r.nextInt(HAUTEUR);
            valeur2 = 1+r.nextInt(LARGEUR);
            while(valeur1==valeur3 && valeur2==valeur4 || valeur1==valeur5 && valeur2==valeur6){
                valeur1 = 1+r.nextInt(HAUTEUR);
                valeur2 = 1+r.nextInt(LARGEUR);

            }
            cellule1=cellules[valeur1][valeur2];
        }

        cellule1.incrementEtat();


        Cellule cellule2=cellules[valeur3][valeur4];


        while(cellule2.getEtat()==3){
            valeur3 = 1+r.nextInt(HAUTEUR);
            valeur4 = 1+r.nextInt(LARGEUR);
            while(valeur3==valeur1 && valeur4==valeur2 || valeur3==valeur5 && valeur4==valeur6){
                valeur3 = 1+r.nextInt(HAUTEUR);
                valeur4 = 1+r.nextInt(LARGEUR);

            }
            cellule2=cellules[valeur3][valeur4];
        }

        cellule2.incrementEtat();


        Cellule cellule3=cellules[valeur5][valeur6];


        while(cellule3.getEtat()==3){
            valeur5 = 1+r.nextInt(HAUTEUR);
            valeur6 = 1+r.nextInt(LARGEUR);
            while(valeur5==valeur1 && valeur6==valeur2 || valeur5==valeur3 && valeur6==valeur4){
                valeur5 = 1+r.nextInt(HAUTEUR);
                valeur6 = 1+r.nextInt(LARGEUR);
            }
            cellule3=cellules[valeur5][valeur6];
        }

        cellule3.incrementEtat();

        notifyObservers();
    }
/** Mouvements */    
    public void playerMovement(int type) {
    	if  (joueurs[currentPlayer].canAct()) {
    		if(type==0 && joueurs[currentPlayer].getAbs()!=1 && getCellule(joueurs[currentPlayer].getAbs()-1,joueurs[currentPlayer].getOrd()).getEtat()!=3 ) {
        		joueurs[currentPlayer].moveLeft();
        		joueurs[currentPlayer].oneAction();
        	}
        	if(type==1 && joueurs[currentPlayer].getAbs()!=LARGEUR && getCellule(joueurs[currentPlayer].getAbs()+1,joueurs[currentPlayer].getOrd()).getEtat()!=3) {
        		joueurs[currentPlayer].moveRight();
        		joueurs[currentPlayer].oneAction();
        	}
        	if(type==2 && joueurs[currentPlayer].getOrd()!=1 && getCellule(joueurs[currentPlayer].getAbs(),joueurs[currentPlayer].getOrd()-1).getEtat()!=3) {
        		joueurs[currentPlayer].moveUp();
        		joueurs[currentPlayer].oneAction();
        	}
        	if(type==3 && joueurs[currentPlayer].getOrd()!=HAUTEUR && getCellule(joueurs[currentPlayer].getAbs(),joueurs[currentPlayer].getOrd()+1).getEtat()!=3) {
        		joueurs[currentPlayer].moveDown();
        		joueurs[currentPlayer].oneAction();
        	}
        	notifyObservers();
    	}
    	else {
    		System.out.println("non");
    	}
    	
    }  
/** Assechement */
    public void dry(Cellule c) {
    	int cellX = c.getX();int cellY = c.getY();
    	int playerX = joueurs[currentPlayer].getAbs();int playerY = joueurs[currentPlayer].getOrd();
    	/** S'il peut agir et qu'il veut assecher une case adjacente inondee */
    		/** On peut reduire le if si l'assechement se fait par des boutons (on ne pourra pas demander d'assecher des cases non-adjacentes) */
    	if (joueurs[currentPlayer].canAct() && (cellX == playerX && (cellY == playerY || cellY-1==playerY || cellY+1==playerY) || cellY == playerY && (cellX-1==playerX || cellX+1==playerX)) && c.getEtat() == 2 ) {
    		c.resetEtat();
    		joueurs[currentPlayer].oneAction();
    		notifyObservers();
    	}
    	else {
    		System.out.println("nope");
    	}
    }
    
    public Cellule getCellule(int x, int y){
        return cellules[x][y];
    }
    public Joueur getPlayerOne(){
    	return joueurs[0];
    }
    public Joueur getPlayerTwo(){
    	return joueurs[1];
    }
    public Joueur getPlayerThree(){
    	return joueurs[2];
    }
    public Joueur getPlayerFour(){
    	return joueurs[3];
    }
    public Joueur getCurrentPlayer() {
    	return joueurs[currentPlayer];
    }

    public Joueur[] getJoueurs() {
        return this.joueurs;
    }
}

