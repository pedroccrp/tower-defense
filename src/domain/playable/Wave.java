package domain.playable;

import java.util.ArrayList;

public class Wave {
	
	private int timeBetweenSpawn;
	
	private ArrayList<Enemy> enemies;

	public Wave(int timeBetweenSpawn, ArrayList<Enemy> enemies) {
		this.timeBetweenSpawn = timeBetweenSpawn;
		this.enemies = enemies;
	}
	
	// Getters and Setters

	public int getTimeBetweenSpawn() {
		return timeBetweenSpawn;
	}

	public void setTimeBetweenSpawn(int timeBetweenSpawn) {
		this.timeBetweenSpawn = timeBetweenSpawn;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
}