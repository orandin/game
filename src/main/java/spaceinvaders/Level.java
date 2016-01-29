package spaceinvaders;

import spaceinvaders.entities.SmallAlien;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;
import gameframework.drawing.GameUniverseViewPort;
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

	/**
	 * Constructor
	 * @param gameData
	 * @param view
	 */
	public Level(GameData gameData, GameUniverseViewPort view){
		super(gameData);
		super.gameBoard = view;
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
				super.data.getUniverse().addGameEntity(enemy);
				if(cell == NB_CELLS)
					posY += enemy.getImage().getHeight();
				else
					posX += enemy.getImage().getWidth();
			}
			posX = super.spriteSize * 5;
		}		
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
				return new LargeAlien(super.data, posX, posY);

			case 2:
			case 3:
				return new MediumAlien(super.data, posX, posY);
		}
		return new SmallAlien(super.data, posX, posY);
	}
}
