package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;
/**
 * this class represents the player laser
 * @author 
 *
 */
public class PlayerLaser extends Laser{

	/**
	 * this class had 1 attribute
	 * - enemy : the player who shoot this laser
	 */
	private Player player;
	
	/**
	 * constructor
	 * @param data : game data
	 * @param enemy : the player who shoot
	 */
	public PlayerLaser(GameData data, Player player) {
		super(data, player);
		this.player = player;
		super.position = new Point((player.getPosition().x + player.image.getWidth() / 2) -2, (player.getPosition().y - player.image.getHeight() / 2) -2);
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, 0)));
	}

	/**
	 * getter for player
	 * @return the shooter
	 */
	@Override
	public Player getShooter(){
		return this.player;
	}
}
