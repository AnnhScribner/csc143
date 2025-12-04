/**
 * @author Anna Scribner
 * @version May 4, 2025
 * <p>
 * Represents a collection of sound effects that can be played in the application.
 * <p>
 * The Sound enum provides predefined sound effects such as AIRHORN, SHOOT_ARROW, TADA, and DICE.
 * Each sound effect is associated with a specific audio file located in the application's resources.
 */

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public enum Sound {

    AIRHORN("sounds/airHorn.wav"),
    SHOOT_ARROW("sounds/shootArrow.wav"),
    TADA("sounds/taDa.wav"),
    DICE("sounds/dice.wav");

    /**
     * Represents the different volume levels for sound playback.
     */
    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }

    public static final Volume volume = Volume.HIGH;

    private Clip clip;

    Sound(String soundFileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);


            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Plays the associated sound clip from the beginning, ensuring the clip is not currently running.
     * The method first stops the clip if it is already playing, resets its position, and then starts it.
     * The playback is paused for an appropriate duration to allow the sound to finish playing.
     * If the volume is set to MUTE, the clip will not be played.
     *
     * @throws RuntimeException if the thread is interrupted while sleeping during playback
     */
    public void play() {
        if (volume != Volume.MUTE) {
            if (clip.isRunning())
                clip.stop();
            clip.setFramePosition(0);
            clip.start();
            try {
                Thread.sleep((long) ((double) clip.getMicrosecondLength() / 1000 * 1.1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



