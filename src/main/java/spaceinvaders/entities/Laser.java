package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

public abstract class Laser extends EntiteMovable {
	
	//Constructor
	
	public Laser(GameData data, Shooter shooter) {
		super(data);
		super.image = new DrawableImage("../../images/entite/laser.png", data.getCanvas());
	}

	//Getter
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(this.image.getWidth(), this.image.getHeight()));
	}

	//Method
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
	}

	public abstract Shooter getShooter();

}
