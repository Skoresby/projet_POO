package launch;

//import java.util.*;

public class Partie extends Jeu {

    public Partie() {
    }

    
    private int numeroPartie;
    protected int nbreJoueurHumain;
    protected int nbreJoueurOrdi;
    private int idGagant;
    private int scoreGagnant;

    public void terminer_coup() {
    }

    public void lancer_partie() {
    }

    public void menu() {
        // TODO implement here
    }

    public void set_gagnant() {
        // TODO implement here
    }

    public int get_nbre_j_total() {
    	return this.nbreJoueurHumain+this.nbreJoueurOrdi;
    }
    
    public int get_nbre_j_humain() {
    	return this.nbreJoueurHumain;
    }
    
    public int get_num_partie() {
    	return this.numeroPartie;
    }
    
    public void set_nbre_j_humain() {
    	do
    	{
    		System.out.println("combien de joueurs humains?");
    		this.nbreJoueurHumain=sc.nextInt();    		
    	}while (this.nbreJoueurHumain<1 || this.nbreJoueurHumain>4);
    	
    }

    public void set_nbre_j_ordi() {
    	
    	do
    	{
	    	
    		System.out.println("combien de joueurs ordinateur?");
    		this.nbreJoueurOrdi=sc.nextInt();    		
    	}while (this.nbreJoueurOrdi<0 || this.nbreJoueurOrdi>4);
    }

    public void annuler_coup() {
        // TODO implement here
    }

    public void afficher_base_jeu() {
        // TODO implement here
    }

}