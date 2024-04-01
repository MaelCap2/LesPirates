package cases;

import jeu.Couleur;
import joueur.Pion;

public class Normale extends Case{
	public Normale(int x, int y, int n, int t) {
		super(x, y, n, t);
		this.couleur = Couleur.BLANC;
		this.description = "Normale";
	}
	
	public void action(Pion j, Plateau p) {
	}
}
