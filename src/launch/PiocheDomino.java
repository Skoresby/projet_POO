package launch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 */
public class PiocheDomino extends Domino {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon imgp = new ImageIcon("p.PNG");//bouton annuler
	protected JButton pioche = new JButton("",imgp);

    public PiocheDomino() {

    	
    }

    /**
     * 
     */
    public void piocher() {
        // TODO implement here
    	
    }

    /**
     * 
     */
    public void afficher(Joueur []joueur, int joueurAct) {
        // TODO implement here
    	super.afficher(joueur, joueurAct);
    	System.out.println("DOMAAAAAAP");
    	pioche.setBounds(x_valider,10, 80, 40);
	    pioche.setOpaque(true);
	    pioche.addActionListener( new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("vous voulez piocher  ! ");
	    	}
	    	}
	    	);
	    zone_joueur.add(pioche);
	    zone_joueur.repaint();
	    container.repaint();
    }

}