package apps.setting;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import javafx.scene.input.KeyCode;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * JsonSetting class, used for saving settings
 */
public class JsonSetting {
    private static SettingPersonnage personnages[];
    private static settingScene settingsScene;  

    /**
     * Method to setup settings from a JSON file
     */
    private static void setup_setting() {
        try {
            JsonReader reader = new JsonReader(new FileReader("./save/setting.json"));
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            personnages = gson.fromJson(jsonObject.get("personnages"), SettingPersonnage[].class);
            settingsScene = gson.fromJson(jsonObject.get("settingsScene"), settingScene.class);
            reader.close();
        } catch (IOException e) {
            reinitialize_setting_personnage();
        }
    }

    /**
     * Method to reinitialize settings for characters
     */
    public static void reinitialize_setting_personnage() {
        Gson gson = new Gson();
        // Initialize settings for each character
        // ...
        // Save settings to a JSON file
        try {
            FileWriter writer = new FileWriter("./save/setting.json");
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("personnages", gson.toJsonTree(personnages, SettingPersonnage[].class));
            jsonObject.add("settingsScene", gson.toJsonTree(settingsScene, settingScene.class));
            gson.toJson(jsonObject, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Getter for settings
     * @return The settings for all characters
     */
    public static SettingPersonnage[] getSetting() {
        if (personnages == null) {
            setup_setting();
        }
        return personnages;
    }

    /**
     * Getter for settings
     * @param i The index of the character
     * @return The settings for the character at index i
     */
    public static SettingPersonnage getSetting(int i) {
        if (personnages == null) {
            setup_setting();
        }
        return personnages[i];
    }
    
    /**
     * Method to save control settings to a JSON file
     */
    public static void save_control() {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter("./save/setting.json");
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("personnages", gson.toJsonTree(personnages, SettingPersonnage[].class));
            jsonObject.add("settingsScene", gson.toJsonTree(settingsScene, settingScene.class));
            gson.toJson(jsonObject, writer);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Getter for scene settings
     * @return The scene settings
     */
    public static settingScene getSettingsScene() {
        if (settingsScene == null) {
            setup_setting();
        }
        return settingsScene;
    }
}