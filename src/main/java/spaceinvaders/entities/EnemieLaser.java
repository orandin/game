package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

public class EnemieLaser extends Laser{

	private Enemies enemies;
	
	public EnemieLaser(GameData data , Enemies enemie) {
		super(data, enemie);
		super.position = new Point((enemie.getPosition().x + enemie.image.getWidth() / 2), (enemie.getPosition().y + enemie.image.getHeight())- 2);
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize())));
		this.enemies = enemie;
	}

	@Override
	public Shooter getShooter() {
		return this.enemies;
	}

}
