package jeu;

import java.util.Random;

public class De {
	private int nombre;
	private int bonus;
	
	public De() {
		this.nombre = 0;
		this.bonus = 0;
	}
	
	public int getNombre() {
		return this.nombre;
	}
	
	public void setNombre(int i) {
		this.nombre = i;
	}
	
	public int getBonus() {
		return this.bonus;
	}
	
	public void setBonus(int i) {
		this.bonus = this.bonus + i;
	}
	
	public void lancerDe() {
		Random random = new Random();
        int d = random.nextInt(6) + 1;
        this.nombre = d;
        this.bonus = 0;
	}
}
