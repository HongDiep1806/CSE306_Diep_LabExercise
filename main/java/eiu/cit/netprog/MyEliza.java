package eiu.cit.netprog;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class MyEliza {

    public static final String SERVER = "telehack.com";

    public static final int PORT = 23;
    public static final int TIMEOUT = 15000;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(TIMEOUT);
            //
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);

            //
            InputStream in = socket.getInputStream();
            BufferedReader terminal = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            int c, prevC = -1;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
                if ((char) c == '.') {
                    if (prevC == '\n') {
                        break;

                    }
                }
                prevC = c;
            }
            writer.write("eliza" + "\r\n");
            writer.flush();
            readFirst(terminal);

            String line = terminal.readLine();
            while ((c = in.read()) != -1) {
                writer.write(line + "\r\n");
                writer.flush();
                readEliza(terminal);
                line = terminal.readLine();
            }

        } catch (IOException e) {
            System.err.print(e);
        } finally {
            if (socket != null) {

                try {

                    socket.close();

                } catch (IOException ex) {

                    // ignore
                }

            }
        }
    }

    public static void readEliza(BufferedReader bif) {
        int c;
        int count = 0;
        try {
            while ((c = bif.read()) != -1) {
                if ((char) c == '\r') {
                    if (count == 3) {
                        System.out.print("<END>");
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.print((char) c);
                }
            }
            System.out.print((char) c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFirst(BufferedReader bif) {
        int c;
        int count = 0;
        try {
            while ((c = bif.read()) != -1) {
                if ((char) c == '\r') {
                    if (count == 2) {
                        System.out.print("<END>");
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == 1) {
                    System.out.print((char) c);
                }
            }
            System.out.print((char) c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
