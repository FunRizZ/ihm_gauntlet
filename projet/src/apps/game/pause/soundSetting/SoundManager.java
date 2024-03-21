package apps.game.pause.soundSetting;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager {
    private static MediaPlayer mediaPlayer;

    public SoundManager() {
        setMusicFile("/apps/game/pause/soundSetting/music.wav");
    }

    public void setMusicFile(String musicFile) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        try {
            Media wavFile = new Media(getClass().getResource(musicFile).toExternalForm());
            mediaPlayer = new MediaPlayer(wavFile);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void play() {
        mediaPlayer.play();
    }

    public static void pause() {
        mediaPlayer.pause();
    }

    public static void stop() {
        mediaPlayer.stop();
    }

    public static boolean isPlaying() {
        return mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING;
    }

    public static void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }
}