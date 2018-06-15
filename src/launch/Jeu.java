package launch;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Jeu extends JFrame implements MouseListener{
	
	
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
	    public static final int annuler_x= (larg_Fenetre/200);//pour menu et annuler  menu et tout
	    public static final int alignement_b_y= (larg_Fenetre/150);//pour menu
	    public static final int larg_ere_joueur = (int )(larg_Fenetre/(3));
	    public static final int y_ere_joueur =(int)(haut_Fenetre/(7.5));
	    public static final int y_annuler =(int)(haut_Fenetre/(1.5));
	    public static final int x_valider =(int)(haut_Fenetre/(3.33));
	    public static final int x_aff =(int)(haut_Fenetre/(16.66));
	    public static final int larg_aff =(int)(larg_Fenetre/(13.33));
	    public static final int y_nom4 =(int)(larg_Fenetre/(12.71));
	    public static final int y_nom3 =(int)(larg_Fenetre/(8.92));
	    public static final int y_nom2 =(int)(larg_Fenetre/(6.88));
	    public static final int y_nom1 =(int)(larg_Fenetre/(5.69));





    public Partie choix_jeu() {
    	do
    	{	
    		System.out.println("domino/triomino/domap?");
    		this.nom=sc.nextLine();
    		
    	}while (!this.nom.equals("domino") && !this.nom.equals("triomino")&&!this.nom.equals("domap"));
    	
    	System.out.println("tu as choisi " + this.nom);
    	
    	Partie jeton;
		System.out.println("jeu 60");

    	if (this.get_nom().equals("domino"))
		{
    		System.out.println("JEU 64");

			jeton=new Domino();
			jeton.setNom("domino");
			System.out.println("JEU 67");

		}
		else if(this.get_nom().equals("triomino"))
		{
			jeton=new Triomino();
			jeton.setNom("triomino");
		}
		else
		{
			jeton=new PiocheDomino();
			jeton.setNom("domap");
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    
}
