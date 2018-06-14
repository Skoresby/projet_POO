package launch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class interface_t extends JPanel {
	public interface_t() {
		super();
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
				// av insertion)

	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		int i, j, exist[], exist2[], exist3[], exist4[];
		setSize(800,200);
		char n = 'O';
		for (i = 0; i < 20; i++) {
			for (j = 0; j < 20; j++) {

				exist = tab[i][j].get_valeurs();
				// System.out.println(exist[1]);
				if (exist[1] != -1) {

					if (i % 2 == 0) {
						if (j % 2 == 0) {
							System.out.println("sens normal");
							drawTrio_fi(g, x1 + j * cd, y1 + i * cd, tab[i][j]);
							/*
							 * if (mode == 1) { try { exist2 = tab[i][j + 1].get_valeurs(); exist3 =
							 * tab[i][j - 1].get_valeurs(); exist4 = tab[i + 1][j].get_valeurs(); if
							 * (exist2[1] == -1) { drawPossibility(g, x1 + j * cd + 20, y1 + i * cd);
							 * System.out.println(exist2[1] + "" + exist3[1] + "" + exist4[1]);
							 * 
							 * } if (exist3[1] == -1) { drawPossibility(g, x1 + j * cd - 30, y1 + i * cd); }
							 * if (exist4[1] == -1) { drawPossibility(g, x1 + j * cd - 5, y1 + i * cd + 45);
							 * } } catch (Exception e) {
							 * 
							 * } }
							 */

						} else {
							drawTrio_fo(g, x1 + j * cd, y1 + i * cd + cd, tab[i][j]);
							System.out.println("sens inverse");
							/*
							 * if (mode == 1) { try { exist2 = tab[i][j + 1].get_valeurs(); exist3 =
							 * tab[i][j - 1].get_valeurs(); exist4 = tab[i + 1][j].get_valeurs();
							 * System.out.println(exist2[1] + "" + exist3[1] + "" + exist4[1]); if
							 * (exist2[1] == -1) { drawPossibility(g, x1 + j * cd + 35, y1 + i * cd + 15);
							 * 
							 * } if (exist3[1] == -1) { drawPossibility(g, x1 + j * cd - 45, y1 + i * cd +
							 * 15);
							 * 
							 * } if (exist4[1] == -1) {
							 * 
							 * drawPossibility(g, x1 + j * cd - 5, y1 + i * cd - 15); } } catch (Exception
							 * e) {
							 * 
							 * } }
							 */

						}
					} else { // ligne decalé
						if (j % 2 == 0) {
							System.out.println("sens normal");
							drawTrio_fi(g, x1 + j * cd + cd, y1 + i * cd, tab[i][j]);

							/*
							 * if (mode == 1) { try { exist2 = tab[i][j + 1].get_valeurs(); exist3 =
							 * tab[i][j - 1].get_valeurs(); exist4 = tab[i + 1][j].get_valeurs();
							 * System.out.println(exist2[1] + exist3[1] + exist4[1]); if (exist2[1] == -1) {
							 * drawPossibility(g, x1 + j * cd - 30 + cd, y1 + i * cd); } if (exist3[1] ==
							 * -1) { drawPossibility(g, x1 + j * cd + 20 + cd, y1 + i * cd); } if (exist4[1]
							 * == -1) { drawPossibility(g, x1 + j * cd - 5 + cd, y1 + i * cd + 45); } }
							 * catch (Exception e) {
							 * 
							 * } }
							 */
						} else {
							System.out.println("sens inverse");
							drawTrio_fo(g, x1 + j * cd + cd, y1 + i * cd + cd, tab[i][j]);
							/*
							 * if (mode == 1) { try { exist2 = tab[i][j + 1].get_valeurs(); exist3 =
							 * tab[i][j - 1].get_valeurs(); exist4 = tab[i + 1][j].get_valeurs();
							 * System.out.println(exist2[1] + exist3[1] + exist4[1]); if (exist2[1] == -1) {
							 * drawPossibility(g, x1 + j * cd - 45 + cd, y1 + i * cd + 15); } if (exist3[1]
							 * == -1) { drawPossibility(g, x1 + j * cd + 35 + cd, y1 + i * cd + 15); } if
							 * (exist4[1] == -1) { drawPossibility(g, x1 + j * cd - 5 + cd, y1 + i * cd -
							 * 15); } } catch (Exception e) {
							 * 
							 * } }
							 */
							// drawPossibility(g,x1 + j * cd+cd,y1 + i * cd);
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
		if (mode == 1) {
			System.out.println("mode insertion");
			for (i = 0; i < 56; i++) {

				
					System.out.println("dessin cercle");
					drawPossibility(g, x1 + cp_possibles[i][0] * cd, y1 + cp_possibles[i][1] * cd);


			}
		}
		for (i = 0; i < 10; i++) {
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

	public void drawTrio_fi(Graphics g, int cX, int cY, Pion p) {
		int data[] = p.get_valeurs();
		g.drawLine(cX, cY, cX - cd, cY + cd);
		g.drawLine(cX, cY, cX + cd, cY + cd);
		g.drawLine(cX + cd, cY + cd, cX - cd, cY + cd);
		g.drawString(String.valueOf(data[0]), cX, cY + cd / 2);
		g.drawString(String.valueOf(data[1]), cX - 20, cY + cd);
		g.drawString(String.valueOf(data[2]), cX + 20, cY + cd);
	}

	public void drawTrio_fo(Graphics g, int cX, int cY, Pion p) {
		int data[] = p.get_valeurs();
		g.drawLine(cX, cY, cX - cd, cY - cd);
		g.drawLine(cX, cY, cX + cd, cY - cd);
		g.drawLine(cX + cd, cY - cd, cX - cd, cY - cd);
		g.drawString(String.valueOf(data[0]), cX, cY - 2);
		g.drawString(String.valueOf(data[1]), cX - 20, cY - cd + 10);
		g.drawString(String.valueOf(data[2]), cX + 20, cY - cd + 10);
	}

	public void drawPossibility(Graphics g, int cX, int cY) {
		// g.setColor(Color.LIGHT_GRAY);
		g.fillOval(cX, cY+5, 8, 8);
		// g.setColor(Color.BLACK);
	}

	public void set_coup_possibles(int[][] tab) {
		cp_possibles = tab;
	}

	public void set_mode(int m) {
		mode = m;
	}

}
