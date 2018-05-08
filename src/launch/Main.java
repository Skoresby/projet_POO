package launch;

import java.util.Scanner;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		Partie jeton = jeu.choix_jeu();
		Joueur joueur[] = new Joueur[4];
		jeton.entrer_joueurs(joueur);
		
		
		Pion[]tableau=jeton.init_tab();
		
		
		
		
	}

}
