package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

public class Laser extends EntiteMovable {

	private Shooter shooter;
	
	//Constructor
	
	public Laser(GameData data, Shooter shooter, boolean top) {
		super(data);
		super.position.setLocation(shooter.getPosition());
		if(!top){
			super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize())));
		}
		else{
			super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, 0)));
		}
		super.image = new DrawableImage("../../images/entite/laser.png", data.getCanvas());
		this.shooter = shooter;
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

	public Shooter getShooter(){
		return this.shooter;
	}

}
