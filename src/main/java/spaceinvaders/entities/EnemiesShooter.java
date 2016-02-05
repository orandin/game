package spaceinvaders.entities;

import gameframework.game.GameData;
import gameframework.game.GameLevel;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.util.Random;

import spaceinvaders.Level;

/**
 * this class represent the different type of enemies in the game
 * @author 
 */
public abstract class EnemiesShooter extends Shooter implements MoveBlocker{

	/* ---- attributes ----- */
	
	/**
	 * this class had 3 attributes
	 * - point : the point win by the player if he is kill
	 * - lvl : the current level ( to access enemies array principally)
	 * - enemiesArrayPosition : the position of this enemies in enemiesArray
	 */
	protected int point;
	protected Level lvl;
	protected Point enemiesArrayPosition;
	
	/* ----- constructor ----- */
	
	/**
	 * Constructor
	 * @param data : game data
	 * @param posX : the position x of this enemy
	 * @param posY : the position y of this enemy
	 * @param lvl : the current level
	 */
	public EnemiesShooter(GameData data, int posX, int posY, Level level) {
		super(data);
		super.setPosition(new Point(posX, posY));
		lvl = level;
	}
	
	/* ----- getters ----- */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canShoot(){
		return lvl.getEnemiesArray().EnemieCanShoot(this);
	}

	/**
	 * getter for lvl
	 * @return the current level
	 */
	public GameLevel getLevel(){
		return lvl;
	}
	
	/**
	 * getter for enemies point
	 * @return the enemy point
	 */
	public int getPoint(){
		return point;
	}
	
	/**
	 * getter for enemiesArrayPosition
	 * @return the position of this enemy in enemiesArray
	 */
	public Point getArrayPosition(){
		return enemiesArrayPosition;
	}
	/* ----- Setter ----- */
	
	/**
	 * set enemiesArrayPosition attribute with the EnemiesArray position
	 * @param position
	 */
	public void setArrayPosition(Point position){
		enemiesArrayPosition = position;
	}
	/* ---- Methods ---- */
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shoot(){
		Random rand = new Random();
		if((rand.nextInt(1000) % 350 == 0)){
			data.getUniverse().addGameEntity(new EnemyLaser(data, this));
		}

	}
}
