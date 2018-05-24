package launch;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import launch.Joueur;
import launch.Pion;


public class Domino extends Partie {
	protected JTextArea nom1 = new JTextArea("  nom joueur4");
	protected JTextArea nom2 = new JTextArea("  nom joueur3");
	protected JTextArea nom3 = new JTextArea("  nom joueur2");
	protected JTextArea nom4 = new JTextArea("  nom joueur1");
	protected  String texte1;
	protected  String texte2;
	protected  String texte3;
	protected  String texte4;
	protected String s1;
	protected String s2;
	protected String s3;
	protected String s4;
	//creation des zones d'affichage score ET DE NOMNS DES JOUEURS
	protected JLabel  label = new JLabel("noms joueurs");
	protected JLabel  score = new JLabel("score");
	protected JLabel  score_J1 = new JLabel("  0 ");
	protected JLabel  score_J2 = new JLabel("  0 ");
	protected JLabel  score_J3 = new JLabel("  0 ");
	protected JLabel  score_J4 = new JLabel("  0 ");
	
	public Domino() {

    	
    }
    
    int premier_a_jouer(){ 
    	int a=-1;
    	return a;
    }
    
    Pion[] init_tab() {
    	Pion[] aFaire=new Pion[28];//j ai mis this.tableau
    	return aFaire;
    }

    Pion[][] init_plateau() {
    	Pion[][] a =new Pion[56][56];
    	return a;
    }
    
		 
    void placer_pion(int indice) {
    	return;
		 
	 }
    
    void aide() {
    }

    boolean partie_gagnee() {
    	boolean gagne=false;
    	return gagne;
    }

    int[] coup_possible(int indice) {
 	   int[] coup= new int[2];
 	   return coup;
     }

    int choisir_coup(Joueur[] joueur, int joueur_act) {
 	   return -1;
    }
    
    int partie_finie(Joueur[] joueur) {
    	return -1;
    }

    void afficher() {
    	label.setBounds(200, 90, 400, 70);
    	label.setForeground(Color.blue);
    	label.setHorizontalAlignment(JLabel.CENTER);
    	container.add(label);
    	label.setOpaque(false);
    	
		  


    }

}