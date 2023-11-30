/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class EchoClient {

    public final static String host = "localhost";
    Scanner sc = new Scanner(System.in);
    String in;

    public static void main(String[] args) {
        Socket socket = null;

        while (true) {
            try {
                socket = new Socket(host, 13);
                socket.setSoTimeout(15000);
                //
                Writer out = new OutputStreamWriter(socket.getOutputStream());
                out = new BufferedWriter(out);
                //
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
                //
                String line = terminal.readLine();
                while(!line.equals("quit")){
                    out.write(line + "\r\n");
                    out.flush();
                    readLine(reader);
                    line = terminal.readLine();
                }

            } catch (Exception e) {
            }
        }
    }
    
    public static void readLine(BufferedReader br) throws IOException{
        String echo = br.readLine();
        System.out.println("<ECHO> "+echo+"\r\n");
    }
}
