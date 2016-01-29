package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Graphics;
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
		super.image = new DrawableImage("../../images/entite/laser.png", data.getCanvas());
		
		//Set laser sprite in the center of the player sprite
		Point location = new Point();
		double x = shooter.getPosition().getX() + (shooter.getImage().getWidth() / 2) - (this.image.getWidth() / 2);
		double y = shooter.getPosition().getY() - 20;
		location.setLocation(x, y);
		
		super.position.setLocation(location);
		
		//Set the move strategy and the laser speed
		Point currentPosition = super.position;
		Point goalPosition = new Point(super.position.x, 0);
		int speed = 16;
		
		if(!top)
			goalPosition = new Point(super.position.x, data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize());
		
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(currentPosition, goalPosition, speed));
		
		this.shooter = shooter;
	}

	//Getter
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(this.image.getWidth(), this.image.getHeight()));
	}

	//Method
	
	@Override
	public void oneStepMoveAddedBehavior() {}
	
	@Override
	public void draw(Graphics g) {
		if (super.position.y <= 0) {
			this.data.getUniverse().removeGameEntity(this);
			this.shooter.resetShoot();
		}
		else
			this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}

	public Shooter getShooter(){
		return this.shooter;
	}

}
