/**
 * 
 */
package spaceinvaders.entities;

import spaceinvaders.Level;
import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 *
 */
public abstract class Alien extends Enemies {
	
	public Alien(GameData data,int posX, int posY, Level lvl){
		super(data, posX, posY, lvl);
		super.image = new DrawableImage(getUriImage(), super.data.getCanvas());
		super.point = score();
	}
	
	protected abstract String getUriImage();
	
	protected abstract int score();
}
