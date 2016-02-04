package spaceinvaders.entities;

import gameframework.game.GameData;
import gameframework.game.GameLevel;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.util.Random;

import spaceinvaders.Level;

/**
 * this class represent the different type of enemies in the game
 * @author 
 */
public abstract class Enemies extends Shooter implements MoveBlocker{

	/* ---- attributes ----- */
	
	/**
	 * this class had 2 attributes
	 * - point : the point win by the player if he is kill
	 * - lvl : the current level ( to access enemies array principally)  
	 */
	protected int point;
	protected Level lvl;
	
	/* ----- constructor ----- */
	
	/**
	 * Constructor
	 * @param data : game data
	 * @param posX : the position x of this enemy
	 * @param posY : the position y of this enemy
	 * @param lvl : the current level
	 */
	public Enemies(GameData data, int posX, int posY, Level level) {
		super(data);
		super.setPosition(new Point(posX, posY));
		moveDriver.setStrategy(new MoveStrategyStraightLine(position, new Point(data.getConfiguration().getNbColumns() * data.getConfiguration().getSpriteSize() ,position.y)));
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
	
	/* ---- Methods ---- */
	
	/**
	 * action to do after a move
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		shoot();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shoot(){
		Random rand = new Random();
		if(this.canShoot() && (rand.nextInt(1000) % 350 == 0)){
			data.getUniverse().addGameEntity(new EnemyLaser(data, this));
		}

	}
}
