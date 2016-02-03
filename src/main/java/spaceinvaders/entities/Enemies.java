package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.Random;

import spaceinvaders.Level;

import gameframework.game.GameData;
import gameframework.game.GameLevel;
import gameframework.motion.blocking.MoveBlocker;

public abstract class Enemies extends Shooter implements MoveBlocker{

	protected int point;
	protected Level lvl;
	
	//Constructor
	
	public Enemies(GameData data, int posX, int posY, Level lvl) {
		super(data);
		super.setPosition(new Point(posX, posY));
		this.lvl = lvl;
	}
	
	//Getter
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(super.image.getWidth(), super.image.getHeight()));
	}
	
	public boolean canShoot(){
		return this.lvl.getEnemiesArray().EnemieCanShoot(this);
	}

	public Level getLevel(){
		return (Level) this.lvl;
	}
	//Method
	
	@Override
	public void oneStepMoveAddedBehavior() {
		this.shoot();
	}

	@Override
	public void shoot(){
		if(this.canShoot()){
			super.data.getUniverse().addGameEntity(new EnemieLaser(super.data, this));
		}
	}
}
