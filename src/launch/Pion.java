package launch;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Pion  extends JPanel implements MouseListener {
//
	
  
    //constructeur
    public Pion() {
    }
    

    private int[] valeurs;
    private boolean occupation;

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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
}