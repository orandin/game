package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public abstract class Laser extends EntiteMovable implements MoveBlocker {

	/* ----- Constructor ----- */
	
	/**
	 * Laser constructor
	 * @param data ; game data
	 * @param shooter : the shooter
	 */
	public Laser(GameData data, Shooter shooter) {
		super(data);
		image = new DrawableImage("../../images/entite/laser.png", data.getCanvas());
	}

	/* ----- Getter ----- */
	/**
	 * getter for the shooter
	 * @return the entitie who shoot
	 */
	public abstract Shooter getShooter();
}
