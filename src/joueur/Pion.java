package joueur;

import jeu.Couleur;

public class Pion {
	private String nom;
	private int position;
	private Couleur couleur;
	private int vie;
	
	public Pion(Couleur c, String n) {
		this.position = 0;
		this.couleur = c;
		this.vie = 5;
		this.nom = n;
	}
	
	public String getNom() {
		return this.nom;
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
	
	public void setVie(int v) {
		this.vie = this.vie - v;
		if(this.vie < 0) {
			this.vie = 0;
		}
	}
}
