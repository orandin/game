package spaceinvaders.entities.playerEntry;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import spaceinvaders.entities.Player;


public class PlayerCommande extends KeyAdapter{

	private Player player;
	
	/**
	 * Constructor
	 * @param player
	 */
	public PlayerCommande(Player player) {
		this.player = player;
	}
	
	/**
	 * Method that check the keys press by the player.
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}
	
	/**
	 * Method that allow a player to shoot if the right is press.
	 * @param keyCode
	 */
	public void keyPressed(int keyCode){
		if(keyCode == KeyEvent.VK_SPACE)
			this.player.shoot();
	}

}
