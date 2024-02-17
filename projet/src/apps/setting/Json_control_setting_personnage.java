package apps.setting;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

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
            // si le fichier n'existe pas, créez un nouveau fichier JSON puis on le lit apres
            define_base_setting_personnage.define_perso_control();
            JsonReader reader = new JsonReader(new FileReader("projet\\src\\apps\\setting\\setting.json"));
            person = gson.fromJson(reader, setting_personnage[].class);
            reader.close();
        }
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


