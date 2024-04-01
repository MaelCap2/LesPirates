package cases;

import jeu.Couleur;
import joueur.Pion;
import joueur.Vismoke;
import processing.core.PImage;

public class Femmes extends Case{
	
	public Femmes(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.ROSE;
		this.description = "Femmes";
	}
	
	public void action(Pion j, Plateau p) {
		if(j instanceof Vismoke) {
			j.setTour(2);
		}
	}
}
