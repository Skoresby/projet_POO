package launch;

import java.util.*;

public class Triomino extends Partie {
	//constructeur
    public Triomino() {
    	
    	/*for(int i=0; i<56; i++)
    	{
    		this.tableau[i]=new Pion();
    		//this.tableau[i].valeurs=new int[3];
    		
    		
    	}*/
    }

   

    public Pion[] init_tab() {
    	this.tableau=new Pion[56];
    	for(int i=0; i<56; i++)
    	{
    		this.tableau[i]=new Pion();
    		this.tableau[i].set_valeurs(new int[3]);
    	}
    	int count=0;
		int[] vals=new int[3];

    	for(int i=0; i<6; i++)
    	{
    		for(int j=i; j<6; j++)
    		{
    			for(int k=j; k<6; k++)
    			{
    				System.out.println("i="+i+" j="+j+" k="+k+" count="+count);
	   				vals[0]=i;
	   				vals[1]=j;
	   				vals[2]=k;
	   				this.tableau[count].set_valeurs(vals);
    				count=count+1;
    			}
    		}
    	}
    	/*for(int i=0; i<56; i++)
    	{
    		int[] vals=new int[3];
    		vals=this.tableau[i].get_valeurs();
    		System.out.println(+vals[0]+" "+vals[1]+" "+vals[2]);
    	}*/
    	
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