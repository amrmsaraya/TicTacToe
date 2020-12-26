/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;

/**
 *
 * @author amr
 */
public class CreateServer implements Runnable {

    ServerSocket serverSocket;
    InputStreamReader isr;
    BufferedReader br;
    PrintStream ps;
    Socket s;
    String connectPurpose;

    boolean P2MovePlayed;
    String p2MovePlace;

    public CreateServer() {

    }

    public void create() {
        connectPurpose = "search";
        P2MovePlayed = false;
        p2MovePlace = "";
        new Thread(new Runnable() {
            public void run() {
                try {
                    serverSocket = new ServerSocket(6610);
                    while (!connectPurpose.equals("join")) {
                        System.out.println("Waiting for opponent...");
                        s = serverSocket.accept();
                        if (connectPurpose.equals("join")) {
                            break;
                        }
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    isr = new InputStreamReader(s.getInputStream());
                                    br = new BufferedReader(isr);
                                    ps = new PrintStream(s.getOutputStream());
                                    String str = "";
                                    while ((str = br.readLine()) != null) {
                                        if (str.equals("join")) {
                                            connectPurpose = str;
                                            System.out.println("opponent joined");
                                        }
                                        if (connectPurpose.equals("join")) {
                                            p2MovePlace = str;
                                            P2MovePlayed = true;
                                        }
                                    }
                                    System.out.println(connectPurpose);
                                    s.close();
                                } catch (Exception ex) {
                                }
                            }
                        }).start();
                    }
                    serverSocket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();
    }

    public void run() {
    }

    public void setP2MovePlayed(boolean P2MovePlayed) {
        this.P2MovePlayed = P2MovePlayed;
    }

    public boolean getP2MovePlayed() {
        return P2MovePlayed;
    }

    public String getP2MovePlace() {
        return p2MovePlace;
    }

}
