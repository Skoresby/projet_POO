package launch;

import java.util.*;

import launch.Joueur;
import launch.Pion;

public class Triomino extends Partie {
	//constructeur
    public Triomino() {
    	this.nbrePositionsPossibles=1;//le coup en [56][56]
    	this.nbreCoupsVoulus=0;
    	//int [][] this.coupsPossibles=new int[58][2](); //a chaque fois qu on rajoute un trio, on rajoute une possibilité de plus par rapport aux trois cotés initiaux.
    	//coupsPossibles represente les coordonnees du plateau ou il est possible de jouer
    	
    	//initialisation du tableau coupsPossibles
    	this.coupsPossibles=new int [58][2];
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

    private int nbrePositionsPossibles;
    private int nbreCoupsVoulus;
    private int[][] coupsPossibles;//tous les emplacements jouables
    private int[][] coupsVoulus;//tous les emplacements jouables en prenant en compte la piece selectionnee
    public static final boolean Endroit=true; // de la forme : /\
    public static final boolean Envers=false; //de la forme \/
    public static final boolean Joue=true;
    public static final boolean PasJoue=false;

    
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

    public int verif_coll_3_pieces(int[] A, int[] B, int[] C, int[] aPlacer) {
    	int coll=-1;
    	
    	
    	return coll;
    }
    
    public int verif_coll_2_pieces(int[] A, int[] B, int[] aPlacer, int sommetManquant) {
    	int coll=-1;
    	return coll;
    }
    
    public int verif_coll_1_piece(int[] A, int[] aPlacer, int coteCommun) {
    	int tourne=-1;
    	int cote;
    	if(coteCommun==0)
    		cote=coteCommun;
    	else
    		cote=coteCommun%2+1;//le numero de valeur à regarder est 1 si le cote manquant est 2 et inversement
    	//pour les commentaires, X est le trio aPlacer
    	for(int i=0; i<3; i++)
    	{
    		if(cote!=0)
    			System.out.println("97 i="+i+" cote="+cote+" c+i="+(cote+i)%3+" a[0]="+A[0]+" ap[c+i]="+aPlacer[(cote+i)%3]+" a[C]="+A[cote]+" ap[i]="+aPlacer[i]);
    		else
    			System.out.println("99 i="+i+" cote="+cote+" c+i="+(cote+i)%3+" a[1]="+A[1]+" ap[2-i]="+aPlacer[2-i]+" a[2]="+A[2]+" ap[(2*i+1)%3]="+aPlacer[(2*i+1)%3]);

	    	if(cote!=0)
	    	{
	    		if((A[0]==aPlacer[(cote+i)%3])&&(A[cote]==aPlacer[i]))//verifie A0 avec X2 (ou X1 a l envers) et A2 (ou A1 a l envers) avec X0, puis on les incremente d 'un pour tester toutes les positions de X 
		    	{
		    		tourne=(3-i)%3;//a modif?
	    			
		    		break;
		    	}
	    	}
	    	else
	    	{
	    		if((A[1]==aPlacer[(2-i)])&&(A[2]==aPlacer[(2*i+1)%3]))//verifie A1 avec X2 et A2 avec X1, puis on tourne le trio X
		    	{
		    		tourne=i;
		    		break;
		    	}
	    	}
	    	
    	}
    	System.out.println("120 : tourne="+tourne);
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
    	for(int i=50; i<60; i++)
    	{
    		for(int k=0; k<10-(i-50+1); k++)
    			System.out.print("  ");//pour que les cases correspondent visuellement
    		
    		for(int j=50; j<60; j++)
    		{
    			int[] vals=new int[3];
    			vals=this.plateau[i][j].get_valeurs();
    			if(this.plateau[i][j].get_occupation()==Endroit)
    			{
    				if(vals[0]!=-1)
    					System.out.print(+vals[0]+" ");
    				else
    					System.out.print(". ");
    					//System.out.print(+j%10+" ");

    			}
    			else
    			{
    				if (vals[0]!=-1)
    					System.out.print(+vals[2]+" "+vals[1]+" ");
    				else
    					System.out.print(". . ");
    					//System.out.print(+j%10+" "+j%10+" ");

				}
    			
    		}
    		System.out.println(" ");
    		for(int k=0; k<10-(i-50+1); k++)
    			System.out.print("  ");//pour que les cases correspondent visuellement
    		
    		for(int j=50; j<60; j++)//on affiche la deuxieme ligne du trio
    		{
    			int[] vals=new int[3];
    			vals=this.plateau[i][j].get_valeurs();
    			if(this.plateau[i][j].get_occupation()==Envers)
    			{
    				if(vals[0]!=-1)
    					System.out.print(+vals[0]+" ");
    				else
    					System.out.print(". ");
    					//System.out.print(+j%10+" ");

    			}
    			else
    			{
    				if (vals[0]!=-1)
    					System.out.print(+vals[1]+" "+vals[2]+" ");
    				else
    					System.out.print(". . ");
    					//System.out.print(+j%10+" "+j%10+" ");
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

  //methodes abstraites
  	public void placer_pion(int indice) {
  		
  		int[] retourCoupPossible=new int[this.nbreCoupsVoulus];
  		retourCoupPossible=this.coup_possible(indice);//on met a jour le tableau coupsVoulus
  		
  		if(this.nbreCoupsVoulus>0)//sinon on ne peut rien placer
  		{
  			System.out.println("a quel emplacement le placer? Emplacement dispos :");
  			for(int i=0; i<this.nbreCoupsVoulus; i++)//affichage des possibilités
  			{
  				System.out.println("num="+i+" x="+this.coupsVoulus[i][0]+" y="+this.coupsVoulus[i][1]);
  			}
  			
  			int rajoutL=0;
  			int rep=sc.nextInt();//rep de l utilisateur
  			int x=this.coupsVoulus[rep][0];//coordonnees voulues par l utilisateur
  			int y=this.coupsVoulus[rep][1];
  			
  			int pivot=retourCoupPossible[rep+1];//on regarde quelle rotation on doit faire en fonction de la reponse faite, rep+1 car tab[0] contient le nbre de collisions
  			//on fait cette rotation : 
  			int[] aPlacer=this.tableau[indice].get_valeurs();
  			for(int i=0; i<pivot%3; i++)
  			{
  				System.out.println("tourne!!!");
  				int echange=aPlacer[2];
  				aPlacer[2]=aPlacer[1];
  				aPlacer[1]=aPlacer[0];
  				aPlacer[0]=echange;
  			}
  			
  			this.plateau[x][y].set_valeurs(this.tableau[indice].get_valeurs());//on place les valeurs sur le plateau
  			this.tableau[indice].set_occupation(Joue);//on modifie son occupation dans le plateau
  			
  			//on recherche dans le tableau des coupsPossibles ou se situe le trio joué
  			int ind=0;
  			while ((this.coupsPossibles[ind][0]!=this.coupsVoulus[rep][0]) || (this.coupsPossibles[ind][1]!=this.coupsVoulus[rep][1]))
  				ind++;
  			
  			System.out.println("250");
  			this.aff_cp();
  			this.coupsPossibles[ind]=this.coupsPossibles[this.nbrePositionsPossibles-1];//on echange les deux cases pour eviter d'avoir un trou en plein milieu du tableau en prenant la derniere case du tableau
  			
  			System.out.println("252");
  			this.aff_cp();
  			//this.aff_cv();
  			
  			this.nbrePositionsPossibles--;
  			this.coupsPossibles[this.nbrePositionsPossibles]=new int[2];//sinon change la valeur de coupsPossibles[rep] aussi
  	
  			this.coupsPossibles[this.nbrePositionsPossibles][0]=-1;
  			this.coupsPossibles[this.nbrePositionsPossibles][1]=-1;//on reinitialise la case pour pas qu'elle soit en double
  			
  			//on regarde la disponibilité des 3 cases autour pour remplir coupsPossibles
  			Pion A=this.plateau[x][y-1];
  			int [] valA=A.get_valeurs();
  			if(valA[0]==-1)//donc la case a gauche est libre
  			{
  				this.coupsPossibles[this.nbrePositionsPossibles][0]=x;
  				this.coupsPossibles[this.nbrePositionsPossibles][1]=y-1;
  				this.nbrePositionsPossibles=this.nbrePositionsPossibles+1;
  			}
  			
  			Pion B=this.plateau[x][y+1];
  			int [] valB=B.get_valeurs();
  			if(valB[0]==-1)//donc la case a droite est libre
  			{
  				this.coupsPossibles[this.nbrePositionsPossibles][0]=x;
  				this.coupsPossibles[this.nbrePositionsPossibles][1]=y+1;
  				this.nbrePositionsPossibles=this.nbrePositionsPossibles+1;
  			}
  			
  			if(this.plateau[x][y].get_occupation()==Endroit)
  				rajoutL=1;
  			else
  				rajoutL=-1;
  			Pion C=this.plateau[x+rajoutL][y+rajoutL];//car le trio du dessous/dessus est décalé dans le tableau
  			int [] valC=C.get_valeurs();
  			if(valC[0]==-1)//donc la case au dessus/dessous est libre
  			{
  				this.coupsPossibles[this.nbrePositionsPossibles][0]=x+rajoutL;
  				this.coupsPossibles[this.nbrePositionsPossibles][1]=y+rajoutL;
  				this.nbrePositionsPossibles=this.nbrePositionsPossibles+1;
  			}
  			int[] placees=this.tableau[indice].get_valeurs();
  			System.out.println("tu as place "+placees[0]+" "+placees[1]+" "+placees[2]+" en x="+x+" y="+y);
  			/*System.out.println("297");
  			this.aff_cp();*/
  			this.init_coupsVoulus();//on reinitialise le tableau pour la prochaine valeur
  			//this.aff_cp();

  		}
  		else
  		{
  			/*System.out.println("305");
  			this.aff_cp();
  			this.init_coupsVoulus();
  			this.aff_cp();*/
  			System.out.println("on ne peut pas mettre ce domino");
  		}
  		//System.out.println("264");
  		//this.aff_cp();
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

   void aide() {
    }

   int partie_finie(Joueur[] joueur) {//retourne 0 si la partie doit continuer, numero du joueur+1 si la partie est gagnee et 5 si la partie est bloquee (plus aucun joueur ne peut jouer)
    	int retour=-1, count=0, nbrePieceRestante, joueurSansPiece=-1;
    	for(int i=0; i<this.get_nbre_j_total(); i++)
    	{
    		nbrePieceRestante=0;
    		
    		for(int j=0; j<joueur[i].get_nbre_piece(); j++)
    		{
    			if(this.tableau[count+j].get_occupation()==false)//la piece n a pas ete jouee
    			{
    				nbrePieceRestante++;
    			}
    			if(nbrePieceRestante>0) //si y a pas besoin de ce nombre plus tard
    				break;//il reste au moins une piece dans la main du joueur i
    			
    		}
    		
    		//pour connaitre le debut de la main suivante : 
    		count=count+joueur[i].get_nbre_piece();
    		
    		if(nbrePieceRestante==0)
    		{//vu qu'on verifie apres chaque joueur, deux ne peuvent pas gagner en meme temps
				retour=joueurSansPiece;
				
				break;
    		}
    	}
    	
    	//if(joueurSansPiece!=-1)
    		//retour=joueurSansPiece;//au moins un joueur n a plus de piece dans sa main
    	
    	if(retour==-1)
    	{
        	//verifier si partie bloquee

    	}
    	
    	if(retour==-1)//la partie n est ni bloquee, ni finie
    		retour=0;
    	
        return retour;
    }

   int[] coup_possible(int indice) { //retourne un tableau avec nbreDeCollisions en premiere case et nbreDeTours ensuite, selon la case dans laquelle on va jouer
   	int[] aPlacer= new int[3];
   	int coll = -1;
		int[] tourne=new int[this.nbrePositionsPossibles+1];//vaut -1 si le coup n est oas possible, et 0, 1 ou 2 selon combien de fois faut faire tourner le trio pour qu'il rentre
		//la premiere case contient la valeur de coll, la suite le nbre de tour que la piece doit faire. ce tableau sera surement trop grand, mais on ne connait pas sa taille exacte a ce moment, donc on a pris sa taille maximale possible
   	int retourTourne=-2;
		aPlacer=this.tableau[indice].get_valeurs();
   	String val=new String();
   	
   	//faire plateau coupsPossibles
   	for(int i=0; i<this.nbrePositionsPossibles; i++)
   	{
   		int x=this.coupsPossibles[i][0];
   		int y=this.coupsPossibles[i][1];
   		int rajoutL=0;
   		int cote=0;
   		
   		Pion A =new Pion();
   		Pion B= new Pion();
   		Pion C=new Pion();
   		
   		int[] valA=new int[3];
   		int[] valB=new int[3];
   		int[] valC=new int[3];
   		
   		//on regarde les triominos autour pour savoir si le triomino C est au dessus ou au dessous du triomino à regarder 
   		System.out.println("verif du trio x="+x+" y="+y);
   		if((x==-1)||(y==-1))
   			this.aff_cp();
   		if(this.plateau[x][y].get_occupation()==Endroit)//donc les trios autour sont à l'"Envers"
   			rajoutL=1;
   		else
   			rajoutL=-1;
   		
   		//on nomme les cases alentours
   		A=this.plateau[x][y+1];
   		B=this.plateau[x][y-1];
   		C=this.plateau[x+rajoutL][y+rajoutL];
   		
   		//on recupere les valeurs pour savoir si la case est occupée ou non
   		valA=A.get_valeurs();
   		valB=B.get_valeurs();
   		valC=C.get_valeurs();

   		if(this.tableau[indice].get_occupation()==Joue)
   			System.out.println("triomino deja joue...");
   		else if((valA[0]!=-1)&&(valB[0]!=-1)&&(valC[0]!=-1))//cette case est entouree de triominos
   		{
   			retourTourne=verif_coll_3_pieces(valA, valB, valC, aPlacer);
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=3;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;//on met dans la premiere case libre. comme un seul de ces if ou else if peut se faire, on est sur de pas ecraser de valeur
   			}
   		}
   		else if ((valA[0]!=-1)&&(valB[0]!=-1))
   		{
   			retourTourne=verif_coll_2_pieces(valA, valB, aPlacer, 2);
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=2;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;
   			}
   		}
   		else if ((valA[0]!=-1)&&(valC[0]!=-1))
   		{
   			retourTourne=verif_coll_2_pieces(valA, valC, aPlacer, 1);
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=2;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;
   			}
   		}
   		else if ((valB[0]!=-1)&&(valC[0]!=-1))
   		{
   			retourTourne=verif_coll_2_pieces(valB, valC, aPlacer, 0);
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=2;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;
   			}
   		}
   		else if (valA[0]!=-1)
   		{
       		if(this.plateau[x][y].get_occupation()==Endroit)//donc les trios autour sont à l'"Envers"
       			cote=1;
       		else
       			cote=2;
       		//System.out.println("530 : valA : x, y-1");
   			val="A";
   			retourTourne=verif_coll_1_piece(valA, aPlacer, cote);//on envoie le cote correspondant, il est différent selon si le triomino est a l endroit ou a l envers
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=1;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;
   			}
   		}
   		else if (valB[0]!=-1)
   		{
   			if(this.plateau[x][y].get_occupation()==Endroit)//donc les trios autour sont à l'"Envers"
       			cote=2;
       		else
       			cote=1;
       		//System.out.println("543 : valB : x, y+1");
   			val=val+"B";

   			retourTourne=verif_coll_1_piece(valB, aPlacer, cote);
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=1;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;
   			}
   		}
   		else if (valC[0]!=-1)
   		{
       		//System.out.println("553 : valC : x+rL, y+rL");
   			val=val+"C";
   			retourTourne=verif_coll_1_piece(valC, aPlacer, 0);
   			if(retourTourne==-1)//la piece n allait pas
   				coll=0;
   			else
   			{
   				coll=1;
   				tourne[this.nbreCoupsVoulus+1]=retourTourne;
   			}
   		}
   		else if((this.coupsPossibles[0][0]==56)&&(this.coupsPossibles[0][1]==56))//c est le premier coup à jouer
   		{
   			tourne[this.nbreCoupsVoulus+1]=0;
   			coll=0;//pour ne pas remettre dans le tableau une 2eme fois 56 56 
   			this.coupsVoulus[this.nbreCoupsVoulus][0]=56;
   			this.coupsVoulus[this.nbreCoupsVoulus][1]=56;
   			this.nbreCoupsVoulus++;
   		}
   		else//il n y a aucun triomino autour de cet endroit => ERREUR
   		{
   			System.out.println("Erreur ligne 273!!!! (coup_possible de triomino)");
   			System.exit(1);
   		}
   		
   		if (coll>0)
   		{
   			//System.out.println("577 coll="+coll);
   			//System.out.println("val="+val);
   			//System.out.println("582 i="+i);
   			//this.aff_cp();
   			tourne[0]=coll;
   			this.coupsVoulus[this.nbreCoupsVoulus]=this.coupsPossibles[i];
				this.nbreCoupsVoulus++;
   		}
   	}
       return tourne;
   }
   int choisir_coup(Joueur[] joueur, int joueur_act) {
   	int deb_main=0;
   	for(int i=0; i<joueur_act; i++)
   	{
   		deb_main=deb_main+joueur[i].get_nbre_piece();
   	}
   	
   	//affichage de la main du joueur
   	System.out.println("main du joueur : ");
   	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
   		System.out.print(+(i-deb_main)+" ");
   	System.out.println(" ");
   	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
   	{
   		int [] vals=new int[3];
   		vals=this.tableau[i].get_valeurs();
   		System.out.print(+vals[0]+" ");
   	}
   	System.out.println(" ");
   	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
   	{
   		int [] vals=new int[3];
   		vals=this.tableau[i].get_valeurs();
   		System.out.print(+vals[1]+" ");
   	}
   	System.out.println(" ");
   	for(int i=deb_main; i<deb_main+joueur[joueur_act].get_nbre_piece(); i++)
   	{
   		int [] vals=new int[3];
   		vals=this.tableau[i].get_valeurs();
   		System.out.print(+vals[2]+" ");
   	}
   	System.out.println(" ");
   	
   	System.out.println("quel triomino choisir?");
   	int num=sc.nextInt();
   	
   	//int [] vals=new int[3];
   	//vals=this.tableau[deb_main+num].get_valeurs();
   	
   	//System.out.println("tu as choisi v0="+vals[0]+" v1="+vals[1]+" v2="+vals[2]);
   	return num+deb_main;
   }

    public void piocher() {
    }

    public void afficher() {
    }

}