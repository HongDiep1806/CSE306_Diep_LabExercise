/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.*;
import java.util.*;

/**
 *
 * @author Asus
 */
public class DaytimeServer {

    public final static int PORT = 13;

    public static void main(String[] args) {
        try ( ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try ( Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString() + "\r\n");
                    out.flush();
                    connection.close();

                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
