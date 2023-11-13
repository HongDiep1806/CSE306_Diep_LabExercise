package eiu.cit.netprog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class SourceViewer {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://eiu.edu.vn/");
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.write((char) c);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
