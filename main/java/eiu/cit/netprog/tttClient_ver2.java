/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.text.*;

/**
 *
 * @author Asus
 */
public class tttClient_ver2 {

    public static void main(String[] args) throws ParseException, IOException {
        String hostname = "localhost";
        Socket socket = null;
        try {
            socket = new Socket(hostname, 10);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bif = new BufferedReader(reader);

            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bout = new BufferedWriter(out);

            // Enter data using BufferReader
            BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
            //enter type of board
            String boardRequire = terminal.readLine();
            bout.write(boardRequire + "\r\n");
            bout.flush();
            //
            String move = terminal.readLine();
            while (!(move.equals("quit"))) {
                bout.write(move + "\r\n");
                bout.flush();
                readBoard(bif);
                move = terminal.readLine();
            }
            bout.write("quit" + "\r\n");
            bout.flush();
            //socket.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("WHY");
                }
            }
        }
    }

    static void readBoard(BufferedReader bif) {
        try {
            String encodedBoard = bif.readLine();
            System.out.println(encodedBoard);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
