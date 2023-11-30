/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class DaytimeClient {

    public final static String host = "localhost";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int timeOff = sc.nextInt();
        int count = 0;
        Socket socket = null;
        while (count < timeOff) {
            Thread.sleep(1000);
            try {
                socket = new Socket(host, 13);
                socket.setSoTimeout(15000);
                //
                InputStream in = socket.getInputStream();
                StringBuilder time = new StringBuilder();
                //
                InputStreamReader reader = new InputStreamReader(in, "ASCII");
                for (int c = reader.read(); c != -1; c = reader.read()) {
                    time.append((char) c);
                }
                System.out.println(time);
                count++;
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

}
