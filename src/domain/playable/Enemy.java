package domain.playable;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import domain.geometrics.Quad;
import domain.managers.MapManager;

public class Enemy extends Quad{
	
	private int health;
	private int damage;
	private int speed;
	
	private Point waypoints[];
	private int currentWaypoint;
	
	public Enemy(Point position, int width, int height, Color color, int health, int damage, int speed, ArrayList<Point> pathPoints) {
	
		super(new Point((int)position.getX() + (MapManager.activeMap.getTileWidth() - width) / 2, 
      			        (int)position.getY() + (MapManager.activeMap.getTileHeight() - height) / 2)
				, width, height, color);
		
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		
		this.currentWaypoint = 0;

		this.waypoints = new Point[pathPoints.size()];
		
		int i = 0;
		
		for (Point p : pathPoints ) {
			
			this.waypoints[i] = new Point((int)p.getX() + (MapManager.activeMap.getTileWidth() - width) / 2, 
					 	   		          (int)p.getY() + (MapManager.activeMap.getTileHeight() - height) / 2);
			
			i++;
		}
	}
	
	public void move () {
		
	}
	
	// Getters and Setters
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Point[] getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(Point[] waypoints) {
		this.waypoints = waypoints;
	}

	public int getCurrentWaypoint() {
		return currentWaypoint;
	}

	public void setCurrentWaypoint(int currentWaypoint) {
		this.currentWaypoint = currentWaypoint;
	}
}
