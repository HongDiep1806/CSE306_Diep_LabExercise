/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Asus
 */
public class downThenPlay {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.tanbinhtech.com:8443/sample1.wav");
            InputStream in = u.openStream();
            int c;
            String s = "C:\\Users\\Asus\\Documents\\CSE306\\lab-exercise\\src\\audio3.wav";
            File file = new File(s);
            OutputStream fileout = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fileout);
            BufferedInputStream bis = new BufferedInputStream(in);

            while ((c = bis.read()) != -1) {
                bos.write(c);
            }
            bos.close();

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);

            clip.start();
            Thread.sleep(5000);
            clip.stop();

        } catch (Exception e) {
        }

    }
}
