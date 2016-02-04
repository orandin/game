package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.MoveStrategyStraightLine;

/**
 * 
 * @author Kevin Rico
 *
 */
public abstract class Laser extends MovableEntity implements MoveBlocker {

	/**
	 * Laser constructor
	 * @param data ; game data
	 * @param shooter : the shooter
	 */
	public Laser(GameData data, Shooter shooter) {
		super(data);
		image = new DrawableImage("../../images/entite/laser.png", data.getCanvas());
	}

	//Method
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
	}

	/* ----- getter ----- */
	
	/**
	 * getter for the shooter
	 * @return the entitie who shoot
	 */
	public abstract Shooter getShooter();
}
