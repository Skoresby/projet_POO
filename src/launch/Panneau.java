package launch;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;


import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Panneau extends JPanel {

	private static final long serialVersionUID = 326366636683489312L;
	public static final int HEIGHT=750; //HAUTEUR
	public static final int WIDTH=1300; //LARGUEUR
	private Triomino trio;
	private Joueur[] joueur;
	private int m_choisi;
	private Pion[] hand2;
	private Pion[][] plateau = new Pion[40][40];
	private int mode = 0;
	int[] values = new int [3];
	int[][] cp_possible = new int[56][2];
	int tab[][]={{1,2,3},{2,3,2},{4,2,3},{2,2,2},{2,3,2},{4,2,3},{3,3,3},{2,1,3},{4,4,4}};
	int clicFleche=0;

	
	
	public Panneau(Triomino trio,Joueur[] joueur, int actuel){
		
		this.addMouseListener(new Ecoute());
		this.trio=trio;
		//Triomino logic = new Triomino(); // Appel d'un objet triomino qui gère la logique de jeu
		int test[] = { 1, 2, 3 };
		

	}    
	
	public void paintComponent(Graphics g) {
		try {
			 super.paintComponent(g);
	        //Pour l'image de fond
	    	/*Image fond = ImageIO.read(new File("fond.jpg"));
	    	g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);*/
	    		
	    	//Images classiques
	    	Image annuler = ImageIO.read(new File("annuler.jpg"));
	    	g.drawImage(annuler,(int)(WIDTH/22),(int)(HEIGHT/1.18), null); //y,x
	    	Image valider = ImageIO.read(new File("valider_rond.jpg"));
	    	g.drawImage(valider, (int)(WIDTH/10),(int)(HEIGHT/1.18), null);
	    	Image menu = ImageIO.read(new File("menu2.png"));
	    	g.drawImage(menu,(int)(WIDTH/22),(int)(HEIGHT/15), null); //x,y
	    	
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("taille i : "+tab[2].length);
	
		affich_main(g);
		affich_nb_trioJ(g);
	}
	
	public void affich_main( Graphics g) {
		int taille=tab.length;
		int i=0, h=0;
		System.out.println("taille1 : "+taille);
		g.drawString("Pseudo : ",(int) (WIDTH/5), (int)(HEIGHT/1.1) );
		g.drawString("Score : ",(int) (WIDTH/3), (int)(HEIGHT/1.1) );
		g.drawString("NbTriomino : ",(int) (WIDTH/2), (int)(HEIGHT/1.1) );
		
		if(tab.length>7) 
		{
			System.out.println("coucou");
			//taille=7;
			Image fleche;
			try {
				fleche = ImageIO.read(new File("fleche.png"));
				g.drawImage(fleche,(int)(7.25*100+WIDTH/5),(int)(HEIGHT/1.25), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(clicFleche==1) {
			h=7;
			//i=0;
		}
		
		do {
			System.out.println("do : "+tab[h][0]+" h : "+h);
			if(tab[h][0] != 0)
			{
				try {
					Image triange = ImageIO.read(new File("triangle.png"));
			    	g.drawImage(triange,(int)(i*100+WIDTH/5),(int)(HEIGHT/1.35), null);
				}catch (IOException e) {
					e.printStackTrace();
				}
				for(int j=0;j<tab[h].length;j++) {
					System.out.println("for");
					switch(j)
					{
						case 0 :
							//haut
							g.drawString(String.valueOf(tab[h][2]), (int)(50+(i*100+WIDTH/5)), (int)(28+HEIGHT/1.35));
							break;
						case 1: //gauche
							g.drawString(String.valueOf(tab[h][0]), (int)(18+(i*100+WIDTH/5)), (int)(80+HEIGHT/1.35));
							break; 
						case 2: //droite
							g.drawString(String.valueOf(tab[h][1]), (int)(80+(i*100+WIDTH/5)), (int)(80+HEIGHT/1.35));
							break;
						default : 
							System.out.println("PB affichage main");
					}
					
					System.out.println(tab[h][j]);
						
				}
			}
			h++;
			i++;
			System.out.println("h : "+h+" i : "+i+" taille : "+taille);
		} while(h<taille && i<7);
		System.out.println("clicFlech : "+clicFleche);
		if(i<7)
			clicFleche=0;
	}
	
	public void affich_nb_trioJ(Graphics g) {
		int nbJoueur=3;
		for(int i=0;i<nbJoueur;i++) {
			switch(i)
			{
				case 0 : //gauche
					try {
						Image triangle = ImageIO.read(new File("grand_triangle.png"));
				    	g.drawImage(triangle,(int)(WIDTH/20),(int)(HEIGHT/4.5), null);
					}catch (IOException e) {
						e.printStackTrace();
					}
					g.drawString("Pseudo : ",(int) (WIDTH/20), (int)(HEIGHT/2.35) );
					g.drawString("Score : ",(int) (WIDTH/20), (int)(HEIGHT/2.25) );
					g.drawString("3",(int) (WIDTH/10), (int)(HEIGHT/3) );
					break;
				case 1: //droite
					try {
						Image triangle = ImageIO.read(new File("grand_triangle.png"));
				    	g.drawImage(triangle,(int)(WIDTH/1.2),(int)(HEIGHT/4.5), null);
					}catch (IOException e) {
						e.printStackTrace();
					}
					g.drawString("Pseudo : ",(int) (WIDTH/1.2), (int)(HEIGHT/2.35) );
					g.drawString("Score : ",(int) (WIDTH/1.2), (int)(HEIGHT/2.25) );
					g.drawString("6",(int) (WIDTH/1.13), (int)(HEIGHT/3) );
					break;
				case 2: //haut
					try {
						Image triangle = ImageIO.read(new File("grand_triangle.png"));
				    	g.drawImage(triangle,(int)(WIDTH/2.5),(int)(HEIGHT/30), null);
					}catch (IOException e) {
						e.printStackTrace();
					}
					g.drawString("Pseudo : ",(int) (WIDTH/2), (int)(HEIGHT/13) );
					g.drawString("Score : ",(int) (WIDTH/2), (int)(HEIGHT/10));
					g.drawString("8",(int) (WIDTH/2.19), (int)(HEIGHT/7) );
					break;
				default : 
					System.out.println("PB affichage nbtriomino");
			}
		}
	}
	
	public class Ecoute implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			/*Autres cliks*/
			int xClic = e.getX();
		    int yClic = e.getY();
		    System.out.println("x: "+xClic+" y: "+yClic);
		    if( yClic < 640  &&  yClic > 560 ) {
		    	if( xClic < 350 && xClic > 270) {
			    	System.out.println("x1: "+xClic+" y1: "+yClic);
			    	if(clicFleche==0)
			    		tab[0][0]=0;
			    	else if(clicFleche==1)
			    		tab[7][0]=0;
			    	repaint();
			    }
			    else if( xClic < 450 && xClic > 370 ) {
			    	System.out.println("x2: "+xClic+" y2: "+yClic);
			    	if(clicFleche==0)
			    		tab[1][0]=0;
			    	else if(clicFleche==1)
			    		tab[7][0]=0;
			    	repaint();
			    }
			    else if( xClic < 550 && xClic > 470 ) {
			    	System.out.println("x3: "+xClic+" y2: "+yClic);
			    	tab[2][0]=0;
			    	repaint();
			    }
			    else if( xClic < 650 && xClic > 570 ) {
			    	System.out.println("x4: "+xClic+" y2: "+yClic);
			    	tab[3][0]=0;
			    	repaint();
			    }
			    else if( xClic < 750 && xClic > 670 ) {
			    	System.out.println("x5: "+xClic+" y2: "+yClic);
			    	tab[4][0]=0;
			    	repaint();
			    }
			    else if( xClic < 850 && xClic > 770 ) {
			    	System.out.println("x6: "+xClic+" y2: "+yClic);
			    	tab[5][0]=0;
			    	repaint();
			    }
			    else if( xClic < 950 && xClic > 870 ) {
			    	System.out.println("x7: "+xClic+" y2: "+yClic);
			    	tab[6][0]=0;
			    	repaint();
			    }
			    else if( xClic < 1050 && xClic > 970 ) {
			    	System.out.println("x8: "+xClic+" y2: "+yClic);
			    	clicFleche++;
			    	repaint();
			    }
		    	
		    	/*Clic sur la partie plateau*/
		    	
		    }
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
	
}


