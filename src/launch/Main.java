package launch;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		Partie jeton = jeu.choix_jeu();
		Joueur joueur[] = new Joueur[4];
		Domino dom= new Domino();
		
		jeton.entrer_joueurs(joueur);
		
		
		jeton.afficher_base_jeu();

		Pion[]tableau=jeton.init_tab();
				
	}

}
