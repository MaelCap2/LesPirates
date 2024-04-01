package cases;

import jeu.Couleur;
import joueur.Pion;
import processing.core.PImage;

public class Combat extends Case{
	public Combat(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.NOIR;
		this.description = "Combat";
	}
	
	public void action(Pion j, Plateau p) {
		j.setCaseVS(true);
	}
}
