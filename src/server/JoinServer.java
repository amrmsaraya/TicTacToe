/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;
import java.util.Vector;
import javax.swing.JFrame;
import gui.TicTacToeFrame;
import java.awt.Color;
import jdk.javadoc.internal.doclets.formats.html.markup.Table;

/**
 *
 * @author amr
 */
public class JoinServer implements Runnable {

    InputStreamReader isr;
    BufferedReader br;
    PrintStream ps;
    Socket s;
    String ip;
    String serverIp;
    Vector<User> serverInfo;
    boolean searchFinished;
    JFrame frame;

    public JoinServer(JFrame frame) {
        serverInfo = new Vector<User>(0);
        searchFinished = false;
        this.frame = frame;
    }

    public void search() {
        new Thread(new Runnable() {
            User user = new User();

            public void run() {
                try {
                    TicTacToeFrame.ButtonSearch.setEnabled(false);
                    for (int i = 0; i < TicTacToeFrame.model.getRowCount(); i++) {
                        TicTacToeFrame.model.removeRow(i);
                        TicTacToeFrame.model.fireTableDataChanged();
                    }
                    ip = InetAddress.getLocalHost().getHostAddress();
                    String[] s = ip.split("[.]");
                    ip = s[0] + "." + s[1] + "." + s[2] + ".";
                    for (int i = 0; i < 254; i++) {
                        try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress(ip + i, 6610), 10);
                            ps = new PrintStream(socket.getOutputStream());
                            if (socket.getInetAddress() != null) {
                                serverIp = socket.getInetAddress().toString().replace("/", "");
                                TicTacToeFrame.model.addRow(new Object[]{"username", serverIp});
                                TicTacToeFrame.model.fireTableDataChanged();

                            }
                            ps.println("search");
                            socket.close();
                            break;
                        } catch (Exception ex) {
                        }
                    }
                    TicTacToeFrame.ButtonSearch.setEnabled(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                searchFinished = true;

            }
        }).start();
    }

    public void run() {
    }

    public Vector<User> getServerIpVector() {
        return serverInfo;
    }

    public void setSearchFinished(boolean searchFinished) {
        this.searchFinished = searchFinished;
    }

    public boolean getSearchFinished() {
        return searchFinished;
    }

}
