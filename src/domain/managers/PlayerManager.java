package domain.managers;

import java.util.TimerTask;
import domain.managers.TimeManager;

public class PlayerManager {
	public static int gold = 100;
	public static int health = 100;
	public static final int gainRatio = 1;
	
	public static boolean alive = false;
	
	public static void updateGold () {
		
		long delayMilisec = 1000;
		
		TimeManager.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (alive) {
					gold += gainRatio;
					updateGold();
				}
				System.out.println("HP: " + PlayerManager.health + "\n" +
						    		"Gold: " + PlayerManager.gold + "\n");
			}
		}, delayMilisec);
		
	}
	
	public static void takeDamage (int damage) {
		
		health -= damage;
		
		if (health <= 0) {
			
			health = 0;
			
			die();
		}
	}
	
	public static void die () {
		
		alive = false;
	}
}
