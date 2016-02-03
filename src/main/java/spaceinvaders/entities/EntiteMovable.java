package spaceinvaders.entities;

import java.awt.Graphics;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class EntiteMovable extends GameMovable implements GameEntity {

	protected GameData data;
	protected DrawableImage image;
	protected GameConfiguration config;

	/**
	 * Create an EntiteMovable
	 * @param data
	 * 		The game data
	 */
	public EntiteMovable(GameData data) {
		this.config = data.getConfiguration();
		this.data   = data;
		this.moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
	}

	/**
	 * Get the entity sprite
	 * @return the entity sprite
	 */
	protected abstract String getSprite();

	/**
	 * Draw the entity to the canvas
	 */
	@Override
	public void draw(Graphics g) {
		data.getCanvas().drawImage(g, image.getImage(), position.x, position.y);
	}

	@Override
	public void oneStepMoveAddedBehavior() {}
}
