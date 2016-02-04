package spaceinvaders.entities.blockersRules;

import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

import spaceinvaders.Level;
import spaceinvaders.entities.Alien;
import spaceinvaders.entities.EnemiesShooter;
import spaceinvaders.entities.EnemyLaser;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.PlayerLaser;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {

	/**
	 * Destroy the enemy touch by the player
	 * @param laser
	 * 		The player laser which touch the enemy
	 * @param alien
	 * 		The alien which is touch by the laser
	 */
	private void kill(PlayerLaser laser, EnemiesShooter alien){
		gameData.getUniverse().removeGameEntity(laser);
		((Level) alien.getLevel()).getEnemiesArray().remove(alien);
		laser.getShooter().getData().getScore().setValue(laser.getShooter().getData().getScore().getValue() + alien.getPoint());
		if(((Level) alien.getLevel()).getEnemiesArray().allDead()){
			System.out.println("you win");
			((Level) alien.getLevel()).resetLevel();
			laser.getShooter().getData().increaseLife(1);
		}
		laser.getShooter().resetShoot();
	}
	
	/**
	 * decrease life when a player is touch by an enemy
	 * @param laser
	 * 		the laser which touch the player
	 */
	private void PlayerTouch(EnemyLaser laser){
		gameData.decreaseLife(1);
		gameData.getUniverse().removeGameEntity(laser);
	}
	
	/**
	 * remove the two lasers which are collided
	 * @param alien
	 * 		the Alien Laser
	 * @param player
	 * 		the Player laser
	 */
	private void lasersColisions(EnemyLaser alien, PlayerLaser player){
		gameData.getUniverse().removeGameEntity(alien);
		gameData.getUniverse().removeGameEntity(player);
		player.getShooter().resetShoot();
	}
	
	private void enemyChangeDirection(Alien alien, int nextGoal){
		((Level) alien.getLevel()).getEnemiesArray().ReverseMoveStrategyForAll(nextGoal);
	}
	/* ----- Rules ----- */
	
	/* ---- Player laser VS Enemy ----- */
	
	/**
	 * Defines the action when the player laser touches an enemy
	 * @param laser
	 * 		The laser which hit the enemy
	 * @param ennemy
	 * 		The enemy which is hit
	 * @throws IllegalMoveException
	 * 		Exception for stop the movement
	 */
	public void moveBlockerRule(PlayerLaser player, Alien alien) throws IllegalMoveException {
		kill(player, alien);
		throw new IllegalMoveException();
	}
	
	/* ----- Enemy Laser VS Enemy ---- */
	
	/**
	 * Defines the action when the enemy laser touches an enemy
	 * do nothing because when the enemy shoot the two bounding boxs collided
	 * so we have to define this rule to not stop the laser
	 * @param laser
	 * 		the enemy laser
	 * @param alien
	 * 		the enemy touch by it
	 * @throws IllegalMoveException
	 *  		Exception for stop the movement
	 */
	public void moveBlockerRule(EnemyLaser laser, Alien alien){
		//sert à gerer l'enjembement des deux move blocker
	}

	/* ----- Enemy laser VS Player ----- */
	
	/**
	 * Defines the action when the enemies laser touch the player
	 * @param player
	 * 		the player touch by an enemy
	 * @param laser
	 * 		the laser which touch the player
	 * @throws IllegalMoveException
	 *  		Exception for stop the movement
	 */
	public void moveBlockerRule(Player player, EnemyLaser laser) throws IllegalMoveException {
		PlayerTouch(laser);
		throw new IllegalMoveException();
	}

	/* ----- Enemy Laser vs Player laser ----- */
	
	/**
	 * Defines the action when enemy laser touch the player laser
	 * @param alien
	 * 		the enemy laser
	 * @param player
	 * 		the player laser
	 * @throws IllegalMoveException
	 * 		Exception for stop the movement
	 */
	public void moveBlockerRule(EnemyLaser alien, PlayerLaser player) throws IllegalMoveException{
		lasersColisions(alien, player);
		throw new IllegalMoveException();
	}
	
	/* ----- Enemy vs Player ----- */
	
	public void moveBlockerRule(Player player, Alien alien) throws IllegalMoveException{
		alien.getLevel().end();
		throw new IllegalMoveException();
	}
	
	/* ----- Enemy vs Wall -----*/
	public void moveBlockerRule(Alien alien, RightWall wall) throws IllegalMoveException{
		enemyChangeDirection(alien, 0);
		throw new IllegalMoveException();
	}
	
	public void moveBlockerRule(Alien alien, LeftWall wall) throws IllegalMoveException{
		enemyChangeDirection(alien, gameData.getConfiguration().getNbColumns() * gameData.getConfiguration().getSpriteSize());
		throw new IllegalMoveException();
	}
}

