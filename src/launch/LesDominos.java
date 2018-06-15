package launch;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class LesDominos extends JPanel {

	// liste

	protected String[] tab_stringb = { "d[1][0].PNG", "d[1][1].PNG", "d[1][2].PNG", "d[1][3].PNG", "d[1][4].PNG","d[1][5].PNG", "d[1][6].PNG" };
	protected String[] tab_stringh = { "d[0][0].PNG", "d[0][1].PNG", "d[0][2].PNG", "d[0][3].PNG", "d[0][4].PNG","d[0][5].PNG", "d[0][6].PNG" };
	protected BufferedImage[] bufferedImageb = new BufferedImage[tab_stringb.length];
	protected BufferedImage[] bufferedImageh = new BufferedImage[tab_stringh.length];
	private int beta = 0;
	private int b;
	private Domino valeur ;
	private Joueur [] joueur;
	private int joueurAct;
	protected Pion[] tabValeurs ;// objet de type tableau pour ou on va stocher les domino dans la classe
												// lesdomino
	
	// constructeur

	public LesDominos (Pion[] tab,Domino valeur, Joueur [] joueur, int joueurAct) {
		this.valeur=valeur;
		this.joueur=joueur;
		this.joueurAct=joueurAct;
		System.out.println("ld 27");
		tabValeurs = tab;
		System.out.println("heloooooooooooo");
		int[] tab1 = new int[2];
		tab1 = tabValeurs[0].get_valeurs();
		if (tab1[1] == 1) {

			System.out.println("cest la valeur basseeee");
		}
	}

	public void setValeurs(int x, int y) {
		beta = x;
		b = y;

	}
	/*
	 * public void setNexTab(Pion[] tab)//pour utiliser les valeur du tableau qui
	 * est dans les dominos { tabValeurs = tab;
	 * System.out.println("heloooooooooooo");
	 * 
	 * }
	 */

	// charge les images dans liste
	public void loadImg() {
		for (int i = 0; i < tab_stringb.length; i++) {
			try {
				this.bufferedImageb[i] = ImageIO.read(new File(tab_stringb[i]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < tab_stringh.length; i++) {
			try {
				this.bufferedImageh[i] = ImageIO.read(new File(tab_stringh[i]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// dessine les images
	public void paint(Graphics g) {
		int a = this.getWidth() / 30;
		int b = this.getHeight() - 260;
		int comp = valeur.getnbre();
		System.out.println("ld " + comp);
		int modu;
		modu = comp % 2;
		System.out.println("103 " + modu);
		int RnbreRestant;
		RnbreRestant=valeur.nbreDonR(joueurAct, joueur);
		System.out.println("ld 83 " +RnbreRestant);
		int con=(int) (Math.ceil(RnbreRestant/7));
		int val=comp % con;//ji
		
		System.out.println("la valeuar de retour de la division pour connaitre le debut de la main du jouer est "+val);
		/*
		 * for(int i = 0; i<this.bufferedImageb.length; i++) {
		 * 
		 * Graphics2D g2 = (Graphics2D)g ; g2.drawImage(this.bufferedImageb[i],a,b,
		 * 55,75, this); a+=70; //b+=30; } int s=this.getWidth() /30; int h =b-75;
		 * for(int i = 0; i<this.bufferedImageh.length; i++) { Graphics2D g2 =
		 * (Graphics2D)g ; g2.drawImage(this.bufferedImageh[i],s,h, 55,75, this); s+=70;
		 * 
		 * }
		 */
				
		int s = this.getWidth() / 30;
		int h = b - 75;
		
		//int recupeff=valeur.getEff();
		//System.out.println("la valeaur de recupeff est "+recupeff);
			for (int i = 0; i < 7; i++) {
				int[] vals = new int[2];
				// System.out.println(comp);
				boolean occup;
				occup = tabValeurs[val*7+i].get_occupation();
				vals = tabValeurs[val*7+i].get_valeurs();//affichage de la main en fonction du clic
				Graphics2D g2 = (Graphics2D) g;
				if (occup == Domino.PasJoue) {// si le domino n'est pas jouer on l'affiche
					    g2.drawImage(this.bufferedImageh[vals[0]], s, h, 55, 75, this);
						g2.drawImage(this.bufferedImageb[vals[1]], a, b, 55, 75, this);
						a += 70;
						s += 70;
						/*if(recupeff==-1) {
							 System.out.println("on peut commencer à jouer");
							g2.drawImage(this.bufferedImageb[vals[1]], a, b-200, 55, 75, this);
							}*/
					
				}
			}
		
		
			
	}

}