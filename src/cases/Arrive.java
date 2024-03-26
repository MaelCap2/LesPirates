package cases;

import jeu.Couleur;
import joueur.Pion;
import processing.core.PImage;

public class Arrive extends Case{
	
	public Arrive(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.JAUNE;
		this.description = "Case : Victoire";
	}
	
	public void action(Pion j, Plateau p) {
		j.setVictoire(true);
	}
	
	public void action(Pion p1, Pion p2) {
	}
	
}
