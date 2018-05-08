package launch;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Domino extends AbsDomTrio {
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
	
	protected Domino() {
    	
    }
    
    int premier_a_jouer(){ 
    	int a=-1;
    	return a;
    }
    
    Pion[] init_tab() {
    	Pion[] aFaire=new Pion[28];//j ai mis this.tableau
    	return aFaire;
    }

    void aide() {
    }

    boolean partie_gagnee() {
    	boolean gagne=false;
    	return gagne;
    }

   boolean coup_possible() {
	   boolean coup=false;
	   return coup;
    }

    void afficher() {
    	label.setBounds(200, 90, 400, 70);
    	label.setForeground(Color.blue);
    	label.setHorizontalAlignment(JLabel.CENTER);
    	container.add(label);
    	label.setOpaque(false);
    	
		  


    }

}