package cases;

import jeu.Couleur;
import joueur.Pion;
import processing.core.PImage;

public class Fruit extends Case{
	public Fruit(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.NOIR;
		this.description = "Fruit du démon";
	}
	
	public void action(Pion j, Plateau p) {
		if(!j.getFruit()) {
			j.setCaseFruit(true);
		}
	}
}
