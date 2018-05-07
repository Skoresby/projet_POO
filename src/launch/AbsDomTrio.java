package launch;

abstract class AbsDomTrio extends Partie {
	 protected Pion tableau[];
	 protected Pion plateau[][];
	 
	 abstract Pion[] init_tab();
	 abstract void afficher();
	 abstract boolean partie_gagnee();
	 abstract boolean coup_possible();
	 abstract int premier_a_jouer();
	// abstract void piocher();
	 abstract void aide();
	 
}
