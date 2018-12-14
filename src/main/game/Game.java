package main.game;

import domain.window.Window;

import static domain.managers.GameManager.*;

public class Game {
	
	public static Window gWindow;
	
	public static void setup (Window w) {
		
		gWindow = w;
		
        gWindow.init();
	}
	
	public static void loop () {
		
		if (gWindow != null) {
			
			check(gWindow);
			
			gWindow.repaint();
		}
	}
}
