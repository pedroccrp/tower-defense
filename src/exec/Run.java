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
		
		
		
		Game.loop();		
	}
}
