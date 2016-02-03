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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSprite() {
		return "../../images/entite/laser.png";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMoveStrategy() {
		moveDriver.setStrategy(new MoveStrategyStraightLine(position, new Point(position.x, 0), 16));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosition() {
		int x = (int) (shooter.getPosition().getX() + (shooter.getImage().getWidth() - image.getWidth()) / 2);
		int y = (int) (shooter.getPosition().getY() - 20);
		
		position.setLocation(new Point(x, y));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		if (position.y <= 0) {
			data.getUniverse().removeGameEntity(this);
			shooter.resetShoot();
		} else {
			data.getCanvas().drawImage(g, image.getImage(), position.x, position.y);
		}
	}
}
