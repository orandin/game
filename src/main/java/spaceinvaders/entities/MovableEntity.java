package spaceinvaders.entities;

import java.awt.Graphics;
import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;

/**
 * 
 * @author Kevin Rico
 *
 */
public abstract class MovableEntity extends GameMovable implements GameEntity {

	protected GameData data;
	protected DrawableImage image;
	protected GameConfiguration config;
	
	//Constructor
	public MovableEntity(GameData data) {
		this.config = data.getConfiguration();
		this.data = data;
		super.moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
	}

	//Method 
	
	public Point getPosition(){
		return super.position;
	}
	
	@Override
	public void draw(Graphics g) {
		this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}

}
