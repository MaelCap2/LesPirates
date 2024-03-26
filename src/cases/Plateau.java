package cases;

import jeu.Couleur;
import jeu.De;
import joueur.Pion;
import joueur.Roronoa;
import joueur.Vismoke;

public class Plateau {
	private Case[] plateau;
	private Roronoa zoro;
	private Vismoke sanji;
	private De de;
	
	public Plateau() {
		this.plateau = new Case[30];
		this.zoro = new Roronoa(Couleur.VERT, "zoro");
		this.sanji = new Vismoke(Couleur.BLEU, "sanji");
		this.de = new De();		
	}
	
	public void setPlateau(Case c, int i) {
		this.plateau[i] = c;
	}
	
	public Case[] getPlateau() {
		return this.plateau;
	}
	
	public Pion getZoro() {
		return this.zoro;
	}
	
	public Pion getSanji() {
		return this.sanji;
	}
	
	public De getDe() {
		return this.de;
	}

}
