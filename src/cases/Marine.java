package cases;

import jeu.Couleur;
import joueur.Pion;
import processing.core.PImage;

public class Marine extends Case{
	public Marine(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.BLANC;
		this.description = "Case : Marine";
	}
	
	public void action(Pion j, Plateau p) {
	}
}
