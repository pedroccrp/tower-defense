package domain.managers;

import java.awt.Graphics;
import java.util.ArrayList;

import domain.playable.Tower;

public class TowerManager {
	
	public static ArrayList<Tower> towers = new ArrayList<Tower>();
	
	public static void addTower (Tower t) {
		
		towers.add(t);
		
		t.init();
	}
	
	public static void removeTower (Tower t) {
		
		towers.remove(t);
	}
	
	public static void draw (Graphics g) {
		
		
		for (Tower t : towers) {
			
			t.draw(g);
		}
		
	}
	
	public static void attack () {
		
		
	}
}
