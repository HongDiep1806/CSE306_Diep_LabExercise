/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Asus
 */
public class playWavFile {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Asus\\Documents\\CSE306\\saving_img\\sample1.wav";
        Playsound(filePath);
    }

    public static void Playsound(String location) {
        try {
            File Wav = new File(location);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(Wav);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);

            clip.start();
            Thread.sleep(5000);
            clip.stop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
