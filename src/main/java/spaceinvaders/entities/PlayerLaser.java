package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;
/**
 * this class represents the player laser
 * @author Kevin Rico
 */
public class PlayerLaser extends Laser{

	/* ----- Attributes ----- */
	
	/**
	 * this class had 1 attribute
	 * - enemy : the player who shoot this laser
	 */
	private Player p;

	/* ----- Constructor ----- */
	
	/**
	 * constructor
	 * @param data : game data
	 * @param enemy : the player who shoot
	 */
	public PlayerLaser(GameData data, Player player) {
		super(data, player);
		p = player;
		position = new Point((player.getPosition().x + player.image.getWidth() / 2) -2, (player.getPosition().y - player.image.getHeight() / 2) -2);
		moveDriver.setStrategy(new MoveStrategyStraightLine(position, new Point(position.x, 0),25));
	}
	
	/* ----- Getter -----*/
	
	/**
	 * getter for player
	 * @return the shooter
	 */
	@Override
	public Player getShooter(){
		return p;
	}
	
	/* ----- Method ----- */
	
	/**
	 * action to do after a move
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		if(position.y <= 30){
			data.getUniverse().removeGameEntity(this);
			p.resetShoot();
		}
	}
}
