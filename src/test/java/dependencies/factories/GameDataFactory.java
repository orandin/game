/**
 * 
 */
package dependencies.factories;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 *
 */
public class GameDataFactory {

	public GameData createDefaultGameData() {
		return new GameData(new GameConfiguration());
	}
}
