package com.miko.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends GameObject {
	Handler handler;
	//Valores Iniciales
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	
	//Elementos a actualizar
	public void tick() {
		x += velX;
		y += velY;		
		
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 32, 32, 0.1f, handler));
		
		collision();
		
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			//Aux para recorrer
			GameObject tempObject = handler.object.get(i);
			//Si el objeto es un enemigo
			if(tempObject.getID() == ID.BasicEnemy) {
				//Si el rectangulo del player intersecta con el rectangulo del enemigo se quita dos de salud
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				}
			}
 		}
	}
	
	//Crear elemento grafico
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 32, 32);
	}
}
