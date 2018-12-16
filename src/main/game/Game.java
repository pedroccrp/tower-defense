package main.game;

import domain.window.Window;

import static domain.managers.GameManager.*;

import domain.managers.BulletManager;
import domain.managers.EnemyManager;
import domain.managers.GameManager;
import domain.managers.PlayerManager;
import domain.managers.TowerManager;
import domain.managers.WaveManager;
import domain.playable.Tower;

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
	
	public static void clear () {
		
		GameManager.interactables.clear();
		GameManager.quads.clear();
		
		BulletManager.bullets.clear();
		
		EnemyManager.enemies.clear();
		
		for (Tower t : TowerManager.towers) {
			
			t.setActive(false);
		}
		
		TowerManager.towers.clear();
		
		WaveManager.waves.clear();
		
		gWindow.removeAll();
	}
}
