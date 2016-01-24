package spaceinvaders;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Enemys;
import spaceinvaders.entities.Player;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level extends GameLevelDefaultImpl{
	
	public Level(GameData gameData){
		super(gameData);
	}

	@Override
	protected void init() {
		//ajout du joueur
		super.universe.addGameEntity(new Player("Test"));
		//ajout des monstres
		for(int i=1; i<= 55 ; i++){
			Enemys monster;
			if(i <= 11) //rangee 1
				monster = new Alien(40);
			if(i > 11 && i <= 33 ) // rangee 2 et 3 
				monster = new Alien(20);
			else // rangee 4 et 5
				monster = new Alien();
			super.universe.addGameEntity(monster);
		}		
	}


}
