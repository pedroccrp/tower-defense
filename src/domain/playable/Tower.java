package domain.playable;

import java.awt.Color;
import java.awt.Point;
import java.util.TimerTask;

import domain.geometrics.Quad;
import domain.managers.BulletManager;
import domain.managers.EnemyManager;
import domain.managers.TimeManager;

public class Tower extends Quad {
	private int damage, fireRate;
	private double currentCooldown;
	private int buyPrice, sellPrice;
	private int range;
	
	public Tower(Point position, int width, int height, Color color, int damage, int fireRate, int buyPrice,
				 int sellPrice, int range) {
		
		super(position, width, height, color);
		this.damage = damage;
		this.fireRate = fireRate;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.range = range;
	}
	
	public void init () {
		
		long delayMilisec = 1000 / fireRate;
		
		TimeManager.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				shoot(getTarget());
			}
		}, delayMilisec);
	}
	
	private Enemy getTarget () {
		
		Enemy closestEnemy = null;
		double record = 10000000;
		
		for (Enemy e : EnemyManager.enemies) {
			
			double d = getPosition().distance(e.getPosition());
			
			if (d < record) {
				
				record = d;
				closestEnemy = e;
			}			
		}
		
		return closestEnemy;
		
	}
	
	public void shoot (Enemy target) {
		
		if (target != null) {
			
			BulletManager.addBullet(new Bullet(getPosition(), 10, 10, Color.white, damage, 500, target, this));
		}
		
		init();
	}
	
	// Getters and Setters
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getCurrentCooldown() {
		return currentCooldown;
	}

	public void setCurrentCooldown(double currentCooldown) {
		this.currentCooldown = currentCooldown;
	}
	
}
