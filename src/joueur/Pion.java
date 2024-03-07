package joueur;

import jeu.Couleur;

public class Pion {
	private int position;
	private Couleur couleur;
	private int vie;
	
	public Pion(Couleur c) {
		this.position = 0;
		this.couleur = c;
		this.vie = 5;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public int getVie() {
		return this.vie;
	}
	
}
