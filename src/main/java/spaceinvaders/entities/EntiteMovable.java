package spaceinvaders.entities;

import java.awt.Graphics;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;

/**
 * represent the different entities movable in the game
 * @author 
 *
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
	
	//Constructor
	
	/**
	 * constructor
	 * @param data : game data
	 */
	public EntiteMovable(GameData data) {
		this.config = data.getConfiguration();
		this.data = data;
		super.moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
	}

	//Method 
	
	/**
	 * method to draw an entitie on the canvas
	 */
	@Override
	public void draw(Graphics g) {
		this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}

}
