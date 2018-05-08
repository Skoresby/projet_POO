package launch;

import java.util.Scanner;

public class Jeu {
	
	 public Jeu() { 
	    
	}
	protected Scanner sc = new Scanner(System.in);
    protected String nom;
    protected int nbreJoueursMax=4;
   
    public Partie choix_jeu() {
    	do
    	{	
    		System.out.println("domino/triomino?");
    		this.nom=sc.nextLine();
    		
    	}while (!this.nom.equals("domino") && !this.nom.equals("triomino"));
    	System.out.println("tu as choisi " + this.nom);
    	
    	Partie jeton;
    	
    	if (this.get_nom().equals("domino"))
		{
			jeton=new Domino();
		}
		else
		{
			jeton=new Triomino();
		}
    	
    	//this.entrer_joueurs(partie);
    	return jeton;
    }
    
    public String get_nom() {
    	return this.nom;
    	
    }
    public void menu() {
        // TODO implement here
    }

    public void fermer_jeu() {
        // TODO implement here
    }

    public void meilleurs_scores() {
        // TODO implement here
    }

    

    public void retour_choix_jeu() {
        // TODO implement here
    }

    public void afficher_regles() {
        // TODO implement here
    }

    public void afficher_base_de_donnee() {
        // TODO implement here
    }
}
