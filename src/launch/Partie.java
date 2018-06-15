package launch;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import java.util.*;

abstract class Partie extends Jeu implements MouseListener {

	protected JPanel container = new JPanel();// le container contiendra tout les conposants de la fenetre
	protected JPanel ere = new JPanel();// panel ou se trouverra les domino joueur
	protected JPanel zone_joueur = new JPanel();
	protected JScrollPane scroll = new JScrollPane(ere);// bare de scroll sur la zone de jeu précedemment définie
	protected ImageIcon img = new ImageIcon(
			"C:\\Users\\mac\\Desktop\\ISTY\\semestre2\\POO\\JAVA\\image_DT/b_annuler.JPG");// bouton annuler
	protected JButton annuler = new JButton("", img);
	protected ImageIcon imgm = new ImageIcon("C:\\Users\\mac\\Desktop\\ISTY\\semestre2\\POO\\JAVA\\image_DT/Menu.PNG");// bouton
																														// MENU
	protected JButton menu = new JButton("", imgm);
	ImageIcon imgv = new ImageIcon("C:\\Users\\mac\\Desktop\\ISTY\\semestre2\\POO\\JAVA\\image_DT/b_valider.PNG");// bouton
																													// valider
	JButton valider = new JButton("", imgv);

	public Partie() {

	}

	private int numeroPartie;
	protected int nbreJoueurHumain;
	protected int nbreJoueurOrdi;
	private int idGagant;
	private int scoreGagnant;
	protected Pion tableau[];
	protected Pion plateau[][];
	protected String nom_jeu;
	// protected LesDomino listImg = new LesDomino();

	public void terminer_coup() {
	}
	
	public void setNom(String nom) {
		this.nom_jeu=nom;
	}

	public void lancer_partie() {
	}

	public void menu() {
		// TODO implement here
	}

	public void set_gagnant() {
		// TODO implement here
	}

	public int get_nbre_j_total() {
		return this.nbreJoueurHumain + this.nbreJoueurOrdi;
	}

	public int get_nbre_j_humain() {
		return this.nbreJoueurHumain;
	}

	public int get_num_partie() {
		return this.numeroPartie;
	}

	public void set_nbre_j_humain() {

		do {
			System.out.println("combien de joueurs humains?");
			this.nbreJoueurHumain = sc.nextInt();
		} while (this.nbreJoueurHumain < 1 || this.nbreJoueurHumain > 4);

	}

	public void set_nbre_j_ordi() {

		do {

			System.out.println("combien de joueurs ordinateur?");
			this.nbreJoueurOrdi = sc.nextInt();
		} while (this.nbreJoueurOrdi < 0 || this.nbreJoueurOrdi > 4);
	}

	public void annuler_coup() {
		// TODO implement here
	}

	public void afficher_base_jeu() {

	}

	public void entrer_joueurs(Joueur[] joueur) {
		/*
		do { this.set_nbre_j_humain(); this.set_nbre_j_ordi();
		 * if(this.get_nbre_j_total()<2) {
		 * System.out.println("tu n as pas mis assez de joueurs"); } else if
		 * (this.get_nbre_j_total()>4) {
		 * System.out.println("tu as mis trop de joueurs"); }
		 * }while(this.get_nbre_j_total()<2 || this.get_nbre_j_total()>4);
		 */
		this.nbreJoueurHumain = 1;
		this.nbreJoueurOrdi = 1;

		// Joueur joueur[] = new Joueur[4];

		for (int i = 0; i < this.nbreJoueurHumain; i++) {
			joueur[i] = new Joueur();
			joueur[i].set_nom("KYNDRA");
			System.out.println("118"+nom);
			if (this.nom_jeu.equals("triomino")) {
				if (this.get_nbre_j_total() == 2)
					joueur[i].set_nbre_piece(9);
				else
					joueur[i].set_nbre_piece(7);
			} else {
				if (this.get_nbre_j_total() == 2)
					joueur[i].set_nbre_piece(7);
				else
					joueur[i].set_nbre_piece(6);
			
			}
			joueur[i].set_type(1);
			// verifier que humain c est 1
			joueur[i].set_num_partie(this.numeroPartie);
			joueur[i].set_position(i);
		}
		for (int i = this.nbreJoueurHumain; i < this.get_nbre_j_total(); i++)// donc pour tous les ordis
		{
			joueur[i] = new Joueur();
			joueur[i].set_nom("ordi" + i);
			if (nom_jeu.equals("triomino")) {
				if (this.get_nbre_j_total() == 2)
					joueur[i].set_nbre_piece(9);
				else
					joueur[i].set_nbre_piece(7);
			} else {
				if (this.get_nbre_j_total() == 2)
					joueur[i].set_nbre_piece(17);
				else
					joueur[i].set_nbre_piece(6);
			}
			joueur[i].set_type(2);
			joueur[i].set_num_partie(this.numeroPartie);
			joueur[i].set_position(i);
		}

		for (int i = this.get_nbre_j_total(); i < 4; i++) {
			joueur[i] = new Joueur();
			joueur[i].set_nom(" ");
			joueur[i].set_nbre_piece(0);
			joueur[i].set_type(0);
			joueur[i].set_num_partie(this.numeroPartie);
			joueur[i].set_position(-1);
		}
	}

	// methodes abstraites
	abstract Pion[] init_tab();

	abstract void afficher(Joueur[] joueur, int joueurAct);

	abstract boolean partie_gagnee();

	abstract boolean coup_possible();

	abstract int premier_a_jouer();

	abstract void aide();

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