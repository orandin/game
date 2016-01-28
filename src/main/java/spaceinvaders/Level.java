package spaceinvaders;

import gameframework.game.GameLevelDefaultImpl;
import spaceinvaders.Game.Game;
import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Ennemy;
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
		for (int i = 0; i < 5; i++) {
			Ennemy monster;
			
			if (i == 11 || i == 33)
				counter = 0;
			
			//rang 1
			if (i < 11) {
				monster = new Alien(this.game, counter * 24, 0, 3, 50);
				counter++;
			}
			//rang 2 & 3
			else if(i >= 11 && i < 32 ) {
				monster = new Alien(this.game, counter * 24, 22, 2, 30);
				counter++;
			}
			//rang 4 & 5
			else {
				monster = new Alien(this.game, counter * 24, 44, 1, 10);
				counter++;
			}
			
			super.universe.addGameEntity(monster);
		}
	}
}