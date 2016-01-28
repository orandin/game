package spaceinvaders.entities;

import java.awt.Graphics;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;

public abstract class EntiteMovable extends GameMovable implements GameEntity {

	protected GameData data;
	protected DrawableImage image;
	protected GameConfiguration config;
	
	//Constructor
	
	public EntiteMovable(GameData data) {
		this.config = data.getConfiguration();
		this.data = data;
		super.moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
	}

	//Method 
	
	@Override
	public void draw(Graphics g) {
		this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}

}
