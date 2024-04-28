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

/**
 * Class representing the Scoreboard
 */
public class Scoreboard {
    /**
     * Class representing a Score
     */
    public static class Score {
        String player;
        int score;
        LocalDate date;

        /**
         * Constructor for Score
         * @param player The name of the player
         * @param score The score achieved by the player
         * @param date The date when the score was achieved
         */
        public Score(String player, int score, LocalDate date) {
            this.player = player;
            this.score = score;
            this.date = date;
        }

        /**
         * Getter for player
         * @return The name of the player
         */
        public String getPlayer() {
            return player;
        }

        /**
         * Getter for score
         * @return The score achieved by the player
         */
        public Integer getScore() {
            return score;
        }

        /**
         * Getter for date
         * @return The date when the score was achieved
         */
        public LocalDate getDate() {
            return date;
        }
    }

    private static List<Score> scores = new ArrayList<>();

    /**
     * Method to add a score to the scoreboard
     * @param player The name of the player
     * @param score The score achieved by the player
     * @param date The date when the score was achieved
     */
    public static void addScore(String player, int score, LocalDate date) {
        if (scores.isEmpty()) {
            loadScoresFromFile();
        }
        scores.add(new Score(player, score, date));
        // Sort scores in descending order
        scores.sort(Comparator.comparing(Score::getScore).reversed());
        saveScoresToFile();
    }

    /**
     * Getter for scores
     * @return The list of scores
     */
    public static List<Score> getScores() {
        if (scores.isEmpty()) {
            loadScoresFromFile();
        }
        return scores;
    }

    /**
     * Method to save scores to a file
     */
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

    /**
     * Method to load scores from a file
     */
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