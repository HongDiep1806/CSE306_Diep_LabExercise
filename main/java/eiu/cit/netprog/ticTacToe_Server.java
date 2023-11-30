/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.*;
import java.net.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ticTacToe_Server {

    public final static int PORT = 13;

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(PORT);
            while (true) {
                try ( Socket connection = socket.accept()) {
                    Reader in = new InputStreamReader(connection.getInputStream());
                    BufferedReader br = new BufferedReader(in);

                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    BufferedWriter bw = new BufferedWriter(out);
                    char[] table = {'-','-','-','-','-','-','-','-','-'};

                    returnBoard(bw, table);
                    String move = br.readLine();
                    while (!(move.equals("quit"))) {
                        int cell = Integer.parseInt(move);
                        if (table[cell] != '-') {
                            bw.write("Invalid Move");
                            bw.flush();
                        } else {
                            table[cell] = 'X';
                            makeMove(table);
                            returnBoard(bw, table);
                        }
                        move = br.readLine();
                    }

                    out.close();

                } catch (IOException e) {
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ticTacToe_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void returnBoard(BufferedWriter bw, char[] table) {
        try {
            for (int i = 0; i < 9; i++) {
                bw.write("_");
            }
            bw.write("\r\n");
            bw.flush();
        } catch (Exception e) {
        }
    }

    public static void makeMove(char[] table) {
        for (int i = 0; i < 9; i++) {
            if (table[i] == '-') {
                table[i] = 'O';
                break;
            }
        }
    }
    public static boolean checkDraw (char[] table){
        boolean result = true;
        for( int i=0; i < 9; i++){
            if(table[i] == '-'){
                result = false;
                break;
                        
            }
        }
        return result;
    }
}
