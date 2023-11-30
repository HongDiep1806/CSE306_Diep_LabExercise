/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.io.Writer;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ticTacToe_Client {

    public final static String host = "localhost";

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(host, 13);
            socket.setSoTimeout(15000);
            //
            //
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //
            OutputStream out = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(reader.readLine());

            String move = terminal.readLine();
            while (!(move.equals("quit"))) {

                bw.write(move + "\r\n");
                bw.flush();
                System.out.println(reader.readLine());
                move = terminal.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ticTacToe_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
