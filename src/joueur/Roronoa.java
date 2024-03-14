package joueur;

import java.util.Random;

import cases.Case;
import jeu.Couleur;

public class Roronoa extends Pion{
	
	public Roronoa(Couleur c, String n) {
		super(c, n);
	}
	
	public int jouer(Case[] tableau) {
		Random random = new Random();
        int de = random.nextInt(6) + 1;
        de = de - 1;
        if (this.getPosition() + de <= 29) {
        	this.setPosition(de);
        } else {
        	this.setPosition(29 - this.getPosition());
        }
        this.setTour(2);
        tableau[this.getPosition()].setPersonnages(this);
        return de + 1;
	}

}
