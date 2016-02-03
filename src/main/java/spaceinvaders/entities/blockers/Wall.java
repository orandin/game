package spaceinvaders.entities.blockers;

import java.awt.Graphics;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

/**
 * this class represents the walls (left and right)
 * @author 
 *
 */
public abstract class Wall implements MoveBlocker, GameEntity {

	/**
	 * this class had 1 attribute
	 * - height : the height of the wall
	 */
	protected int height;
	
	/**
	 * constructor
	 * @param data : game data
	 */
	public Wall(GameData data) {
		this.height = data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize();
	}

	/**
	 * getter for know if this entitie is movable or not
	 */
	@Override
	public boolean isMovable() {
		return false;
	}

	/**
	 * method unused because the wall have to be invisible
	 */
	@Override
	public void draw(Graphics g) {
	}
	
}
