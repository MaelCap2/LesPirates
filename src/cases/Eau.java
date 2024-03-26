package cases;

import jeu.Couleur;
import joueur.Pion;
import processing.core.PImage;

public class Eau extends Case{
	public Eau(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.BLEU;
		this.description = "Case : Eau";
	}
	
	public void action(Pion j, Plateau p) {
	}

}
