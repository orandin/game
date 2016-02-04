package spaceinvaders.entities;

import java.awt.Point;

import spaceinvaders.Level;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.blocking.MoveBlocker;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class Alien extends EnemiesShooter  implements MoveBlocker{

	public Alien(GameData data,int posX, int posY, Level lvl){
		super(data, posX, posY, lvl);
		moveDriver.setStrategy(new MoveStrategyStraightLine(position, new Point(data.getConfiguration().getNbColumns() * data.getConfiguration().getSpriteSize() , position.y)));
	}
	/* ----- Method ----- */

	/**
	 * action to do after a move
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		if(canShoot())
			shoot();
	}
}
