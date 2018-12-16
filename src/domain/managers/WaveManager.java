package domain.managers;

import java.util.ArrayList;
import java.util.TimerTask;

import domain.playable.Enemy;
import domain.playable.Wave;

public class WaveManager {
	
	public static ArrayList<Enemy> definedEnemies = new ArrayList<Enemy>();
	public static ArrayList<Wave> waves = new ArrayList<Wave>();
	
	
	public static Wave currentWave;
	
	private static int currentEnemyIndex = 0;
	private static int currentWaveIndex = 0;
	
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
		
		waves.add(new Wave(timeBetweenSpawn, enemies));
		
		currentWave = waves.get(currentWaveIndex);
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
		
		if (!PlayerManager.alive ) {
			
			return;
		}
		
		if (currentEnemyIndex < currentWave.getEnemies().size()) {
			
			EnemyManager.addEnemy(currentWave.getEnemies().get(currentEnemyIndex));
			
			currentEnemyIndex++;
			
			init();
			
		} else {
			
			currentWaveIndex++;
			
			if (currentWaveIndex < waves.size()) {
				
				currentEnemyIndex = 0;
				
				currentWave = waves.get(currentWaveIndex);
				
				init();
				
			} else {
				
				//End Game
			}
		}
	}
}
