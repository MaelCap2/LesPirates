package joueur;

import java.util.Random;

import cases.Case;
import jeu.Couleur;

public class Pion {
	private String nom;
	private int position;
	private Couleur couleur;
	private int vie;
	private boolean victoire;
	private int tour;
	
	public Pion(Couleur c, String n) {
		this.position = 0;
		this.couleur = c;
		this.vie = 5;
		this.nom = n;
		this.victoire = false;
		this.tour = 0;
		
	}
	
	public int getTour() {
		return this.tour;
	}
	
	public void setTour(int i) {
		this.tour = this.tour + i;
	}
	
	public boolean getVictoire() {
		return this.victoire;
	}
	
	public void setVictoire(boolean b) {
		this.victoire = b;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void setPosition(int des) {
		this.position = this.position + des;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public int getVie() {
		return this.vie;
	}
	
	public void setVie(int v) {
		this.vie = this.vie - v;
		if(this.vie < 0) {
			this.vie = 0;
		}
	}
	
	public int jouer(Case[] tableau) {
		Random random = new Random();
        int de = random.nextInt(6) + 1;
        if (this.getPosition() + de <= 29) {
        	this.setPosition(de);
        } else {
        	this.setPosition(29 - this.getPosition());
        }
        this.setTour(2);
        tableau[this.getPosition()].action(this);
        return de;
	}
}
