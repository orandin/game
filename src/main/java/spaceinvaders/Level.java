package spaceinvaders;

import gameframework.game.GameLevelDefaultImpl;
import spaceinvaders.Game.Game;
import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Player;

public class Level extends GameLevelDefaultImpl {
	
	private Game game;
	
	public Level(Game game) {
		super(game.getData());
		this.game = game;
		this.gameBoard = game.getUniverseViewPort();
	}

	@Override
	protected void init() {
		
		//Permet le positionnement de chaque Alien
		int counter = 0;
		
		//ajout du joueur
		super.universe.addGameEntity(new Player(this.game));
		//ajout des monstres
		for (int i = 0; i < 55; i++) {
			
			int xPos = counter * 24;
			int yPos;
			int lifePoints;
			int reward;
			
			if (i == 11 || i == 33)
				counter = 0;
			
			//rang 1
			if (i < 11) {
				yPos = 0;
				lifePoints = 3;
				reward = 50;
			}
			//rang 2 & 3
			else if(i >= 11 && i < 32 ) {
				yPos = 22;
				lifePoints = 2;
				reward = 30;
			}
			//rang 4 & 5
			else {
				yPos = 44;
				lifePoints = 1;
				reward = 10;
			}
			
			counter++;
			
			super.universe.addGameEntity(new Alien(this.game, xPos, yPos, lifePoints, reward));
		}
	}
}