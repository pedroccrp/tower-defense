package domain.map;

import java.awt.Point;
import java.util.ArrayList;

public class Map {
	
	private int tileWidth, tileHeight, tileSpacing;
	
	private int tiles[][];
	
	private final Point enemySpawn;
	
	private ArrayList<Point> enemyPath;

	public Map(int tileWidth, int tileHeight, int tileSpacing, int[][] tiles, ArrayList<Point> enemyPath, Point enemySpawn) {
		
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.tileSpacing = tileSpacing;
		this.tiles = tiles;
		this.enemyPath = enemyPath;
		this.enemySpawn = enemySpawn;
	}

	// Getters and Setters

	public int getTileWidth() {
		return tileWidth;
	}
	
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}
	
	public int getTileHeight() {
		return tileHeight;
	}



	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}



	public int getTileSpacing() {
		return tileSpacing;
	}



	public void setTileSpacing(int tileSpacing) {
		this.tileSpacing = tileSpacing;
	}



	public int[][] getTiles() {
		return tiles;
	}



	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}



	public ArrayList<Point> getEnemyPath() {
		return enemyPath;
	}



	public void setEnemyPath(ArrayList<Point> enemyPath) {
		this.enemyPath = enemyPath;
	}

	public Point getEnemySpawn() {
		return enemySpawn;
	}
	
	
}
