package domain.playable;

import java.awt.Color;
import java.awt.Point;
import java.util.TimerTask;

import domain.geometrics.Quad;
import domain.managers.MapManager;
import domain.managers.TimeManager;

public class Bullet extends Quad implements Movement{
	
	private int damage;
	private int speed;
	private Enemy target;
	
	private float distanceTraveled;
	private Point initialPos;
	
	public Bullet(Point position, int width, int height, Color color, int damage, int speed, Enemy target) {
		
		super(position, width, height, color);
		this.damage = damage;
		this.speed = speed;
		this.target = target;
		
		initialPos = new Point((int)position.getX(), (int)position.getY());
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
	public void move () {
		
		distanceTraveled += 0.01;
		
		if (distanceTraveled > 1) {
			
			distanceTraveled = 1;
		}
		
		int newX = (int)((target.getPosition().getX() - initialPos.getX()) * distanceTraveled);
		newX += initialPos.getX();
		int newY = (int)((target.getPosition().getY() - initialPos.getY()) * distanceTraveled);
		newY += initialPos.getY();
		
		setPosition(new Point(newX, newY));
				
		if (distanceTraveled >= 1) {
			
			hit();
			
		} else {
			
			init();
		}
	}
	
	public void hit() {
		
		target.receiveDamage(this.damage);
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

	public Enemy getTarget() {
		return target;
	}

	public void setTarget(Enemy target) {
		this.target = target;
	}
	
}
