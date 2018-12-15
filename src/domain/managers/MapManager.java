package domain.managers;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import domain.geometrics.Quad;
import domain.interactables.Button;
import domain.map.Map;
import domain.map.TileTypes;

public class MapManager {
	
	public static Map activeMap;
	
	private static Button towerTile = new Button(null, 100, 100, Color.cyan, Color.darkGray, true); 
	private static Quad enemyWalkTile = new Quad(null, 100, 100, Color.blue);
	private static Quad enemyBaseTile = new Quad(null, 100, 100, Color.red);
	private static Quad playerBaseTile = new Quad(null, 100, 100, Color.green);
	
	public static void defineTiles (Button tower, Quad enemyWalk, Quad enemyBase, Quad playerBase) {
		
		towerTile = tower; 
		enemyWalkTile = enemyWalk;
		enemyBaseTile = enemyBase;
		playerBaseTile = playerBase;
	}
	
	public static void createMap (int[][] tiles, int tileWidth, int tileHeight, int tileSpacing) {
		
		Point baseLocation = new Point(0, 0);
		
		int enemyTurningPointIndex = 0;
		ArrayList<Point> enemyPath = new ArrayList<Point>();
		
		for (int i = 0; i < tiles.length; i++) {
			
			for (int j = 0; j < tiles[i].length; j++) {
				
				int newX, newY;
				
				newX = j * tileWidth;
				newY = i * tileHeight;
				
				switch (tiles[i][j]) {
				
					case TileTypes.ENEMY_BASE_TILE:
						
						baseLocation = new Point(i, j);
						
						newX += j * tileSpacing + (tileWidth - enemyBaseTile.getWidth()) / 2;
						newY += i * tileSpacing + (tileHeight - enemyBaseTile.getHeight()) / 2;
						
						GameManager.createQuad(new Quad(new Point(newX, newY),
														enemyBaseTile.getWidth(),
														enemyBaseTile.getHeight(),
														enemyBaseTile.getColor()));
						
						break;
						
					case TileTypes.ENEMY_TURNING_TILE:						
					case TileTypes.ENEMY_WALK_TILE:
						
						newX += j * tileSpacing + (tileWidth - enemyWalkTile.getWidth()) / 2;
						newY += i * tileSpacing + (tileHeight - enemyWalkTile.getHeight()) / 2;
						
						GameManager.createQuad(new Quad(new Point(newX, newY),
														enemyWalkTile.getWidth(),
														enemyWalkTile.getHeight(),
														enemyWalkTile.getColor()));
	
						break;
	
					case TileTypes.TOWER_TILE:
						
						newX += j * tileSpacing + (tileWidth - towerTile.getWidth()) / 2;
						newY += i * tileSpacing + (tileHeight - towerTile.getHeight()) / 2;
						
						GameManager.createInteractable(new Button(new Point(newX, newY),
														towerTile.getWidth(),
														towerTile.getHeight(),
														towerTile.getNormalColor(),
														towerTile.getHighlightColor(),
														towerTile.isActive()));
	
						break;
						
					case TileTypes.PLAYER_BASE_TILE:
						
						newX += j * tileSpacing + (tileWidth - playerBaseTile.getWidth()) / 2;
						newY += i * tileSpacing + (tileHeight - playerBaseTile.getHeight()) / 2;
						
						GameManager.createQuad(new Quad(new Point(newX, newY),
														playerBaseTile.getWidth(),
														playerBaseTile.getHeight(),
														playerBaseTile.getColor()));
	
						break;
						
					default:
						
						System.out.println("Tile Type does not exist!");
						break;
				}
			}
		}
		
		int tilesSave[][] = tiles.clone(); 
		
		boolean finish = false;
		
		while (true) {
			
			boolean found = false;
			
			for (int i = -1; i <= 1; i += 1) {
				for (int j = -1; j <= 1; j += 1) {
					
					if (i == 0 && j == 0) {
						
						j = 1;
					}
					
					int x = (int)baseLocation.getX() + i;
					int y = (int)baseLocation.getY() + j;
					
					if (x >= 0 && x < tiles.length) {
						if (y >= 0 && y < tiles[0].length) {
							
							int newX = j * tileWidth;
							int newY = i * tileHeight;
							newX += j * tileSpacing + (tileWidth - enemyWalkTile.getWidth()) / 2;
							newY += i * tileSpacing + (tileHeight - enemyWalkTile.getHeight()) / 2;
							
							int turningX;
							int turningY;
							switch (tiles[x][y]) {
							
								case TileTypes.ENEMY_TURNING_TILE:			
									
									tiles[x][y] = -1;
									
									turningX = newX + enemyWalkTile.getWidth() / 2;
									turningY = newY + enemyWalkTile.getHeight() / 2;
																		
									enemyPath.add(enemyTurningPointIndex, new Point(turningX, turningY));
									enemyTurningPointIndex++;
									found = true;
									break;
									
								case TileTypes.ENEMY_WALK_TILE:
									
									tiles[x][y] = -1;
									baseLocation = new Point(x, y);
									found = true;
									break;
									
								case TileTypes.PLAYER_BASE_TILE:
									
									turningX = newX + enemyWalkTile.getWidth() / 2;
									turningY = newY + enemyWalkTile.getHeight() / 2;
																		
									enemyPath.add(enemyTurningPointIndex, new Point(turningX, turningY));
									
									found = true;
									finish = true;
									break;
							}
						}
					}		
					
					if (found) {						
						break;
					}
				}
				
				if (found) {					
					break;
				}
			}
			
			if (finish) {
				break;
			}
		}
		
		activeMap = new Map(tileWidth, tileHeight, tileSpacing, tilesSave, enemyPath);
	}
}
