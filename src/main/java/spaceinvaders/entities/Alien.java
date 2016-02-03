package spaceinvaders.entities;

import spaceinvaders.Level;
import gameframework.game.GameData;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class Alien extends Enemies {
	
	public Alien(GameData data,int posX, int posY, Level lvl){
		super(data, posX, posY, lvl);
	}
	
}
