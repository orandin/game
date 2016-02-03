package spaceinvaders;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;
import spaceinvaders.entities.Enemies;

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
	private final Enemies[][] enemiesArray = new Enemies[5][11];
	private int nbEnemies = 0;
	
	/**
	 * Constructor
	 * @param data : data game
	 */
	public EnemiesArray(GameData data) {
		this.data = data;
	}

	//Getter
	
	/**
	 * 
	 * @param enemy : the enemy which search in the enemies array
	 * @return the postion of this enemy in the array
	 */
	public Point getEnemiesPositionInArray(Enemies enemy){
		Point p = null;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 11 ; j++){
				if(enemy.equals(this.enemiesArray[i][j])){
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
	 * method to add an enemy in the enemies array
	 * @param enemy : he enemy which want to be add in the array
	 */
	public void add(Enemies enemy){
		if(this.nbEnemies < 55){
			this.enemiesArray[this.y][this.x] = enemy;
			this.data.getUniverse().addGameEntity(enemy);
			this.nbEnemies++;
			if(this.x == 10){
				this.x = 0;
				this.y ++;
			}
			else{
				this.x ++;
			}
		}
	}
	
	/**
	 * method for remove an enemy in the enemies array (replace by <code>null</code>)
	 * @param enemy : the enemy which want to be remove
	 */
	public void remove(Enemies enemy){
		Point p = getEnemiesPositionInArray(enemy);
		this.enemiesArray[p.y][p.x] = null;
		this.nbEnemies --;
		this.data.getUniverse().removeGameEntity(enemy);
	}
	
	/**
	 * method for know if an enemy is well placed for shoot
	 * @param enemy : the enemy which want to shoot
	 * @return <code>true</code> true if he can <code>false</code> else
	 */
	public boolean EnemieCanShoot(Enemies enemy){
		try{
			Point p = getEnemiesPositionInArray(enemy);
			return this.enemiesArray[p.y + 1][p.x] == null;
		} catch (IndexOutOfBoundsException e){
			return true;
		}
	}
	
	// pas encore sur pour cette methode elle sert a inverser la strategy de déplacement pour tout les enemies 
	public void ReverseMoveStrategyForAll(MoveStrategyStraightLine line){
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 11 ; j++){
				if(this.enemiesArray[i][j] != null){
					Enemies alien = this.enemiesArray[i][j];
					alien.getPosition().y += alien.getImage().getHeight();
					alien.getDriver().setStrategy(line);
				}
			}
		}
	}
}
