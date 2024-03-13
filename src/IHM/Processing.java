package IHM;

import cases.Case;
import cases.IleFemmes;
import cases.OnePiece;
import jeu.Couleur;
import jeu.TourJoueur;
import processing.core.PApplet;
import processing.core.PImage;

public class Processing extends PApplet {
	
	PImage fruit;
	PImage chapeau;
	PImage marine;
	PImage coffre;
	PImage sanji;
	PImage combat;
	
	int unite_x = width / 100;
	int unite_y = height / 100;
	
	TourJoueur joueur = TourJoueur.ZORO;
	
	public static void main(String[] args) {
		PApplet.main("IHM.Processing");
	}
	
	public void settings() {
		  size(1200, 600);
		}

	public void setup(){
		background(255);
		fruit = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/devilfruit.png");
		fruit.resize(width / (14 * 15/10), width / (14 * 13/10));
		chapeau = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/chapeau.png");
		chapeau.resize(width / (14 * 10/10), width / (14 * 18/10));
		marine = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/marine.png");
		marine.resize(width / (14 * 12/10), width / (14 * 15/10));
		coffre = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/coffre.png");
		coffre.resize(width / (14 * 9/10), width / (14 * 11/10));
		sanji = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/sanji.png");
		sanji.resize(width / (14 * 12/10), width / (14 * 13/10));
		combat = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/combat.png");
		combat.resize(width / (14 * 12/10), width / (14 * 13/10));
	}

	public void draw() {
		dessinerPlateau();
		dessinerLancementDe();
	}
	
	public void dessinerCase(Case c) {
		if(c.getCouleur() != null) {
			switch(c.getCouleur()) {
			case BLEU:
				fill(0, 0, 255);
				break;
			case BLANC:
				fill(255);
				break;
			case ROUGE:
				fill(255, 0, 0);
				break;
			case JAUNE:
				fill(255, 230, 0);
				break;
			case VIOLET:
				fill(128, 0, 128);
				break;
			case NOIR:
				fill(0, 0, 0);
				break;
			case ROSE:
				fill(255, 105, 180);
				break;
			default:
			      break;
			}
		}
		rect(c.getPosition()[0], c.getPosition()[1], c.getTaille(), c.getTaille());
		fill(0);
		if(c.getImage() != null) {
			image(c.getImage(), c.getPosition()[0] + c.getPositionImg_x() , c.getPosition()[1] + c.getPositionImg_y());
		}
		textSize(32);
		textAlign(CENTER, CENTER);
		text(c.getNumero(), c.getPosition()[0] + c.getTaille() / 2, c.getPosition()[1] + c.getTaille() / 2);
		
	}
	
	public void dessinerPlateau() {
		int coinHG_x = width / 100 * 52;
		int coinHG_y = height / 100 * 20;
		int tailleCase = width / 14;
		strokeWeight(1);
		stroke(0);
		Case c1 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 0 * tailleCase, 1, Couleur.BLANC, tailleCase);
		dessinerCase(c1);
		Case c2 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 0 * tailleCase, 2, Couleur.BLANC, tailleCase);
		dessinerCase(c2);
		Case c3 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 0 * tailleCase, 3, Couleur.BLANC, tailleCase);
		dessinerCase(c3);
		Case c4 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 0 * tailleCase, 4, Couleur.BLANC, tailleCase);
		dessinerCase(c4);
		Case c5 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 0 * tailleCase, 5, Couleur.NOIR, tailleCase, fruit, width / (14 * 6), width / (14 * 10));
		dessinerCase(c5);
		Case c6 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 0 * tailleCase, 6, Couleur.BLANC, tailleCase);
		dessinerCase(c6);
		Case c7 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 1 * tailleCase, 7, Couleur.BLANC, tailleCase);
		dessinerCase(c7);
		Case c8 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 2 * tailleCase, 8, Couleur.BLANC, tailleCase);
		dessinerCase(c8);
		Case c9 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 3 * tailleCase, 9, Couleur.BLANC, tailleCase);
		dessinerCase(c9);
		Case c10 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 4 * tailleCase, 10, Couleur.NOIR, tailleCase, chapeau, width / (14 * 50), width / (14 * 4));
		dessinerCase(c10);
		Case c11 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 4 * tailleCase, 11, Couleur.BLANC, tailleCase);
		dessinerCase(c11);
		Case c12 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 4 * tailleCase, 12, Couleur.BLANC, tailleCase);
		dessinerCase(c12);
		Case c13 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 4 * tailleCase, 13, Couleur.BLANC, tailleCase);
		dessinerCase(c13);
		Case c14 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 4 * tailleCase, 14, Couleur.BLANC, tailleCase, marine, width / (14 * 15), width / (14 * 5));
		dessinerCase(c14);
		Case c15 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 4 * tailleCase, 15, Couleur.BLANC, tailleCase);
		dessinerCase(c15);
		Case c16 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 3 * tailleCase, 16, Couleur.BLANC, tailleCase);
		dessinerCase(c16);
		Case c17 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 2 * tailleCase, 17, Couleur.BLANC, tailleCase);
		dessinerCase(c17);
		Case c18 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 1 * tailleCase, 18, Couleur.BLANC, tailleCase);
		dessinerCase(c18);
		Case c19 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 1 * tailleCase, 19, Couleur.BLANC, tailleCase);
		dessinerCase(c19);
		Case c20 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 1 * tailleCase, 20, Couleur.BLANC, tailleCase);
		dessinerCase(c20);
		Case c21 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 1 * tailleCase, 21, Couleur.BLANC, tailleCase);
		dessinerCase(c21);
		Case c22 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 1 * tailleCase, 22, Couleur.BLANC, tailleCase);
		dessinerCase(c22);
		Case c23 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 2 * tailleCase, 23, Couleur.BLANC, tailleCase);
		dessinerCase(c23);
		IleFemmes c24 = new IleFemmes(coinHG_x + 4 * tailleCase, coinHG_y + 3 * tailleCase, 24, tailleCase, sanji, width / (14 * 15), width / (14 * 10));
		dessinerCase(c24);
		Case c25 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 3 * tailleCase, 25, Couleur.BLANC, tailleCase);
		dessinerCase(c25);
		Case c26 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 3 * tailleCase, 26, Couleur.BLANC, tailleCase);
		dessinerCase(c26);
		Case c27 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 3 * tailleCase, 27, Couleur.BLANC, tailleCase);
		dessinerCase(c27);
		Case c28 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 2 * tailleCase, 28, Couleur.BLANC, tailleCase);
		dessinerCase(c28);
		Case c29 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 2 * tailleCase, 29, Couleur.BLANC, tailleCase);
		dessinerCase(c29);
		OnePiece c30 = new OnePiece(coinHG_x + 3 * tailleCase, coinHG_y + 2 * tailleCase, 30, tailleCase, coffre, -width / (14 * 8), width / (14 * 50));
		dessinerCase(c30);
		
		strokeWeight(5);
		line(coinHG_x + 0 * tailleCase, coinHG_y + 0 * tailleCase, coinHG_x + 6 * tailleCase, coinHG_y + 0 * tailleCase);
		line(coinHG_x + 6 * tailleCase, coinHG_y + 0 * tailleCase, coinHG_x + 6 * tailleCase, coinHG_y + 5 * tailleCase);
		line(coinHG_x + 6 * tailleCase, coinHG_y + 5 * tailleCase, coinHG_x + 0 * tailleCase, coinHG_y + 5 * tailleCase);
		line(coinHG_x + 0 * tailleCase, coinHG_y + 5 * tailleCase, coinHG_x + 0 * tailleCase, coinHG_y + 1 * tailleCase);
		line(coinHG_x + 0 * tailleCase, coinHG_y + 1 * tailleCase, coinHG_x + 5 * tailleCase, coinHG_y + 1 * tailleCase);
		line(coinHG_x + 5 * tailleCase, coinHG_y + 1 * tailleCase, coinHG_x + 5 * tailleCase, coinHG_y + 4 * tailleCase);
		line(coinHG_x + 5 * tailleCase, coinHG_y + 4 * tailleCase, coinHG_x + 1 * tailleCase, coinHG_y + 4 * tailleCase);
		line(coinHG_x + 1 * tailleCase, coinHG_y + 4 * tailleCase, coinHG_x + 1 * tailleCase, coinHG_y + 2 * tailleCase);
		line(coinHG_x + 1 * tailleCase, coinHG_y + 2 * tailleCase, coinHG_x + 4 * tailleCase, coinHG_y + 2 * tailleCase);
		line(coinHG_x + 4 * tailleCase, coinHG_y + 2 * tailleCase, coinHG_x + 4 * tailleCase, coinHG_y + 3 * tailleCase);
		line(coinHG_x + 4 * tailleCase, coinHG_y + 3 * tailleCase, coinHG_x + 2 * tailleCase, coinHG_y + 3 * tailleCase);
	}
	
	public void dessinerLancementDe() {
		if(joueur == TourJoueur.ZORO) {
			stroke(0, 150, 0);
			noFill();
			rect(width / 100 * 10, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
			fill(0, 150, 0);
			textSize(40);
			textAlign(CENTER, CENTER);
			text("Lancer les dés !", width / 100 * 25, height / 100 * 70);
		}
	}
}
