package domain.managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import domain.geometrics.Quad;
import domain.interactables.Interactable;
import domain.window.Window;

public class GameManager {
	
	public static ArrayList<Quad> quads = new ArrayList<Quad>();	
	public static ArrayList<Interactable> interactables = new ArrayList<Interactable>();
	
	public void check (Window window) {
		
		JPanel panel = new JPanel() {
        	
			private static final long serialVersionUID = 1L;

			public void paintComponent(final Graphics g) {
	            super.paintComponent(g);

	            drawQuads(g);
            }
       };
	}
	
	public void drawQuads (Graphics g) {
		
		for (Quad q : quads) {
			
			q.draw(g);
		}
	}
	
	public void checkInteractables () {
		
		
	}
}