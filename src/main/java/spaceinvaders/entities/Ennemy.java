package spaceinvaders.entities;

import gameframework.motion.MoveStrategyStraightLine;

import java.awt.Point;

import spaceinvaders.Game.Game;

public abstract class Ennemy extends AbstractEntity {

	protected int lifePoints; 	//vie actuel
	protected int reward; 		// nbr de point
	protected final Point INITIAL_POSITION; //Point de spawn initial
	
	/**
	 * Create the entity
	 * @param game
	 * 		The game where the entity is registered
	 * @param initialXPos
	 * 		The initial X coordinate where the entity is draw
	 * @param initialYPos
	 * 		The initial Y coordinate where the entity is draw
	 * @param speed
	 * 		The entity movement speed
	 * @param entitySpritePath
	 * 		The entity sprite
	 * @param spriteWidth
	 * 		The sprite width
	 * @param spriteHeight
	 * 		The sprite height
	 * @param lifePoints
	 * 		The entity life points
	 * @param reward
	 * 		When you kill the entity you've been rewarded by this amount of points
	 */
	public Ennemy(Game game, int initialXPos, int initialYPos, int speed, String entitySpritePath, int spriteWidth, int spriteHeight, int lifePoints, int reward) {
		super(game, initialXPos, initialYPos, speed, entitySpritePath, spriteWidth, spriteHeight);
		this.lifePoints = lifePoints;
		this.reward = reward;
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(22,22)));
		
		this.INITIAL_POSITION = new Point(initialXPos, initialYPos);
		
		if (this.xPos++ == this.game.getGameCanvas().getWidth()) {
			this.xPos = this.INITIAL_POSITION.x;
			this.yPos++;
		}
	}
	
	/**
	 * Get the amount of point you win when this entity die
	 * @return The amount of point you win
	 */
	public int getReward() {
		return this.reward;
	}
	
	/**
	 * Get the entity lifePoints
	 * @return the life points left
	 */
	public int getLifePoints() {
		return this.lifePoints;
	}
	
	/**
	 * Hurt the entity by 1 damage
	 * Can kill the entity
	 */
	public void hurt() {
		this.lifePoints--;
		
		if (this.lifePoints == 0)
			this.die();
	}
	
	public void die() {
		//Ne plus l'affiché à l'écran et la retiré des entités enregistrée
	}
}