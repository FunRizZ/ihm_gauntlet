package apps.setting;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import javafx.scene.input.KeyCode;

import java.io.FileWriter;

import java.io.FileReader;
import java.io.IOException;

/**
 * Json Class, uses for save
 */
public class JsonSetting {
    private static SettingPersonnage personnages[];
    private static settingScene settingsScene;  

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

        public static void reinitialize_setting_personnage() {
            Gson gson = new Gson();
            SettingPersonnage person1 = new SettingPersonnage(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.ENTER, KeyCode.F);
            SettingPersonnage person2 = new SettingPersonnage(KeyCode.Z, KeyCode.S, KeyCode.Q, KeyCode.D, KeyCode.A, KeyCode.W, KeyCode.E);
            SettingPersonnage person3 = new SettingPersonnage(KeyCode.Y, KeyCode.H, KeyCode.G, KeyCode.J, KeyCode.T, KeyCode.B, KeyCode.U);
            SettingPersonnage perso4 = new SettingPersonnage(KeyCode.O, KeyCode.L, KeyCode.K, KeyCode.N, KeyCode.I, KeyCode.N, KeyCode.P);
            SettingPersonnage[] pers = {person1, person2, person3, perso4};
            settingScene setti = new settingScene();
            personnages = pers;
            settingsScene = setti;

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
    
    public static SettingPersonnage[] getSetting() {
        if (personnages == null) {
            setup_setting();
            return personnages;
        }
        else {
            return personnages;
        }
    }
    public static SettingPersonnage getSetting(int i) {
        if (personnages == null) {
            setup_setting();
            return personnages[i];
        }
        else{
        return personnages[i];
        }
    }
    
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

    public static settingScene getSettingsScene() {
        if (settingsScene == null) {
            setup_setting();
            return settingsScene;
        }
        else {
            return settingsScene;
        }
    }
}


