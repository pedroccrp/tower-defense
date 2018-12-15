package domain.playable;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.TimerTask;

import domain.geometrics.Quad;
import domain.managers.EnemyManager;
import domain.managers.MapManager;
import domain.managers.PlayerManager;
import domain.managers.TimeManager;

public class Enemy extends Quad implements Movement {
	
	private int health;
	private int damage;
	private int speed;
	private int gold;
	
	private Point waypoints[];
	private int currentWaypoint;
	
	private float distanceTraveled; 
	private Point initialPos;
	private Point finalPos;
	
	public Enemy(Point position, int width, int height, Color color, int health, int damage, int speed, int gold) {
	
		super(new Point((int)position.getX() + (MapManager.activeMap.getTileWidth() - width) / 2, 
      			        (int)position.getY() + (MapManager.activeMap.getTileHeight() - height) / 2), 
				width, 
				height, 
				color);
		
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.gold = gold;
		
		ArrayList<Point> pathPoints = MapManager.activeMap.getEnemyPath();
		
		this.currentWaypoint = 0;

		this.waypoints = new Point[pathPoints.size()];
		
		int i = 0;
		
		for (Point p : pathPoints ) {
			
			this.waypoints[i] = new Point((int)p.getX() + (MapManager.activeMap.getTileWidth() - width) / 2, 
					 	   		          (int)p.getY() + (MapManager.activeMap.getTileHeight() - height) / 2);
			
			i++;
		}
		
		
		getNextWaypoint();
	}
	
	public void init() {
		
		long delayMilisec = 1000 * speed;
		
		delayMilisec /= MapManager.activeMap.getTileWidth() + MapManager.activeMap.getTileSpacing();
		
		TimeManager.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				move();
			}
		}, delayMilisec);
		
	}
	
	@Override
	public void move() {
		
		distanceTraveled += 0.01;
		
		if (distanceTraveled > 1) {
			
			distanceTraveled = 1;
		}
		
		int newX = (int)((finalPos.getX() - initialPos.getX()) * distanceTraveled);
		newX += initialPos.getX();
		int newY = (int)((finalPos.getY() - initialPos.getY()) * distanceTraveled);
		newY += initialPos.getY();
		
		setPosition(new Point(newX, newY));
				
		if (distanceTraveled >= 1) {
			
			currentWaypoint++;			
			getNextWaypoint();		
		}
		
		init();
	}
	
	public void getNextWaypoint () {
		
		if (currentWaypoint < waypoints.length) {
			
			distanceTraveled = 0;
			initialPos = new Point((int)this.getPosition().getX(), (int)this.getPosition().getY());
			finalPos = waypoints[currentWaypoint];
			
		} else {
			
			damagePlayer();
		}
	}
	
	public void receiveDamage (int damage) {
		
		health -= damage;
		
		if (health <= 0) {
			
			die(true);
		}
	}
	
	public void damagePlayer () {
		
		PlayerManager.health -= damage;
		
		if (PlayerManager.health <= 0) {
			
			PlayerManager.health = 0;
			
			PlayerManager.die();
		}
		
		die(false);
	}
	
	public void die (boolean wasPlayer) {
		
		
		if (wasPlayer) {
			
			PlayerManager.gold += gold;
			
		}
		
		EnemyManager.removeEnemy(this);
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

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
}
