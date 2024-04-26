package apps.game.pause.soundSetting;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundManager {
    private static Clip clip;
    public static float volume = 0.5f;

    public SoundManager() {
    }

    public void initialize() {
        setMusicFile("music.wav");
    }

    public void setMusicFile(String musicFile) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        try {
            URL url = getClass().getResource(musicFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public static void pause() {
        if (clip != null) {
            clip.stop();
        }
    }

    public static void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public static boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    public static void setVolume(float new_volume) {
        if (clip != null) {
            volume = new_volume;
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (volume == 0.0f) ? -80.0f : (float) (20.0 * Math.log10(volume));
            volumeControl.setValue(dB);
        }
    }
}