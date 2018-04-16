import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controleur implements ActionListener {
    CModele modele;
    public Controleur(CModele modele) {
        this.modele = modele; }

    public void actionPerformed(ActionEvent e) {
    	/** Fin de tour */
    	if (e.getActionCommand()=="Avance"){
    		modele.avance();	
    	}
    	/** Deplacements */
    	if (e.getActionCommand()=="Gauche") {
    		modele.playerMovement(0);
    	}
    	if (e.getActionCommand()=="Droite") {
    		modele.playerMovement(1);
    	}
    	if (e.getActionCommand()=="Haut") {
    		modele.playerMovement(2);
    	}
    	if (e.getActionCommand()=="Bas") {
    		modele.playerMovement(3);
    	}
    	/** Assechement */
    	/** On pourrait peut etre faire 5 fonctions du type 'assechela' dans CModel pour plus de clarte */
    	int playerX = modele.getCurrentPlayer().getAbs();
    	int playerY = modele.getCurrentPlayer().getOrd();
    	if (e.getActionCommand()=="AssecheGauche") {
    		modele.dry(modele.getCellule(playerX-1, playerY));
    	}
    	if (e.getActionCommand()=="AssecheDroite") {
    		modele.dry(modele.getCellule(playerX+1, playerY));
    	}
    	if (e.getActionCommand()=="AssecheHaut") {
    		modele.dry(modele.getCellule(playerX, playerY-1));
    	}
    	if (e.getActionCommand()=="AssecheBas") {
    		modele.dry(modele.getCellule(playerX, playerY+1));
    	}
    	if (e.getActionCommand()=="AssecheIci") {
    		modele.dry(modele.getCellule(playerX, playerY));
    	}
        
    }
}