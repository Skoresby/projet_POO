package launch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class interface_t extends JPanel {
	public interface_t() {
		scroll.setOrientation(JScrollBar.HORIZONTAL);
		add(scroll);
		scroll.setPreferredSize(new Dimension(1200,15));
	}

	private int cd = 40;
	private int x1 = 200;
	private int y1 = 50;
	private int x2 = 200;
	private int y2 = 1000;
	Pion[][] tab = new Pion[40][40];
	Pion[] hand = new Pion[10];
	private int[][] cp_possibles = new int[56][2];
	int mode; // mode insertion de piece ou mode sans insertion de pièces (0 sans insertion, 1
	private final JScrollBar scroll = new JScrollBar();
				// av insertion)

	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		int i, j, exist[], exist2[], exist3[], exist4[];

		char n = 'O';
		for (i = 0; i < 20; i++) {
			for (j = 0; j < 20; j++) {

				exist = tab[i][j].get_valeurs();
				// System.out.println(exist[1]);
				if (exist[1] != -1) { // si il n'existe pas (la valeur -1 représente une piece non présente), on n'affichera pas de triomino

					if (i % 2 == 0) {
						if (j % 2 == 0) {
							System.out.println("sens normal");
							drawTrio_fi(g, x1 + j * cd, y1 + i * cd, tab[i][j]); // affichage en fonction de i et j pour le décalage
	

						} else {
							drawTrio_fo(g, x1 + j * cd, y1 + i * cd + cd, tab[i][j]);
							System.out.println("sens inverse");


						}
					} else { // ligne decalé, on veut que les triomino soit symetrique dans le sens vertical
						if (j % 2 == 0) {
							System.out.println("sens normal");
							drawTrio_fi(g, x1 + j * cd + cd, y1 + i * cd, tab[i][j]); 


						} else {
							System.out.println("sens inverse");
							drawTrio_fo(g, x1 + j * cd + cd, y1 + i * cd + cd, tab[i][j]);

						}
						// Fin affichage des triominos
						// Debut affichage des points d'insertions si mode == 1

					}

					/*
					 * if (j%2 == 0) { if (i%2 == 0) { drawTrio_fi(g,x1+i*cd,y1+j*cd,tab[i][j]); }
					 * else { drawTrio_fo(g,x1+i*cd,y1+j*cd+cd,tab[i][j]); } } else { if (i%2 == 0)
					 * { drawTrio_fi(g,x1+i*cd+cd,y1+j*cd,tab[i][j]); } else {
					 * drawTrio_fo(g,x1+i*cd+cd,y1+j*cd+cd,tab[i][j]); } }
					 */
				}
			}
		}
		if (mode == 1) { // affichage des cout possible pour l'utilisateur actuel
			System.out.println("mode insertion");
			for (i = 0; i < 1; i++) {

				
					System.out.println("dessin cercle");
					drawPossibility(g, x1 + cp_possibles[i][0] * cd, y1 + cp_possibles[i][1] * cd);//cordonees


			}
		}
		for (i = 0; i < 10; i++) { // affichage de main avant integration partie oceane
			if (hand[i].get_occupation() == true) {
				drawTrio_fo(g, x2 + i * cd * 2, y2, hand[i]);
				/*
				 * if (i%2 == 0) { drawTrio_fi(g,x2+i*cd,y2); } else {
				 * drawTrio_fo(g,x2+i*cd,y2); }
				 */
			}
		}
	}

	public void set_data(Pion[][] plateau) {
		tab = plateau;
	}

	public void set_hand(Pion[] ttab) {
		hand = ttab;
	}

	public void drawTrio_fi(Graphics g, int cX, int cY, Pion p) { // triomino position normale
		int data[] = p.get_valeurs();
		g.drawLine(cX, cY, cX - cd, cY + cd);
		g.drawLine(cX, cY, cX + cd, cY + cd);
		g.drawLine(cX + cd, cY + cd, cX - cd, cY + cd);
		g.drawString(String.valueOf(data[0]), cX, cY + cd / 2);
		g.drawString(String.valueOf(data[1]), cX - 20, cY + cd);
		g.drawString(String.valueOf(data[2]), cX + 20, cY + cd);
	}

	public void drawTrio_fo(Graphics g, int cX, int cY, Pion p) { // triomino position inverse
		int data[] = p.get_valeurs();
		g.drawLine(cX, cY, cX - cd, cY - cd);
		g.drawLine(cX, cY, cX + cd, cY - cd);
		g.drawLine(cX + cd, cY - cd, cX - cd, cY - cd);
		g.drawString(String.valueOf(data[0]), cX, cY - 2);
		g.drawString(String.valueOf(data[1]), cX - 20, cY - cd + 10);
		g.drawString(String.valueOf(data[2]), cX + 20, cY - cd + 10);
	}

	public void drawPossibility(Graphics g, int cX, int cY) {
		g.fillOval(cX, cY+5, 8, 8);
	}

	public void set_coup_possibles(int[][] tab) {
		cp_possibles = tab;
	}

	public void set_mode(int m) {
		mode = m;
	}

}
