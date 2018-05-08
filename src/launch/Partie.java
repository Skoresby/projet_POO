package launch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import java.util.*;

public class Partie extends Jeu {
	
	protected JPanel container = new JPanel();//le container contiendra tout les conposants de la fenetre
    protected JPanel  ere = new JPanel();//panel ou se trouverra les domino joueur
    protected JPanel zone_joueur = new JPanel();
	protected JScrollPane scroll = new JScrollPane(ere);//bare de scroll sur la zone de jeu précedemment définie
	protected ImageIcon img = new ImageIcon("C:\\Users\\mac\\Desktop\\ISTY\\semestre2\\POO\\JAVA\\image_DT/b_annuler.JPG");//bouton annuler
	protected JButton annuler = new JButton("",img);
	protected ImageIcon imgm = new ImageIcon("C:\\Users\\mac\\Desktop\\ISTY\\semestre2\\POO\\JAVA\\image_DT/Menu.PNG");//bouton MENU
	protected JButton menu = new JButton("",imgm);
	ImageIcon imgv = new ImageIcon("C:\\Users\\mac\\Desktop\\ISTY\\semestre2\\POO\\JAVA\\image_DT/b_valider.PNG");//bouton valider
	JButton valider = new JButton("",imgv);
    public Partie() {
    }

    
    private int numeroPartie;
    protected int nbreJoueurHumain;
    protected int nbreJoueurOrdi;
    private int idGagant;
    private int scoreGagnant;

    public void terminer_coup() {
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
    	return this.nbreJoueurHumain+this.nbreJoueurOrdi;
    }
    
    public int get_nbre_j_humain() {
    	return this.nbreJoueurHumain;
    }
    
    public int get_num_partie() {
    	return this.numeroPartie;
    }
    
    public void set_nbre_j_humain() {
    	do
    	{
    		System.out.println("combien de joueurs humains?");
    		this.nbreJoueurHumain=sc.nextInt();    		
    	}while (this.nbreJoueurHumain<1 || this.nbreJoueurHumain>4);
    	
    }

    public void set_nbre_j_ordi() {
    	
    	do
    	{
	    	
    		System.out.println("combien de joueurs ordinateur?");
    		this.nbreJoueurOrdi=sc.nextInt();    		
    	}while (this.nbreJoueurOrdi<0 || this.nbreJoueurOrdi>4);
    }

    public void annuler_coup() {
        // TODO implement here
    }

    public void afficher_base_jeu() {
    	this.setTitle("Ma première fenêtre Java");
		  this.setSize(larg_Fenetre, haut_Fenetre);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setLocationRelativeTo(null);
		  this.setVisible(true);
		  
		  container.setLayout(null);
		  zone_joueur.setLayout(null);
		  System.out.println("ere="+haut_ere);
		  zone_joueur.setBounds(0,y_ere_joueur,larg_ere_joueur,haut_ere);
		  zone_joueur.setOpaque(true);
		  zone_joueur.setBackground(Color.gray);
		  
		  Font pole= new Font("tahona",Font.BOLD,16);//definition d'une police pour les écrits
		    annuler.setFont(pole);
		    annuler.setBounds(annuler_x,y_annuler,larg_bouton,haut_bouton);
		    annuler.setOpaque(true);
		    annuler.addActionListener( new ActionListener() {//ecouteur permetant d'emplemmenter les actions du bouton annuler
		    	public void actionPerformed(ActionEvent e) {
		    	System.out.println("annuler");
		    	System.exit(0);
		    	}
		    	}
		    	);
		    valider.setFont(pole);
		    valider.setBounds(x_valider, y_annuler, larg_bouton, haut_bouton);
		    valider.setOpaque(true);
		    
		    menu.setBounds(annuler_x,0, larg_bouton, haut_bouton);
		    menu.setOpaque(true);
		    
		    ere.setLayout(null);
			ere.setBackground(new Color (82,137,83));//fond gris
			ere.setBounds(y_ere,y_ere,larg_ere,haut_ere);


		    zone_joueur.add(annuler);
		    zone_joueur.add(valider);
		    zone_joueur.add(menu);
		  container.add(zone_joueur);
		  container.add(ere);

		  this.setContentPane(container);
		    
		  }

}