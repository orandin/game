package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public abstract class Enemys extends Shooter implements MoveBlocker{

	protected int point;
	
	//Constructor
	
	public Enemys(GameData data, int posX, int posY) {
		super(data);
		super.setPosition(new Point(posX, posY));
	}
	
	//Getter
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(super.image.getWidth(), super.image.getHeight()));
	}

	//Method
	
	@Override
	public void oneStepMoveAddedBehavior() {
		
	}

	@Override
	public void shoot(){
	}
}
