/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

/**
 *
 * @author Asus
 */
public class mp3Player {

    public static void main(String[] args) {
        AudioInputStream audioStream = null;
        SourceDataLine line = null;
        try {
            URL u = new URL("https://www.tanbinhtech.com:8443/sample1.wav");
            InputStream in = u.openStream();
            in = new BufferedInputStream(in);

            audioStream = AudioSystem.getAudioInputStream(u);

            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
            System.out.println("Playback started: ");
            byte[] bufferBytes = new byte[4096];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            System.out.println("Playback has been finished: ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

