package jeu;

import java.util.Random;

public class De {
	private int de;
	
	public De() {
		this.de = 0;
	}
	
	public int getDe() {
		return this.de;
	}
	
	public void setDe(int i) {
		this.de = i;
	}
	
	public void lancerDe() {
		Random random = new Random();
        int d = random.nextInt(6) + 1;
        this.de = d;
	}
}
