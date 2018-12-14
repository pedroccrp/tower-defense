package domain.managers;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import domain.geometrics.Quad;
import domain.interactables.Button;
import domain.interactables.Interactable;
import domain.window.Window;

public class GameManager {
	
	public static ArrayList<Quad> quads = new ArrayList<Quad>();	
	public static ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	
	public static void createQuad (Quad q) {
		
		quads.add(q);
	}

	public static void createInteractable (Interactable i) {
		
		if (i instanceof Button) {
			
			quads.add((Button)i);
		}
		
		interactables.add(i);
	}
	
	public static void check (Window window) {
				
		checkInteractables(window);
		
		JPanel panel = new JPanel() {
        	
			private static final long serialVersionUID = 1L;

			public void paintComponent(final Graphics g) {
	            super.paintComponent(g);

	            drawQuads(g);
            }
       };
       
       window.add(panel);
	}
	
	public static void drawQuads (Graphics g) {
		
		for (Quad q : quads) {
			
			q.draw(g);
		}
	}
	
	public static void checkInteractables (Window window) {
		
		Point mousePosition = MouseManager.getMousePosition(window);		

		for (Interactable i : interactables) {
			
			i.onMouseHover(i.detectMouse(mousePosition));
		}
	}
}