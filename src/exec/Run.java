package exec;

import java.awt.Color;

import domain.geometrics.Quad;
import domain.managers.MapManager;
import domain.managers.WaveManager;
import domain.map.ColorPalette;
import domain.playable.Enemy;
import domain.playable.TowerBase;
import domain.window.Window;
import main.game.Game;

import static domain.general.DefaultInstances.*;

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
		
		
		MapManager.createMap(INT_MAP, tileSide, tileSide, spacing);
		
		final Enemy NORMAL_ENEMY  = new Enemy(MapManager.activeMap.getEnemySpawn(), 50, 50, Color.magenta, 50, 10,  5,  5);
		final Enemy FAST_ENEMY    = new Enemy(MapManager.activeMap.getEnemySpawn(), 25, 25, Color.yellow,  25, 10,  3, 10);
		final Enemy TANK_ENEMY    = new Enemy(MapManager.activeMap.getEnemySpawn(), 80, 80, Color.red,    100,  5, 10, 15);
		final Enemy SPECIAL_ENEMY = new Enemy(MapManager.activeMap.getEnemySpawn(), 10, 10, Color.pink,    10, 50,  2, 50);
		
		
		WaveManager.defineEnemy(NORMAL_ENEMY, 0);
		WaveManager.defineEnemy(FAST_ENEMY, 1);
		WaveManager.defineEnemy(TANK_ENEMY, 2);
		WaveManager.defineEnemy(SPECIAL_ENEMY, 3);
		
		int e1[] = {0, 0, 0, 2, 2, 1, 0, 0, 2, 2, 2, 3, 0, 0};
		int e2[] = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 1, 1};
		int e3[] = {2, 2, 2, 2, 0, 3, 1, 1, 1, 1};
		int e4[] = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
		int e5[] = {2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1};
		
		WaveManager.createWave(e1, 3);
		WaveManager.createWave(e2, 2);
		WaveManager.createWave(e3, 2);
		WaveManager.createWave(e4, 1);
		WaveManager.createWave(e5, 1);
		
		WaveManager.init();
		
		while(true) {
		
			Game.loop();	
		}				
	}
}

