/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package media;

import java.io.File;
import static java.lang.Thread.sleep;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author amr
 */

public class Soundtrack {

    public void backgroundMusic() {
        Thread th = new Thread() {

            @Override
            public void run() {
                AudioInputStream audioInputStream = null;
                while (true) {
                    try {
                        String soundName = "src/gui/resources/bgMusic.wav";
                        audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        sleep(27000);
                    } catch (Exception ex) {

                    }
                }
            }
        };
        th.start();
    }

    public void onHoverMusic() {
        Thread th = new Thread() {
            @Override
            public void run() {
                AudioInputStream audioInputStream = null;
                Clip clip = null;
                try {

                    String soundName = "src/gui/resources/onHover.wav";
                    audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception ex) {
                }
            }
        };
        th.start();
    }
}
