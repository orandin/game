package spaceinvaders;

import java.awt.Point;

import gameframework.game.GameData;
import spaceinvaders.entities.Enemies;

public class EnemiesArray {

	private GameData data;
	private int x = 0;
	private int y = 0;
	private final Enemies[][] enemiesArray = new Enemies[5][11];
	private int nbEnemies = 0;
	
	public EnemiesArray(GameData data) {
		this.data = data;
	}

	public Point getEnemiesPositionInArray(Enemies enemie){
		Point p = null;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 11 ; j++){
				if(enemie.equals(this.enemiesArray[i][j])){
					p = new Point(j, i);
					break;
				}
			}
			if(p != null)
				break;
		}
		return p;
	}
	
	public void add(Enemies enemie){
		if(this.nbEnemies < 55){
			this.enemiesArray[this.y][this.x] = enemie;
			this.data.getUniverse().addGameEntity(enemie);
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
	
	public void remove(Enemies enemie){
		Point p = getEnemiesPositionInArray(enemie);
		this.enemiesArray[p.y][p.x] = null;
		this.nbEnemies --;
		this.data.getUniverse().removeGameEntity(enemie);
	}
	
	public boolean EnemieCanShoot(Enemies enemie){
		try{
			Point p = getEnemiesPositionInArray(enemie);
			return this.enemiesArray[p.y + 1][p.x] == null;
		} catch (IndexOutOfBoundsException e){
			return true;
		}
	}
	
}
