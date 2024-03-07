package cases;

import jeu.Couleur;

public abstract class Case {
	protected int position;
	protected Couleur couleur;
	
	public Case(int p, Couleur c) {
		this.position = p;
		this.couleur = c;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}

}
