package launch;

//import java.util.*;

abstract class Partie extends Jeu {

    public Partie() {
    }

    
    private int numeroPartie;
    protected int nbreJoueurHumain;
    protected int nbreJoueurOrdi;
    private int idGagant;
    private int scoreGagnant;
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
        // TODO implement here
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
    abstract void afficher();
    abstract boolean partie_gagnee();
    abstract boolean coup_possible();
    abstract int premier_a_jouer();	
    abstract void aide();

}