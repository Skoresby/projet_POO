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

import launch.Joueur;
import launch.Pion;

//import java.util.*;

abstract class Partie extends Jeu {
	
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
    protected Pion tableau[];
	protected Pion plateau[][];
	 
	 

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
    
    public void entrer_joueurs(Joueur[] joueur) {
    	do
    	{
    		this.set_nbre_j_humain();
    		this.set_nbre_j_ordi();
    		if(this.get_nbre_j_total()<2)
    		{
    			System.out.println("tu n as pas mis assez de joueurs");
    		}
    		else if (this.get_nbre_j_total()>4)
    		{
    			System.out.println("tu as mis trop de joueurs");
    		}
    	}while(this.get_nbre_j_total()<2 || this.get_nbre_j_total()>4);
    	
    	//Joueur joueur[] = new Joueur[4];

    	for(int i=0; i<this.nbreJoueurHumain; i++)
    	{
    		joueur[i]=new Joueur();
    		joueur[i].set_nom();
    		if(this.get_nbre_j_total() == 2)
    			joueur[i].set_nbre_piece(9);
    		else
    			joueur[i].set_nbre_piece(7);
    		joueur[i].set_type(1);
    		//verifier que humain c est 1
    		joueur[i].set_num_partie(this.numeroPartie);
    		joueur[i].set_position(i);
    	}
    	for(int i=this.nbreJoueurHumain; i<this.get_nbre_j_total(); i++)//donc pour tous les ordis
    	{
    		joueur[i]=new Joueur();
    		joueur[i].set_nom("ordi"+i);
    		if(this.get_nbre_j_total() == 2)
    			joueur[i].set_nbre_piece(9);
    		else
    			joueur[i].set_nbre_piece(7);
    		joueur[i].set_type(2);
			joueur[i].set_num_partie(this.numeroPartie);
			joueur[i].set_position(i);
    	}
    	
    	for(int i=this.get_nbre_j_total(); i<4; i++)
    	{
    		joueur[i]=new Joueur();
    		joueur[i].set_nom(" ");
    		joueur[i].set_nbre_piece(0);
    		joueur[i].set_type(0);
			joueur[i].set_num_partie(this.numeroPartie);
			joueur[i].set_position(-1);
    	}
    }
    
    //methodes abstraites
    abstract Pion[] init_tab();
	abstract Pion[][] init_plateau();
    abstract void afficher();
	abstract  int partie_finie(Joueur[] joueur);
	abstract int choisir_coup(Joueur[] joueur, int joueur_act);
    abstract int[] coup_possible(int indice);
	abstract void placer_pion(int indice);
    abstract int premier_a_jouer();	
    abstract void aide();

}