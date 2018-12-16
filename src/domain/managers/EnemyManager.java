package domain.managers;

import java.awt.Graphics;
import java.util.ArrayList;

import domain.playable.Enemy;

public class EnemyManager {
	
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public static void draw (Graphics g) {
		
		for (Enemy e : new ArrayList<>(enemies)) {
			
			if (e.isValid()) {

				e.draw(g);

			} else {
				
				enemies.remove(e);
			}
		}
	}
	
	public static void update () {
		
		for (Enemy e : enemies) {
			
			e.move();
		}
	}
	
	public static void addEnemy(Enemy e) {
		
		enemies.add(e);
		
		e.init();
	}
	
	public static void removeEnemy(Enemy e) {
		
		e.setValid(false);
	}
}
