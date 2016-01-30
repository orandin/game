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
		this.data = data;
		super.moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
	}
	
	/* ----- Drawing ----- */
	/**
	 * Draw the entity to the canvas
	 */
	@Override
	public void draw(Graphics g) {
		this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}
	
	/* ----- Unused ----- */
	@Override
	public void oneStepMoveAddedBehavior() {}
}
