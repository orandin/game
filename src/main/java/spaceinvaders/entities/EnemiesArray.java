package spaceinvaders.entities;

import gameframework.game.GameData;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class EnemiesArray extends EntiteMovable {
	
	protected final Enemy[][] enemyArray = new Enemy[11][5];
	protected double xPos = 0;
	protected int yPos = 0;
	protected int sign = 1;
	protected double speed = 0.05;
	
	/**
	 * Create the array witch set in movement all enemies
	 * @param data	The game data
	 */
	public EnemiesArray(GameData data) {
		super(data);
		super.setPosition(new Point(0, 0));
		
		//Creating all enemies
		for (int i = 0; i < enemyArray.length; i++) {
			for (int j = 0; j < enemyArray[0].length; j++) {
				
				Enemy enemy = rulesToCreateEnemy(j, i, j);
				enemyArray[i][j] = enemy;
				data.getUniverse().addGameEntity(enemy);	
			}
		}
	}

	/**
	 * This entity have no bounding box, the player can't collide with it
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(0, 0, 0, 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSprite() {
		return "";
	}

	/**
	 * Remove an enemy by set it to null
	 * @param position	The position in array, x is row, y is column
	 */
	public void removeEnemyFromPosition(Point position) {
		enemyArray[(int) position.getX()][(int) position.getY()] = null;
	}

	/**
	 * Increase the speed by 0.002
	 */
	public void increaseSpeed() {
		speed += 0.002;
	}

	/**
	 * Check if all enemies are dead
	 * @return {@code true} if are, {@code false} else
	 */
	public boolean checkAllDead() {
		
		int maxEntities = enemyArray.length * enemyArray[0].length;
		int killedEntities = 0;
		
		for (int i = 0; i < enemyArray.length; i++) {
			for (int j = 0; j < enemyArray[0].length; j++) {
				if (enemyArray[i][j] == null)
					killedEntities++;
			}
		}

		return maxEntities == killedEntities;
	}

	/**
	 * Defines the rules to create an enemy by row
	 * @param row The enemy row in the game
	 * @param posX The enemy initial X position
	 * @param posY	The enemy initial X position
	 * @return An enemy
	 */
	protected abstract Enemy rulesToCreateEnemy(int row, int posX, int posY);
}
