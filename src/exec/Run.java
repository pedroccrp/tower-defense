package exec;

import java.awt.Color;
import java.awt.Point;

import domain.interactables.Button;
import domain.managers.GameManager;
import domain.window.Window;
import main.game.Game;

public class Run {
	
	public static void main(String[] args) {
		
		Game.setup(new Window("Tower Defense", 800, 600, Color.black));
		
		for (int i = 0; i < 15; i++) {
			
			for (int j = 0; j < 15; j++) {
			
				GameManager.createInteractable(new Button(new Point(i * 55, j * 55), 50, 50, Color.red, Color.green, true));
			
			}
		}
		
		while(true) {
		
			Game.loop();	
		}				
	}
}
