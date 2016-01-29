package spaceinvaders.entities.playerEntry;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import spaceinvaders.entities.Player;


public class PlayerCommande extends KeyAdapter{

	private Player player;
	
	//Constructor
	public PlayerCommande(Player player) {
		this.player = player;
	}
	
	//Method
	
	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}
	
	public void keyPressed(int keyCode){
		if(keyCode == KeyEvent.VK_SPACE)
			this.player.shoot();
	}

}
