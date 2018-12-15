package domain.playable;

import java.awt.Color;
import java.awt.Point;

import domain.geometrics.Quad;

public class Bullet extends Quad implements Movement{
	private int damage;
	private int speed;
	private Enemy target;
	
	public Bullet(Point position, int width, int height, Color color, int damage, int speed, Enemy target) {
		super(position, width, height, color);
		this.damage = damage;
		this.speed = speed;
		this.target = target;
	}
	
	@Override
	public void move() {
		
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
