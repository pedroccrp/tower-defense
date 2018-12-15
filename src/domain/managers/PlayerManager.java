package domain.managers;

import java.util.TimerTask;
import domain.managers.TimeManager;

public class PlayerManager {
	public static int gold = 100;
	public static int health = 100;
	public static final int gainRatio = 1;
	
	public static void updateGold () {
		
		long delayMilisec = 1000;
		
		TimeManager.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				gold += gainRatio;
				System.out.println(gold);
				updateGold();
			}
		}, delayMilisec);
		
	}
}
