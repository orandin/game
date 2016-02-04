package spaceinvaders;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

import java.awt.Point;

import spaceinvaders.entities.EnemiesShooter;

/**
 * this class represent enemies array, all the enemies present in the level
 * @author Rico Kevin
 *
 */
public class EnemiesArray {

	/* ----- Attributes ----- */

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
	private final EnemiesShooter[][] enemiesArray = new EnemiesShooter[5][11];
	private int nbEnemies = 0;

	/* ----- Constructor ----- */

	/**
	 * Constructor
	 * @param data : data game
	 */
	public EnemiesArray(GameData gameData) {
		data = gameData;
	}

	/* ----- Getter ----- */

	/**
	 * 
	 * @param enemy : the enemy which search in the enemies array
	 * @return the position of this enemy in the array
	 */
	public Point getEnemiesPositionInArray(EnemiesShooter enemy){
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
	public boolean EnemieCanShoot(EnemiesShooter enemy){
		try{
			Point p = getEnemiesPositionInArray(enemy);
			return enemiesArray[p.y + 1][p.x] == null;
		} catch (IndexOutOfBoundsException e){
			return true;
		}
	}

	/**
	 * getter for know if all enemies are dead
	 * @return <code>true</code> if all enemies are dead <code>false</code> else
	 */
	public boolean allDead(){
		return nbEnemies == 0;
	}
	
	/* ----- Methods ----- */

	/**
	 * method to add an enemy in the enemies array
	 * @param enemy : he enemy which want to be add in the array
	 */
	public void add(EnemiesShooter enemy){
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
	public void remove(EnemiesShooter enemy){
		Point p = getEnemiesPositionInArray(enemy);
		enemiesArray[p.y][p.x] = null;
		nbEnemies --;
		data.getUniverse().removeGameEntity(enemy);
	}

	// pas encore sur pour cette methode elle sert a inverser la strategy de déplacement pour tout les enemies 
	public void ReverseMoveStrategyForAll(int nextGoal){
			for(int i = 0 ; i < 5 ; i++){
				for(int j = 0 ; j < 11 ; j++){
					if(enemiesArray[i][j] != null){
						EnemiesShooter alien = enemiesArray[i][j];
						alien.getPosition().y += 10;
						alien.getDriver().setStrategy(new MoveStrategyStraightLine(alien.getPosition(), new Point(nextGoal, alien.getPosition(). y)));
				}
			}
		}
	}
}