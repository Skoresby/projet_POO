package launch;

import java.util.Scanner;


public class Joueur {

    private static final Object[] tabJoueur = null;

	// Default constructor
    public Joueur() {
    	this.score=0;//initialisation
    	
    }//
    
    protected Scanner sc = new Scanner(System.in);
    private String pseudo;
    private int type;
    private int score;
    private int nbrePieceMax;
    private int position;
    private int numeroPartie;
   
    public void set_nom() {
    	//System.out.println("rentre ton pseudo");
    	//this.pseudo=sc.nextLine();
    	this.pseudo="Kyndra";
    	System.out.println("tu as choisi "+this.pseudo+" comme pseudo");
    }
    public void set_nom(String pseudo) {
    	this.pseudo=pseudo;
    }
    
    public void set_num_partie(int num) {
    	this.numeroPartie=num;
    }
    
    public void set_type(int type) {
    	this.type=type;
    }
    
    public void coup_voulu() {
        // TODO implement here
    }

    public void positionner() {
        // TODO implement here
    }

    public void set_score(int scoreAAjouter) {
    	this.score=this.score+scoreAAjouter;
    }

    public int get_score() {
        return this.score;
    }

    public String get_pseudo() {
    	return this.pseudo;
    }

    public int get_type() {
        return this.type;
    }

    public int get_nbre_piece() {
        return this.nbrePieceMax;
    }

    public void set_nbre_piece(int nbrePiece) {
    	this.nbrePieceMax=nbrePiece;
    }

    public int get_position() {
    	return this.position;
    }

    public void set_position(int position) {
    	this.position=position;
    }
    
    public static int info() {
    	int debutMain;
    	int JoueurActuel=0;
    	Joueur[] tabJoueur= new Joueur[4];
    	/*tabJoueur[0].set_nom("mounouille");
    	tabJoueur[0].set_type(1);
    	tabJoueur[0].set_score(0);
    	tabJoueur[0].set_nbre_piece(7);
    	tabJoueur[0].set_position(2);
    	tabJoueur[0].set_num_partie(1);
    	System.out.println("les info sur le joueur sont" +tabJoueur[0]);
    	System.out.println(" ");
    	/*for(int i=0;i<JoueurActuel;i++) {
    		debutMain=Joueur[JoueurActuel].get_nbre_piece();
    	}
    	*/
    	
    	return 0;
    }

}