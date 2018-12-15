package domain.managers;

import java.util.ArrayList;
import java.util.TimerTask;

import domain.playable.Enemy;
import domain.playable.Wave;

public class WaveManager {
	
	public static ArrayList<Enemy> definedEnemies = new ArrayList<Enemy>();
	
	public static Wave currentWave;
	
	private static int currentEnemyIndex = 0;
	
	public static void defineEnemy (Enemy e, int id) {
		
		definedEnemies.add(id, e);
	}
	
	public static void createWave (int enemiesId[], int timeBetweenSpawn) {
		
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
		for (int i = 0; i < enemiesId.length; i++) {
			
			Enemy defE = definedEnemies.get(enemiesId[i]);
			
			Enemy e = new Enemy(MapManager.activeMap.getEnemySpawn(), 
								defE.getWidth(), 
								defE.getHeight(), 
								defE.getColor(), 
								defE.getHealth(), 
								defE.getDamage(), 
								defE.getSpeed(), 
								defE.getGold());
			
			enemies.add(e);			
		}
		
		currentWave = new Wave(timeBetweenSpawn, enemies);
		
		for (Enemy e : currentWave.getEnemies()) {
			
			System.out.println(e.getPosition());
		}
	}
	
	public static void init () {
		
		long delayMilisec = 1000 * currentWave.getTimeBetweenSpawn();
		
		TimeManager.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				spawn();
			}
		}, delayMilisec);
		
	}
	
	public static void spawn () {
		
		if (currentEnemyIndex < currentWave.getEnemies().size()) {
			
			EnemyManager.addEnemy(currentWave.getEnemies().get(currentEnemyIndex));
			
			currentEnemyIndex++;
			
			init();
		}		
	}
}
