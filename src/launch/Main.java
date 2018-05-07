package launch;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("je suis dans le bon dossier!!!");
		Jeu jeu = new Jeu();
		Partie partie = jeu.choix_jeu();
		Joueur joueur[] = new Joueur[4];
		Domino dom= new Domino();
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
		
		
		//Triomino jetons=new Triomino();
		Pion[]tableau=jeton.init_tab();
		partie.afficher_base_jeu();
		dom.afficher();
		System.out.println("rien");

		
	}

}
