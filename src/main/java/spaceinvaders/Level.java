package spaceinvaders;


import java.awt.List;
import java.lang.reflect.Array;
import java.util.Arrays;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.SmallAlien;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

/**
 * @author Kévin Rico
 * @author Simon Delberghe
 *
 */
public class Level extends GameLevelDefaultImpl {
	
	private static final int NB_CELLS = 11;
	private static final int NB_ROWS  = 5;
	private EnemiesArray enemiesArray;
	/**
	 * Constructor
	 * @param gameData
	 * @param view
	 */
	public Level(GameData gameData, GameUniverseViewPort view){
		super(gameData);
		super.gameBoard = view;
		this.enemiesArray = new EnemiesArray(gameData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {
		Enemies enemy;
		Player player = new Player(super.data);
		
		data.getUniverse().addGameEntity(new LeftWall(data));
		data.getUniverse().addGameEntity(new RightWall(data));
		data.getUniverse().addGameEntity(player);

		int posX = super.spriteSize * 5;
		int posY = posX;

		for(int row = 1; row <= NB_ROWS; row++){
			for(int cell = 1; cell <= NB_CELLS; cell++){
				enemy = rulesToCreateEnemy(row, posX, posY);
				this.enemiesArray.add(enemy);
				if(cell == NB_CELLS)
					posY += enemy.getImage().getHeight();
				else
					posX += enemy.getImage().getWidth();
			}
			posX = super.spriteSize * 5;
		}
		
	}

	public EnemiesArray getEnemiesArray(){
		return this.enemiesArray;
	}
	
	/**
	 * Defines the rules to create an enemy by row
	 * @param row
	 * @param posX
	 * @param posY
	 * @return Returns the enemy created
	 */
	protected Enemies rulesToCreateEnemy(int row, int posX, int posY) {
		switch(row) {
			case 1:
				return new LargeAlien(super.data, posX, posY, this);

			case 2:
			case 3:
				return new MediumAlien(super.data, posX, posY, this);
		}
		return new SmallAlien(super.data, posX, posY, this);
	}
}
