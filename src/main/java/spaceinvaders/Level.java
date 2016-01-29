package spaceinvaders;

import spaceinvaders.entities.Alien1;
import spaceinvaders.entities.Alien2;
import spaceinvaders.entities.Alien3;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level extends GameLevelDefaultImpl{
	
	public Level(GameData gameData, GameUniverseViewPort view){
		super(gameData);
		super.gameBoard = view;
	}

	@Override
	protected void init() {
		
		data.getUniverse().addGameEntity(new LeftWall(data));
		data.getUniverse().addGameEntity(new RightWall(data));
		
		// We add the player
		Player p = new Player(super.data);
		data.getUniverse().addGameEntity(p);
		
		// We add monsters
		int posX = super.spriteSize * 5;
		int posY = super.spriteSize * 5;
		
		for(int i= 1; i<= 5; i++){
			for(int j= 1 ; j<= 11; j++){
				Enemies alien;
				if(i == 1){
					alien = new Alien3(super.data,posX,posY);
				}
				if(i == 2 || i == 3){
					alien = new Alien2(super.data,posX,posY);
				}
				else{
					alien = new Alien1(super.data,posX,posY);
				}
				super.data.getUniverse().addGameEntity(alien);
				
				if(j == 11)
					posY += alien.getImage().getHeight();
				
				posX += alien.getImage().getWidth();
			}
			posX = super.spriteSize * 5;
		}		
	}

}
