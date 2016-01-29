package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

/**
 * 
 * @author Kevin Rico
 * @author Benjamin Szczapa
 *
 */
public abstract class Enemies extends Shooter implements MoveBlocker{

	protected int point;
	
	//Constructor
	public Enemies(GameData data, int posX, int posY) {
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
		// TODO
	}

	@Override
	public void shoot(){
		// TODO: Enemies can shoot too
	}
}
