package cases;

import jeu.Couleur;
import processing.core.PImage;

public class Case {
	protected int[] position;
	protected int numero;
	protected Couleur couleur;
	protected int taille;
	protected PImage image;
	protected int positionImg_x;
	protected int positionImg_y;
	protected boolean[] personnages = new boolean[2];
	
	public Case(int x, int y, int n, Couleur c, int t) {
		this.position = new int[2];
		this.position[0] = x;
		this.position[1] = y;
		this.numero = n;
		this.couleur = c;
		this.taille = t;
		this.image = null;
	}
	
	public Case(int x, int y, int n, int t, PImage i, int pix, int piy) {
		this.position = new int[2];
		this.position[0] = x;
		this.position[1] = y;
		this.numero = n;
		this.image = i;
		this.taille = t;
		this.positionImg_x = pix;
		this.positionImg_y = piy;
	}
	
	public Case(int x, int y, int n, Couleur c, int t, PImage i, int pix, int piy) {
		this.position = new int[2];
		this.position[0] = x;
		this.position[1] = y;
		this.numero = n;
		this.couleur = c;
		this.image = i;
		this.taille = t;
		this.positionImg_x = pix;
		this.positionImg_y = piy;
	}
	
	public int getPositionImg_x() {
		return this.positionImg_x;
	}
	
	public int getPositionImg_y() {
		return this.positionImg_y;
	}
	
	public PImage getImage() {
		return this.image;
	}
	
	public int[] getPosition() {
		return this.position;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	//public abstract void action();

}
