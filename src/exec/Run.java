package exec;

import java.awt.Color;

import domain.geometrics.Quad;
import domain.managers.MapManager;
import domain.map.ColorPalette;
import domain.playable.Enemy;
import domain.playable.TowerBase;
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
		
		
		MapManager.defineTiles(new TowerBase(null, 100, 100, ColorPalette.TOWER_BASE_NORMAL, ColorPalette.TOWER_BASE_HIGHLIGHT, true, null), 
							   new Quad(null, 100, 100, ColorPalette.ENEMY_WALKWAY), 
							   new Quad(null, 100, 100, ColorPalette.ENEMY_BASE), 
							   new Quad(null, 100, 100, ColorPalette.PLAYER_BASE));
		
		int t[][] = {{1, 2, 2, 2, 3, 0, 0, 0, 0},
				     {0, 0, 0, 0, 2, 0, 0, 0, 0},
				     {0, 0, 0, 0, 3, 2, 2, 2, 4}};
	
		MapManager.createMap(t, tileSide, tileSide, spacing);
		
		new Enemy(null, 0, 0, null, 0, 0, 0, MapManager.activeMap.getEnemyPath());
		
		while(true) {
		
			Game.loop();	
		}				
	}
}

