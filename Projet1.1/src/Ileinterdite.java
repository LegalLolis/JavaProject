import java.util.Random;
import java.util.Scanner;

public class Ileinterdite {
    public static void main(String [] args){
    	
    /**Scanner sc = new Scanner(System.in);
    int nbrjoueurs =5;
    while (nbrjoueurs>4 || nbrjoueurs<1) {
	    System.out.println("Veuillez saisir le nombre de joueurs (de 1 à 4) : ");
	    String str = sc.nextLine();
	    nbrjoueurs = Integer.parseInt(str);
    }
    sc.close();*/
        
    CModele modele = new CModele(/**nbrjoueurs*/ 4);
    CVue vue = new CVue(modele);

    }
}
