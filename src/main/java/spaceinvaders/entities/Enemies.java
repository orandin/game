package spaceinvaders.entities;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;


import spaceinvaders.Level;

import gameframework.motion.MoveStrategyStraightLine;

/**
 * this class represent the differents type of enemies in the game
 * @author 
 */
public abstract class Enemies extends Shooter implements MoveBlocker{

	/**
	 * this class had 2 attributes
	 * - point : the point win by the player if he is kill
	 * - lvl : the current level ( to access enemies array principally)  
	 */
	protected int point;

	protected Level lvl;
	
	//Constructor
	
	/**
	 * Constructor
	 * @param data : game data
	 * @param posX : the position x of this enemy
	 * @param posY : the position y of this enemy
	 * @param lvl : the current level
	 */
	public Enemies(GameData data, int posX, int posY, Level lvl) {
		super(data);
		super.setPosition(new Point(posX, posY));
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(position, new Point(super.data.getConfiguration().getNbColumns() * super.data.getConfiguration().getSpriteSize() ,position.y)));
		this.lvl = lvl;
	}
	
	/**
	 * Get the bounding box of this entity
	 * @return the bounding box as a rectangle
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(new Point(position.x, position.y), new Dimension(super.image.getWidth(), super.image.getHeight()));
	}
	
	/**
	 * getter to know if an enemy can shoot or not
	 * @return <code>true</code> if he can shoot <code>false</code> else
	 */
	@Override
	public boolean canShoot(){
		return this.lvl.getEnemiesArray().EnemieCanShoot(this);
	}

	/**
	 * getter for lvl
	 * @return the current level
	 */
	public Level getLevel(){
		return (Level) this.lvl;
	}
	
	//Method
	
	/**
	 * action to do after a move
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		this.shoot();
	}

	/**
	 * method to shoot
	 */
	@Override
	public void shoot(){
		Random rand = new Random();
		if(this.canShoot() && (rand.nextInt(1000) % 350 == 0)){
			super.data.getUniverse().addGameEntity(new EnemyLaser(super.data, this));
		}

	}
}
