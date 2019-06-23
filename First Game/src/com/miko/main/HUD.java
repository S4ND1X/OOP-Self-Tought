package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;

public class HUD {	
	public static int HEALTH = 100;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
	}
	
	public void render(Graphics g) {
		//Color de fondo
		g.setColor(Color.DARK_GRAY);
		g.fillRect(15, 15, 200, 32);
		//Color de vida
		g.setColor(Color.blue);
		g.fillRect(15, 15, HEALTH * 2, 32);
		//Borde
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(15, 15, 200, 32);
	}
}
