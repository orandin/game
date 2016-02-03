package spaceinvaders.entities;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

import java.awt.Graphics;
import java.awt.Point;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class Laser extends AbstractLaser {
	
	/**
	 * {@inheritDoc}
	 */
	public Laser(GameData data, Shooter shooter) {
		super(data, shooter);
	}

	/* ----- Getters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSprite() {
		return "../../images/entite/laser.png";
	}
	
	/* ----- Setters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMoveStrategy() {
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, 0), 16));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosition() {
		int x = (int) (this.shooter.getPosition().getX() + (this.shooter.getImage().getWidth() / 2) - (this.image.getWidth() / 2));
		int y = (int) (this.shooter.getPosition().getY() - 20);
		
		this.position.setLocation(new Point(x, y));
	}
	
	/* ----- Drawing ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		if (super.position.y <= 0) {
			this.data.getUniverse().removeGameEntity(this);
			this.shooter.resetShoot();
		}
		else
			this.data.getCanvas().drawImage(g, this.image.getImage(), super.position.x, super.position.y);
	}
}
