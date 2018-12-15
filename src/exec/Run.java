package exec;

import java.awt.Color;

import domain.geometrics.Quad;
import domain.managers.EnemyManager;
import domain.managers.MapManager;
import domain.managers.WaveManager;
import domain.map.ColorPalette;
import domain.playable.Enemy;
import domain.playable.TowerBase;
import domain.playable.Wave;
import domain.window.Window;
import main.game.Game;

public class Run {
	
	public static void main(String[] args) {
		
		int rows = 8, columns = 9;
		int tileSide = 120;
		int spacing = 5;
		int windowWidth = (columns * (tileSide + spacing)) - spacing;
		int windowHeight = (rows * (tileSide + spacing)) - spacing;
		
		Game.setup(new Window("Tower Defense", windowWidth, windowHeight, Color.black));
		
		
		MapManager.defineTiles(new TowerBase(null, 100, 100, ColorPalette.TOWER_BASE_NORMAL, ColorPalette.TOWER_BASE_HIGHLIGHT, true, null), 
							   new Quad(null, 100, 100, ColorPalette.ENEMY_WALKWAY), 
							   new Quad(null, 100, 100, ColorPalette.ENEMY_BASE), 
							   new Quad(null, 100, 100, ColorPalette.PLAYER_BASE));
		
		int t[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
					 {0, 0, 0, 0, 0, 0, 0, 0, 0},
					 {1, 2, 2, 2, 3, 0, 0, 0, 0},
				     {0, 0, 0, 0, 2, 0, 0, 0, 0},
				     {0, 0, 0, 0, 2, 0, 0, 0, 0},
				     {0, 0, 0, 0, 3, 2, 2, 2, 4},
				     {0, 0, 0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
		MapManager.createMap(t, tileSide, tileSide, spacing);
		
		WaveManager.defineEnemy(new Enemy(MapManager.activeMap.getEnemySpawn(), 50, 50, Color.magenta, 50, 10, 5, 5), 0);
		WaveManager.defineEnemy(new Enemy(MapManager.activeMap.getEnemySpawn(), 25, 25, Color.yellow, 25, 10, 3, 10), 1);
		WaveManager.defineEnemy(new Enemy(MapManager.activeMap.getEnemySpawn(), 80, 80, Color.red, 100, 5, 10, 15), 2);
		WaveManager.defineEnemy(new Enemy(MapManager.activeMap.getEnemySpawn(), 10, 10, Color.pink, 10, 50, 2, 50), 3);
		
		int e[] = {0, 0, 0, 2, 2, 1, 0, 0, 2, 2, 2, 3, 0, 0};
		
		WaveManager.createWave(e, 2);
		
		WaveManager.init();
		
		while(true) {
		
			Game.loop();	
		}				
	}
}

