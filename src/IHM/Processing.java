package IHM;

import cases.Arrive;
import cases.Case;
import cases.Combat;
import cases.Eau;
import cases.Femmes;
import cases.Fruit;
import cases.Marine;
import cases.Normale;
import cases.Plateau;
import jeu.Etat;
import processing.core.PApplet;
import processing.core.PImage;

public class Processing extends PApplet {
	
	private Etat etat;
	private Plateau plateau = new Plateau();
	
	PImage fruit;
	PImage chapeau;
	PImage marine;
	PImage coffre;
	PImage femme;
	PImage combat;
	PImage eau;
	PImage zoroVS;
	PImage sanjiVS;
	
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
		femme = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/sanji.png");
		femme.resize(width / (14 * 12/10), width / (14 * 13/10));
		combat = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/combat.png");
		combat.resize(width / (14 * 8/10), width / (14 * 9/10));
		eau = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/eau.png");
		eau.resize(width / (14 * 12/10), width / (14 * 13/10));
		zoroVS = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/zoroVS.jpg");
		zoroVS.resize(width / 10 * 6, height / 20 * 13);
		sanjiVS = loadImage("C:/Users/maelc/eclipse-workspace/LesPirates/src/image/sanjiVS.jpg");
		sanjiVS.resize(width / 10 * 6, height / 20 * 13);
		etat = Etat.COMMENCER_1;
	}

	public void draw() {
		switch(etat) {
		case COMMENCER_1:
			etatCommencer1();
			break;
		case COMMENCER_2:
			etatCommencer2();
			break;
		case JEU:
			dessinerJeu();
			if(plateau.getZoro().getCaseVictoire() || plateau.getSanji().getCaseVictoire() || plateau.getZoro().getVie() == 0 || plateau.getSanji().getVie() == 0) {
				etat = Etat.VICTOIRE;
			}
			if(plateau.getZoro().getCaseFruit() || plateau.getSanji().getCaseFruit()) {
				etat = Etat.FRUIT;
			}
			if(plateau.getZoro().getCaseVS() || plateau.getSanji().getCaseVS()) {
				etat = Etat.COMBAT_1;
			}
			if((plateau.getZoro().getCaseMarine() && plateau.getZoro().getNbTourCaseMarine() == 0) || (plateau.getSanji().getCaseMarine() && plateau.getSanji().getNbTourCaseMarine() == 0)) {
				etat = Etat.MARINE;
			}
			break;
		case CLICK:
			tour();
			etat = Etat.JEU;
			break;
		case VICTOIRE:
			etatVictoire();
			break;
		case FRUIT:
			etatFruit();
			break;
		case COMBAT_1:
			etatCombat1();
			break;
		case COMBAT_2:
			etatCombat2();
			break;
		case MARINE:
			etatMarine();
			break;
		default:
		      break;
		}	
	}
	
	public void etatMarine() {
		background(255);
		image(marine, width / 100 * 25, height / 100 * 8, fruit.width * 10, fruit.height * 6);
		noFill();
		stroke(0);
		strokeWeight(5);
		rect(width / 100 * 70, height / 100 * 78 , width / 100 * 25, height / 100 * 15);
		fill(0);
		textSize(30);
		text("Retour au jeu", width / 200 * 165, height / 200 * 171);
		if(plateau.getZoro().getCaseMarine()) {
			text("La marine a capturé Zoro", width / 100 * 30, height / 100 * 85);
		} else {
			text("La marine a capturé Sanji", width / 100 * 30, height / 100 * 85);
		}
		text("Faire un chiffre paire pour s'échapper", width / 100 * 30, height / 100 * 90);
	}
	
	public void etatCommencer1() {
		background(255);
		strokeWeight(3);
		textAlign(CENTER, CENTER);
		fill(0);
		textSize(32);
		String titre = "One Piece Game";
		text(titre, width / 2, height / 10);
		textSize(24);
		String texte = "Zoro et Sanji, de l'équipage au chapeau de paille dirigé par Monkey D. Luffy,\n ne cesse de se disputer pour savoir lequel des deux est le plus digne d'être le bras droit du capitaine.\n Un jour, lassé de leurs chamailleries, l'équipage décide de les départager en les laissant sur une île.\n Le premier de retour au bateau sera déclaré vainqueur.";
		text(texte, width / 2, height / 10 * 3);
		String de = "Lancer le dé pour savoir qui commence : Pair = Zoro, Impair = Sanji";
		text(de, width / 2, height / 10 * 5);
		strokeWeight(3);
		stroke(0);
		fill(0, 150, 0);
		rect(width / 100 * 35, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
		fill(0);
		textSize(40);
		textAlign(CENTER, CENTER);
		text("Lancer le dé !", width / 2, height / 100 * 70);
		image(zoroVS, width / 40, height / 10 * 6, zoroVS.width/2, zoroVS.height/2);
		image(sanjiVS, width / 40 * 27, height / 10 * 6, zoroVS.width/2, zoroVS.height/2);
	}
	
	public void etatCommencer2() {
		noStroke();
		fill(255);
		rect(0, height / 100 * 15, width, height / 100 * 40);
		strokeWeight(3);
		stroke(0);
		fill(150);
		rect(width / 100 * 35, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
		textSize(40);
		textAlign(CENTER, CENTER);
		fill(0);
		text("Lancer le dé !", width / 2, height / 100 * 70);
		fill(255, 230, 0);
		rect(width / 100 * 30, height / 100 * 20 , width / 100 * 40, height / 100 * 30);
		fill(0);
		text("Jouer !", width / 2, height / 100 * 35);
		if(plateau.getDe().getNombre() == 0) {
			plateau.getDe().lancerDe();
			dessinerChoixPerso();
		}
	}
	
	public void etatCombat1() {
		background(0);
		image(combat, width / 100 * 38, height / 100 * 14, fruit.width * 5, fruit.height * 4);
		image(zoroVS, width / 40, height / 100 * 20, zoroVS.width/2, zoroVS.height/2);
		image(sanjiVS, width / 40 * 27, height / 100 * 20, zoroVS.width/2, zoroVS.height/2);
		fill(255);
		textSize(40);
		textAlign(CENTER, CENTER);
		text("Combat !", width/2, height/100 * 10);
		textSize(24);
		text("Lancer le dé pour savoir qui \nremporte l'affrontement :", width / 100 * 20, height / 100 * 67);
		text("Pair = Zoro\nImpair = Sanji", width / 100 * 20, height / 100 * 79);
		text("Le perdant perd un PV.", width / 100 * 20, height / 100 * 90);
		fill(255, 230, 0);
		rect(width / 100 * 37, height / 100 * 60 , width / 100 * 26, height / 100 * 20);
		fill(0);
		textSize(40);
		text("Lancer", width / 2, height / 100 * 70);
		plateau.getDe().setNombre(0);
	}
	
	public void etatCombat2(){
		if(plateau.getDe().getNombre() == 0) {
			plateau.getDe().lancerDe();
			fill(255);
			text(plateau.getDe().getNombre(), width / 2, height / 100 * 90);
			stroke(255, 0, 0);
			strokeWeight(5);
			noFill();
			textSize(24);
			if (plateau.getDe().getNombre() % 2 == 0) {
				rect(width / 40, height / 100 * 20, zoroVS.width/2, zoroVS.height/2);
				fill(255);
				strokeWeight(3);
				text("Zoro gagne !\nSanji perd un PV.", width / 100 * 83, height / 100 * 68);
				plateau.getSanji().setVie();
			} else {
				rect(width / 40 * 27, height / 100 * 20, zoroVS.width/2, zoroVS.height/2);
				fill(255);
				strokeWeight(3);
				text("Sanji gagne !\nZoro perd un PV.", width / 100 * 83, height / 100 * 68);
				plateau.getZoro().setVie();
			}
			fill(150);
			noStroke();
			rect(width / 100 * 37, height / 100 * 60 , width / 100 * 26, height / 100 * 20);
			fill(0);
			textSize(40);
			text("Lancer", width / 2, height / 100 * 70);
			fill(255);
			rect(width / 100 * 70, height / 100 * 78 , width / 100 * 25, height / 100 * 15);
			fill(0);
			textAlign(CENTER, CENTER); 
			textSize(30);
			text("Retour au jeu", width / 200 * 165, height / 200 * 171);
			plateau.getZoro().setCaseVS(false);
			plateau.getSanji().setCaseVS(false);
		}
	}

	public void etatVictoire() {
		background(0);
		textSize(32);
		textAlign(CENTER, CENTER);
		if (plateau.getZoro().getCaseVictoire() || plateau.getSanji().getVie() == 0) {
			fill(0, 150, 0);
			textSize(40);
			text("Zoro gagne !", width/100*25, height/10);
			image(zoroVS, width / 10 * 2, height / 10 * 2);
			if (plateau.getZoro().getCaseVictoire()) {
				textSize(32);
				text("Il est le premier à atteindre le bateau.", width / 100 * 75, height / 10);
			} else {
				textSize(32);
				text("Il est le dernier debout.", width / 100 * 75, height / 10);
			}
		} else {
			fill(0, 0, 200);
			textSize(40);
			text("Sanji gagne !", width/100*25, height/10);
			image(sanjiVS, width / 10 * 2, height / 10 * 2);
			if (plateau.getSanji().getCaseVictoire()) {
				textSize(32);
				text("Il est le premier à atteindre le bateau.", width / 100 * 75, height / 10);
			} else {
				textSize(32);
				text("Il est le dernier debout.", width / 100 * 75, height / 10);
			}
		}
	}
	
	public void etatFruit() {
		background(0);
		image(fruit, width / 3, height / 10, fruit.width * 7, fruit.height * 7);
		fill(255);
		textSize(40);
		textAlign(CENTER, CENTER);
		text("Fruit du démon !", width/2, height/100*10);
		textSize(32);
		text("Vous avez la possiblilité de manger un fruit du démon.\n Si vous acceptez, vous gagnerez 2 à chaque lancé, \nmais en contre partie, vous perdez 1 PV à chaque case eau.", width/2, height/100*40);
		fill(0, 150, 0);
		rect(width / 100 * 10, height / 100 * 70, width / 100 * 30, height / 100 * 20);
		fill(0);
		text("Accepter", width / 100 * 25, height / 100 * 80);
		fill(255, 0, 0);
		rect(width / 100 * 60, height / 100 * 70, width / 100 * 30, height / 100 * 20);
		fill(0);
		text("Refuser", width / 100 * 75, height / 100 * 80);
		plateau.getZoro().setCaseFruit(false);
		plateau.getSanji().setCaseFruit(false);
	}
	
	public void tour() {
		dessinerPlateau();
		textSize(40);
		if(plateau.getZoro().getTour() < plateau.getSanji().getTour()) {
			plateau.getDe().setNombre(plateau.getZoro().jouer(plateau).getNombre());
		} else {
			plateau.getDe().setNombre(plateau.getSanji().jouer(plateau).getNombre());
		}
		dessinerJeu();
	}
	
	public void dessinerChoixPerso() {
		fill(0);
		textSize(45);
		text(plateau.getDe().getNombre(), width / 2, height / 100 * 90);
		stroke(255, 0, 0);
		strokeWeight(5);
		noFill();
		if(plateau.getDe().getNombre() % 2 == 0) {
			rect(width / 40, height / 10 * 6, zoroVS.width/2, zoroVS.height/2);
			plateau.getSanji().setTour(1);
		} else {
			rect(width / 40 * 27, height / 10 * 6, zoroVS.width/2, zoroVS.height/2);
			plateau.getZoro().setTour(1);
		}
	}
	
	public void dessinerStats() {
		int x_zoro = width / 100 * 15;
		int y_zoro = height / 100 * 10;
		int x_sanji = width / 100 * 38;
		int y_sanji = height / 100 * 10;
		textSize(24);
		fill(0);
		text("XP :", width / 100 * 4, height / 100 * 31);
		text("Fruit :", width / 100 * 4, height / 100 * 40);
		String fruitZoro = "";
		String fruitSanji = "";
		if (plateau.getZoro().getFruit()) {
			fruitZoro = "Oui";
		} else {
			fruitZoro = "Non";
		}
		if (plateau.getSanji().getFruit()) {
			fruitSanji = "Oui";
		} else {
			fruitSanji = "Non";
		}
		text(fruitZoro, x_zoro, y_zoro + height / 100 * 30);
		text(fruitSanji, x_sanji, y_sanji + height / 100 * 30);
		text("Case :", width / 100 * 4, height / 100 * 49);
		text(plateau.getPlateau()[plateau.getZoro().getPosition()].getDescription(), x_zoro, y_zoro + height / 100 * 39);
		text(plateau.getPlateau()[plateau.getSanji().getPosition()].getDescription(), x_sanji, y_sanji + height / 100 * 39);
		fill(0, 150, 0);
		text("Zoro", x_zoro, y_zoro);
		textSize(20);
		text("son sens de l'orientation \nlui fait perdre 1 à chaque dé", x_zoro, y_zoro + width / 100 * 5);
		fill(135, 206, 250);
		noStroke();
		rect(x_zoro - width / 100 * 7, y_zoro + height / 100 * 20 , width / 100 * 3 * plateau.getZoro().getVie(), height / 100 * 3);
		fill(135, 206, 250, 0);
		stroke(0);
		strokeWeight(3);
		rect(x_zoro - width / 100 * 7, y_zoro + height / 100 * 20 , width / 100 * 15, height / 100 * 3);
		fill(0, 0, 220);
		textSize(24);
		text("Sanji", x_sanji, y_sanji);
		textSize(20);
		text("son attirance pour les femmes \nlui fait passer son tour \nsur les cases 'femmes'", x_sanji, y_sanji + width / 100 * 5);
		fill(135, 206, 250);
		noStroke();
		rect(x_sanji - width / 100 * 7, y_sanji + height / 100 * 20 , width / 100 * 3 * plateau.getSanji().getVie(), height / 100 * 3);
		fill(135, 206, 250, 0);
		stroke(0);
		strokeWeight(3);
		rect(x_sanji - width / 100 * 7, y_sanji + height / 100 * 20 , width / 100 * 15, height / 100 * 3);
		fill(0);
		textSize(25);
		textAlign(LEFT, BASELINE);
		
	}
	
	public void dessinerJeu() {
		background(255);
		dessinerPlateau();
		dessinerStats();
		dessinerLancementDe();
		dessinerPion();
		if(plateau.getZoro().getPosition() != 0 || plateau.getSanji().getPosition() != 0) {
			textSize(70);
			fill(0);
			text(plateau.getDe().getNombre(), width / 100 * 45, height / 100 * 70);
			textSize(32);
			if(plateau.getDe().getBonus() != 0) {
				if(plateau.getDe().getBonus() < 0) {
					text(plateau.getDe().getBonus(), width / 100 * 45, height / 100 * 80);
				} else if (plateau.getDe().getBonus() > 0){
					String bonus = "+" + plateau.getDe().getBonus();
					text(bonus, width / 100 * 45, height / 100 * 80);
				}
			}
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
	
	public void dessinerPion() {
		fill(0, 150, 0);
		stroke(0);
		strokeWeight(2);
		ellipse(plateau.getPlateau()[plateau.getZoro().getPosition()].getPosition()[0] + width/55, plateau.getPlateau()[plateau.getZoro().getPosition()].getPosition()[1] + width/55, width/70, width/70);
		fill(0, 0, 255);
		ellipse(plateau.getPlateau()[plateau.getSanji().getPosition()].getPosition()[0] + width/19, plateau.getPlateau()[plateau.getSanji().getPosition()].getPosition()[1] + width/19, width/70, width/70);
	}
	
	public void dessinerPlateau() {
		int coinHG_x = width / 100 * 52;
		int coinHG_y = height / 100 * 20;
		int tailleCase = width / 14;
		strokeWeight(1);
		stroke(0);
		Case c1 = new Normale(coinHG_x + 0 * tailleCase, coinHG_y + 0 * tailleCase, 1, tailleCase);
		dessinerCase(c1);
		plateau.setPlateau(c1, 0);
		Case c2 = new Normale(coinHG_x + 1 * tailleCase, coinHG_y + 0 * tailleCase, 2, tailleCase);
		dessinerCase(c2);
		plateau.setPlateau(c2, 1);
		Case c3 = new Femmes(coinHG_x + 2 * tailleCase, coinHG_y + 0 * tailleCase, 3, tailleCase, femme, width / (14 * 15), width / (14 * 10));
		dessinerCase(c3);
		plateau.setPlateau(c3, 2);
		Case c4 = new Normale(coinHG_x + 3 * tailleCase, coinHG_y + 0 * tailleCase, 4, tailleCase);
		dessinerCase(c4);
		plateau.setPlateau(c4, 3);
		Case c5 = new Fruit(coinHG_x + 4 * tailleCase, coinHG_y + 0 * tailleCase, 5, tailleCase, fruit, width / (14 * 6), width / (14 * 10));
		dessinerCase(c5);
		plateau.setPlateau(c5, 4);
		Case c6 = new Normale(coinHG_x + 5 * tailleCase, coinHG_y + 0 * tailleCase, 6, tailleCase);
		dessinerCase(c6);
		plateau.setPlateau(c6, 5);
		Case c7 = new Femmes(coinHG_x + 5 * tailleCase, coinHG_y + 1 * tailleCase, 7, tailleCase, femme, width / (14 * 15), width / (14 * 10));
		dessinerCase(c7);
		plateau.setPlateau(c7, 6);
		Case c8 = new Marine(coinHG_x + 5 * tailleCase, coinHG_y + 2 * tailleCase, 8, tailleCase, marine, width / (14 * 15), width / (14 * 5));
		dessinerCase(c8);
		plateau.setPlateau(c8, 7);
		Case c9 = new Normale(coinHG_x + 5 * tailleCase, coinHG_y + 3 * tailleCase, 9, tailleCase);
		dessinerCase(c9);
		plateau.setPlateau(c9, 8);
		Case c10 = new Combat(coinHG_x + 5 * tailleCase, coinHG_y + 4 * tailleCase, 10, tailleCase, combat, -width / (14 * 6), -width / (14 * 10));
		dessinerCase(c10);
		plateau.setPlateau(c10, 9);
		Case c11 = new Normale(coinHG_x + 4 * tailleCase, coinHG_y + 4 * tailleCase, 11, tailleCase);
		dessinerCase(c11);
		plateau.setPlateau(c11, 10);
		Case c12 = new Eau(coinHG_x + 3 * tailleCase, coinHG_y + 4 * tailleCase, 12, tailleCase, eau, width / (14 * 15), width / (14 * 10));
		dessinerCase(c12);
		plateau.setPlateau(c12, 11);
		Case c13 = new Normale(coinHG_x + 2 * tailleCase, coinHG_y + 4 * tailleCase, 13, tailleCase);
		dessinerCase(c13);
		plateau.setPlateau(c13, 12);
		Case c14 = new Marine(coinHG_x + 1 * tailleCase, coinHG_y + 4 * tailleCase, 14, tailleCase, marine, width / (14 * 15), width / (14 * 5));
		dessinerCase(c14);
		plateau.setPlateau(c14, 13);
		Case c15 = new Femmes(coinHG_x + 0 * tailleCase, coinHG_y + 4 * tailleCase, 15, tailleCase, femme, width / (14 * 15), width / (14 * 10));
		dessinerCase(c15);
		plateau.setPlateau(c15, 14);
		Case c16 = new Normale(coinHG_x + 0 * tailleCase, coinHG_y + 3 * tailleCase, 16, tailleCase);
		dessinerCase(c16);
		plateau.setPlateau(c16, 15);
		Case c17 = new Femmes(coinHG_x + 0 * tailleCase, coinHG_y + 2 * tailleCase, 17, tailleCase, femme, width / (14 * 15), width / (14 * 10));
		dessinerCase(c17);
		plateau.setPlateau(c17, 16);
		Case c18 = new Normale(coinHG_x + 0 * tailleCase, coinHG_y + 1 * tailleCase, 18, tailleCase);
		dessinerCase(c18);
		plateau.setPlateau(c18, 17);
		Case c19 = new Combat(coinHG_x + 1 * tailleCase, coinHG_y + 1 * tailleCase, 19, tailleCase, combat, -width / (14 * 6), -width / (14 * 10));
		dessinerCase(c19);
		plateau.setPlateau(c19, 18);
		Case c20 = new Marine(coinHG_x + 2 * tailleCase, coinHG_y + 1 * tailleCase, 20, tailleCase, marine, width / (14 * 15), width / (14 * 5));
		dessinerCase(c20);
		plateau.setPlateau(c20, 19);
		Case c21 = new Eau(coinHG_x + 3 * tailleCase, coinHG_y + 1 * tailleCase, 21, tailleCase, eau, width / (14 * 15), width / (14 * 10));
		dessinerCase(c21);
		plateau.setPlateau(c21, 20);
		Case c22 = new Normale(coinHG_x + 4 * tailleCase, coinHG_y + 1 * tailleCase, 22, tailleCase);
		dessinerCase(c22);
		plateau.setPlateau(c22, 21);
		Case c23 = new Normale(coinHG_x + 4 * tailleCase, coinHG_y + 2 * tailleCase, 23, tailleCase);
		dessinerCase(c23);
		plateau.setPlateau(c23, 22);
		Case c24 = new Femmes(coinHG_x + 4 * tailleCase, coinHG_y + 3 * tailleCase, 24, tailleCase, femme, width / (14 * 15), width / (14 * 10));
		dessinerCase(c24);
		plateau.setPlateau(c24, 23);
		Case c25 = new Combat(coinHG_x + 3 * tailleCase, coinHG_y + 3 * tailleCase, 25, tailleCase, combat, -width / (14 * 6), -width / (14 * 10));
		dessinerCase(c25);
		plateau.setPlateau(c25, 24);
		Case c26 = new Normale(coinHG_x + 2 * tailleCase, coinHG_y + 3 * tailleCase, 26, tailleCase);
		dessinerCase(c26);
		plateau.setPlateau(c26, 25);
		Case c27 = new Eau(coinHG_x + 1 * tailleCase, coinHG_y + 3 * tailleCase, 27, tailleCase, eau, width / (14 * 15), width / (14 * 10));
		dessinerCase(c27);
		plateau.setPlateau(c27, 26);
		Case c28 = new Normale(coinHG_x + 1 * tailleCase, coinHG_y + 2 * tailleCase, 28, tailleCase);
		dessinerCase(c28);
		plateau.setPlateau(c28, 27);
		Case c29 = new Normale(coinHG_x + 2 * tailleCase, coinHG_y + 2 * tailleCase, 29, tailleCase);
		dessinerCase(c29);
		plateau.setPlateau(c29, 28);
		Case c30 = new Arrive(coinHG_x + 3 * tailleCase, coinHG_y + 2 * tailleCase, 30, tailleCase, chapeau, width / (14 * 100), width / (14 * 4));
		dessinerCase(c30);
		plateau.setPlateau(c30, 29);
		
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
		if(plateau.getZoro().getTour() < plateau.getSanji().getTour()) {
			stroke(0);
			fill(0, 150, 0);
			rect(width / 100 * 9, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
			fill(0);
			textSize(40);
			textAlign(CENTER, CENTER);
			text("Lancer le dé !", width / 100 * 25, height / 100 * 70);
		} else {
			stroke(0);
			fill(0, 0, 220);
			rect(width / 100 * 9, height / 100 * 60 , width / 100 * 30, height / 100 * 20);
			fill(0);
			textSize(40);
			textAlign(CENTER, CENTER);
			text("Lancer les dés !", width / 100 * 25, height / 100 * 70);
		}
	}
	
	public void mousePressed() {
		  if (etat == Etat.JEU && mouseX > width / 100 * 10 && mouseX < width / 100 * 10 + width / 100 * 30 && mouseY > height / 100 * 60 && mouseY < height / 100 * 60 + height / 100 * 20) {
			  dessinerJeu();
			  etat = Etat.CLICK;
		  }
		  if (etat == Etat.COMMENCER_1 && mouseX > width / 100 * 35 && mouseY > height / 100 * 60 && mouseX < width / 100 * 65 && mouseY < height / 100 * 80) {
			  etat = Etat.COMMENCER_2;
		  }
		  if (etat == Etat.COMMENCER_2 && mouseX > width && mouseY > 0 && mouseX < width && mouseY < height) {
			  etat = Etat.JEU;
		  }
		  if (etat == Etat.FRUIT && mouseX > width / 100 * 10 && mouseY > height / 100 * 70 && mouseX < width / 100 * 40 && mouseY < height / 100 * 90) {
			  if (plateau.getZoro().getTour() < plateau.getSanji().getTour()) {
				  plateau.getSanji().setFruit(true);
			  } else {
				  plateau.getZoro().setFruit(true);
			  }
			  etat = Etat.JEU;
		  }
		  if(etat == Etat.FRUIT && mouseX > width / 100 * 60 && mouseY > height / 100 * 70 && mouseX < width / 100 * 90 && mouseY < height / 100 * 90) {
			  etat = Etat.JEU;
		  }
		  if(etat == Etat.COMMENCER_2 && mouseX > width / 100 * 30 && mouseY > height / 100 * 20 && mouseX < width / 100 * 70 && mouseY < height / 100 * 50) {
			  etat = Etat.JEU;
		  }
		  if(etat == Etat.COMBAT_1 && mouseX > width / 100 * 35 && mouseX < width / 100 * 65 && mouseY > height / 100 * 60 && mouseY < height / 100 * 80) {
			  etat = etat.COMBAT_2;
		  }
		  if(etat == Etat.COMBAT_2 && mouseX > width / 100 * 70 && mouseX < width / 100 * 95 && mouseY > height / 100 * 78 && mouseY < height / 100 * 93) {
			  etat = Etat.JEU;
		  }
		  if(etat == Etat.MARINE && mouseX > width / 100 * 70 && mouseX < width / 100 * 95 && mouseY > height / 100 * 78 && mouseY < height / 100 * 93) {
			  plateau.getZoro().setNbTourCaseMarine();
			  plateau.getSanji().setNbTourCaseMarine();
			  etat = Etat.JEU;
		  }
		}
}
