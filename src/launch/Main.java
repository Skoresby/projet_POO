package launch;

import java.util.Scanner;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		Partie partie = jeu.choix_jeu();
		Joueur joueur[] = new Joueur[4];
		jeu.entrer_joueurs(partie, joueur);
		AbsDomTrio jeton;
		if (jeu.get_nom().equals("Domino"))
		{
			jeton=new Domino();
		}
		else
		{
			jeton=new Triomino();
		}
		
		Pion[]tableau=jeton.init_tab();
		
		
		
		
	}

}
