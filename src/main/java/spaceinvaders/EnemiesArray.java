package spaceinvaders;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

import java.awt.Point;

import spaceinvaders.entities.Enemy;

/**
 * this class represent enemies array, all the enemies present in the level
 * @author Rico Kevin
 *
 */
public class EnemiesArray {

	/**
	 * this class had 5 attributes
	 * - data : the game data
	 * - x : actual position x in array
	 * - y : actual position y in array
	 * (x and y are incremented automatically)
	 * - enemiesArray : the enemies array
	 * - nbEnemies : the number of enemy present in the game (incremented and decremented automatically)
	 */
	private GameData data;
	private int x = 0;
	private int y = 0;
	private final Enemy[][] enemiesArray = new Enemy[5][11];
	private int nbEnemies = 0;

	/**
	 * Constructor
	 * @param data : data game
	 */
	public EnemiesArray(GameData gameData) {
		data = gameData;
	}

	/**
	 * 
	 * @param enemy : the enemy which search in the enemies array
	 * @return the position of this enemy in the array
	 */
	public Point getEnemiesPositionInArray(Enemy enemy){
		Point p = null;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 11 ; j++){
				if(enemy.equals(enemiesArray[i][j])){
					p = new Point(j, i);
					break;
				}
			}
			if(p != null)
				break;
		}
		return p;
	}

	/**
	 * method for know if an enemy is well placed for shoot
	 * @param enemy : the enemy which want to shoot
	 * @return <code>true</code> true if he can <code>false</code> else
	 */
	public boolean EnemieCanShoot(Enemy enemy){
		try{
			Point p = getEnemiesPositionInArray(enemy);
			return enemiesArray[p.y + 1][p.x] == null;
		} catch (IndexOutOfBoundsException e){
			return true;
		}
	}

	/**
	 * method to add an enemy in the enemies array
	 * @param enemy : he enemy which want to be add in the array
	 */
	public void add(Enemy enemy){
		if(nbEnemies < 55){
			enemiesArray[y][x] = enemy;
			data.getUniverse().addGameEntity(enemy);
			nbEnemies++;
			if(x == 10){
				x = 0;
				y ++;
			}
			else{
				x ++;
			}
		}
	}

	/**
	 * method for remove an enemy in the enemies array (replace by <code>null</code>)
	 * @param enemy : the enemy which want to be remove
	 */
	public void remove(Enemy enemy){
		Point p = getEnemiesPositionInArray(enemy);
		enemiesArray[p.y][p.x] = null;
		nbEnemies --;
		data.getUniverse().removeGameEntity(enemy);
	}

	// pas encore sur pour cette methode elle sert a inverser la strategy de déplacement pour tout les enemies 
	public void ReverseMoveStrategyForAll(MoveStrategyStraightLine line){
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 11 ; j++){
				if(enemiesArray[i][j] != null){
					Enemy alien = enemiesArray[i][j];
					alien.getPosition().y += alien.getImage().getHeight();
					alien.getDriver().setStrategy(line);
				}
			}
		}
	}
}
