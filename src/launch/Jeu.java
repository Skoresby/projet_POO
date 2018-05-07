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
	    public static final int larg_Fenetre = 2000;
	    public static final int haut_Fenetre = 1500;
	    public static final int larg_ere = 1400;
	    public static final int haut_ere = 1050;
	    public static final int x_ere = 600;
	    public static final int y_ere = 200;
	    public static final int xa= larg_Fenetre/10;
	    public static final int larg_bouton= 80;
	    public static final int haut_bouton= 40;
	    public static final int ya= haut_Fenetre -300;
	    public static final int alignement_b_x= 10;//pour menu et annuler
	    public static final int alignement_b_y= 10;//pour menu
	    public static final int larg_ere_joueur = 600;
	    public static final int y_ere_joueur = 200;

    public Partie choix_jeu() {
    	do
    	{	
    		System.out.println("domino/triomino?");
    		this.nom=sc.nextLine();
    		
    	}while (!this.nom.equals("Domino") && !this.nom.equals("Triomino"));
    	System.out.println("tu as choisi " + this.nom);
    	
    	Partie partie= new Partie();
    	//this.entrer_joueurs(partie);
    	return partie;
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

    public void entrer_joueurs(Partie partie, Joueur[] joueur) {
    	do
    	{
    		partie.set_nbre_j_humain();
    		partie.set_nbre_j_ordi();
    		if(partie.get_nbre_j_total()<2)
    		{
    			System.out.println("tu n as pas mis assez de joueurs");
    		}
    		else if (partie.get_nbre_j_total()>4)
    		{
    			System.out.println("tu as mis trop de joueurs");
    		}
    	}while(partie.get_nbre_j_total()<2 || partie.get_nbre_j_total()>4);
    	
    	//Joueur joueur[] = new Joueur[4];

    	for(int i=0; i<partie.get_nbre_j_humain(); i++)
    	{
    		joueur[i]=new Joueur();
    		joueur[i].set_nom();
    		if(partie.get_nbre_j_total() == 2)
    			joueur[i].set_nbre_piece(9);
    		else
    			joueur[i].set_nbre_piece(7);
    		joueur[i].set_type(1);
    		//verifier que humain c est 1
    		joueur[i].set_num_partie(partie.get_num_partie());
    		joueur[i].set_position(i);
    	}
    	for(int i=partie.get_nbre_j_humain(); i<partie.get_nbre_j_total(); i++)//donc pour tous les ordis
    	{
    		joueur[i]=new Joueur();
    		joueur[i].set_nom("ordi"+i);
    		if(partie.get_nbre_j_total() == 2)
    			joueur[i].set_nbre_piece(9);
    		else
    			joueur[i].set_nbre_piece(7);
    		joueur[i].set_type(2);
			joueur[i].set_num_partie(partie.get_num_partie());
			joueur[i].set_position(i);
    	}
    	
    	for(int i=partie.get_nbre_j_total(); i<4; i++)
    	{
    		joueur[i]=new Joueur();
    		joueur[i].set_nom(" ");
    		joueur[i].set_nbre_piece(0);
    		joueur[i].set_type(0);
			joueur[i].set_num_partie(partie.get_num_partie());
			joueur[i].set_position(-1);
    	}
    }

    public void retour_choix_jeu() {
        // TODO implement here
    }

    public void afficher_regles() {
        // TODO implement here
    }

    public void afficher_base() {
        // TODO implement here
    	
    }

}
