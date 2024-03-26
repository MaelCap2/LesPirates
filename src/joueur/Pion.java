package joueur;

import java.util.Random;

import cases.Case;
import cases.Plateau;
import jeu.Couleur;
import jeu.De;

public abstract class Pion {
	private String nom;
	private int position;
	private Couleur couleur;
	private int vie;
	private boolean caseVictoire;
	private int tour;
	private boolean caseFruit;
	private boolean fruit;
	
	public Pion(Couleur c, String n) {
		this.position = 0;
		this.couleur = c;
		this.vie = 5;
		this.nom = n;
		this.caseVictoire = false;
		this.tour = 0;
		this.caseFruit = false;
		
	}
	
	public boolean getCaseFruit() {
		return this.caseFruit;
	}
	
	public void setCaseFruit(boolean b) {
		this.caseFruit = b;
	}
	
	public boolean getFruit() {
		return this.fruit;
	}
	
	public void setFruit(boolean b) {
		this.fruit = b;
	}
	
	public int getTour() {
		return this.tour;
	}
	
	public void setTour(int i) {
		this.tour = this.tour + i;
	}
	
	public boolean getCaseVictoire() {
		return this.caseVictoire;
	}
	
	public void setVictoire(boolean b) {
		this.caseVictoire = b;
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
	
	public De jouer(Plateau p) {
		p.getDe().lancerDe();
        if(this instanceof Roronoa) {
        	p.getDe().setDe(p.getDe().getDe() - 1);
        }
        if (this.getPosition() + p.getDe().getDe() <= 29) {
        	this.setPosition(p.getDe().getDe());
        } else {
        	int n = this.getPosition() + p.getDe().getDe() - 29;
			n = 29 - n;
			this.setPosition(n - this.getPosition());
        }
        this.setTour(2);
        p.getPlateau()[this.getPosition()].action(this, p);
        if(this instanceof Roronoa) {
        	p.getDe().setDe(p.getDe().getDe() + 1);
        	return p.getDe();
        }
        return p.getDe();
	};
}
