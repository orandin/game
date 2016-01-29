package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

/**
 * 
 * @author Kevin Rico
 * @author Benjamin Szczapa
 *
 */
public abstract class Enemies extends Shooter implements MoveBlocker{

	protected int point;
	
	/**
	 * Constructor
	 * @param data
	 * @param posX
	 * @param posY
	 */
	public Enemies(GameData data, int posX, int posY) {
		super(data);
		super.setPosition(new Point(posX, posY));
	}
	
	/**
	 * @return The dimension of the game.
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(super.image.getWidth(), super.image.getHeight()));
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO
	}

	/**
	 * Method that allow the enemies to shoot at the player.
	 */
	@Override
	public void shoot(){
		// TODO: Enemies can shoot too
	}
}
