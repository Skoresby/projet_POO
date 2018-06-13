package launch;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class fenetre_t extends JFrame implements MouseListener {
	private int m_choisi;
	private Pion[] hand2;
	private interface_t un = new interface_t();
	private Pion[][] plateau = new Pion[40][40];
	private int mode = 0;
	int[] values = new int [3];
	int[][] cp_possible = new int[56][2];

	public fenetre_t() {
		Triomino logic = new Triomino(); // Appel d'un objet triomino qui gère la logique de jeu
		int test[] = { 1, 2, 3 };

		logic.init_plateau();
		logic.init_tab();

		plateau = logic.get_plateau();
		hand2 = logic.get_tableau();
		plateau[10][10].set_valeurs(test);
		plateau[10][13].set_valeurs(test);
		plateau[10][11].set_valeurs(test);
		this.setTitle("Triomino");
		this.setSize(1200, 1200);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JPanel pan = new JPanel();
		// pan.addMouseListener(this);

		cp_possible[0][0] = 9;
		cp_possible[0][1] = 10;
		cp_possible[1][0] = 10;
		cp_possible[1][1] = 11;

		un.set_coup_possibles(cp_possible);
		// getContentPane().add(un, BorderLayout.CENTER);
		// un.setBackground(new java.awt.Color(255, 255, 255));
		un.set_data(plateau);
		un.set_hand(hand2);
		un.set_mode(0); // 0 mode normale, 1 mode insertion de triomino
		un.addMouseListener(this);
		//
		// getContentPane().add(panel, BorderLayout.CENTER);
		// pan.setBackground(Color.WHITE);
		// this.setContentPane(pan);
		this.setContentPane(un);
		this.setVisible(true);
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int i;
		int posX;
		int posY;
		int x = e.getX();
		int y = e.getY();
		int x2 = (x - 155) / 80; // l d'un triomino
		int x3 = (x - 155) / 40; // coordonnee d'un triomino dans plateau
		int y2 = (y - 50) / 40; // l d'un triomino
		int pos;
		System.out.println("coord x" + x + "coord y" + y);
		if ((x > 155) && (x < 970)) {
			if ((y > 955) && (y < 1010)) {
				System.out.println("carte dans main = " + x2);

				// hand2[x2].set_occupation(false);
				// un.set_hand(hand2);
				m_choisi =x2;
				mode = 1;
				un.set_mode(mode);
				// utilisation fonction coups possibles

				repaint();
			} else if ((y > 50) && (y < 855)) {
				if (mode == 1) {
					pos = x2 + y2 * 20;
					System.out.println("piece numero =" + pos);
					for (i = 0; i < 56; i++) {
						posX = 200 + cp_possible[i][0] * i;
						posX = 200 + cp_possible[i][1] * i;
						posY = 50+ cp_possible[i][0] * i;
						posY = 50 + cp_possible[i][1] * i;
						if ((x > posX -100) && (x < posX +100))
						{
							if ((y > posY -100) && (y < posY +100))
							{
								hand2[m_choisi].set_occupation(false);
								mode = 0;
								values  = hand2[m_choisi].get_valeurs();
								plateau[cp_possible[i][0]][cp_possible[i][1]].set_valeurs(values);
								break;
							}
						}
					}
				}
			}
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
