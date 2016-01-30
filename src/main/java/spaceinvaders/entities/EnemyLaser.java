package spaceinvaders.entities;

import java.awt.Graphics;
import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class EnemyLaser extends AbstractLaser {

	/**
	 * {@inheritDoc}
	 */
	public EnemyLaser(GameData data, Shooter shooter) {
		super(data, shooter);
	}
	
	/* ----- Getters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrawableImage getUrlImage() {
		return new DrawableImage("../../images/entite/enemylaser.png", data.getCanvas());
	}
	
	/* ----- Setters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMoveStrategy() {
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, 0), -12));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosition() {
		
		Enemies enemy = (Enemies) this.shooter;
		
		Point location = new Point();
		int x = (int) (enemy.xOffset + enemy.getPosition().getX() + (enemy.getImage().getWidth() / 2) - (this.image.getWidth() / 2));
		int y = (int) (enemy.yOffset + enemy.getPosition().getY() + this.image.getHeight() + 20);
		location.setLocation(x, y);
		
		this.position.setLocation(new Point(x, y));
	}
	
	/* ----- Drawing ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		if (super.position.y >= super.data.getCanvas().getHeight())
			this.data.getUniverse().removeGameEntity(this);
		else
			this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}
}