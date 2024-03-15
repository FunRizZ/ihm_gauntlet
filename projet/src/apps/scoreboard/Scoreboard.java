package apps.scoreboard;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//TODO Faire la doc (Ambroise)
public class Scoreboard {
    public static class Score {
        String player;
        int score;
        LocalDate date;

        public Score(String player, int score, LocalDate date) {
            this.player = player;
            this.score = score;
            this.date = date;
        }
        public String getPlayer() {
            return player;
        }
    
        public Integer getScore() {
            return score;
        }
    
        public LocalDate getDate() {
            return date;
        }
    }

    private static List<Score> scores = new ArrayList<>();

    public static void addScore(String player, int score, LocalDate date) {
        if (scores.isEmpty()) {
            loadScoresFromFile();
        }
        scores.add(new Score(player, score, date));
        // Trier les scores en ordre décroissant
        scores.sort(Comparator.comparing(Score::getScore).reversed());
        saveScoresToFile();
    }

    public static List<Score> getScores() {
        if (scores.isEmpty()) {
            loadScoresFromFile();
        }
        return scores;
    }

    private static void saveScoresToFile() {
        try (JsonWriter writer = new JsonWriter(new FileWriter("./save/Score.json"))) {
            writer.beginArray();
            for (Score score : scores) {
                writer.beginObject();
                writer.name("player").value(score.player);
                writer.name("score").value(score.score);
                writer.name("date").value(score.date.toString());
                writer.endObject();
            }
            writer.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadScoresFromFile() {
        try (JsonReader reader = new JsonReader(new FileReader("./save/Score.json"))) {
            reader.beginArray();
            while (reader.hasNext()) {
                reader.beginObject();
                String player = "";
                int score = 0;
                LocalDate date = null;
                while (reader.hasNext()) {
                    switch (reader.nextName()) {
                        case "player":
                            player = reader.nextString();
                            break;
                        case "score":
                            score = reader.nextInt();
                            break;
                        case "date":
                            date = LocalDate.parse(reader.nextString());
                            break;
                    }
                }
                reader.endObject();
                scores.add(new Score(player, score, date));
            }
            reader.endArray();
        } catch (IOException e) {
            saveScoresToFile();
            loadScoresFromFile();
        }
    }
}