package IHM;

import cases.Case;
import cases.IleFemmes;
import cases.OnePiece;
import jeu.Couleur;
import jeu.TourJoueur;
import joueur.Pion;
import joueur.Roronoa;
import joueur.Vismoke;
import processing.core.PApplet;
import processing.core.PImage;

public class Processing extends PApplet {
	
	public enum ETAT {
		  OPEN,
		  CLICK
		}
	
	ETAT etat;
	
	PImage fruit;
	PImage chapeau;
	PImage marine;
	PImage coffre;
	PImage sanji;
	PImage combat;
	
	Couleur c;
	
	Roronoa Zoro = new Roronoa(Couleur.VERT, "zoro");
	Vismoke Sanji = new Vismoke(Couleur.BLEU, "sanji");
	int de;
	
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
		Zoro.setTour(1);
		etat = etat.OPEN;
	}

	public void draw() {
		switch(etat) {
		case OPEN:
			dessinerJeu(Zoro, Sanji, de);
			break;
		case CLICK:
			dessinerTour();
			etat = etat.OPEN;
		default:
		      break;
		}
		
	}
	
	public void dessinerTour() {
		Case[] tableau = dessinerPlateau();
		textSize(40);
		if(Zoro.getTour() < Sanji.getTour()) {
			de = Zoro.jouer(tableau);
		} else {
			de = Sanji.jouer(tableau);
		}
		dessinerJeu(Zoro, Sanji, de);
	}
	
	public void dessinerJeu(Pion p1, Pion p2, int de) {
		background(255);
		Case[] tableau = dessinerPlateau();
		dessinerLancementDe();
		dessinerPion(p1, p2, tableau);
		if(p1.getPosition() != 0 || p2.getPosition() != 0) {
			fill(0);
			text(de, width / 100 * 45, height / 100 * 70);
		}
	}
	
	public void dessinerCase(Case c) {
		if(c.getCouleur() != null) {
			switch(c.getCouleur()) {
			case BLEU:
				fill(0, 0, 200);
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
			case VERT:
				fill(0, 150, 0);
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
	
	public void dessinerPion(Pion p1, Pion p2, Case[] tableau) {
		switch(p1.getCouleur()) {
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
		case VERT:
			fill(0, 150, 0);
			break;
		default:
		      break;
		}
		stroke(0);
		strokeWeight(2);
		ellipse(tableau[p1.getPosition()].getPosition()[0] + width/55, tableau[p1.getPosition()].getPosition()[1] + width/55, width/70, width/70);
		switch(p2.getCouleur()) {
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
		case VERT:
			fill(0, 150, 0);
			break;
		default:
		      break;
		}
		ellipse(tableau[p2.getPosition()].getPosition()[0] + width/19, tableau[p2.getPosition()].getPosition()[1] + width/19, width/70, width/70);
	}
	
	public Case[] dessinerPlateau() {
		int coinHG_x = width / 100 * 52;
		int coinHG_y = height / 100 * 20;
		int tailleCase = width / 14;
		strokeWeight(1);
		stroke(0);
		Case[] tableau = new Case[30];
		Case c1 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 0 * tailleCase, 1, Couleur.BLANC, tailleCase);
		dessinerCase(c1);
		tableau[0] = c1;
		Case c2 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 0 * tailleCase, 2, Couleur.BLANC, tailleCase);
		dessinerCase(c2);
		tableau[1] = c2;
		Case c3 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 0 * tailleCase, 3, Couleur.BLANC, tailleCase);
		dessinerCase(c3);
		tableau[2] = c3;
		Case c4 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 0 * tailleCase, 4, Couleur.BLANC, tailleCase);
		dessinerCase(c4);
		tableau[3] = c4;
		Case c5 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 0 * tailleCase, 5, Couleur.NOIR, tailleCase, fruit, width / (14 * 6), width / (14 * 10));
		dessinerCase(c5);
		tableau[4] = c5;
		Case c6 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 0 * tailleCase, 6, Couleur.BLANC, tailleCase);
		dessinerCase(c6);
		tableau[5] = c6;
		IleFemmes c7 = new IleFemmes(coinHG_x + 5 * tailleCase, coinHG_y + 1 * tailleCase, 7, tailleCase, sanji, width / (14 * 15), width / (14 * 10));
		dessinerCase(c7);
		tableau[6] = c7;
		Case c8 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 2 * tailleCase, 8, Couleur.BLANC, tailleCase);
		dessinerCase(c8);
		tableau[7] = c8;
		Case c9 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 3 * tailleCase, 9, Couleur.BLANC, tailleCase);
		dessinerCase(c9);
		tableau[8] = c9;
		Case c10 = new Case(coinHG_x + 5 * tailleCase, coinHG_y + 4 * tailleCase, 10, Couleur.NOIR, tailleCase, chapeau, width / (14 * 50), width / (14 * 4));
		dessinerCase(c10);
		tableau[9] = c10;
		Case c11 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 4 * tailleCase, 11, Couleur.BLANC, tailleCase);
		dessinerCase(c11);
		tableau[10] = c11;
		Case c12 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 4 * tailleCase, 12, Couleur.BLANC, tailleCase);
		dessinerCase(c12);
		tableau[11] = c12;
		Case c13 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 4 * tailleCase, 13, Couleur.BLANC, tailleCase);
		dessinerCase(c13);
		tableau[12] = c13;
		Case c14 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 4 * tailleCase, 14, Couleur.BLANC, tailleCase, marine, width / (14 * 15), width / (14 * 5));
		dessinerCase(c14);
		tableau[13] = c14;
		Case c15 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 4 * tailleCase, 15, Couleur.BLANC, tailleCase);
		dessinerCase(c15);
		tableau[14] = c15;
		Case c16 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 3 * tailleCase, 16, Couleur.BLANC, tailleCase);
		dessinerCase(c16);
		tableau[15] = c16;
		Case c17 = new IleFemmes(coinHG_x + 0 * tailleCase, coinHG_y + 2 * tailleCase, 17, tailleCase, sanji, width / (14 * 15), width / (14 * 10));
		dessinerCase(c17);
		tableau[16] = c17;
		Case c18 = new Case(coinHG_x + 0 * tailleCase, coinHG_y + 1 * tailleCase, 18, Couleur.BLANC, tailleCase);
		dessinerCase(c18);
		tableau[17] = c18;
		Case c19 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 1 * tailleCase, 19, Couleur.BLANC, tailleCase);
		dessinerCase(c19);
		tableau[18] = c19;
		Case c20 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 1 * tailleCase, 20, Couleur.BLANC, tailleCase);
		dessinerCase(c20);
		tableau[19] = c20;
		Case c21 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 1 * tailleCase, 21, Couleur.BLANC, tailleCase);
		dessinerCase(c21);
		tableau[20] = c21;
		Case c22 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 1 * tailleCase, 22, Couleur.BLANC, tailleCase);
		dessinerCase(c22);
		tableau[21] = c22;
		Case c23 = new Case(coinHG_x + 4 * tailleCase, coinHG_y + 2 * tailleCase, 23, Couleur.BLANC, tailleCase);
		dessinerCase(c23);
		tableau[22] = c23;
		IleFemmes c24 = new IleFemmes(coinHG_x + 4 * tailleCase, coinHG_y + 3 * tailleCase, 24, tailleCase, sanji, width / (14 * 15), width / (14 * 10));
		dessinerCase(c24);
		tableau[23] = c24;
		Case c25 = new Case(coinHG_x + 3 * tailleCase, coinHG_y + 3 * tailleCase, 25, Couleur.BLANC, tailleCase);
		dessinerCase(c25);
		tableau[24] = c25;
		Case c26 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 3 * tailleCase, 26, Couleur.BLANC, tailleCase);
		dessinerCase(c26);
		tableau[25] = c26;
		Case c27 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 3 * tailleCase, 27, Couleur.BLANC, tailleCase);
		dessinerCase(c27);
		tableau[26] = c27;
		Case c28 = new Case(coinHG_x + 1 * tailleCase, coinHG_y + 2 * tailleCase, 28, Couleur.BLANC, tailleCase);
		dessinerCase(c28);
		tableau[27] = c28;
		Case c29 = new Case(coinHG_x + 2 * tailleCase, coinHG_y + 2 * tailleCase, 29, Couleur.BLANC, tailleCase);
		dessinerCase(c29);
		tableau[28] = c29;
		OnePiece c30 = new OnePiece(coinHG_x + 3 * tailleCase, coinHG_y + 2 * tailleCase, 30, tailleCase, coffre, -width / (14 * 8), width / (14 * 50));
		dessinerCase(c30);
		tableau[29] = c30;
		
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
		
		return tableau;
	}
	
	public void dessinerLancementDe() {
		if(Zoro.getTour() < Sanji.getTour()) {
			stroke(0);
			fill(0, 150, 0);
			rect(width / 100 * 10, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
			fill(0);
			textSize(40);
			textAlign(CENTER, CENTER);
			text("Lancer les dés !", width / 100 * 25, height / 100 * 70);
		} else {
			stroke(0);
			fill(0, 0, 220);
			rect(width / 100 * 10, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
			fill(0);
			textSize(40);
			textAlign(CENTER, CENTER);
			text("Lancer les dés !", width / 100 * 25, height / 100 * 70);
		}
	}
	
	public void mousePressed() {
		  if (mouseX > width / 100 * 10 && mouseX < width / 100 * 10 + width / 100 * 30 && mouseY > height / 100 * 60 && mouseY < height / 100 * 60 + height / 100 * 20) {
			  dessinerJeu(Zoro, Sanji, de);
			  etat = etat.CLICK;
		  }
		}
}
