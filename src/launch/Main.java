package launch;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
<<<<<<< HEAD
		//Partie partie = jeu.choix_jeu();
=======
		Partie jeton = jeu.choix_jeu();
>>>>>>> branch 'master' of https://github.com/Skoresby/projet_POO
		Joueur joueur[] = new Joueur[4];
<<<<<<< HEAD
		Domino dom= new Domino();
		//jeu.entrer_joueurs(partie, joueur);
		AbsDomTrio jeton;
		//if (jeu.get_nom().equals("Domino"))
		//{
=======
		jeton.entrer_joueurs(joueur);
>>>>>>> branch 'master' of https://github.com/Skoresby/projet_POO
		
			//jeton=new Domino();
		//}
		//else
		//{
			//jeton=new Domino();
		//}
		Partie partie = new Partie();
		
<<<<<<< HEAD
		//Triomino jetons=new Triomino();
		//Pion[]tableau=jeton.init_tab();
		partie.afficher_base_jeu();
		//jeton.afficher();
		System.out.println("rien");

=======
		Pion[]tableau=jeton.init_tab();
		
		
		
>>>>>>> branch 'master' of https://github.com/Skoresby/projet_POO
		
	}

}
