package apps.setting;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import javafx.scene.input.KeyCode;


public class define_base_setting_personnage {
    public static void define_perso_control() {
        // Créez un objet
                Gson gson = new Gson();
                setting_personnage person = new setting_personnage(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.ENTER, KeyCode.F);
                setting_personnage person2 = new setting_personnage(KeyCode.Z, KeyCode.S, KeyCode.Q, KeyCode.D, KeyCode.A, KeyCode.W, KeyCode.E);
                setting_personnage person3 = new setting_personnage(KeyCode.Y, KeyCode.H, KeyCode.G, KeyCode.J, KeyCode.T, KeyCode.B, KeyCode.U);
                setting_personnage perso4 = new setting_personnage(KeyCode.O, KeyCode.L, KeyCode.K, KeyCode.N, KeyCode.I, KeyCode.N, KeyCode.P);
                setting_personnage[] pers = {person, person2, person3, perso4};
        try {
            JsonWriter writer = new JsonWriter(new FileWriter("projet\\src\\apps\\setting\\setting.json"));
            writer.beginArray(); // commence le tableau
            for (setting_personnage p : pers) {
                gson.toJson(p, setting_personnage.class, writer);
            }
            writer.endArray(); // termine le tableau
            writer.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
