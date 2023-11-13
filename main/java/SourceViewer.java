
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class SourceViewer {

    public static void main(String[] args){
        try {
            URL u = new URL("https://eiu.edu.vn");
            InputStream in = u.openStream();
            int c = in.read();
            while (c != -1) {
                System.out.write((char) c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
