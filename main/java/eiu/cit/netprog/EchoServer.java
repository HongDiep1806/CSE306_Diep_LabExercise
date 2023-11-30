/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;

/**
 *
 * @author Asus
 */
public class EchoServer {

    public final static int PORT = 13;

    public static void main(String[] args) {
        try ( ServerSocket socket = new ServerSocket(PORT)) {
            while (true) {
                try ( Socket connection = socket.accept()) {
                    Reader in = new InputStreamReader(connection.getInputStream());
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    StringBuilder Printout = new StringBuilder();
                    for (int c = in.read(); c != -1; c = in.read()) {
                        Printout.append((char) c);
                    }
                    out.append(Printout);
                    out.flush();
                    //connection.close();

                } catch (Exception e) {
                }

            }
        } catch (Exception e) {
        }
    }
}
