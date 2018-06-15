package launch;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		System.out.println("main 14");

		Partie jeton = jeu.choix_jeu();
		System.out.println("main 17");

		Joueur joueur[] = new Joueur[4];
		System.out.println("main 20");

		//Domino dom= new Domino();
		
		jeton.entrer_joueurs(joueur);
		
		//jeton.afficher_base_jeu();
		System.out.println("main 22");
		Pion[]tableau=jeton.init_tab();
		//jeton.premier_a_jouer();
		System.out.println("main 24");
        //Joueur.info();
		int joueurAct=1;
		//jeton.premier_a_jouer();
		jeton.afficher( joueur, joueurAct);	

        }

}
