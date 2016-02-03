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
public class EnemyLaser extends AbstractLaser {

	/**
	 * {@inheritDoc}
	 */
	public EnemyLaser(GameData data, Shooter shooter) {
		super(data, shooter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSprite() {
		return "../../images/entite/enemylaser.png";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMoveStrategy() {
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(position.x, 0), -12));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosition() {
		Enemy enemy = (Enemy) shooter;
		int x = (int) (enemy.xOffset + enemy.getPosition().getX() + (enemy.getImage().getWidth() - image.getWidth()) / 2);
		int y = (int) (enemy.yOffset + enemy.getPosition().getY() + image.getHeight() + 20);
		
		this.position.setLocation(new Point(x, y));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		if (position.y >= data.getCanvas().getHeight())
			data.getUniverse().removeGameEntity(this);
		else
			data.getCanvas().drawImage(g, image.getImage(), position.x, position.y);
	}
}
