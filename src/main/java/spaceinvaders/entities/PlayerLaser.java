package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

public class PlayerLaser extends Laser{

	private Player player;
	
	public PlayerLaser(GameData data, Player player) {
		super(data, player);
		this.player = player;
		super.position = new Point((player.getPosition().x + player.image.getWidth() / 2) -2, (player.getPosition().y - player.image.getHeight() / 2) -2);
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(super.position.x, 0)));
	}

	public Player getShooter(){
		return this.player;
	}
}
