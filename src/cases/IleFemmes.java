package cases;

import jeu.Couleur;
import processing.core.PImage;

public class IleFemmes extends Case{
	
	public IleFemmes(int x, int y, int n, int t, PImage i, int pix, int piy) {
		super(x, y, n, t, i, pix, piy);
		this.couleur = Couleur.ROSE;
	}
	
	public void action() {
		
	}
}
