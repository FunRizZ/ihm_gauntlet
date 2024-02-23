package apps.setting;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;

public class setting_personnage {
    private Map<String, KeyCode> keySettings = new HashMap<>();

    public setting_personnage(KeyCode UP, KeyCode DOWN, KeyCode LEFT, KeyCode RIGHT, KeyCode Attack, KeyCode Bomb, KeyCode Resurec) {
        keySettings.put("UP", UP);
        keySettings.put("DOWN", DOWN);
        keySettings.put("LEFT", LEFT);
        keySettings.put("RIGHT", RIGHT);
        keySettings.put("Attack", Attack);
        keySettings.put("Bomb", Bomb);
        keySettings.put("Resurec", Resurec);
    }

    public void setKey(String action, KeyCode key) {
        keySettings.put(action, key);
    }

    public KeyCode getKey(String action) {
        return keySettings.get(action);
    }

    public String getKeyString(KeyCode Key) {
        for (Map.Entry<String, KeyCode> entry : keySettings.entrySet()) {
            if (entry.getValue() == Key) {
                return entry.getKey();
            }
        }
        return null;
    }
}