package exec;

import java.awt.Color;

import domain.geometrics.Quad;
import domain.interactables.Button;
import domain.managers.MapManager;
import domain.window.Window;
import main.game.Game;

public class Run {
	
	public static void main(String[] args) {
		
		int rows = 3, columns = 9;
		int tileSide = 120;
		int spacing = 5;
		int windowWidth = (columns * (tileSide + spacing)) - spacing;
		int windowHeight = (rows * (tileSide + spacing)) - spacing;
		
		Game.setup(new Window("Tower Defense", windowWidth, windowHeight, Color.black));
		
		
		MapManager.defineTiles(new Button(null, 100, 100, Color.cyan, Color.darkGray, true), 
							   new Quad(null, 100, 100, Color.blue), 
							   new Quad(null, 100, 100, Color.red), 
							   new Quad(null, 100, 100, Color.green));
		
		int t[][] = {{1, 2, 2, 2, 3, 0, 0, 0, 0},
				     {0, 0, 0, 0, 2, 0, 0, 0, 0},
				     {0, 0, 0, 0, 3, 2, 2, 2, 4}};
  
		MapManager.createMap(t, tileSide, tileSide, spacing);
		
		while(true) {
		
			Game.loop();	
		}				
	}
}

