package launch;

import java.util.*;

import launch.Pion;

public class Triomino extends Partie {
	//constructeur
    public Triomino() {
    	
    	
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
    		int [] vals=new int[3];
    		change=this.tableau[i];
    		vals=change.get_valeurs();
    		
    		alea=(int)(Math.random()*56);
    		
    		this.tableau[i]=this.tableau[alea];
    		this.tableau[alea]=change;
    	}
    	
    	return this.tableau;
    }
    int premier_a_jouer() {
    	return -1;
    }

   void aide() {
    }

    boolean partie_gagnee() {
        return false;
    }

    boolean coup_possible() {
        return false;
    }

    public void piocher() {
    }

    public void afficher() {
    }

}