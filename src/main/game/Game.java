package main.game;

import domain.window.Window;

import static domain.managers.GameManager.*;

import domain.managers.PlayerManager;

public class Game {
	
	public static Window gWindow;
	
	public static void setup (Window w) {
		
		gWindow = w;
		
        gWindow.init();
        
		PlayerManager.updateGold();
	}
	
	public static void loop () {
		
		if (gWindow != null) {
			
			check(gWindow);
			
			gWindow.repaint();
		}
	}
}
