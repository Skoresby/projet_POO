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
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		Joueur joueur[] = new Joueur[4];

		Partie jeton = jeu.choix_jeu();
		
		jeton.entrer_joueurs(joueur);
		
		
		//jeton.afficher_base_jeu();

		Pion[]tableau=jeton.init_tab();
		Pion[][] plateau=jeton.init_plateau();
		joueurAct=jeton.premier_a_jouer();		
		do
		{
			System.out.println("c est au tour de "+joueur[joueurAct].get_pseudo()+" de jouer");
			if(joueur[joueurAct].get_type()==1)//humain
				indiceChoisi=jeton.choisir_coup(joueur, joueurAct);
			else
				indiceChoisi=jeton.ia(joueur, joueurAct);
			
			if(indiceChoisi!=-1)//si -1 donc passe son tour
			{
		    	jeton.placer_pion(indiceChoisi, joueur, joueurAct);
			}
			joueurAct=(joueurAct+1)%jeton.get_nbre_j_total();
			finJeu=jeton.partie_finie(joueur);
		}while(finJeu==0);
		
		
	}

}
