/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *
 * @author Asus
 */
public class downloadWavFile {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream in = u.openStream();
            int c;
            String file = "C:\\Users\\Asus\\Documents\\CSE306\\lab-exercise\\src\\audio.wav";
            OutputStream fileout = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fileout);
            BufferedInputStream bis = new BufferedInputStream(in);

            while ((c = bis.read()) != -1) {
                bos.write(c);
            }
            bos.close();

        } catch (IOException e) {
        }
    }
}
