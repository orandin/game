package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

/**
 * this class represents the enemy laser
 * @author 
 *
 */
public class EnemyLaser extends Laser{

	/**
	 * this class had 1 attribute
	 * - enemy : the enemy who shoot this laser
	 */
	private Enemy enem;

	/**
	 * constructor
	 * @param data : game data
	 * @param enemy : the enemy who shoot
	 */
	public EnemyLaser(GameData data , Enemy enemy) {
		super(data, enemy);
		position = new Point((enemy.getPosition().x + enemy.image.getWidth() / 2), (enemy.getPosition().y + enemy.image.getHeight()/2));
		moveDriver.setStrategy(new MoveStrategyStraightLine(position, new Point(position.x, data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize())));
		enem = enemy;
	}

	/**
	 * getter for enemy
	 * @return the shooter
	 */
	@Override
	public Shooter getShooter() {
		return this.enem;
	}

}

