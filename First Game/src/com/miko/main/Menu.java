package com.miko.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.miko.main.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	

	
	public void mousePressed(MouseEvent e) {
		//Obtener Coordenadas del Mouse
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 390, 310, 300, 100) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH / 2 - 64, Game.HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}
		if(mouseOver(mx, my, 390, 460, 300, 100) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Credits;
		}
		
		if(mouseOver(mx, my, 390, 610, 300, 100) &&  game.gameState == STATE.Menu) {
			System.exit(1);
		}
		
		if(mouseOver(mx, my, 390, 400, 300, 100) &&  game.gameState == STATE.Credits) {
			game.gameState = STATE.Menu;
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	
	
	public void tick() {
		
	}
	
	public void render (Graphics g) {
		g.setFont(new Font("arial", 1, 100));	
		g.setColor(Color.white);
		g.drawString("CUBIK", 385, 230);
		
		Font font = new Font("arial", 1, 50);
		//Play Button
		
			g.setFont(font);
			g.setColor(Color.magenta);
			g.drawString("PLAY", 475, 380);
			
			g.setColor(Color.white);
			g.drawRect(390, 310, 300, 100);
		
		//Credits Button
		
			g.setFont(font);
			g.setColor(Color.cyan);
			g.drawString("CREDITS", 435, 530);
			
			
			g.setColor(Color.white);
			g.drawRect(390, 460, 300, 100);
		
		//QUIT Button
		
			g.setFont(font);
			g.setColor(Color.pink);
			g.drawString("QUIT", 475, 680);
			
			g.setColor(Color.white);
			g.drawRect(390, 610, 300, 100);
			
				
	}

}
