package spaceinvaders.entities.blockers;


import java.awt.Graphics;

import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public abstract class Wall implements MoveBlocker, GameEntity {

	protected int height;
	
	/**
	 * Constructor
	 * @param data
	 */
	public Wall(GameData data) {
		this.height = data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize();
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public void draw(Graphics g) {
	}
}
