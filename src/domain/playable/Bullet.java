package domain.playable;

import java.awt.Color;
import java.awt.Point;
import java.util.TimerTask;

import domain.geometrics.Quad;
import domain.managers.BulletManager;
import domain.managers.EnemyManager;
import domain.managers.MapManager;
import domain.managers.TimeManager;

public class Bullet extends Quad implements Movement{
	
	private int damage;
	private int speed;
	private Enemy target;
	
	private float distanceTraveled;
	private Point initialPos;
	
	private boolean valid;
	
	public Bullet(Point position, int width, int height, Color color, int damage, int speed, Enemy target, Tower sourceTower) {
		
		super(position, width, height, color);
		this.damage = damage;
		this.speed = speed;
		this.target = target;
		
		initialPos = new Point((int)position.getX() + (sourceTower.getWidth() - width) / 2, 
			                   (int)position.getY() + (sourceTower.getHeight() - height) / 2);
		
		valid = true;
		
		init();
	}
	
	public void init() {
		
		long delayMilisec = speed;
		
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
		
		if (!EnemyManager.enemies.contains(target)) {
			
			BulletManager.bullets.remove(this);
			return;
		}
		
		distanceTraveled += 0.01;
		
		if (distanceTraveled > 1) {
			
			distanceTraveled = 1;
		}
		
		Point targetPos = new Point((int)target.getPosition().getX() + (target.getWidth() - getWidth()) / 2, 
                				    (int)target.getPosition().getY() + (target.getHeight() - getHeight()) / 2);
		
		int newX = (int)((targetPos.getX() - initialPos.getX()) * distanceTraveled);
		newX += initialPos.getX();
		int newY = (int)((targetPos.getY() - initialPos.getY()) * distanceTraveled);
		newY += initialPos.getY();
		
		setPosition(new Point(newX, newY));
				
		if (distanceTraveled >= 1) {
			
			hit();
			
		} else {
			
			init();
		}
	}
	
	public void hit() {
		
		BulletManager.removeBullet(this);
		
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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
