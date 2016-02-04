package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

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

	/**
	 * this class had 3 attributes
	 * - data : game data
	 * - image : image of this entities
	 * - config : game configuration
	 */
	protected GameData data;
	protected DrawableImage image;
	protected GameConfiguration config;

	/**
	 * Create an EntiteMovable
	 * @param data
	 * 		The game data
	 */
	public EntiteMovable(GameData gameData) {
		moveDriver.setmoveBlockerChecker(gameData.getMoveBlockerChecker());
		config = gameData.getConfiguration();
		data = gameData;
	}

	/**
	 * @return the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position, new Dimension(image.getWidth(), image.getHeight()));
	}

	/**
	 * method to draw an entitie on the canvas
	 */
	@Override
	public void draw(Graphics g) {
		data.getCanvas().drawImage(g, image.getImage(), position.x, position.y);
	}

	@Override
	public void oneStepMoveAddedBehavior() {}
}
