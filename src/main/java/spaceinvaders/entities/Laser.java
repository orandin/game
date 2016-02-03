package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Rectangle;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public abstract class Laser extends EntiteMovable implements MoveBlocker {
	
	//Constructor
	
	public Laser(GameData data, Shooter shooter) {
		super(data);
		super.image = new DrawableImage("../../images/entite/laser.png", data.getCanvas());
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(image.getWidth(), image.getHeight()));
	}
	public abstract Shooter getShooter();
}
