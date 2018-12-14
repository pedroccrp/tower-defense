package exec;

import java.awt.Color;
import java.awt.Point;

import domain.interactables.Button;
import domain.managers.GameManager;
import domain.window.Window;
import main.game.Game;

public class Run {
	
	public static void main(String[] args) {
		
		int rows = 10, columns = 15;
		int tileSide = 50;
		int spacing = 5;
		int windowWidth = (columns * (tileSide + spacing)) - spacing;
		int windowHeight = (rows * (tileSide + spacing)) - spacing;
		
		Game.setup(new Window("Tower Defense", windowWidth, windowHeight, Color.black));
		
		for (int i = 0; i < columns; i++) {
			
			for (int j = 0; j < rows; j++) {
			
				GameManager.createInteractable(new Button(new Point(i * (tileSide + spacing), j * (tileSide + spacing)), tileSide, tileSide, Color.red, Color.green, true));
			
			}
		}
		
		while(true) {
		
			Game.loop();	
		}				
	}
}

