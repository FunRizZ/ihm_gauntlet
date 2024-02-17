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
    public static void main(String[] args) throws IOException {
        Json_control_setting_personnage j = new Json_control_setting_personnage();
        j.print();
    }

    public Json_control_setting_personnage() throws IOException{
        Gson gson = new Gson();

        try {
            // lire le fichier JSON existant
            JsonReader reader = new JsonReader(new FileReader("projet\\src\\apps\\setting\\setting.json"));
            person = gson.fromJson(reader, setting_personnage[].class);
            reader.close();

        } catch (IOException e) {
            // si le fichier n'existe pas, créez un nouveau fichier
            reinitialize_setting_personnage();
        }
    }  

        public void reinitialize_setting_personnage() throws IOException{
        Gson gson = new Gson();
            setting_personnage person1 = new setting_personnage(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, KeyCode.ENTER, KeyCode.F);
            setting_personnage person2 = new setting_personnage(KeyCode.Z, KeyCode.S, KeyCode.Q, KeyCode.D, KeyCode.A, KeyCode.W, KeyCode.E);
            setting_personnage person3 = new setting_personnage(KeyCode.Y, KeyCode.H, KeyCode.G, KeyCode.J, KeyCode.T, KeyCode.B, KeyCode.U);
            setting_personnage perso4 = new setting_personnage(KeyCode.O, KeyCode.L, KeyCode.K, KeyCode.N, KeyCode.I, KeyCode.N, KeyCode.P);
            setting_personnage[] pers = {person1, person2, person3, perso4};
            person = pers;
            JsonWriter writer = new JsonWriter(new FileWriter("projet\\src\\apps\\setting\\setting.json"));
            writer.beginArray(); // commence le tableau
            for (setting_personnage p : pers) 
            {
                gson.toJson(p, setting_personnage.class, writer);
            }
            writer.endArray(); // termine le tableau
            writer.close();
        }

    public void print() {
        for (setting_personnage p : person) {
            System.out.println("avancer "+p.getUP());
            System.out.println("reculer "+p.getDOWN());
            System.out.println("gauche "+p.getLEFT());
            System.out.println("droite "+p.getRIGHT());
            System.out.println("attack "+p.getAttack());
            System.out.println("bomb "+p.getBomb());
            System.out.println("resurection "+p.getResurec());
            System.out.println();
        }
    }
    
    public static setting_personnage[] getPerson() {
        return person;
    }
    public static setting_personnage getPerson(int i) {
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
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


