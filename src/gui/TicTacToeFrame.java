package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.*;

public class TicTacToeFrame extends javax.swing.JFrame {

    Font FONT_ZORQUE;
    CardLayout cards;

    public TicTacToeFrame() {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
        setResizable(false);
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize(width, height);

        initComponents();
        cards = (CardLayout) parentPanel.getLayout();

        try {
            InputStream is = new BufferedInputStream(getClass().getResourceAsStream("resources/zorque.ttf"));
            FONT_ZORQUE = Font.createFont(Font.TRUETYPE_FONT, is);
            LabelLogo.setFont(FONT_ZORQUE.deriveFont(144f));
            LabelUsername.setFont(FONT_ZORQUE.deriveFont(60f));
            LabelPassword.setFont(FONT_ZORQUE.deriveFont(60f));
            ButtonLogin.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonSignup.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonLogin.setOpaque(false);
            ButtonLogin.setContentAreaFilled(false);
            ButtonLogin.setBorderPainted(false);
            ButtonSignup.setOpaque(false);
            ButtonSignup.setContentAreaFilled(false);
            ButtonSignup.setBorderPainted(false);
            TextFieldUsername.setFont(FONT_ZORQUE.deriveFont(32f));
            PasswordFieldPassword.setFont(FONT_ZORQUE.deriveFont(32f));
            TextFieldUsername.requestFocus();

            LabelLogo2.setFont(FONT_ZORQUE.deriveFont(144f));
            ButtonStartGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonRecords.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonQuit.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonStartGame.setOpaque(false);
            ButtonStartGame.setContentAreaFilled(false);
            ButtonStartGame.setBorderPainted(false);
            ButtonRecords.setOpaque(false);
            ButtonRecords.setContentAreaFilled(false);
            ButtonRecords.setBorderPainted(false);
            ButtonQuit.setOpaque(false);
            ButtonQuit.setContentAreaFilled(false);
            ButtonQuit.setBorderPainted(false);

            ButtonOnePlayer.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonTwoPlayers.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowGameMode.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonOnePlayer.setOpaque(false);
            ButtonOnePlayer.setContentAreaFilled(false);
            ButtonOnePlayer.setBorderPainted(false);
            ButtonTwoPlayers.setOpaque(false);
            ButtonTwoPlayers.setContentAreaFilled(false);
            ButtonTwoPlayers.setBorderPainted(false);
            ButtonArrowGameMode.setOpaque(false);
            ButtonArrowGameMode.setContentAreaFilled(false);
            ButtonArrowGameMode.setBorderPainted(false);

            ButtonSamePC.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonLocalNetwork.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowTowPlayers.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonSamePC.setOpaque(false);
            ButtonSamePC.setContentAreaFilled(false);
            ButtonSamePC.setBorderPainted(false);
            ButtonLocalNetwork.setOpaque(false);
            ButtonLocalNetwork.setContentAreaFilled(false);
            ButtonLocalNetwork.setBorderPainted(false);
            ButtonArrowTowPlayers.setOpaque(false);
            ButtonArrowTowPlayers.setContentAreaFilled(false);
            ButtonArrowTowPlayers.setBorderPainted(false);

            ButtonCreateGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonJoinGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowLocalNetwork.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonCreateGame.setOpaque(false);
            ButtonCreateGame.setContentAreaFilled(false);
            ButtonCreateGame.setBorderPainted(false);
            ButtonJoinGame.setOpaque(false);
            ButtonJoinGame.setContentAreaFilled(false);
            ButtonJoinGame.setBorderPainted(false);
            ButtonArrowLocalNetwork.setOpaque(false);
            ButtonArrowLocalNetwork.setContentAreaFilled(false);
            ButtonArrowLocalNetwork.setBorderPainted(false);

            ButtonMyProfile.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonPlayers.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowRecords.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonMyProfile.setOpaque(false);
            ButtonMyProfile.setContentAreaFilled(false);
            ButtonMyProfile.setBorderPainted(false);
            ButtonPlayers.setOpaque(false);
            ButtonPlayers.setContentAreaFilled(false);
            ButtonPlayers.setBorderPainted(false);
            ButtonArrowRecords.setOpaque(false);
            ButtonArrowRecords.setContentAreaFilled(false);
            ButtonArrowRecords.setBorderPainted(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        LoginPanel = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        LabelUsername = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        TextFieldUsername = new javax.swing.JTextField();
        ButtonLogin = new javax.swing.JButton();
        ButtonSignup = new javax.swing.JButton();
        PasswordFieldPassword = new javax.swing.JPasswordField();
        MainMenuPanel = new javax.swing.JPanel();
        LabelLogo2 = new javax.swing.JLabel();
        ButtonStartGame = new javax.swing.JButton();
        ButtonRecords = new javax.swing.JButton();
        ButtonQuit = new javax.swing.JButton();
        GameModePanel = new javax.swing.JPanel();
        ButtonOnePlayer = new javax.swing.JButton();
        ButtonTwoPlayers = new javax.swing.JButton();
        ButtonArrowGameMode = new javax.swing.JButton();
        TwoPlayersPanel = new javax.swing.JPanel();
        ButtonSamePC = new javax.swing.JButton();
        ButtonLocalNetwork = new javax.swing.JButton();
        ButtonArrowTowPlayers = new javax.swing.JButton();
        LocalNetworkPanel = new javax.swing.JPanel();
        ButtonCreateGame = new javax.swing.JButton();
        ButtonJoinGame = new javax.swing.JButton();
        ButtonArrowLocalNetwork = new javax.swing.JButton();
        RecordsPanel = new javax.swing.JPanel();
        ButtonMyProfile = new javax.swing.JButton();
        ButtonPlayers = new javax.swing.JButton();
        ButtonArrowRecords = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parentPanel.setLayout(new java.awt.CardLayout());

        LoginPanel.setBackground(new java.awt.Color(33, 33, 33));
        LoginPanel.setFocusable(false);
        LoginPanel.setNextFocusableComponent(TextFieldUsername);

        LabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        LabelLogo.setForeground(new java.awt.Color(158, 158, 158));
        LabelLogo.setText("TicTacToe");

        LabelUsername.setForeground(new java.awt.Color(158, 158, 158));
        LabelUsername.setText("Username");

        LabelPassword.setForeground(new java.awt.Color(158, 158, 158));
        LabelPassword.setText("Passowrd");

        TextFieldUsername.setBackground(new java.awt.Color(158, 158, 158));
        TextFieldUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        TextFieldUsername.setMinimumSize(new java.awt.Dimension(80, 50));
        TextFieldUsername.setNextFocusableComponent(PasswordFieldPassword);
        TextFieldUsername.setPreferredSize(new java.awt.Dimension(80, 50));
        TextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsernameActionPerformed(evt);
            }
        });

        ButtonLogin.setForeground(new java.awt.Color(158, 158, 158));
        ButtonLogin.setText("Login");
        ButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLoginMouseExited(evt);
            }
        });
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        ButtonSignup.setForeground(new java.awt.Color(158, 158, 158));
        ButtonSignup.setText("Signup");
        ButtonSignup.setToolTipText("Create a new account");
        ButtonSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonSignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonSignupMouseExited(evt);
            }
        });
        ButtonSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSignupActionPerformed(evt);
            }
        });

        PasswordFieldPassword.setBackground(new java.awt.Color(158, 158, 158));
        PasswordFieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        PasswordFieldPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PasswordFieldPassword.setMinimumSize(new java.awt.Dimension(80, 50));
        PasswordFieldPassword.setPreferredSize(new java.awt.Dimension(80, 50));

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(ButtonLogin)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(ButtonSignup))
                    .addComponent(TextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(348, Short.MAX_VALUE))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(LabelLogo)
                .addGap(178, 178, 178)
                .addComponent(LabelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin)
                    .addComponent(ButtonSignup))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        parentPanel.add(LoginPanel, "LoginCard");

        MainMenuPanel.setBackground(new java.awt.Color(33, 33, 33));

        LabelLogo2.setBackground(new java.awt.Color(255, 255, 153));
        LabelLogo2.setForeground(new java.awt.Color(158, 158, 158));
        LabelLogo2.setText("TicTacToe");

        ButtonStartGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonStartGame.setText("Start Game");
        ButtonStartGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonStartGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonStartGameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonStartGameMouseReleased(evt);
            }
        });
        ButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonStartGameActionPerformed(evt);
            }
        });

        ButtonRecords.setForeground(new java.awt.Color(158, 158, 158));
        ButtonRecords.setText("Records");
        ButtonRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRecordsMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonRecordsMouseReleased(evt);
            }
        });
        ButtonRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecordsActionPerformed(evt);
            }
        });

        ButtonQuit.setForeground(new java.awt.Color(158, 158, 158));
        ButtonQuit.setText("Quit");
        ButtonQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonQuitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonQuitMouseExited(evt);
            }
        });
        ButtonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuPanelLayout = new javax.swing.GroupLayout(MainMenuPanel);
        MainMenuPanel.setLayout(MainMenuPanelLayout);
        MainMenuPanelLayout.setHorizontalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addGroup(MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(385, Short.MAX_VALUE))
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelLogo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainMenuPanelLayout.setVerticalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(LabelLogo2)
                .addGap(173, 173, 173)
                .addComponent(ButtonStartGame)
                .addGap(64, 64, 64)
                .addComponent(ButtonRecords)
                .addGap(62, 62, 62)
                .addComponent(ButtonQuit)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        parentPanel.add(MainMenuPanel, "MainMenuCard");

        GameModePanel.setBackground(new java.awt.Color(33, 33, 33));

        ButtonOnePlayer.setForeground(new java.awt.Color(158, 158, 158));
        ButtonOnePlayer.setText("One  Player");
        ButtonOnePlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonOnePlayerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonOnePlayerMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonOnePlayerMouseReleased(evt);
            }
        });

        ButtonTwoPlayers.setForeground(new java.awt.Color(158, 158, 158));
        ButtonTwoPlayers.setText("Two Players");
        ButtonTwoPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonTwoPlayersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonTwoPlayersMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonTwoPlayersMouseReleased(evt);
            }
        });
        ButtonTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTwoPlayersActionPerformed(evt);
            }
        });

        ButtonArrowGameMode.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowGameMode.setText("<<");
        ButtonArrowGameMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowGameModeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowGameModeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonArrowGameModeMouseReleased(evt);
            }
        });
        ButtonArrowGameMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowGameModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GameModePanelLayout = new javax.swing.GroupLayout(GameModePanel);
        GameModePanel.setLayout(GameModePanelLayout);
        GameModePanelLayout.setHorizontalGroup(
            GameModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameModePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GameModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonTwoPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonOnePlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GameModePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowGameMode)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        GameModePanelLayout.setVerticalGroup(
            GameModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameModePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ButtonArrowGameMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonOnePlayer)
                .addGap(60, 60, 60)
                .addComponent(ButtonTwoPlayers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(GameModePanel, "GameModeCard");

        TwoPlayersPanel.setBackground(new java.awt.Color(33, 33, 33));

        ButtonSamePC.setForeground(new java.awt.Color(158, 158, 158));
        ButtonSamePC.setText("Same  PC ");
        ButtonSamePC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonSamePCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonSamePCMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonSamePCMouseReleased(evt);
            }
        });

        ButtonLocalNetwork.setForeground(new java.awt.Color(158, 158, 158));
        ButtonLocalNetwork.setText("Local Network");
        ButtonLocalNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLocalNetworkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLocalNetworkMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonLocalNetworkMouseReleased(evt);
            }
        });
        ButtonLocalNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLocalNetworkActionPerformed(evt);
            }
        });

        ButtonArrowTowPlayers.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowTowPlayers.setText("<<");
        ButtonArrowTowPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowTowPlayersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowTowPlayersMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonArrowTowPlayersMouseReleased(evt);
            }
        });
        ButtonArrowTowPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowTowPlayersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TwoPlayersPanelLayout = new javax.swing.GroupLayout(TwoPlayersPanel);
        TwoPlayersPanel.setLayout(TwoPlayersPanelLayout);
        TwoPlayersPanelLayout.setHorizontalGroup(
            TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TwoPlayersPanelLayout.createSequentialGroup()
                .addGroup(TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonArrowTowPlayers)
                    .addGroup(TwoPlayersPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonLocalNetwork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonSamePC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TwoPlayersPanelLayout.setVerticalGroup(
            TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TwoPlayersPanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowTowPlayers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonLocalNetwork)
                .addGap(65, 65, 65)
                .addComponent(ButtonSamePC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(TwoPlayersPanel, "TwoPlayersCard");

        LocalNetworkPanel.setBackground(new java.awt.Color(33, 33, 33));

        ButtonCreateGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonCreateGame.setText("Create Game");
        ButtonCreateGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCreateGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCreateGameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonCreateGameMouseReleased(evt);
            }
        });

        ButtonJoinGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonJoinGame.setText("Join Game");
        ButtonJoinGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonJoinGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonJoinGameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonJoinGameMouseReleased(evt);
            }
        });
        ButtonJoinGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonJoinGameActionPerformed(evt);
            }
        });

        ButtonArrowLocalNetwork.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowLocalNetwork.setText("<<");
        ButtonArrowLocalNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowLocalNetworkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowLocalNetworkMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonArrowLocalNetworkMouseReleased(evt);
            }
        });
        ButtonArrowLocalNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowLocalNetworkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LocalNetworkPanelLayout = new javax.swing.GroupLayout(LocalNetworkPanel);
        LocalNetworkPanel.setLayout(LocalNetworkPanelLayout);
        LocalNetworkPanelLayout.setHorizontalGroup(
            LocalNetworkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocalNetworkPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LocalNetworkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonCreateGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonJoinGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LocalNetworkPanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowLocalNetwork)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LocalNetworkPanelLayout.setVerticalGroup(
            LocalNetworkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocalNetworkPanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowLocalNetwork)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonCreateGame)
                .addGap(65, 65, 65)
                .addComponent(ButtonJoinGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(LocalNetworkPanel, "LocalNetworkCard");

        RecordsPanel.setBackground(new java.awt.Color(38, 38, 38));

        ButtonMyProfile.setForeground(new java.awt.Color(158, 158, 158));
        ButtonMyProfile.setText("My Profile");
        ButtonMyProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonMyProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonMyProfileMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonMyProfileMouseReleased(evt);
            }
        });
        ButtonMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMyProfileActionPerformed(evt);
            }
        });

        ButtonPlayers.setForeground(new java.awt.Color(158, 158, 158));
        ButtonPlayers.setText("Players");
        ButtonPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPlayersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPlayersMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonPlayersMouseReleased(evt);
            }
        });

        ButtonArrowRecords.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowRecords.setText("<<");
        ButtonArrowRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowRecordsMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonArrowRecordsMouseReleased(evt);
            }
        });
        ButtonArrowRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowRecordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RecordsPanelLayout = new javax.swing.GroupLayout(RecordsPanel);
        RecordsPanel.setLayout(RecordsPanelLayout);
        RecordsPanelLayout.setHorizontalGroup(
            RecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecordsPanelLayout.createSequentialGroup()
                .addGroup(RecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RecordsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonMyProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(ButtonArrowRecords))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RecordsPanelLayout.setVerticalGroup(
            RecordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecordsPanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowRecords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonMyProfile)
                .addGap(65, 65, 65)
                .addComponent(ButtonPlayers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(RecordsPanel, "RecordsCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonStartGameActionPerformed
        cards.show(parentPanel, "GameModeCard");
    }//GEN-LAST:event_ButtonStartGameActionPerformed

    private void ButtonStartGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStartGameMouseEntered
        ButtonStartGame.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonStartGameMouseEntered

    private void ButtonStartGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStartGameMouseExited
        ButtonStartGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonStartGameMouseExited

    private void ButtonRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordsMouseEntered
        ButtonRecords.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonRecordsMouseEntered

    private void ButtonRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordsMouseExited
        ButtonRecords.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonRecordsMouseExited

    private void ButtonQuitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitMouseEntered
        ButtonQuit.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonQuitMouseEntered

    private void ButtonQuitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitMouseExited
        ButtonQuit.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonQuitMouseExited

    private void ButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignupActionPerformed
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonSignupActionPerformed

    private void ButtonSignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignupMouseExited
        ButtonSignup.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonSignupMouseExited

    private void ButtonSignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignupMouseEntered
        ButtonSignup.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonSignupMouseEntered

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void ButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseExited
        ButtonLogin.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonLoginMouseExited

    private void ButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseEntered
        ButtonLogin.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonLoginMouseEntered

    private void TextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsernameActionPerformed

    }//GEN-LAST:event_TextFieldUsernameActionPerformed

    private void ButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ButtonQuitActionPerformed

    private void ButtonTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersActionPerformed
        cards.show(parentPanel, "TwoPlayersCard");
    }//GEN-LAST:event_ButtonTwoPlayersActionPerformed

    private void ButtonArrowGameModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeActionPerformed
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonArrowGameModeActionPerformed

    private void ButtonOnePlayerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOnePlayerMouseEntered
        ButtonOnePlayer.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonOnePlayerMouseEntered

    private void ButtonOnePlayerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOnePlayerMouseExited
        ButtonOnePlayer.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonOnePlayerMouseExited

    private void ButtonTwoPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseEntered
        ButtonTwoPlayers.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonTwoPlayersMouseEntered

    private void ButtonTwoPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseExited
        ButtonTwoPlayers.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonTwoPlayersMouseExited

    private void ButtonArrowGameModeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseEntered
        ButtonArrowGameMode.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonArrowGameModeMouseEntered

    private void ButtonArrowGameModeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseExited
        ButtonArrowGameMode.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowGameModeMouseExited

    private void ButtonLocalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkActionPerformed
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonLocalNetworkActionPerformed

    private void ButtonArrowTowPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowTowPlayersActionPerformed
        cards.show(parentPanel, "GameModeCard");
    }//GEN-LAST:event_ButtonArrowTowPlayersActionPerformed

    private void ButtonSamePCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseEntered
        ButtonSamePC.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonSamePCMouseEntered

    private void ButtonSamePCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseExited
        ButtonSamePC.setForeground(new Color(158, 158, 158));

    }//GEN-LAST:event_ButtonSamePCMouseExited

    private void ButtonArrowTowPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTowPlayersMouseEntered
        ButtonArrowTowPlayers.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonArrowTowPlayersMouseEntered

    private void ButtonArrowTowPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTowPlayersMouseExited
        ButtonArrowTowPlayers.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowTowPlayersMouseExited

    private void ButtonLocalNetworkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseEntered
        ButtonLocalNetwork.setForeground(new Color(224, 224, 224));

    }//GEN-LAST:event_ButtonLocalNetworkMouseEntered

    private void ButtonLocalNetworkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseExited
        ButtonLocalNetwork.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonLocalNetworkMouseExited

    private void ButtonJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinGameActionPerformed

    }//GEN-LAST:event_ButtonJoinGameActionPerformed

    private void ButtonCreateGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseEntered
        ButtonCreateGame.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonCreateGameMouseEntered

    private void ButtonCreateGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseExited
        ButtonCreateGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonCreateGameMouseExited

    private void ButtonArrowLocalNetworkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseEntered
        ButtonArrowLocalNetwork.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseEntered

    private void ButtonArrowLocalNetworkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseExited
        ButtonArrowLocalNetwork.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseExited

    private void ButtonJoinGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseEntered
        ButtonJoinGame.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonJoinGameMouseEntered

    private void ButtonJoinGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseExited
        ButtonJoinGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonJoinGameMouseExited

    private void ButtonArrowLocalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkActionPerformed
        cards.show(parentPanel, "TwoPlayersCard");
    }//GEN-LAST:event_ButtonArrowLocalNetworkActionPerformed

    private void ButtonRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordsActionPerformed
        cards.show(parentPanel, "RecordsCard");
    }//GEN-LAST:event_ButtonRecordsActionPerformed

    private void ButtonMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMyProfileActionPerformed

    }//GEN-LAST:event_ButtonMyProfileActionPerformed

    private void ButtonArrowRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowRecordsMouseEntered
        ButtonArrowRecords.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonArrowRecordsMouseEntered

    private void ButtonArrowRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowRecordsMouseExited
        ButtonArrowRecords.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowRecordsMouseExited

    private void ButtonMyProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMyProfileMouseEntered
        ButtonMyProfile.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonMyProfileMouseEntered

    private void ButtonMyProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMyProfileMouseExited
        ButtonMyProfile.setForeground(new Color(158, 158, 158));

    }//GEN-LAST:event_ButtonMyProfileMouseExited

    private void ButtonPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayersMouseEntered
        ButtonPlayers.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonPlayersMouseEntered

    private void ButtonPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayersMouseExited
        ButtonPlayers.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonPlayersMouseExited

    private void ButtonArrowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowRecordsActionPerformed
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonArrowRecordsActionPerformed

    private void ButtonLocalNetworkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseReleased
        ButtonLocalNetwork.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonLocalNetworkMouseReleased

    private void ButtonSamePCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseReleased
        ButtonSamePC.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonSamePCMouseReleased

    private void ButtonArrowTowPlayersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTowPlayersMouseReleased
        ButtonArrowTowPlayers.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowTowPlayersMouseReleased

    private void ButtonCreateGameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseReleased
        ButtonCreateGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonCreateGameMouseReleased

    private void ButtonJoinGameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseReleased
        ButtonJoinGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonJoinGameMouseReleased

    private void ButtonArrowLocalNetworkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseReleased
        ButtonArrowLocalNetwork.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseReleased

    private void ButtonArrowRecordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowRecordsMouseReleased
        ButtonArrowRecords.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowRecordsMouseReleased

    private void ButtonMyProfileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMyProfileMouseReleased
        ButtonMyProfile.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonMyProfileMouseReleased

    private void ButtonPlayersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayersMouseReleased
        ButtonPlayers.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonPlayersMouseReleased

    private void ButtonArrowGameModeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseReleased
        ButtonArrowGameMode.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowGameModeMouseReleased

    private void ButtonOnePlayerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOnePlayerMouseReleased
        ButtonOnePlayer.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonOnePlayerMouseReleased

    private void ButtonTwoPlayersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseReleased
        ButtonTwoPlayers.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonTwoPlayersMouseReleased

    private void ButtonStartGameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStartGameMouseReleased
        ButtonStartGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonStartGameMouseReleased

    private void ButtonRecordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordsMouseReleased
        ButtonRecords.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonRecordsMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonArrowGameMode;
    private javax.swing.JButton ButtonArrowLocalNetwork;
    private javax.swing.JButton ButtonArrowRecords;
    private javax.swing.JButton ButtonArrowTowPlayers;
    private javax.swing.JButton ButtonCreateGame;
    private javax.swing.JButton ButtonJoinGame;
    private javax.swing.JButton ButtonLocalNetwork;
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonMyProfile;
    private javax.swing.JButton ButtonOnePlayer;
    private javax.swing.JButton ButtonPlayers;
    private javax.swing.JButton ButtonQuit;
    private javax.swing.JButton ButtonRecords;
    private javax.swing.JButton ButtonSamePC;
    private javax.swing.JButton ButtonSignup;
    private javax.swing.JButton ButtonStartGame;
    private javax.swing.JButton ButtonTwoPlayers;
    private javax.swing.JPanel GameModePanel;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogo2;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JPanel LocalNetworkPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel MainMenuPanel;
    private javax.swing.JPasswordField PasswordFieldPassword;
    private javax.swing.JPanel RecordsPanel;
    private javax.swing.JTextField TextFieldUsername;
    private javax.swing.JPanel TwoPlayersPanel;
    private javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
