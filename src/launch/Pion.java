package launch;

public class Pion {

    //constructeur
    public Pion() {
    }

    private int[] valeurs;
    private boolean occupation=false;

    public void set_occupation(boolean occupation) {
    	this.occupation=occupation;
    }
    
    public void set_valeurs(int[] vals) {
    	this.valeurs=vals;
    }
    

    public int[] get_valeurs() {
    	return this.valeurs;
    }
    
    public boolean get_occupation() {
    	return this.occupation;
    }
    
}