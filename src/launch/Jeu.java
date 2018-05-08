package launch;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Jeu extends JFrame {
	
	
	 public Jeu() { 
 
	}
	   protected Scanner sc = new Scanner(System.in);
	    protected String nom;
	    protected int nbreJoueursMax=4;
	    //les macro
	    public static final int larg_Fenetre = 2000;
	    public static final int haut_Fenetre = 1500;
	    public static final int larg_ere = (int )(larg_Fenetre/(1.25));
	    public static final int haut_ere = (int)(haut_Fenetre/(1.42));
	    public static final int x_ere = (int)(larg_Fenetre/(1.33));
	    public static final int y_ere = (int)(haut_Fenetre/(7.5));
	    public static final int xa= larg_Fenetre/10;
	    public static final int larg_bouton= 80;
	   
	    public static final int haut_bouton= 40;
	    public static final int ya= (int)(haut_Fenetre /(1.25));
	    public static final int annuler_x= (larg_Fenetre/200);//pour menu et annuler
	    public static final int alignement_b_y= (larg_Fenetre/150);//pour menu
	    public static final int larg_ere_joueur = (int )(larg_Fenetre/(3));
	    public static final int y_ere_joueur =(int)(haut_Fenetre/(7.5));
	    public static final int y_annuler =(int)(haut_Fenetre/(1.5));
	    public static final int x_valider =(int)(haut_Fenetre/(3.33));

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
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/Skoresby/projet_POO
}
