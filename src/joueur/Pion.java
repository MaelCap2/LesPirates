package joueur;

import cases.Plateau;
import jeu.Couleur;
import jeu.De;

public abstract class Pion {
	private String nom;
	private int position;
	private Couleur couleur;
	private int vie;
	private int tour;
	private boolean fruit;
	private boolean caseFruit;
	private boolean caseVictoire;
	private boolean caseVS;
	
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
	
	public boolean getCaseVS() {
		return this.caseVS;
	}
	
	public void setCaseVS(boolean b) {
		this.caseVS = b;
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
        	p.getDe().setBonus(-1);
        }
        if(this.getFruit()) {
        	p.getDe().setBonus(2);
        }
        if (this.getPosition() + p.getDe().getNombre() + p.getDe().getBonus() <= 29) {
        	this.setPosition(p.getDe().getNombre() + p.getDe().getBonus());
        } else {
        	int n = this.getPosition() + p.getDe().getNombre() + p.getDe().getBonus() - 29;
			n = 29 - n;
			this.setPosition(n - this.getPosition());
        }
        this.setTour(2);
        p.getPlateau()[this.getPosition()].action(this, p);
        return p.getDe();
	}
	
	public void setVie() {
		this.vie = this.vie - 1;
	}
}
