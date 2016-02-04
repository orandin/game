package spaceinvaders.entities.playerEntry;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import spaceinvaders.entities.Player;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class PlayerCommande extends KeyAdapter {

	private Player player;
	
	/**
	 * Create a PlayerCommande
	 * @param player
	 * 		The player
	 */
	public PlayerCommande(Player player) {
		this.player = player;
	}
	
	/* ----- Actions ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}
	
	/**
	 * The player shoot if the pressed key is the space bar
	 * @param keyCode
	 */
	public void keyPressed(int keyCode){
		if(keyCode == KeyEvent.VK_SPACE)
			this.player.shoot();
	}
}
