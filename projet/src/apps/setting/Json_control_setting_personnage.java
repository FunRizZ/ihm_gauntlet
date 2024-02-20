package apps.setting;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import javafx.scene.input.KeyCode;

import java.io.FileWriter;

import java.io.FileReader;
import java.io.IOException;

public class Json_control_setting_personnage {
    private static setting_personnage person[];
    private static settingScene settingsScene;

    public Json_control_setting_personnage() {
        Gson gson = new Gson();

        try {
            // lire le fichier JSON existant
            JsonReader reader = new JsonReader(new FileReader("projet\\src\\apps\\setting\\setting.json"));
            person = gson.fromJson(reader, setting_personnage[].class);
            settingsScene = gson.fromJson(reader, settingScene.class);
            reader.close();

        } catch (IOException e) {
            // si le fichier n'existe pas, créez un nouveau fichier
            try {
                reinitialize_setting_personnage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }  

        public void reinitialize_setting_personnage() throws IOException{
        Gson gson = new Gson();
            setting_personnage person1 = new setting_personnage(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.ENTER, KeyCode.F);
            setting_personnage person2 = new setting_personnage(KeyCode.Z, KeyCode.S, KeyCode.Q, KeyCode.D, KeyCode.A, KeyCode.W, KeyCode.E);
            setting_personnage person3 = new setting_personnage(KeyCode.Y, KeyCode.H, KeyCode.G, KeyCode.J, KeyCode.T, KeyCode.B, KeyCode.U);
            setting_personnage perso4 = new setting_personnage(KeyCode.O, KeyCode.L, KeyCode.K, KeyCode.N, KeyCode.I, KeyCode.N, KeyCode.P);
            setting_personnage[] pers = {person1, person2, person3, perso4};
            settingScene setti = new settingScene();
            person = pers;
            settingsScene = setti;
            JsonWriter writer = new JsonWriter(new FileWriter("projet\\src\\apps\\setting\\setting.json"));
            writer.beginArray(); // commence le tableau
            for (setting_personnage p : pers) 
            {
                gson.toJson(p, setting_personnage.class, writer);
            }
            writer.endArray(); // termine le tableau
            gson.toJson(setti, settingScene.class, writer);
            writer.close();
        }
    
    public setting_personnage[] getPerson() {
        return person;
    }
    public setting_personnage getPerson(int i) {
        return person[i];
    }
    
    public static void save_control() {
        Gson gson = new Gson();
        try {
            JsonWriter writer = new JsonWriter(new FileWriter("projet\\src\\apps\\setting\\setting.json"));
            writer.beginArray(); // commence le tableau
            for (setting_personnage p : person) {
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
    public settingScene getSettingsScene() {
        return settingsScene;
    }
}


