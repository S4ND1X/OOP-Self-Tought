package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class BasicEnemy extends GameObject {
	
	private Handler handler;
	
	//Valores Iniciales
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);			
		this.handler = handler;		
		velX = 5;
		velY = 5;
	}	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);	
	}
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;		
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		//Crear la sombra
		handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 16, 16, 0.02f, handler ));
		
	}
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(Color.BLACK);		
		g.fillRect(x, y, 16, 16);
	} 

}
