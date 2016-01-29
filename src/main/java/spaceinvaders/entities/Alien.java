package spaceinvaders.entities;

import gameframework.game.GameData;

public abstract class Alien extends Enemys {
	//Constructor
	public int point;
	
	public Alien(GameData data,int posX, int posY){
		super(data,posX, posY);
	}
}
