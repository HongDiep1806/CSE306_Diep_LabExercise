/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;

/**
 *
 * @author Asus
 */
public class downAndPlay {

    public static void main(String[] args) {
        AudioInputStream audioStream = null;
        SourceDataLine line = null;
        try {
            URL u = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream inputStream = u.openStream();
            inputStream = new BufferedInputStream(inputStream);
            
            audioStream = AudioSystem.getAudioInputStream(u);
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine)AudioSystem.getLine(info);
            
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
            
            System.out.println("Playback Started.");
            int BUFFER_SIZE = 10000;
            byte[] bufferByte = new byte[BUFFER_SIZE];
            int readBytes = -1;
            
            while((readBytes = audioStream.read(bufferByte))!=-1){
                sourceDataLine.write(bufferByte, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            
            System.out.println("Playback has been finished.");
        } catch (Exception e) {
        }
    }
}
