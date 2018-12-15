package domain.playable;

import java.awt.Color;
import java.awt.Point;

import domain.geometrics.Quad;

public class Enemy extends Quad{
	
	private int health;
	private int damage;
	private int speed;
	
	private Point waypoints[][];
	private int currentWaypoint;
	
	public Enemy(Point position, int width, int height, Color color, int health, int damage, int speed,
			Point[][] waypoints, int currentWaypoint) {
	
		super(position, width, height, color);
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.waypoints = waypoints;
		this.currentWaypoint = currentWaypoint;
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

	public Point[][] getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(Point[][] waypoints) {
		this.waypoints = waypoints;
	}

	public int getCurrentWaypoint() {
		return currentWaypoint;
	}

	public void setCurrentWaypoint(int currentWaypoint) {
		this.currentWaypoint = currentWaypoint;
	}
}
