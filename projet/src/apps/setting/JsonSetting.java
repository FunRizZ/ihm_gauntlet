package apps.setting;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import javafx.scene.input.KeyCode;

import java.io.FileWriter;

import java.io.FileReader;
import java.io.IOException;

public class JsonSetting {
    private static setting_personnage personnages[];
    private static settingScene settingsScene;  

    private static void setup_setting() {
            try {
                JsonReader reader = new JsonReader(new FileReader("./src/apps/setting/setting.json"));
                Gson gson = new Gson();
                personnages = gson.fromJson(reader, setting_personnage[].class);
                settingsScene = gson.fromJson(reader, settingScene.class);
                reader.close();
            } catch (IOException e) {
                reinitialize_setting_personnage();
            }
        }

        private static void reinitialize_setting_personnage() {
            Gson gson = new Gson();
            setting_personnage person1 = new setting_personnage(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.ENTER, KeyCode.F);
            setting_personnage person2 = new setting_personnage(KeyCode.Z, KeyCode.S, KeyCode.Q, KeyCode.D, KeyCode.A, KeyCode.W, KeyCode.E);
            setting_personnage person3 = new setting_personnage(KeyCode.Y, KeyCode.H, KeyCode.G, KeyCode.J, KeyCode.T, KeyCode.B, KeyCode.U);
            setting_personnage perso4 = new setting_personnage(KeyCode.O, KeyCode.L, KeyCode.K, KeyCode.N, KeyCode.I, KeyCode.N, KeyCode.P);
            setting_personnage[] pers = {person1, person2, person3, perso4};
            settingScene setti = new settingScene();
            personnages = pers;
            settingsScene = setti;
            JsonWriter writer;
            try {
                writer = new JsonWriter(new FileWriter("./src/apps/setting/setting.json"));
                writer.beginArray(); // commence le tableau
                for (setting_personnage p : pers)
                {
                    gson.toJson(p, setting_personnage.class, writer);
                }
                writer.endArray(); // termine le tableau
                gson.toJson(setti, settingScene.class, writer);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    public static setting_personnage[] getPersonnages() {
        if (personnages == null) {
            setup_setting();
            return personnages;
        }
        else {
            return personnages;
        }
    }
    public static setting_personnage getPersonnage(int i) {
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
            JsonWriter writer = new JsonWriter(new FileWriter("./src/apps/setting/setting.json"));
            writer.beginArray(); // commence le tableau
            for (setting_personnage p : personnages) {
                gson.toJson(p, setting_personnage.class, writer);
            }
            writer.endArray(); // termine le tableau
            gson.toJson(settingsScene, settingScene.class, writer);
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


