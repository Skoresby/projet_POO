package launch;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

import launch.Joueur;
import launch.Pion;

public class Main extends JFrame{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int joueurAct=-1; 
		int indiceChoisi=-1;
		int retourCoupPossible=-1;
		int finJeu=-1;
		Pion[] hand = new Pion[10];
		//System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		Joueur joueur[] = new Joueur[4];

		Partie jeton = jeu.choix_jeu();
		//Domino dom= new Domino();
		
		//jeton.entrer_joueurs(joueur);
		
		
		//jeton.afficher_base_jeu();

		//Pion[]tableau=jeton.init_tab();
		//Pion[][] plateau=jeton.init_plateau();
		triangle_m aff = new triangle_m();
		joueurAct=jeton.premier_a_jouer();
		
		/*do
		{
			System.out.println("le joueur numero "+joueurAct+" commence");
			indiceChoisi=jeton.choisir_coup(joueur, joueurAct);
			//retourCoupPossible=jeton.coup_possible(indiceChoisi);
	    	jeton.placer_pion(indiceChoisi);

			//System.out.println("retour : coll="+(retourCoupPossible/10)+" nbre de tours a faire : "+(retourCoupPossible%10));
		
			finJeu=jeton.partie_finie(joueur);
		}while(finJeu==0);*/
		
	}

}
