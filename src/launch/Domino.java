package launch;


public class Domino extends Partie {

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
    }

}