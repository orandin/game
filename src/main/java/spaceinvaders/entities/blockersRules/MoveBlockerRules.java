package spaceinvaders.entities.blockersRules;

import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

import spaceinvaders.Level;
import spaceinvaders.entities.Alien;
import spaceinvaders.entities.EnemiesShooter;
import spaceinvaders.entities.EnemyLaser;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.PlayerLaser;
import spaceinvaders.entities.SmallAlien;
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
	protected void kill(PlayerLaser laser, EnemiesShooter alien){
		gameData.getUniverse().removeGameEntity(laser);
		((Level) alien.getLevel()).getEnemiesArray().remove(alien);
		laser.getShooter().getData().getScore().setValue(laser.getShooter().getData().getScore().getValue() + alien.getPoint());
		if(((Level) alien.getLevel()).getEnemiesArray().allDead()){
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
	protected void PlayerTouch(EnemyLaser laser){
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
	protected void lasersColisions(EnemyLaser alien, PlayerLaser player){
		gameData.getUniverse().removeGameEntity(alien);
		gameData.getUniverse().removeGameEntity(player);
		player.getShooter().resetShoot();
	}
	
	/**
	 * change Direction of all enemies presents in the game
	 * @param alien : alien which touch the well
	 * @param nextGoal : the nextGoal for the MoveStrategy
	 */
	private void enemyChangeDirection(Alien alien, int nextGoal){
		((Level) alien.getLevel()).getEnemiesArray().ReverseMoveStrategyForAll(nextGoal);
	}
	/* ----- Rules ----- */
	
	/* ---- When the player touch Alien with laser ----- */
	
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
	
	/* ---- For the different types of Alien ----- */
	
	public void moveBlockerRule(PlayerLaser player, SmallAlien alien) throws IllegalMoveException {
		moveBlockerRule(player, (Alien) alien);
	}

	public void moveBlockerRule(PlayerLaser player, MediumAlien alien) throws IllegalMoveException {
		moveBlockerRule(player, (Alien) alien);
	}

	public void moveBlockerRule(PlayerLaser player, LargeAlien alien) throws IllegalMoveException {
		moveBlockerRule(player, (Alien) alien);
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
	
	/**
	 * rule when en enemy touch the player
	 * @param player
	 * @param alien
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Player player, Alien alien) throws IllegalMoveException{
		alien.getLevel().end();
		throw new IllegalMoveException();
	}
	
	/* ---- For the different type of Alien ----- */
	public void moveBlockerRule(Player player, SmallAlien alien) throws IllegalMoveException{
		moveBlockerRule(player, (Alien) alien);
	}
	
	public void moveBlockerRule(Player player, MediumAlien alien) throws IllegalMoveException{
		moveBlockerRule(player, (Alien) alien);
	}
	
	public void moveBlockerRule(Player player, LargeAlien alien) throws IllegalMoveException{
		moveBlockerRule(player, (Alien) alien);
	}
	
	/* ----- Enemy vs Wall -----*/
	
	/* ----- LeftWall -----*/
	
	/**
	 * rule when an alien touch left screen
	 * @param alien
	 * @param wall
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Alien alien, LeftWall wall) throws IllegalMoveException{
		enemyChangeDirection(alien,gameData.getConfiguration().getNbColumns() * gameData.getConfiguration().getSpriteSize());
		throw new IllegalMoveException();
	}
	
	/* ---- For the different type of Alien ----- */

	public void moveBlockerRule(SmallAlien alien, LeftWall wall) throws IllegalMoveException{
		moveBlockerRule((Alien) alien , wall);
	}
	
	public void moveBlockerRule(MediumAlien alien, LeftWall wall) throws IllegalMoveException{
		moveBlockerRule((Alien) alien , wall);
	}
	
	public void moveBlockerRule(LargeAlien alien, LeftWall wall) throws IllegalMoveException{
		moveBlockerRule((Alien) alien , wall);
	}
	
	/* ----- RighttWall -----*/
	
	/**
	 * rules when en alien touch the right screen
	 * @param alien
	 * @param wall
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Alien alien, RightWall wall) throws IllegalMoveException{
		enemyChangeDirection(alien,0);
		throw new IllegalMoveException();
	}
	
	/* ---- For the different type of Alien ----- */
	
	
	public void moveBlockerRule(SmallAlien alien, RightWall wall) throws IllegalMoveException{
		moveBlockerRule((Alien) alien , wall);
	}
	
	public void moveBlockerRule(MediumAlien alien, RightWall wall) throws IllegalMoveException{
		moveBlockerRule((Alien) alien , wall);
	}
	
	public void moveBlockerRule(LargeAlien alien, RightWall wall) throws IllegalMoveException{
		moveBlockerRule((Alien) alien , wall);
	}
	
	/* ----- Bug Fix ----- */
	
	/* this section is a set of rules to defines differents rules for fix bug */
	
	/* ----- Enemy touch an Enemy ---- */
	
	public void moveBlockerRule(Alien Alien1, Alien alien2){
		//sert à gerer l'enjembement des voisins dans le deplacement des Alien
		//se qui evite les decalage
	}

	/* ---- For the different types of Alien ----- */
	
	public void moveBlockerRule(SmallAlien alien1, SmallAlien alien2) throws IllegalMoveException {
		moveBlockerRule((Alien) alien1, (Alien) alien2);
	}

	public void moveBlockerRule(MediumAlien alien1, MediumAlien alien2) throws IllegalMoveException {
		moveBlockerRule((Alien) alien1, (Alien) alien2);
	}

	public void moveBlockerRule(LargeAlien alien1, LargeAlien alien2) throws IllegalMoveException {
		moveBlockerRule((Alien) alien1, (Alien) alien2);
	}
	
	/* ----- when Enemy laser touch Alien ----- */
	
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
		//car quand un alien tir les 2 moveBlocker se chevauchent
		//il faut donc gerer le conflit
	}

	/* ---- For the different types of Alien ----- */
	
	public void moveBlockerRule(EnemyLaser laser, SmallAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}

	public void moveBlockerRule(EnemyLaser laser, MediumAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}

	public void moveBlockerRule(EnemyLaser laser, LargeAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	
	/* ----- Enemy Laser VS Enemy ---- */
	
	public void moveBlockerRule(Alien alien, EnemyLaser laser){
		//sert à gerer l'enjembement des deux move blocker
	}

	/* ---- For the different types of Alien ----- */
	
	public void moveBlockerRule(SmallAlien alien , EnemyLaser laser) throws IllegalMoveException {
		moveBlockerRule((Alien) alien, laser);
	}

	public void moveBlockerRule(MediumAlien alien, EnemyLaser laser) throws IllegalMoveException {
		moveBlockerRule((Alien) alien, laser);
	}

	public void moveBlockerRule(LargeAlien alien, EnemyLaser laser) throws IllegalMoveException {
		moveBlockerRule((Alien) alien, laser);
	}
}

