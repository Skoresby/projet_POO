package launch;

import java.util.*;

import launch.Joueur;
import launch.Pion;

public class Triomino extends Partie {
	private int nbrePositionsPossibles;
    private int nbreCoupsVoulus;
    private int[][] coupsPossibles;//tous les emplacements jouables
    private int[][] coupsVoulus;//tous les emplacements jouables en prenant en compte la piece selectionnee
    private boolean pioche; 
	private int[] coupIA;
    public static final boolean Endroit=true; // de la forme : /\
    public static final boolean Envers=false; //de la forme \/
    public static final boolean Joue=true;
    public static final boolean PasJoue=false;
	public static final boolean Vide = true;

	
	//constructeur
    public Triomino() {
    	this.nbrePositionsPossibles=1;//le coup en [56][56]
    	this.nbreCoupsVoulus=0;
    	
		// initialisation du tableau coupsPossibles
    	this.coupsPossibles=new int [58][2];//a chaque fois qu on rajoute un trio, on rajoute une possibilité de plus par rapport aux trois cotés initiaux.
    	//coupsPossibles represente les coordonnees du plateau ou il est possible de jouer
    	
    	this.coupsVoulus=new int [58][2];
    	this.init_coupsVoulus();
    	for(int i=0; i<58; i++)
    	{
    		this.coupsPossibles[i][0]=-1;
    		this.coupsPossibles[i][1]=-1;
    		
    	}
    	
    	//on met la premiere valeur : a la case [56][56]
    	this.coupsPossibles[0][0]=56;
    	this.coupsPossibles[0][1]=56;
    	
    	
    }

    
    
    //methodes non abstraites
    public void aff_tableau_terminal() {
    	int vals[]=new int[3];
    	
    	for(int i=0; i<56; i++)
    	{
    		System.out.print(+i+" ");
    	}
    	System.out.println("");
    	
    	for(int i=0; i<56; i++)
    	{
    		vals=this.tableau[i].get_valeurs();
    		if(i>=10)
    			System.out.print(" ");
    		System.out.print(+vals[0]+" ");
    	}
    	System.out.println("");
    	
    	for(int i=0; i<56; i++)
    	{
    		vals=this.tableau[i].get_valeurs();
    		if(i>=10)
    			System.out.print(" ");
    		System.out.print(+vals[1]+" ");
    	}
    	System.out.println("");
    	
    	for(int i=0; i<56; i++)
    	{
    		vals=this.tableau[i].get_valeurs();
    		if(i>=10)
    			System.out.print(" ");
    		System.out.print(+vals[2]+" ");
    	}
    	System.out.println("");
    	
    }

    public int verif_coll_3_pieces(int[] A, int[] B, int[] C, int[] X, boolean posAPlacer) {// X est le trio à placer
    	int tourne = -1;
		int ajout = 0;

		if (posAPlacer == Envers)
			ajout = 1;
		for (int i = 0; i < 3; i++) {
			if ((C[1] == X[(2 + i) % 3]) && (C[2] == X[(1 + i) % 3]) && (A[0] == X[(1 + ajout + i) % 3])
					&& (A[2] == X[i]) && (B[2 - ajout] == X[i]) && (B[0] == X[(2 - ajout + i) % 3])) {
				tourne = (3 - i) % 3;
				break;
			}
		}
		return tourne;
    }
    
    public int verif_coll_2_pieces(int[] A, int[] B, int[] X, int sommetManquant, boolean posAPlacer) {
		int tourne = -1;

		int ajout = 0;// en fonction de la position endroit/envers du triomino
		int sommetCommun;

		if (posAPlacer == Envers)
		{
			ajout = 1;
			sommetCommun=sommetManquant+1;
		}
		else
		{
			if(sommetManquant==1)
				sommetCommun=1;
			else
				sommetCommun=2;
		}

		if (sommetManquant == 2)
			
			sommetCommun = 0;
		
		if(sommetCommun==0)
		{
			for(int i=0; i<3; i++)
			{
				if((A[1+ajout]==X[i])&&(A[0]==X[(1+ajout+i)%3])
						&&(B[2-ajout]==X[i])&&(B[0]==X[(2-ajout+i)%3]))
				{
					tourne=(3-i)%3;
					break;
				}
			}
		}
		else if(sommetCommun==1)
		{
			for(int i=0; i<3; i++)
			{
				if((A[0]==X[(i+1)%3])&&(A[1]==X[i])
						&&(B[1]==X[(2+i)%3])&&(B[2]==X[(1+i)%3]))
				{
					tourne=(3-i)%3;
					break;
				}
			}
		}
		else
		{
			for(int i=0; i<3; i++)
			{
				if((A[0]==X[(2+i)%3])&&(A[2]==X[i])
						&&(B[2]==X[(1+i)%3])&&(B[1]==X[(2+i)%3]))
				{
					tourne=(3-i)%3;
					break;
				}
			}
		}
		
		return tourne;
	}

    
    public int verif_coll_1_piece(int[] A, int[] aPlacer, int coteCommun) {
		int tourne = -1;
		int cote;
		if (coteCommun == 0)
			cote = coteCommun;
		else
			cote = coteCommun % 2 + 1;// le numero de valeur à regarder est 1 si le cote manquant est 2 et inversement
		// pour les commentaires, X est le trio aPlacer

		if(coteCommun==2)//A
		{
			int sommet=cote;
			for(int i=0; i<3; i++)
			{
				if((A[sommet]==aPlacer[i])&&(A[0]==aPlacer[(sommet+i)%3]))
				{
					tourne=(3-i)%3;
					break;
				}
			}
		}
		else if(coteCommun==1)//B
		{
			int sommet=cote;

			for(int i=0; i<3; i++)
			{
				if((A[sommet]==aPlacer[i])&&(A[0]==aPlacer[(sommet+i)%3]))
				{
					tourne=(3-i)%3;
					break;
				}
			}
		}
		else
		{
			for(int i=0; i<3; i++)
			{
				if((A[2]==aPlacer[(1+i)%3])&&(A[1]==aPlacer[(i+2)%3]))
				{
					tourne=(3-i)%3;
				}
			}
		}
		
		return tourne;
	}
    
    public void init_coupsVoulus() {
    	this.nbreCoupsVoulus=0;

    	for(int i=0; i<58; i++)
    	{
    		this.coupsVoulus[i]=new int[2];//sinon reinitialise les cases en commun avec coupsPossibles
    		this.coupsVoulus[i][0]=-1;
    		this.coupsVoulus[i][1]=-1;
    	}
    }

    public void aff_plateau_terminal() {
    	int debLargeur = 40, finLargeur = 70, debHauteur = 45, finHauteur = 65;
		for (int i = debHauteur; i < finHauteur; i++) {
			for (int k = 0; k < (finLargeur - debLargeur) - (i - debLargeur + 1); k++)
				System.out.print("  ");// pour que les cases correspondent visuellement

			for (int j = debLargeur; j < finLargeur; j++) {
				int[] vals = new int[3];
				vals = this.plateau[i][j].get_valeurs();
				if (this.plateau[i][j].get_occupation() == Endroit) {
					if (vals[0] != -1)
						System.out.print(+vals[0] + " ");
					else if (this.existe_deja_CP(i, j) == true)
						System.out.print("- ");
					else
						System.out.print(". ");

				} else {
					if (vals[0] != -1)
						System.out.print(+vals[2] + " " + vals[1] + " ");
					else if (this.existe_deja_CP(i, j) == true)
						System.out.print("- - ");
					else
						System.out.print(". . ");

				}

			}
			System.out.println(" ");
			for (int k = 0; k < (finLargeur - debLargeur) - (i - debLargeur + 1); k++)
				System.out.print("  ");// pour que les cases correspondent visuellement

			for (int j = debLargeur; j < finLargeur; j++)// on affiche la deuxieme ligne du trio
			{
				int[] vals = new int[3];
				vals = this.plateau[i][j].get_valeurs();
				if (this.plateau[i][j].get_occupation() == Envers) {
					if (vals[0] != -1)
						System.out.print(+vals[0] + " ");
					else if (this.existe_deja_CP(i, j) == true)
						System.out.print("- ");
					else
						System.out.print(". ");

				} else {
					if (vals[0] != -1)
						System.out.print(+vals[1] + " " + vals[2] + " ");
					else if (this.existe_deja_CP(i, j) == true)
						System.out.print("- - ");
					else
						System.out.print(". . ");
					// System.out.print(+j%10+" "+j%10+" ");
				}

			}
			System.out.println(" ");

		}
    }
  
    public void aff_cp() {
    	for(int i=0; i<this.nbrePositionsPossibles; i++)
    		System.out.println("cp x="+this.coupsPossibles[i][0]+" y="+this.coupsPossibles[i][1]);
    }
    
    public void aff_cv() {
    	for(int i=0; i<this.nbreCoupsVoulus; i++)
    		System.out.println("cv x="+this.coupsVoulus[i][0]+" y="+this.coupsVoulus[i][1]);
    }

    public int aff_main_joueur(Joueur[] joueur, int joueur_act) {
    	int deb_main=0;
    	int count=0;

    	for(int i=0; i<joueur_act; i++)
    	{
    		deb_main=deb_main+joueur[i].get_nbre_piece();
    	}
    	
    	//affichage de la main du joueur
    	System.out.println("main du joueur : ");
    	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
    	{
    		if(this.tableau[i].get_occupation()==PasJoue)
    		{
    			System.out.print(+count+" ");
    			count++;
    		}
    	}
    	System.out.println(" ");
    	count=0;
    	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
    	{
    		if(this.tableau[i].get_occupation()==PasJoue)
    		{
	    		int [] vals=new int[3];
	    		vals=this.tableau[i].get_valeurs();
	    		System.out.print(+vals[0]+" ");
	    		if (i-count-deb_main>9)
	    			System.out.print(" ");
	    	}
    		else
    			count++;
    	}
    	System.out.println(" ");
    	count=0;
    	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
    	{
    		if(this.tableau[i].get_occupation()==PasJoue)
    		{
	    		int [] vals=new int[3];
	    		vals=this.tableau[i].get_valeurs();
	    		System.out.print(+vals[1]+" ");
	    		if (i-count-deb_main>9)
	    			System.out.print(" ");
    		}
    		else
    			count++;
    	}
    	System.out.println(" ");
    	count=0;
    	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
    	{
    		if(this.tableau[i].get_occupation()==PasJoue)
    		{
	    		int [] vals=new int[3];
	    		vals=this.tableau[i].get_valeurs();
	    		System.out.print(+vals[2]+" ");
	    		if (i-count-deb_main>9)
	    			System.out.print(" ");
    		}
    		else 
    			count++;
    	}
    	System.out.println(" ");
    	return deb_main;
    }
    
    public boolean piocher(Joueur[] joueur, int joueur_act) {
		int total;
		Pion triominoAEchanger;
		boolean vide = false;

		total = joueur[0].get_nbre_piece() + joueur[1].get_nbre_piece() + joueur[2].get_nbre_piece()
				+ joueur[3].get_nbre_piece();
		if (total == 56)
			return true;

		if (joueur_act == this.get_nbre_j_total()) {
			joueur[joueur_act].set_nbre_piece(joueur[joueur_act].get_nbre_piece() + 1);
		} else {
			for (int j = this.get_nbre_j_total() - 1; j > joueur_act; j--) {
				int place = 0;
				for (int i = 0; i < j; i++) {
					place = place + joueur[i].get_nbre_piece();
				}
				triominoAEchanger = this.tableau[place];
				this.tableau[place] = this.tableau[total];
				this.tableau[total] = triominoAEchanger;
				total = total - joueur[j - 1].get_nbre_piece();
			}
			joueur[joueur_act].set_nbre_piece(joueur[joueur_act].get_nbre_piece() + 1);

		}

		total = joueur[0].get_nbre_piece() + joueur[1].get_nbre_piece() + joueur[2].get_nbre_piece()
				+ joueur[3].get_nbre_piece();
		if (total == 56)
			vide = true;

		this.aff_main_joueur(joueur, joueur_act);
		return vide;
	}
    
    public boolean existe_deja_CP(int x, int y) {
		boolean existe = false;
		for (int i = 0; i < this.nbrePositionsPossibles; i++) {
			if ((this.coupsPossibles[i][0] == x) && (this.coupsPossibles[i][1] == y)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	public boolean existe_deja_CV(int x, int y) {
		boolean existe = false;
		for (int i = 0; i < this.nbreCoupsVoulus; i++) {
			if ((this.coupsVoulus[i][0] == x) && (this.coupsVoulus[i][1] == y)) {
				existe = true;
				break;
			}
		}
		return existe;
	}
	
	public int recup_indice_tableau(int rep) {
		int indice = 0, count = 0;// indice compte le nombre de trios deja joues et situes avant le trio demande
									// dans la main vituelle, count sert de compteur pour arriver jusqu a l indice
									// demande

		do {
			while ((count + indice < 56) && (this.tableau[count + indice].get_occupation() == Joue)) {
				indice++;
			}
			count++;
			//System.out.println("432 count=" + count + " indice=" + indice);
		} while (rep >= count);
		count--;

		return count + indice;
	}
	
	public int hexa_gauche(boolean position, int x, int y) {
		int existe = 1;
		int[] vals;
		if (position == Endroit) {
			for (int i = x; i < x + 2; i++) {
				for (int j = y + (i - x) - 2; j < y + 1 + (i - x); j++) {
					if ((i != x) || (j != y)) {
						vals = plateau[i][j].get_valeurs();
						if (vals[0] == -1)
							existe = 0;
					}
				}
			}
		} else// position a l envers
		{
			for (int i = x - 1; i < x + 1; i++) {
				for (int j = y + (i - x) - 2; j < y + (i - x) + 1; j++) {
					if ((i != x) || (j != y)) {
						vals = plateau[i][j].get_valeurs();
						if (vals[0] == -1)
							existe = 0;

					}
				}
			}
		}

		return existe;
	}

	public int hexa_droite(boolean position, int x, int y) {
		int existe = 1;
		int[] vals;

		if (position == Endroit) {
			for (int i = x; i < x + 2; i++) {
				for (int j = y + (i - x); j < y + 3 + (i - x); j++) {
					if ((i != x) || (j != y)) {
						vals = plateau[i][j].get_valeurs();
						if (vals[0] == -1)
							existe = 0;
					}
				}
			}
		} else// position a l envers
		{
			for (int i = x - 1; i < x + 1; i++) {
				for (int j = y + (i - x); j < y + (i - x) + 3; j++) {
					if ((i != x) || (j != y)) {
						vals = plateau[i][j].get_valeurs();
						if (vals[0] == -1)
							existe = 0;

					}
				}
			}
		}
		
		return existe;
	}

	public int hexa_hb(boolean position, int x, int y) {
		int existe = 1;
		int[] vals;
		if (position == Endroit) {
			for (int i = x - 1; i < x + 1; i++) {
				for (int j = y + (i - x) - 1; j < y + 2 + (i - x); j++) {
					if ((i != x) || (j != y)) {
						vals = plateau[i][j].get_valeurs();
						if (vals[0] == -1)
							existe = 0;
					}
				}
			}
		} else// position a l envers
		{
			for (int i = x; i < x + 2; i++) {
				for (int j = y + (i - x) - 1; j < y + (i - x) + 2; j++) {
					if ((i != x) || (j != y)) {
						vals = plateau[i][j].get_valeurs();
						if (vals[0] == -1)
							existe = 0;

					}
				}
			}
		}
		

		return existe;
	}
	
	int calcul_score(int indice_pion, int indice_coupVoulu) {// indice du jeton a jouer et de l ednroit ou on va jouer
		// boolean appartient=false;
		int hexg, hexd, hexhb;
		int x = coupsVoulus[indice_coupVoulu][0];
		int y = coupsVoulus[indice_coupVoulu][1];
		int score = 0;
		int[] vals = tableau[indice_pion].get_valeurs();

		boolean position = ((plateau[x][y].get_occupation() == Endroit) ? Endroit : Envers);
		hexg = hexa_gauche(position, x, y);
		hexd = hexa_droite(position, x, y);
		hexhb = hexa_hb(position, x, y);
		int total = hexg + hexd + hexhb;
		if (total == 3) {
			score = 70 + vals[0] + vals[1] + vals[2];
		} else if (total == 2) {
			score = 60 + vals[0] + vals[1] + vals[2];
		} else if (total == 1) {
			score = 50 + vals[0] + vals[1] + vals[2];
		} else {
			score = +vals[0] + vals[1] + vals[2];
		}

		return score;
	}

	
  //methodes abstraites
  	public void placer_pion(int indice, Joueur[] joueur, int joueur_act) {
  		
  		int[] retourCoupPossible = new int[this.nbreCoupsVoulus];
		retourCoupPossible = this.coup_possible(indice);// on met a jour le tableau coupsVoulus
				
		int rep = 0;
		if (this.nbreCoupsVoulus > 0)// sinon on ne peut rien placer
		{
			if (joueur[joueur_act].get_type() == 1)// humain
			{
				System.out.println("a quel emplacement le placer? Emplacement dispos :");
				for (int i = 0; i < this.nbreCoupsVoulus; i++)// affichage des possibilités
				{
					System.out.println("num=" + i + " x=" + this.coupsVoulus[i][0] + " y=" + this.coupsVoulus[i][1]);
				}

				rep = sc.nextInt();// rep de l utilisateur
			} else if (joueur[joueur_act].get_type() == 2)// ordinateur
				rep = coupIA[1];
			else
				System.out.println("enorme probleme placer pion 546!!!!");

			int rajoutL = 0;
			int x = this.coupsVoulus[rep][0];// coordonnees voulues par l utilisateur
			int y = this.coupsVoulus[rep][1];

			int pivot = retourCoupPossible[rep + 2];// on regarde quelle rotation on doit faire en fonction de la
													// reponse faite, rep+1 car tab[0] contient le nbre de collisions
			// on fait cette rotation :
			int[] aPlacer = this.tableau[indice].get_valeurs();

			for (int i = 0; i < pivot % 3; i++) {
				int echange = aPlacer[2];
				aPlacer[2] = aPlacer[1];
				aPlacer[1] = aPlacer[0];
				aPlacer[0] = echange;
			}

			this.plateau[x][y].set_valeurs(this.tableau[indice].get_valeurs());// on place les valeurs sur le plateau
			this.tableau[indice].set_occupation(Joue);// on modifie son occupation dans le plateau

			int score = calcul_score(indice, rep);
			System.out.println("485 score=" + score);
			joueur[joueur_act].set_score(score);

			// on recherche dans le tableau des coupsPossibles ou se situe le trio joué
			int ind = 0;
			while ((this.coupsPossibles[ind][0] != this.coupsVoulus[rep][0])
					|| (this.coupsPossibles[ind][1] != this.coupsVoulus[rep][1]))
				ind++;

			this.coupsPossibles[ind] = this.coupsPossibles[this.nbrePositionsPossibles - 1];// on echange les deux cases
																							// pour eviter d'avoir un
																							// trou en plein milieu du
																							// tableau en prenant la
																							// derniere case du tableau

			this.nbrePositionsPossibles--;
			this.coupsPossibles[this.nbrePositionsPossibles] = new int[2];// sinon change la valeur de
																			// coupsPossibles[rep] aussi

			this.coupsPossibles[this.nbrePositionsPossibles][0] = -1;
			this.coupsPossibles[this.nbrePositionsPossibles][1] = -1;// on reinitialise la case pour pas qu'elle soit en
																		// double

			// on regarde la disponibilité des 3 cases autour pour remplir coupsPossibles
			Pion A = this.plateau[x][y - 1];
			int[] valA = A.get_valeurs();
			if (existe_deja_CP(x, y - 1))
				System.out.println("A existe deja : x=" + x + " y=" + (y - 1));
			if ((valA[0] == -1) && (existe_deja_CP(x, y - 1) == false))// donc la case a gauche est libre et n existe
																		// pas deja
			{
				this.coupsPossibles[this.nbrePositionsPossibles][0] = x;
				this.coupsPossibles[this.nbrePositionsPossibles][1] = y - 1;
				this.nbrePositionsPossibles = this.nbrePositionsPossibles + 1;
			}

			Pion B = this.plateau[x][y + 1];
			int[] valB = B.get_valeurs();
			if ((valB[0] == -1) && (existe_deja_CP(x, y + 1) == false))// donc la case a droite est libre
			{
				this.coupsPossibles[this.nbrePositionsPossibles][0] = x;
				this.coupsPossibles[this.nbrePositionsPossibles][1] = y + 1;
				this.nbrePositionsPossibles = this.nbrePositionsPossibles + 1;
			}

			if (this.plateau[x][y].get_occupation() == Endroit)
				rajoutL = 1;
			else
				rajoutL = -1;
			Pion C = this.plateau[x + rajoutL][y + rajoutL];// car le trio du dessous/dessus est décalé dans le tableau
			int[] valC = C.get_valeurs();
			if ((valC[0] == -1) && (existe_deja_CP(x + rajoutL, y + rajoutL) == false))// donc la case au dessus/dessous
																						// est libre
			{
				this.coupsPossibles[this.nbrePositionsPossibles][0] = x + rajoutL;
				this.coupsPossibles[this.nbrePositionsPossibles][1] = y + rajoutL;
				this.nbrePositionsPossibles = this.nbrePositionsPossibles + 1;
			}

			int[] placees = this.tableau[indice].get_valeurs();
			System.out.println(
					"tu as place " + placees[0] + " " + placees[1] + " " + placees[2] + " en x=" + x + " y=" + y);
			this.init_coupsVoulus();// on reinitialise le tableau pour la prochaine valeur

		} else if (retourCoupPossible[0] == -2)
			System.out.println("triomino deja joue...");

		
		this.aff_plateau_terminal();

	}
  	
    public Pion[] init_tab() {
    	this.tableau=new Pion[56];
    	for(int i=0; i<56; i++)
    	{
    		this.tableau[i]=new Pion();
    		this.tableau[i].set_valeurs(new int[3]);
    	}
    	int count=0;
		

    	for(int i=0; i<6; i++)
    	{
    		for(int j=i; j<6; j++)
    		{
    			for(int k=j; k<6; k++)
    			{
    				int[] vals=new int[3];
	   				vals[0]=i;
	   				vals[1]=j;
	   				vals[2]=k;
	   				this.tableau[count].set_valeurs(vals);
	   				this.tableau[count].set_occupation(false);
    				count=count+1;
    			}
    		}
    	}
    	
    	//melange du tableau
    	Pion change=new Pion();
    	int alea;
    	for(int i=0; i<56; i++)
    	{
    		change=this.tableau[i];
    		
    		alea=(int)(Math.random()*56);
    		
    		this.tableau[i]=this.tableau[alea];
    		this.tableau[alea]=change;
    	}
    	this.aff_tableau_terminal();
    	return this.tableau;
    }
    
    Pion[][] init_plateau() {
   	 int[] vals= {-1, -1, -1};
   	 this.plateau=new Pion[111][111];
   	 for(int i=0; i<111; i++)
   	 {
   		 for(int j=0; j<111; j++)
   		 {
   			 this.plateau[i][j]=new Pion();
   			 this.plateau[i][j].set_valeurs(new int[3]);
   			 this.plateau[i][j].set_valeurs(vals);
   			 if(j%2==0)//donc le triomino est à l endroit
   				 this.plateau[i][j].set_occupation(Endroit);
   			 else
   				 this.plateau[i][j].set_occupation(Envers);
   		 }
   	 }
   	 return this.plateau;
    }

    int premier_a_jouer() {
    	int nbrePiece;
    	int joueur=0;
    	int max=0;
    	
    	if(this.get_nbre_j_total()==2)
    		nbrePiece=9;
    	else
    		nbrePiece=7;
    	
    	for(int i=0; i<this.get_nbre_j_total(); i++)
    	{
    		int[] vals=new int[3];
    		vals=this.tableau[this.get_nbre_j_total()*nbrePiece+i].get_valeurs();
    		
    		if(vals[0]+vals[1]+vals[2]>max)
    		{
    			joueur=i;
    			max=vals[0]+vals[1]+vals[2];
    		}
    		
    	}
    	
    	return joueur;
    }

    void aide(Joueur[] joueur, int joueur_act) {
		int deb_main = 0;
		int countJoue = 0;
		for (int i = 0; i < joueur_act; i++) {
			deb_main = deb_main + joueur[i].get_nbre_piece();

		}
		int[] peutEtreJoue = new int[joueur[joueur_act].get_nbre_piece()];// on met dedans tous les trios que le joueur
																			// peut placer sur le jeu
		int nbrePeutEtreJoue = 0;
		// on recupere les indices des pions pouvant etre joués
		for (int i = deb_main; i < deb_main + joueur[joueur_act].get_nbre_piece(); i++) {
			if (this.tableau[i].get_occupation() == Joue)
				countJoue++;
			int[] retourCoupPossible = new int[this.nbreCoupsVoulus];// tableau stockant le retour de la fonction
			retourCoupPossible = this.coup_possible(i);
			this.init_coupsVoulus();
			if (retourCoupPossible[0] > 0)// donc cette piece peut etre jouee quelque part
			{
				peutEtreJoue[nbrePeutEtreJoue] = (i - countJoue);
				nbrePeutEtreJoue++;
			}

		}
    }

   int partie_finie(Joueur[] joueur) {//retourne 0 si la partie doit continuer, numero du joueur+1 si la partie est gagnee et 5 si la partie est bloquee (plus aucun joueur ne peut jouer)
	// retourne 0 si la partie doit continuer, numero du joueur+1 si la partie est
			// gagnee et 5 si la partie est bloquee (plus aucun joueur ne peut jouer)
			int retour = -1, count = 0, nbrePieceRestante, joueurSansPiece = -1;
			for (int i = 0; i < this.get_nbre_j_total(); i++) {
				nbrePieceRestante = 0;

				for (int j = 0; j < joueur[i].get_nbre_piece(); j++) {
					if (this.tableau[count + j].get_occupation() == false)// la piece n a pas ete jouee
					{
						nbrePieceRestante++;
					}
					if (nbrePieceRestante > 0) // si y a pas besoin de ce nombre plus tard
						break;// il reste au moins une piece dans la main du joueur i

				}

				// pour connaitre le debut de la main suivante :
				count = count + joueur[i].get_nbre_piece();

				if (nbrePieceRestante == 0) {// vu qu'on verifie apres chaque joueur, deux ne peuvent pas gagner en meme
												// temps
					retour = joueurSansPiece;

					break;
				}
			}


			if (retour == -1) {// verifier si partie bloquee
				if(pioche==Vide)
				{
					int tem=0;
					for(int i=0; i< get_nbre_j_total(); i++)
					{
						ia(joueur, i);
						if(coupIA[0]==-1)
						{
							tem++;
						}
					}
					if(tem==get_nbre_j_total())
						retour=5;
					
				}

			}

			if (retour == -1)// la partie n est ni bloquee, ni finie
				retour = 0;

			return retour;
		}
   
   int[] coup_possible(int indice) { // retourne un tableau avec posable (0=non, 1=oui) en premiere case
		// nbreDeCollisions en deuxieme case
		//et nbreDeTours ensuite, selon la case dans laquelle on va jouer
int[] aPlacer = new int[3];
int coll = 0;
int posable = 0;
int[] tourne = new int[this.nbrePositionsPossibles + 2];// vaut -1 si le coup n est pas possible, et 0, 1 ou 2
								// selon combien de fois faut faire tourner le trio pour
								// qu'il rentre
// la premiere case dit si le triomino est posable, la deuxieme contient la
// valeur de coll, la suite le nbre de tour que la piece doit faire. ce tableau
// sera surement trop grand, mais on ne connait pas sa taille exacte a ce
// moment, donc on a pris sa taille maximale possible
tourne[0] = -5;
int retourTourne = -2;
aPlacer = this.tableau[indice].get_valeurs();
String val = new String();

// faire plateau coupsPossibles
if ((this.coupsPossibles[0][0] == 56) && (this.coupsPossibles[0][1] == 56))// c est le premier coup à jouer
{

coll = -1;// pour ne pas remettre dans le tableau une 2eme fois 56 56
if (!existe_deja_CV(56, 56)) {
this.coupsVoulus[this.nbreCoupsVoulus][0] = 56;
this.coupsVoulus[this.nbreCoupsVoulus][1] = 56;
this.nbreCoupsVoulus++;

}
posable = 1;
tourne[0] = posable;
tourne[1] = coll;
tourne[2] = 0;
return tourne;
}
int i;
if(nbreCoupsVoulus==0)//sinon  c est que le tableau est deja rempli
{
for (i = 0; i < this.nbrePositionsPossibles; i++) {
int x = this.coupsPossibles[i][0];
int y = this.coupsPossibles[i][1];
int rajoutL = 0;
int cote = 0;

Pion A = new Pion();
Pion B = new Pion();
Pion C = new Pion();

int[] valA = new int[3];
int[] valB = new int[3];
int[] valC = new int[3];

// on regarde les triominos autour pour savoir si le triomino C est au dessus ou
// au dessous du triomino à regarder

if ((x == -1) || (y == -1)) {
System.out.println("verif du trio x=" + x + " y=" + y);
this.aff_cp();
}
if (this.plateau[x][y].get_occupation() == Endroit)// donc les trios autour sont à l'"Envers"
rajoutL = 1;
else
rajoutL = -1;

// on nomme les cases alentours
A = this.plateau[x][y + 1];// le trio deja place est a droite, donc on veut placer le trio a gauche
B = this.plateau[x][y - 1];// le trio deja place est a gauche, donc celui qu on veut placer celui de droite
C = this.plateau[x + rajoutL][y + rajoutL];// au dessus ou en dessous

// on recupere les valeurs pour savoir si la case est occupée ou non
valA = A.get_valeurs();
valB = B.get_valeurs();
valC = C.get_valeurs();

if (this.tableau[indice].get_occupation() == Joue) {
coll = -2;
} else if ((valA[0] != -1) && (valB[0] != -1) && (valC[0] != -1))// cette case est entouree de triominos
{
retourTourne = verif_coll_3_pieces(valB, valA, valC, aPlacer, this.plateau[x][y].get_occupation());// azerty
if (retourTourne != -1) {
// System.out.println("573 ok");
coll = 3;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;// on met dans la premiere case libre. comme un seul
										// de ces if ou else if peut se faire, on est sur de
										// pas ecraser de valeur
} else// la piece n allait pas
{
coll = 0;
}
} else if ((valA[0] != -1) && (valB[0] != -1)) {
retourTourne = verif_coll_2_pieces(valB, valA, aPlacer, 2, this.plateau[x][y].get_occupation());// azerty
if ((retourTourne != -1) && (coll < 3)) {
coll = 2;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;
} else// la piece n allait pas ou on a deja trouve mieux
{
coll = 0;
}
} else if ((valA[0] != -1) && (valC[0] != -1)) {
retourTourne = verif_coll_2_pieces(valA, valC, aPlacer, 0, this.plateau[x][y].get_occupation());

if ((retourTourne != -1) && (coll < 3)) {
coll = 2;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;
} else// la piece n allait pas
{
coll = 0;
}
} else if ((valB[0] != -1) && (valC[0] != -1)) {
retourTourne = verif_coll_2_pieces(valB, valC, aPlacer, 1, this.plateau[x][y].get_occupation());
if ((retourTourne != -1) && (coll < 3)) {
coll = 2;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;
} else// la piece n allait pas
{
coll = 0;
}
} else if (valA[0] != -1) {
if (this.plateau[x][y].get_occupation() == Endroit)// donc les trios autour sont à l'"Envers"
cote = 1;
else
cote = 2;

retourTourne = verif_coll_1_piece(valA, aPlacer, cote);
if ((retourTourne != -1) && (coll < 2)) {
coll = 1;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;
} else// la piece n allait pas
{
coll = 0;
}
} else if (valB[0] != -1) {
if (this.plateau[x][y].get_occupation() == Endroit)// donc les trios autour sont à l'"Envers"
cote = 2;
else
cote = 1;
retourTourne = verif_coll_1_piece(valB, aPlacer, cote);// on envoie le cote correspondant, il est
											// différent selon si le triomino est a l
											// endroit ou a l envers
if ((retourTourne != -1) && (coll < 2)) {
coll = 1;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;
} else// la piece n allait pas
{
coll = 0;
}

} else if (valC[0] != -1) {
retourTourne = verif_coll_1_piece(valC, aPlacer, 0);
if ((retourTourne != -1) && (coll < 2)) {
coll = 1;
posable = 1;
tourne[this.nbreCoupsVoulus + 2] = retourTourne;
} else// la piece n allait pas
{
coll = 0;
}

} else// il n y a aucun triomino autour de cet endroit => ERREUR
{
System.out.println("Erreur ligne 273!!!! (coup_possible de triomino)");
System.exit(1);
}

tourne[0] = posable;
tourne[1] = coll;

if (coll > 0) {
if (!existe_deja_CV(this.coupsPossibles[i][0], this.coupsPossibles[i][1])) {
this.coupsVoulus[this.nbreCoupsVoulus] = this.coupsPossibles[i];
this.nbreCoupsVoulus++;
}
}
}
}
return tourne;
	   }

   int choisir_coup(Joueur[] joueur, int joueur_act) {
	   int num = -3, temPioche = 0, ind = -3;
		int deb_main = this.aff_main_joueur(joueur, joueur_act);
		do {
			if ((temPioche < 3) && (this.pioche != Vide))
				System.out.println("quel triomino choisir?(-1 : aide, -2 : passe ton tour, -3 : pioche)");
			else
				System.out.println("quel triomino choisir?(-1 : aide, -2 : passe ton tour)");

			num = sc.nextInt();
			if (num >= 0) {
				int[] retourCP = new int[nbrePositionsPossibles];
				ind = this.recup_indice_tableau(num);
				retourCP = coup_possible(ind);
				init_coupsVoulus();
				if (retourCP[0] <= 0)
				{	
					num = -4;
					int[] vals = tableau[ind].get_valeurs();
					System.out.println("on ne peut pas mettre le domino " + vals[0] + " " + vals[1] + " " + vals[2]);
				}
			}

			if (num == -3) {
				if (temPioche >= 3)
					System.out.println("tu as trop pioché");
				else if (this.pioche == Vide)
					System.out.println("la pioche est vide");
				else {
					this.pioche = this.piocher(joueur, joueur_act);
					temPioche++;
					joueur[joueur_act].set_score(-5);
				}
			} else if (num == -1)
				this.aide(joueur, joueur_act);
		} while ((num < 0) && (num != -2));// -2 passe le tour
		if (num == -2) {
			if (temPioche == 2)
				joueur[joueur_act].set_score(-10);
			return -1;
		}
		return ind + deb_main;
	}

   int ia(Joueur[] joueur, int joueur_act) {
		coupIA = new int[2];// la premiere case est le nbre de collisions faites avec l indice, stocke dans
							// la deuxieme case
		coupIA[0] = -1;
		coupIA[1] = -1;
		int deb_main = 0;
		int countJoue = 0;
		int meilleurScore = 0, scoreActu = 0;

		for (int i = 0; i < joueur_act; i++) {
			deb_main = deb_main + joueur[i].get_nbre_piece();
		}
		
		//System.out.println("main de l'IA : ");
		//aff_main_joueur(joueur, joueur_act);

		int[] peutEtreJoue = new int[joueur[joueur_act].get_nbre_piece()];// on met dedans tous les trios que le joueur
																			// peut placer sur le jeu
		
		for (int i = deb_main; i < deb_main + joueur[joueur_act].get_nbre_piece(); i++) {
			if (this.tableau[i].get_occupation() == PasJoue)
			{
				int[] retourCoupPossible = new int[this.nbrePositionsPossibles];// tableau stockant le retour de la fonction
				retourCoupPossible = this.coup_possible(i);
				if (retourCoupPossible[0] > 0)// donc cette piece peut etre jouee quelque part
				{

					for (int ind_cv = 0; ind_cv < nbreCoupsVoulus; ind_cv++) {
						scoreActu = calcul_score(i, ind_cv);
						if (scoreActu > meilleurScore) {
							meilleurScore = scoreActu;
							coupIA[0] = i;
							coupIA[1] = ind_cv;
						}
					}
				}
			}
		}
		
		this.init_coupsVoulus();
		int temPioche = 0;
		
		while ((this.pioche != Vide)&&(temPioche < 3) && (coupIA[0] == -1))// il y a aucune piece qui va
		{
			int[] retourCoupPossible = new int[this.nbreCoupsVoulus];
			int piece_actu=joueur[joueur_act].get_nbre_piece()-1;
			this.pioche=piocher(joueur, joueur_act);
			temPioche++;
			joueur[joueur_act].set_score(-5);
			retourCoupPossible = this.coup_possible(piece_actu);//on regarde si la piece qu'on vient de poser est jouable ou non
			if(retourCoupPossible[0]>0)
				for (int ind_cv = 0; ind_cv < nbreCoupsVoulus; ind_cv++) {
					scoreActu = calcul_score(piece_actu, ind_cv);
					if (scoreActu > meilleurScore) {
						meilleurScore = scoreActu;
						coupIA[0] = piece_actu;
						coupIA[1] = ind_cv;
					}
				}
			
		}
		
		if((temPioche==2) && (coupIA[0]==-1))
			joueur[joueur_act].set_score(-10);

		return coupIA[0];// si retourne -1 c est que passe son tour
	}
   
    

    public void afficher() {
    }

}
