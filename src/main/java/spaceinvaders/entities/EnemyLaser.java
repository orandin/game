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
	private Enemies enemy;
	
	/**
	 * constructor
	 * @param data : game data
	 * @param enemy : the enemy who shoot
	 */
	public EnemyLaser(GameData data , Enemies enemy) {
		super(data, enemy);
		super.position = new Point((enemy.getPosition().x + enemy.image.getWidth() / 2), (enemy.getPosition().y + enemy.image.getHeight()/2));
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize())));
		this.enemy = enemy;
	}

	/**
	 * getter for enemy
	 * @return the shooter
	 */
	@Override
	public Shooter getShooter() {
		return this.enemy;
	}

}
