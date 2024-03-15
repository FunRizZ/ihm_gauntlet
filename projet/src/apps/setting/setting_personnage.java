package apps.setting;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;

/**
 * Class for the settings characters
 */
public class setting_personnage {
    private Map<String, KeyCode> keySettings = new HashMap<>();

    /**
     * Settings of the characters
     * @param UP go straight ahead
     * @param DOWN go back
     * @param LEFT go left
     * @param RIGHT go right
     * @param Attack attack
     * @param Bomb lauch a bomb
     * @param Resurec resurection
     */
    public setting_personnage(KeyCode UP, KeyCode DOWN, KeyCode LEFT, KeyCode RIGHT, KeyCode Attack, KeyCode Bomb, KeyCode Resurec) {
        keySettings.put("UP", UP);
        keySettings.put("DOWN", DOWN);
        keySettings.put("LEFT", LEFT);
        keySettings.put("RIGHT", RIGHT);
        keySettings.put("Attack", Attack);
        keySettings.put("Bomb", Bomb);
        keySettings.put("Resurec", Resurec);
    }

    /**
     * Set key with an action
     * @param action action associated
     * @param key key associated
     */
    public void setKey(String action, KeyCode key) {
        keySettings.put(action, key);
    }

    /**
     * Get the key in association of the specific action
     * @param action action associated
     * @return The key associated
     */
    public KeyCode getKey(String action) {
        return keySettings.get(action);
    }

    /**
     * Get the string of the given key
     * @param Key key
     * @return The associated string of the key
     */
    public String getKeyString(KeyCode Key) {
        for (Map.Entry<String, KeyCode> entry : keySettings.entrySet()) {
            if (entry.getValue() == Key) {
                return entry.getKey();
            }
        }
        return null;
    }
}