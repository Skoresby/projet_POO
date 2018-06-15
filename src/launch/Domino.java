package launch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.Dimension;

public class Domino extends Partie implements ActionListener {
	protected JPanel container = new JPanel();
	protected LesDominos listImg;
	// protected LesDominos listImg = new LesDominos();

	protected JPanel zone_joueur = new JPanel();// definition de la zone ou se trouve les donino de celui qui joue
	private JPanel pan = new JPanel();// ajout de l'image de fond
	private JPanel ere = new JPanel();//
	// private JScrollPane scroll = new JScrollPane(ere);
	ImageIcon img = new ImageIcon("b_annuler.JPG");// bouton annuler
	JButton annuler = new JButton("", img);
	ImageIcon imgP = new ImageIcon("fleche.JPG");// bouton suivant
	JButton suivant = new JButton("", imgP);
	// private Pions p = new Pions();
	ImageIcon imgv = new ImageIcon("b_valider.PNG");// bouton valider
	JButton valider = new JButton("", imgv);
	ImageIcon imgm = new ImageIcon("Menu.PNG");// bouton MENU
	JButton menu = new JButton("", imgm);
	// ImageIcon imgp = new ImageIcon("p.PNG");//bouton pioche
	// JButton pioche = new JButton("",imgp);
	private JLabel nom1 = new JLabel("  nom joueur4");
	private JLabel nom2 = new JLabel("  nom joueur3");
	private JLabel nom3 = new JLabel("  nom joueur2");
	private JLabel nom4 = new JLabel("  nom joueur1 ");

	private String texte1;
	private String texte2;
	private String texte3;
	private String texte4;
	private String s1;
	private String s2;
	private String s3;
	private String s4;

	// String tete = "le niiiiiiiiii";
	// creation des zones d'affichage score ET DE NOMNS DES JOUEURS
	private JLabel label = new JLabel("noms joueurs");
	private JLabel score = new JLabel(" NbDomRes");
	private JLabel score_J1 = new JLabel("  0 ");
	private JLabel score_J2 = new JLabel("  0 ");
	private JLabel score_J3 = new JLabel("  0 ");
	private JLabel score_J4 = new JLabel("  0 ");
	// private Affiche pan_aff = new Affiche();

	private int compteur;
	public static final boolean Joue = true;
	public static final boolean PasJoue = false;
	public static final boolean Horizontal = true; // de la forme : /\
	public static final boolean Vertical = false;

	public Domino() {

	}

	/*les fonction théorique sont mise en commin avec les fonction graphiques mais aucune fonction 
	 * theorique (exectée init!tab nest appelée car nous n'avons pas encore trouvé comment faire la laison entres elles
	 */
	
	
	//fonction permettant de determiner quel joueur debute la partie 
	int premier_a_jouer() {
		 
	    	int numCase=-1,i=0,tem=6,one=0,Max=0;// car 6 est le plus grand double
	    	int []somme =new int[28];
	    	int nbre_double=0,id;
	    	int [] val =new int[2];
	    	do
	    	{
	    		if(tem>=0)//
	    		{
	    			do
	    			{
	    				
	    				val = this.tableau[i].get_valeurs();
	    				if((val[0]==val[1])&&(val[0]==tem))
	    				{
	    					numCase = i;
	    					nbre_double++;
	    					i++;
	    					//System.out.println("nC="+numCase+", tem="+tem);
	    					
	    				}
	    			} while((i<28)&& (numCase<0));
	    			tem--;
	    			one=numCase/7;					
	    		}
	    		else
	    		{	
	    			for(id=0;id<(get_nbre_j_total() * 7);id++)
	    			{
	    			
	    				val = this.tableau[i].get_valeurs();
	    				somme[id] = val[0] + val[1];
	                    System.out.println("les sommes"+id+"sont "+somme[id]+"\n");
	    			}
	    			
	    			for(id=0;id<(get_nbre_j_total() *7);id++)
	                 {
	                     if(somme[id]>=somme[Max])
	                     {
	                       Max=id;
	                     }
	                 }
	    			 System.out.println("le joueur qui commence le jeu est le joueur" + (Max/7+1) + " avec une somme de"+ somme[Max]+"\n");
	                 one=(Max/7); 			
	    		}
	    		
	    	}while((numCase/7)>=get_nbre_j_total());
	    	 System.out.println("le joueur qui commence est le numéro "+one+"avec le double "+tem+1 +"\n");
	    	 return one;
	    }
	
//initialise le tableau permettant de fiare un partie de jeu
	Pion[] init_tab() {
		
		tableau = new Pion[28];
		int numCase = 0;
		Pion transition;
		for (int k = 0; k < 28; k++) {
			this.tableau[k] = new Pion();
			this.tableau[k].set_valeurs(new int[2]);
		}
		for (int numHaut = 0; numHaut < 7; numHaut++) {
			for (int numBas = numHaut; numBas < 7; numBas++) {
				int[] v = new int[2];
				v[0] = numHaut;
				v[1] = numBas;
				this.tableau[numCase].set_valeurs(v);
				this.tableau[numCase].set_occupation(PasJoue);
				numCase++;
			}
		}
		for (numCase = 0; numCase < 28; numCase++) {
			Random rand = new Random();
			int hasard = rand.nextInt(28);
			transition = this.tableau[numCase];
			this.tableau[numCase] = this.tableau[hasard];
			this.tableau[hasard] = transition;

		}
		aff_tab();
		return tableau;
	}

	public void aff_tab() {
		// pour l'affichage
		for (int i = 0; i < 28; i++) {
			System.out.print(i + " ");
		}
		System.out.println(" ");
		for (int i = 0; i < 28; i++) {
			int[] var = new int[2];
			var = this.tableau[i].get_valeurs();
			if (i < 10)
				System.out.print(var[0] + " ");
			else
				System.out.print(var[0] + "  ");
		}
		System.out.println(" ");

		for (int j = 0; j < 28; j++) {
			int[] var = new int[2];
			var = this.tableau[j].get_valeurs();
			if (j < 10)
				System.out.print(var[1] + " ");
			else
				System.out.print(var[1] + "  ");
		}
		System.out.println(" ");

	}

	Pion[][] init_plateau() {
		Pion[][] a = new Pion[56][56];
		return a;
	}
	void placer_pion(int indice)
    {
    	int i=0,j=0,k=0,l=0;// i et j sont les indices de la case correspondant au dernier domino placé sur le plateau
    	// k et l sont les indices de la case correspondant au choix de placement de l'utilsateur à récuperer normalement
    	// (à déterminer à partir de son clic )
    	int []valP1=this.plateau[i][j].get_valeurs();
    	int []valP2=this.tableau[indice].get_valeurs();
    	int []valcase =new int[2];
    	boolean occup1=this.plateau[i][j].get_occupation();
    	
    
        if (occup1==Horizontal)
        {
        	
        		if((valP1[1]==valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[0]!=valP1[1]))//val2 de p1 = val1 de p1 uniquement et p1 non double
            	{
            				
        			this.plateau[i+1][j].set_valeurs(valP2);
        			this.plateau[i+1][j].set_occupation(this.tableau[indice].get_occupation());	
        			this.tableau[indice].set_occupation(Joue);
        	    }
        		else if((valP1[1]==valP2[1])&&(valP1[1]!=valP2[0])&&(valP1[0]!=valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[0]!=valP1[1]))//val2 de p1 = val2 de p1 uniquement et p1 double
        		{
        			
        			this.plateau[i+1][j].set_valeurs(valP2);
        			this.plateau[i+1][j].set_occupation(Vertical);
        			this.tableau[indice].set_occupation(Joue);
        		}
        		else if((valP1[0]==valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[1]!=valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP1[1]))//val1 de p1 = val1 de p1 uniquement et p1 non double
        		{
        			
        			this.plateau[i-1][j].set_valeurs(valP2);
        			this.plateau[i-1][j].set_occupation(Vertical);
        			this.tableau[indice].set_occupation(Joue);
        		}
        		else if((valP1[0]==valP2[1])&&(valP1[0]!=valP2[0])&&(valP1[1]!=valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP1[1]))////val1 de p1 = val2 de p1 uniquement et p1 non double
        		{
        			
        			this.plateau[i-1][j].set_valeurs(valP2);
        			this.plateau[i-1][j].set_occupation(Vertical);	
        			this.tableau[indice].set_occupation(Joue);
        		}
        		else if((valP1[0]==valP2[1])&&(valP1[0]==valP2[0])&&(valP1[0]!=valP1[1])&&(valP1[0]!=valP1[1]))//val1 de p1 est égale aux valeurs du double p2 et p1 non double
        		{
        			
        			this.plateau[i-1][j].set_valeurs(valP2);
        			this.plateau[i-1][j].set_occupation(this.tableau[indice].get_occupation());	
        			this.tableau[indice].set_occupation(Joue);
        		}
        		else if((valP1[1]==valP2[1])&&(valP1[1]==valP2[0])&&(valP1[0]!=valP1[1]))//val2 de p1 est égale aux valeurs du double p2 et p1 non double
        		{
        			
        			this.plateau[i+1][j].set_valeurs(valP2);
        			this.plateau[i+1][j].set_occupation(this.tableau[indice].get_occupation());
        			this.tableau[indice].set_occupation(Joue);
        		}
        		else if ((valP1[0]==valP2[1])&&(valP1[1]==valP2[0])&&(valP1[0]!=valP1[1]))//val1 de p1 =val2 de p2  et val2 de p1 = val1 de p2 besoin de k et l
        		{
        			
        				this.plateau[k][l].set_valeurs(valP2);
            			this.plateau[k][l].set_occupation(this.tableau[indice].get_occupation());
            			this.tableau[indice].set_occupation(Joue);
        			
        		}
        		else if((valP1[0]==valP1[1])&&(valP1[1]==valP2[0])&&(valP2[0]!=valP2[1]))//le pion p1 est un double et sa val1 = val1 de p2 besoin de k et de l
        		{
        			
        			if(k==i+1)
        			{
        				this.plateau[k][l].set_valeurs(valP2);
            			this.plateau[k][l].set_occupation(this.tableau[indice].get_occupation());
            			this.tableau[indice].set_occupation(Joue);
        			}
        			else
        			{
        				this.plateau[k][l].set_valeurs(valP2);
            			this.plateau[k][l].set_occupation(Vertical);
            			this.tableau[indice].set_occupation(Joue);
        			}
        		}
        		else if((valP1[0]==valP1[1])&&(valP1[1]==valP2[1])&&(valP2[0]!=valP2[1]))//le pion p1 est un double et sa val1 = val2 de p2
        		{
        			
        			if(k==i-1)
        			{
        				this.plateau[k][l].set_valeurs(valP2);
            			this.plateau[k][l].set_occupation(this.tableau[indice].get_occupation());
            			this.tableau[indice].set_occupation(Joue);
        			}
        			else
        			{
        				this.plateau[k][l].set_valeurs(valP2);
            			this.plateau[k][l].set_occupation(Vertical);
            			this.tableau[indice].set_occupation(Joue);
        			}
        		}
        		else
        		{
        			System.out.println("Autre cas");
        		}
  
        }
        if (occup1==Vertical)
        {
        	if((valP1[0]==valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[1]!=valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP1[1]))//val1 de p1 = val1 de p2 uniquement et p1 non double
        	{
        		
    			this.plateau[i][j-1].set_valeurs(valP2);
    			this.plateau[i][j-1].set_occupation(Vertical);	
    			this.tableau[indice].set_occupation(Joue);
    	    }
        	else if((valP1[0]==valP2[1])&&(valP1[0]!=valP2[0])&&(valP1[1]!=valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP1[1]))//val1 de p1 = val2 de p2 uniquement et p1 non double
    		{
    			
    			this.plateau[i][j-1].set_valeurs(valP2);
    			this.plateau[i][j-1].set_occupation(Vertical);	
    			this.tableau[indice].set_occupation(Joue);
    		}
        	else if((valP1[1]==valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[0]!=valP1[1]))//val2 de p1 = val1 de p2 uniquement et p1 non double
    		{
    			
    			this.plateau[i][j-1].set_valeurs(valP2);
    			this.plateau[i][j-1].set_occupation(Vertical);	  
    			this.tableau[indice].set_occupation(Joue);
    		}
        	else if((valP1[1]==valP2[1])&&(valP1[1]!=valP2[0])&&(valP1[0]!=valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[0]!=valP1[1]))//val2 de p1 = val2 de p2 uniquement et p1 non double
    		{
    			
    			this.plateau[i][j+1].set_valeurs(valP2);
    			this.plateau[i][j+1].set_occupation(Vertical);
    			this.tableau[indice].set_occupation(Joue);
    		}
        	else if((valP1[0]==valP2[0])&&(valP1[0]==valP2[1])&&(valP1[1]!=valP2[0])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP1[1]))//val1 de p1 est égale aux valeurs du double p2 et p1 non double
    		{
    			
        		if(k==i-1)
    			{
    				this.plateau[k][l].set_valeurs(valP2);
        			this.plateau[k][l].set_occupation(this.tableau[indice].get_occupation());
        			this.tableau[indice].set_occupation(Joue);
    			}
    			else
    			{
    				this.plateau[k][l].set_valeurs(valP2);
        			this.plateau[k][l].set_occupation(Vertical);
        			this.tableau[indice].set_occupation(Joue);
    			}	
        		
        		
    		}
        	else if((valP1[1]==valP2[0])&&(valP1[1]==valP2[0])&&(valP1[0]!=valP2[1])&&(valP1[1]!=valP2[1])&&(valP1[0]!=valP1[1]))//val2 de p1 est égale aux valeurs du double p2 et p1 non double
    		{
    			
        		if(k==i+1)
    			{
    				this.plateau[k][l].set_valeurs(valP2);
        			this.plateau[k][l].set_occupation(this.tableau[indice].get_occupation());
        			this.tableau[indice].set_occupation(Joue);
    			}
    			else
    			{
    				this.plateau[k][l].set_valeurs(valP2);
        			this.plateau[k][l].set_occupation(Vertical);
        			this.tableau[indice].set_occupation(Joue);
    			}	
    		}
        	else
    		{
    			System.out.println("Autre cas");
    		}

        	
        }
    	
    	return;
 
		
	 }

	void aide() {
	}

	boolean partie_gagnee() {
		boolean gagne = false;
		return gagne;
	}

	int[] coup_possible(int indice) {
		int[] coup = new int[2];
		return coup;
	}

	int choisir_coup(Joueur[] joueur, int joueur_act) {
		return -1;
	}

	int partie_finie(Joueur[] joueur) {

		return -1;
	}

	int nbreDonR(int joueurAct, Joueur[] joueur) {
		int nbDomRestant = 0;
		int debMain = 0;
		for (int i = 0; i < debMain; i++) {
			debMain += joueur[joueurAct].get_nbre_piece();
		}
		System.out.println("nom joueur : "+joueur[joueurAct].get_pseudo());
		for (int j = 0; j < joueur[joueurAct].get_nbre_piece(); j++) {
			if (tableau[debMain].get_occupation() == (PasJoue)) {
				nbDomRestant++;
			}
		}
		System.out.println("le nbre de domino restant est "+nbDomRestant);
		return nbDomRestant;
	}

	void afficher(Joueur[] joueur, int joueurAct) {

		listImg = new LesDominos(this.tableau, this, joueur, joueurAct);
		nbreDonR(joueurAct,joueur);
		compteur = 0;
		this.setTitle("Ma première fenêtre Java");
		this.setSize(2000, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		Font police = new Font("tahona", Font.BOLD, 20);

		nom1.setBounds(10, 150, 150, 40);
		nom1.setFont(police);
		nom1.setForeground(Color.blue);
		nom1.setBackground(Color.lightGray);
		nom1.setOpaque(true);
		nom2.setBounds(10, 200, 150, 40);
		nom2.setFont(police);
		nom2.setForeground(Color.blue);
		nom2.setBackground(Color.lightGray);
		nom2.setOpaque(true);
		nom3.setBounds(10, 250, 150, 40);
		nom3.setFont(police);
		nom3.setForeground(Color.blue);
		nom3.setBackground(Color.lightGray);
		nom3.setOpaque(true);
		nom4.setBounds(10, 300, 150, 40);
		nom4.setFont(police);
		nom4.setForeground(Color.blue);
		nom4.setBackground(Color.lightGray);
		nom4.setOpaque(true);
		label.setFont(police);
		label.setBounds(10, 90, 150, 40);
		label.setForeground(Color.blue);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBackground(Color.lightGray);
		score.setBackground(Color.lightGray);
		label.setOpaque(true);
		score.setForeground(Color.blue);
		score.setFont(police);
		score.setBounds(250, 90, 150, 35);
		score.setBackground(Color.lightGray);

		score.setOpaque(true);
		score_J1.setFont(police);
		score_J1.setBounds(300, 150, 50, 35);
		score_J1.setForeground(Color.blue);
		score_J1.setOpaque(true);
		score_J1.setBackground(Color.lightGray);
		score_J2.setFont(police);
		score_J2.setBounds(300, 200, 50, 35);
		score_J2.setForeground(Color.blue);
		score_J2.setOpaque(true);
		score_J2.setBackground(Color.lightGray);
		score_J3.setFont(police);
		score_J3.setBounds(300, 250, 50, 35);
		score_J3.setForeground(Color.blue);
		score_J3.setOpaque(true);
		score_J3.setBackground(Color.lightGray);
		score_J4.setFont(police);
		score_J4.setBounds(300, 300, 50, 35);
		score_J4.setForeground(Color.blue);
		score_J4.setBackground(Color.lightGray);
		score_J4.setOpaque(true);
		zone_joueur.add(nom1);
		zone_joueur.add(nom2);
		zone_joueur.add(nom3);
		zone_joueur.add(nom4);
		zone_joueur.add(score_J1);
		zone_joueur.add(score_J2);
		zone_joueur.add(score_J3);
		zone_joueur.add(score_J4);
		// zone_joueur.add(p);

		int xa = this.getWidth() / 10;
		int ya = this.getHeight() - 300;
		Font pole = new Font("tahona", Font.BOLD, 16);
		annuler.setFont(pole);
		annuler.setBounds(10, ya, 80, 40);
		annuler.setOpaque(false);
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("annuler");
				System.exit(0);
			}
		});

		valider.setFont(pole);
		valider.setBounds(x_valider, ya, 80, 40);
		valider.setOpaque(false);
		// valider.addMouseListener( new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// }
		// );
		menu.setBounds(10, 10, 80, 40);
		menu.setOpaque(false);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("vous voulez aller au menu ohohhh  ! ");
			}
		});
		/*
		 * pioche.setBounds(xa+100, 10, 80, 40); pioche.setOpaque(false);
		 * pioche.addActionListener( new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * System.out.println("vous voulez piocher  ! "); } } );
		 */
		suivant.setBounds(520, 835, 40, 40);
		suivant.addActionListener(this);

		texte1 = nom1.getText();
		texte2 = nom2.getText();
		texte3 = nom3.getText();
		texte4 = nom4.getText();
		s1 = score_J1.getText();
		s2 = score_J2.getText();
		s3 = score_J3.getText();
		s4 = score_J4.getText();
		System.out.println("les informations sur ces joueurs à la fin de cette partie sont : ");
		System.out.println(" joueur1  nom: " + texte1 + " score  " + s1);
		System.out.println(" joueur2  nom: " + texte2 + " score  " + s2);
		System.out.println(" joueur3  nom: " + texte4 + " score  " + s3);
		System.out.println(" joueur4  nom: " + texte1 + " score  " + s4);

		pan.setLayout(null);
		zone_joueur.setLayout(null);
		zone_joueur.setBounds(0, 250, 600, 1000);
		zone_joueur.setBackground(Color.gray);
		container.setLayout(new BorderLayout());
		ere.setLayout(null);
		ere.setBackground(new Color(82, 137, 83));
		ere.setBounds(600, 250, 1500, 1000);

		zone_joueur.add(label);
		zone_joueur.add(score);
		pan.add(annuler);
		pan.add(valider);
		pan.add(zone_joueur);
		zone_joueur.add(menu);
		// zone_joueur.add(pioche);
		zone_joueur.add(suivant);

		// apelle la méthode pour initialiser
		listImg.loadImg();
		listImg.setBounds(0, 610, 800, 450);
		// dessine les images
		listImg.repaint();
		zone_joueur.add(listImg);
		zone_joueur.repaint();
		container.repaint();
		// container.add(pan_aff);
		pan.add(ere, BorderLayout.CENTER);
		container.add(pan, BorderLayout.CENTER);
        container.setVisible(true);
		this.setContentPane(container);
		

	}

	@Override
	boolean coup_possible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Lorsque l'on clique sur le bouton, on met à jour le JLabel
		this.compteur++;
		System.out.println("Vous avez cliqué " + this.compteur + " fois");
		listImg.repaint();
		zone_joueur.repaint();
		container.repaint();
	}

	public int getnbre() {
		System.out.println("339" + compteur);
		return compteur;
	}
	
}