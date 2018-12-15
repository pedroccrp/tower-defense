package domain.playable;

import java.awt.Color;
import java.awt.Point;

import domain.geometrics.Quad;

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
