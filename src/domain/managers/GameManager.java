package domain.managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import domain.geometrics.Quad;
import domain.interactables.Button;
import domain.interactables.Interactable;
import domain.window.Window;
import main.game.Game;

public class GameManager {
	
	public static ArrayList<Quad> quads = new ArrayList<Quad>();	
	public static ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	
	private static JPanel panel = null;
	
	public static void createQuad (Quad q) {
		
		quads.add(q);
	}

	public static void createInteractable (Interactable i) {
		
		if (i instanceof Button) {
			
			quads.add((Button)i);
		}
		
		interactables.add(i);
	}
	
	public static void removeInteractable (Interactable i) {
				
		if (i instanceof Quad) {
			
			((Quad) i).setValid(false);
		}
	}
	
	public static void check (Window window) {
				
		checkInteractables(window);
	
		panel = new JPanel() {
        	
			private static final long serialVersionUID = 1L;

			public void paintComponent(final Graphics g) {
	            
				super.paintComponent(g);

	            drawQuads(g);
	            
	            EnemyManager.draw(g);
	            
	            TowerManager.draw(g);
	                       
	            BulletManager.draw(g);
            }
		};
		   
		panel.setBackground(Color.black);
		
		window.add(panel);
	}
	
	public static void drawQuads (Graphics g) {
		
		for (Quad q : new ArrayList<>(quads)) {
			
			if (q.isValid()) {
				
				q.draw(g);
				
			} else {
				
				quads.remove(q);
			}
		}
	}
	
	public static void checkInteractables (Window window) {
		
		Point mousePosition = MouseManager.getMousePosition(window);		

		for (Interactable i : new ArrayList<>(interactables)) {
			
			if (i instanceof Button) {
				
				if (!((Button)i).isValid()) {
					
					interactables.remove(i);
				}
			}
			
			if (i.isActive()) {
				
				i.onMouseHover(i.detectMouse(mousePosition));
			}
		}
	}
	
	public static void checkClicked (int mouseButton) {
		
		Point mousePosition = MouseManager.getMousePosition(Game.gWindow);		

		for (Interactable i : interactables) {
			
			if (i.isActive()) {
				
				if (i.detectMouse(mousePosition)) {
					
					i.onMouseClick(mouseButton);
				}
			}
		}
	}
}
