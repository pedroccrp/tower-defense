package domain.managers;

import java.util.ArrayList;

import domain.playable.Enemy;
import domain.playable.Wave;

public class WaveManager {
	
	public static ArrayList<Enemy> definedEnemies;
	
	public static Wave currentWave;
	
	private static int currentEnemyIndex = 0;
	
	public static void defineEnemy (Enemy e, int id) {
		
		definedEnemies.add(id, e);
	}
	
	public static void createWave (int enemiesId[], int timeBetweenSpawn) {
		
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
		for (int i = 0; i < enemiesId.length; i++) {
			
			enemies.add(definedEnemies.get(i));			
		}
		
		currentWave = new Wave(timeBetweenSpawn, enemies);
	}
	
	public static void spawn () {
		
		
	}
}
