package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class TicTacToeFrame extends javax.swing.JFrame {

    Font FONT_ZORQUE;
    CardLayout cards;

    public TicTacToeFrame() {
        setUndecorated(true);
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

            // Login
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

            // Main Menu
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

            // Game Modes
            ButtonOnePlayer.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonTwoPlayers.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowGameMode.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowCreateGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonOnePlayer.setOpaque(false);
            ButtonOnePlayer.setContentAreaFilled(false);
            ButtonOnePlayer.setBorderPainted(false);
            ButtonTwoPlayers.setOpaque(false);
            ButtonTwoPlayers.setContentAreaFilled(false);
            ButtonTwoPlayers.setBorderPainted(false);
            ButtonArrowGameMode.setOpaque(false);
            ButtonArrowGameMode.setContentAreaFilled(false);
            ButtonArrowGameMode.setBorderPainted(false);
            ButtonArrowCreateGame.setOpaque(false);
            ButtonArrowCreateGame.setContentAreaFilled(false);
            ButtonArrowCreateGame.setBorderPainted(false);

            // Two Players Mode
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

            // Local Network Mode
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

            // Records
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

            // My Profile
            LabelWelcome.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowMyProfile.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelTotalGames.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelWins.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelLosses.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelDraws.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelWins.setForeground(new Color(27, 94, 32));
            LabelLosses.setForeground(new Color(183, 28, 28));
            LabelDraws.setForeground(new Color(1, 87, 155));
            LabelHistory.setFont(FONT_ZORQUE.deriveFont(48f));
            TableHistory.getTableHeader().setFont(FONT_ZORQUE.deriveFont(32f));
            TableHistory.getTableHeader().setForeground(new Color(33, 33, 33));
            ButtonArrowMyProfile.setOpaque(false);
            ButtonArrowMyProfile.setContentAreaFilled(false);
            ButtonArrowMyProfile.setBorderPainted(false);

            // Game Board
            ButtonP1.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP2.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP3.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP4.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP5.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP6.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP7.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP8.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonP9.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonForfit.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelPlayer1.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelPlayer2.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelCurrentTurn.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelCurrentTurnValue.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonForfit.setOpaque(false);
            ButtonForfit.setContentAreaFilled(false);
            ButtonForfit.setBorderPainted(false);
            ButtonP1.setOpaque(false);
            ButtonP1.setContentAreaFilled(false);
            ButtonP1.setBorderPainted(false);
            ButtonP2.setOpaque(false);
            ButtonP2.setContentAreaFilled(false);
            ButtonP2.setBorderPainted(false);
            ButtonP3.setOpaque(false);
            ButtonP3.setContentAreaFilled(false);
            ButtonP3.setBorderPainted(false);
            ButtonP4.setOpaque(false);
            ButtonP4.setContentAreaFilled(false);
            ButtonP4.setBorderPainted(false);
            ButtonP5.setOpaque(false);
            ButtonP5.setContentAreaFilled(false);
            ButtonP5.setBorderPainted(false);
            ButtonP6.setOpaque(false);
            ButtonP6.setContentAreaFilled(false);
            ButtonP6.setBorderPainted(false);
            ButtonP7.setOpaque(false);
            ButtonP7.setContentAreaFilled(false);
            ButtonP7.setBorderPainted(false);
            ButtonP8.setOpaque(false);
            ButtonP8.setContentAreaFilled(false);
            ButtonP8.setBorderPainted(false);
            ButtonP9.setOpaque(false);
            ButtonP9.setContentAreaFilled(false);
            ButtonP9.setBorderPainted(false);

            // Create Game Card
            LabelWaitingOpponent.setFont(FONT_ZORQUE.deriveFont(72f));

            // Join Game Card
            ButtonJoin.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonRefresh.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowJoinGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonJoin.setOpaque(false);
            ButtonJoin.setContentAreaFilled(false);
            ButtonJoin.setBorderPainted(false);
            ButtonRefresh.setOpaque(false);
            ButtonRefresh.setContentAreaFilled(false);
            ButtonRefresh.setBorderPainted(false);
            ButtonArrowJoinGame.setOpaque(false);
            ButtonArrowJoinGame.setContentAreaFilled(false);
            ButtonArrowJoinGame.setBorderPainted(false);
            TableActivePlayer.getTableHeader().setFont(FONT_ZORQUE.deriveFont(32f));
            TableActivePlayer.getTableHeader().setForeground(new Color(33, 33, 33));

            // Game Result
            ButtonPlayAgain.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonMainMenu.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonQuitResult.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelTmp.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonPlayAgain.setOpaque(false);
            ButtonPlayAgain.setContentAreaFilled(false);
            ButtonPlayAgain.setBorderPainted(false);
            ButtonMainMenu.setOpaque(false);
            ButtonMainMenu.setContentAreaFilled(false);
            ButtonMainMenu.setBorderPainted(false);
            ButtonQuitResult.setOpaque(false);
            ButtonQuitResult.setContentAreaFilled(false);
            ButtonQuitResult.setBorderPainted(false);

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
        CreateGamePanel = new javax.swing.JPanel();
        ButtonArrowCreateGame = new javax.swing.JButton();
        LabelWaitingOpponent = new javax.swing.JLabel();
        JoinGamePanel = new javax.swing.JPanel();
        ButtonArrowJoinGame = new javax.swing.JButton();
        ButtonJoin = new javax.swing.JButton();
        ButtonRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableActivePlayer = new javax.swing.JTable();
        RecordsPanel = new javax.swing.JPanel();
        ButtonMyProfile = new javax.swing.JButton();
        ButtonPlayers = new javax.swing.JButton();
        ButtonArrowRecords = new javax.swing.JButton();
        MyProfilePanel = new javax.swing.JPanel();
        ButtonArrowMyProfile = new javax.swing.JButton();
        LabelWelcome = new javax.swing.JLabel();
        LabelTotalGames = new javax.swing.JLabel();
        LabelWins = new javax.swing.JLabel();
        LabelDraws = new javax.swing.JLabel();
        LabelLosses = new javax.swing.JLabel();
        LabelHistory = new javax.swing.JLabel();
        ScrollPaneHistoryTable = new javax.swing.JScrollPane();
        TableHistory = new javax.swing.JTable();
        GameBoardPanel = new javax.swing.JPanel();
        LabelPlayer1 = new javax.swing.JLabel();
        LabelPlayer2 = new javax.swing.JLabel();
        LabelCurrentTurn = new javax.swing.JLabel();
        LabelCurrentTurnValue = new javax.swing.JLabel();
        ButtonP1 = new javax.swing.JButton();
        ButtonP2 = new javax.swing.JButton();
        ButtonP3 = new javax.swing.JButton();
        ButtonP4 = new javax.swing.JButton();
        ButtonP5 = new javax.swing.JButton();
        ButtonP6 = new javax.swing.JButton();
        ButtonP7 = new javax.swing.JButton();
        ButtonP8 = new javax.swing.JButton();
        ButtonP9 = new javax.swing.JButton();
        ButtonForfit = new javax.swing.JButton();
        GameResultPanel = new javax.swing.JPanel();
        ButtonPlayAgain = new javax.swing.JButton();
        ButtonMainMenu = new javax.swing.JButton();
        ButtonQuitResult = new javax.swing.JButton();
        LabelTmp = new javax.swing.JLabel();

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
                .addContainerGap(385, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(ButtonLogin)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(ButtonSignup))
                    .addComponent(TextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(386, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LabelLogo)
                .addGap(190, 190, 190)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(422, Short.MAX_VALUE)
                .addGroup(MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelLogo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        MainMenuPanelLayout.setVerticalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LabelLogo2)
                .addGap(183, 183, 183)
                .addComponent(ButtonStartGame)
                .addGap(64, 64, 64)
                .addComponent(ButtonRecords)
                .addGap(62, 62, 62)
                .addComponent(ButtonQuit)
                .addContainerGap(86, Short.MAX_VALUE))
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
        ButtonOnePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOnePlayerActionPerformed(evt);
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
        ButtonSamePC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSamePCActionPerformed(evt);
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
        ButtonCreateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateGameActionPerformed(evt);
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

        CreateGamePanel.setBackground(new java.awt.Color(33, 33, 33));

        ButtonArrowCreateGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowCreateGame.setText("<<");
        ButtonArrowCreateGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowCreateGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowCreateGameMouseExited(evt);
            }
        });
        ButtonArrowCreateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowCreateGameActionPerformed(evt);
            }
        });

        LabelWaitingOpponent.setBackground(new java.awt.Color(33, 33, 33));
        LabelWaitingOpponent.setForeground(new java.awt.Color(153, 153, 153));
        LabelWaitingOpponent.setText("Waiting for opponent . . .");

        javax.swing.GroupLayout CreateGamePanelLayout = new javax.swing.GroupLayout(CreateGamePanel);
        CreateGamePanel.setLayout(CreateGamePanelLayout);
        CreateGamePanelLayout.setHorizontalGroup(
            CreateGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateGamePanelLayout.createSequentialGroup()
                .addGroup(CreateGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonArrowCreateGame)
                    .addGroup(CreateGamePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelWaitingOpponent)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CreateGamePanelLayout.setVerticalGroup(
            CreateGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateGamePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowCreateGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWaitingOpponent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(CreateGamePanel, "CreateGameCard");

        JoinGamePanel.setBackground(new java.awt.Color(38, 38, 38));

        ButtonArrowJoinGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowJoinGame.setText("<<");
        ButtonArrowJoinGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowJoinGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowJoinGameMouseExited(evt);
            }
        });
        ButtonArrowJoinGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowJoinGameActionPerformed(evt);
            }
        });

        ButtonJoin.setForeground(new java.awt.Color(158, 158, 158));
        ButtonJoin.setText("Join");
        ButtonJoin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonJoinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonJoinMouseExited(evt);
            }
        });
        ButtonJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonJoinActionPerformed(evt);
            }
        });

        ButtonRefresh.setForeground(new java.awt.Color(158, 158, 158));
        ButtonRefresh.setText("Refresh");
        ButtonRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRefreshMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonRefreshMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonRefreshMouseReleased(evt);
            }
        });

        TableActivePlayer.setBackground(new java.awt.Color(158, 158, 158));
        TableActivePlayer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "IP Address"
            }
        ));
        jScrollPane1.setViewportView(TableActivePlayer);

        javax.swing.GroupLayout JoinGamePanelLayout = new javax.swing.GroupLayout(JoinGamePanel);
        JoinGamePanel.setLayout(JoinGamePanelLayout);
        JoinGamePanelLayout.setHorizontalGroup(
            JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowJoinGame)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonJoin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JoinGamePanelLayout.setVerticalGroup(
            JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowJoinGame)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonJoin)
                    .addComponent(ButtonRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(JoinGamePanel, "JoinGameCard");

        RecordsPanel.setBackground(new java.awt.Color(33, 33, 33));

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

        MyProfilePanel.setBackground(new java.awt.Color(33, 33, 33));
        MyProfilePanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MyProfilePanelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        ButtonArrowMyProfile.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowMyProfile.setText("<<");
        ButtonArrowMyProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowMyProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowMyProfileMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonArrowMyProfileMouseReleased(evt);
            }
        });
        ButtonArrowMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowMyProfileActionPerformed(evt);
            }
        });

        LabelWelcome.setForeground(new java.awt.Color(158, 158, 158));
        LabelWelcome.setText("Welcome Username!");

        LabelTotalGames.setForeground(new java.awt.Color(158, 158, 158));
        LabelTotalGames.setText("Total games : 10");

        LabelWins.setForeground(new java.awt.Color(158, 158, 158));
        LabelWins.setText("Wins : 5");

        LabelDraws.setForeground(new java.awt.Color(158, 158, 158));
        LabelDraws.setText("Draws : 2");

        LabelLosses.setForeground(new java.awt.Color(158, 158, 158));
        LabelLosses.setText("Losses : 3");

        LabelHistory.setForeground(new java.awt.Color(158, 158, 158));
        LabelHistory.setText("History");

        TableHistory.setBackground(new java.awt.Color(33, 33, 33));
        TableHistory.setForeground(new java.awt.Color(158, 158, 158));
        TableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opponent", "Game ID", "Result", "Record"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableHistory.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableHistory.getTableHeader().setReorderingAllowed(false);
        ScrollPaneHistoryTable.setViewportView(TableHistory);

        javax.swing.GroupLayout MyProfilePanelLayout = new javax.swing.GroupLayout(MyProfilePanel);
        MyProfilePanel.setLayout(MyProfilePanelLayout);
        MyProfilePanelLayout.setHorizontalGroup(
            MyProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWins)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelDraws)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelLosses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MyProfilePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowMyProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MyProfilePanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(ScrollPaneHistoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 32, Short.MAX_VALUE))
            .addGroup(MyProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MyProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTotalGames)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MyProfilePanelLayout.setVerticalGroup(
            MyProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyProfilePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowMyProfile)
                .addGap(10, 10, 10)
                .addComponent(LabelWelcome)
                .addGap(65, 65, 65)
                .addComponent(LabelTotalGames)
                .addGap(34, 34, 34)
                .addGroup(MyProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelWins)
                    .addGroup(MyProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelLosses)
                        .addComponent(LabelDraws)))
                .addGap(116, 116, 116)
                .addComponent(LabelHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneHistoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(MyProfilePanel, "MyProfileCard");

        GameBoardPanel.setBackground(new java.awt.Color(38, 38, 38));

        LabelPlayer1.setForeground(new java.awt.Color(158, 158, 158));
        LabelPlayer1.setText("Player 1  : X");

        LabelPlayer2.setForeground(new java.awt.Color(158, 158, 158));
        LabelPlayer2.setText("Player 2 : O");

        LabelCurrentTurn.setForeground(new java.awt.Color(158, 158, 158));
        LabelCurrentTurn.setText("Current Turn : ");

        LabelCurrentTurnValue.setForeground(new java.awt.Color(158, 158, 158));
        LabelCurrentTurnValue.setText("X");

        ButtonP1.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP1.setText("X");
        ButtonP1.setPreferredSize(new java.awt.Dimension(100, 100));

        ButtonP2.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP2.setText("X");
        ButtonP2.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP2ActionPerformed(evt);
            }
        });

        ButtonP3.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP3.setText("O");
        ButtonP3.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP3ActionPerformed(evt);
            }
        });

        ButtonP4.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP4.setText("X");
        ButtonP4.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP4ActionPerformed(evt);
            }
        });

        ButtonP5.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP5.setText("X");
        ButtonP5.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP5ActionPerformed(evt);
            }
        });

        ButtonP6.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP6.setText("O");
        ButtonP6.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP6ActionPerformed(evt);
            }
        });

        ButtonP7.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP7.setText("O");
        ButtonP7.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP7ActionPerformed(evt);
            }
        });

        ButtonP8.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP8.setText("X");
        ButtonP8.setPreferredSize(new java.awt.Dimension(100, 100));

        ButtonP9.setForeground(new java.awt.Color(153, 153, 153));
        ButtonP9.setText("X");
        ButtonP9.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP9ActionPerformed(evt);
            }
        });

        ButtonForfit.setForeground(new java.awt.Color(183, 28, 28));
        ButtonForfit.setText("Forfit");
        ButtonForfit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonForfitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonForfitMouseExited(evt);
            }
        });
        ButtonForfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonForfitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GameBoardPanelLayout = new javax.swing.GroupLayout(GameBoardPanel);
        GameBoardPanel.setLayout(GameBoardPanelLayout);
        GameBoardPanelLayout.setHorizontalGroup(
            GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonP7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ButtonP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonP8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ButtonP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonP6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonP9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(GameBoardPanelLayout.createSequentialGroup()
                            .addComponent(LabelCurrentTurn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LabelCurrentTurnValue))
                        .addComponent(LabelPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonForfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        GameBoardPanelLayout.setVerticalGroup(
            GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPlayer1))
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GameBoardPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonP8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonP7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonP9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonForfit))))
                    .addGroup(GameBoardPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(LabelPlayer2)
                        .addGap(75, 75, 75)
                        .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCurrentTurn)
                            .addComponent(LabelCurrentTurnValue))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(GameBoardPanel, "GameBoardCard");

        GameResultPanel.setBackground(new java.awt.Color(38, 38, 38));

        ButtonPlayAgain.setForeground(new java.awt.Color(158, 158, 158));
        ButtonPlayAgain.setText("Play Again");
        ButtonPlayAgain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPlayAgainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPlayAgainMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonPlayAgainMouseReleased(evt);
            }
        });
        ButtonPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPlayAgainActionPerformed(evt);
            }
        });

        ButtonMainMenu.setForeground(new java.awt.Color(158, 158, 158));
        ButtonMainMenu.setText("Main Menu");
        ButtonMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonMainMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonMainMenuMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonMainMenuMouseReleased(evt);
            }
        });
        ButtonMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMainMenuActionPerformed(evt);
            }
        });

        ButtonQuitResult.setForeground(new java.awt.Color(158, 158, 158));
        ButtonQuitResult.setText("Quit");
        ButtonQuitResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonQuitResultMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonQuitResultMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonQuitResultMouseReleased(evt);
            }
        });
        ButtonQuitResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQuitResultActionPerformed(evt);
            }
        });

        LabelTmp.setForeground(new java.awt.Color(158, 158, 158));
        LabelTmp.setText("Winning or Losing Video");

        javax.swing.GroupLayout GameResultPanelLayout = new javax.swing.GroupLayout(GameResultPanel);
        GameResultPanel.setLayout(GameResultPanelLayout);
        GameResultPanelLayout.setHorizontalGroup(
            GameResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(ButtonPlayAgain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(ButtonMainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(ButtonQuitResult)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTmp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GameResultPanelLayout.setVerticalGroup(
            GameResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(LabelTmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(GameResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonPlayAgain)
                    .addComponent(ButtonMainMenu)
                    .addComponent(ButtonQuitResult))
                .addGap(123, 123, 123))
        );

        parentPanel.add(GameResultPanel, "GameResultCard");

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
        cards.show(parentPanel, "JoinGameCard");
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
        cards.show(parentPanel, "MyProfileCard");
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

    private void ButtonArrowMyProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseEntered
        ButtonArrowMyProfile.setForeground(new Color(224, 224, 224));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileMouseEntered

    private void ButtonArrowMyProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseExited
        ButtonArrowMyProfile.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileMouseExited

    private void ButtonArrowMyProfileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseReleased
        ButtonArrowMyProfile.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileMouseReleased

    private void ButtonArrowMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileActionPerformed
        cards.show(parentPanel, "RecordsCard");
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileActionPerformed

    private void MyProfilePanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MyProfilePanelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_MyProfilePanelAncestorAdded

    private void ButtonP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP2ActionPerformed

    private void ButtonP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP4ActionPerformed

    private void ButtonP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP6ActionPerformed

    private void ButtonForfitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonForfitMouseEntered
        ButtonForfit.setForeground(new Color(229, 57, 53));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonForfitMouseEntered

    private void ButtonForfitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonForfitMouseExited
        ButtonForfit.setForeground(new Color(183, 28, 28));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonForfitMouseExited

    private void ButtonForfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonForfitActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameResultCard");
    }//GEN-LAST:event_ButtonForfitActionPerformed

    private void ButtonArrowJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonArrowJoinGameActionPerformed

    private void ButtonPlayAgainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseEntered
        ButtonPlayAgain.setForeground(new Color(224, 224, 224));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPlayAgainMouseEntered

    private void ButtonPlayAgainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseExited
        ButtonPlayAgain.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPlayAgainMouseExited

    private void ButtonPlayAgainMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseReleased
        ButtonPlayAgain.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPlayAgainMouseReleased

    private void ButtonPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPlayAgainActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonPlayAgainActionPerformed

    private void ButtonMainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseEntered
        ButtonMainMenu.setForeground(new Color(224, 224, 224));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuMouseEntered

    private void ButtonMainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseExited
        ButtonMainMenu.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuMouseExited

    private void ButtonMainMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseReleased
        ButtonMainMenu.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuMouseReleased

    private void ButtonMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMainMenuActionPerformed
        cards.show(parentPanel, "MainMenuCard");
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuActionPerformed

    private void ButtonQuitResultMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseEntered
        ButtonQuitResult.setForeground(new Color(224, 224, 224));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultMouseEntered

    private void ButtonQuitResultMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseExited
        ButtonQuitResult.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultMouseExited

    private void ButtonQuitResultMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseReleased
        ButtonQuitResult.setForeground(new Color(158, 158, 158));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultMouseReleased

    private void ButtonQuitResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitResultActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultActionPerformed

    private void ButtonP9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP9ActionPerformed

    private void ButtonP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP7ActionPerformed

    private void ButtonP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP5ActionPerformed

    private void ButtonOnePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOnePlayerActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonOnePlayerActionPerformed

    private void ButtonP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonP3ActionPerformed

    private void ButtonArrowCreateGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowCreateGameMouseEntered
        // TODO add your handling code here:
        ButtonArrowCreateGame.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonArrowCreateGameMouseEntered

    private void ButtonArrowCreateGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowCreateGameMouseExited
        // TODO add your handling code here:
        ButtonArrowCreateGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowCreateGameMouseExited

    private void ButtonArrowCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowCreateGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonArrowCreateGameActionPerformed

    private void ButtonCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "CreateGameCard");
    }//GEN-LAST:event_ButtonCreateGameActionPerformed

    private void ButtonSamePCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSamePCActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonSamePCActionPerformed

    private void ButtonJoinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseEntered
        // TODO add your handling code here:
        ButtonJoin.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonJoinMouseEntered

    private void ButtonJoinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseExited
        // TODO add your handling code here:
        ButtonJoin.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonJoinMouseExited

    private void ButtonRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseEntered
        // TODO add your handling code here:
        ButtonRefresh.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonRefreshMouseEntered

    private void ButtonRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseExited
        // TODO add your handling code here:
        ButtonRefresh.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonRefreshMouseExited

    private void ButtonArrowJoinGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameMouseEntered
        // TODO add your handling code here:
        ButtonArrowJoinGame.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonArrowJoinGameMouseEntered

    private void ButtonArrowJoinGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameMouseExited
        // TODO add your handling code here:
        ButtonArrowJoinGame.setForeground(new Color(158, 158, 158));
    }//GEN-LAST:event_ButtonArrowJoinGameMouseExited

    private void ButtonRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMousePressed
        // TODO add your handling code here:
        ButtonRefresh.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_ButtonRefreshMousePressed

    private void ButtonRefreshMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseReleased
        // TODO add your handling code here:
        ButtonRefresh.setForeground(new Color(224, 224, 224));
    }//GEN-LAST:event_ButtonRefreshMouseReleased

    private void ButtonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonJoinActionPerformed

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
    private javax.swing.JButton ButtonArrowCreateGame;
    private javax.swing.JButton ButtonArrowGameMode;
    private javax.swing.JButton ButtonArrowJoinGame;
    private javax.swing.JButton ButtonArrowLocalNetwork;
    private javax.swing.JButton ButtonArrowMyProfile;
    private javax.swing.JButton ButtonArrowRecords;
    private javax.swing.JButton ButtonArrowTowPlayers;
    private javax.swing.JButton ButtonCreateGame;
    private javax.swing.JButton ButtonForfit;
    private javax.swing.JButton ButtonJoin;
    private javax.swing.JButton ButtonJoinGame;
    private javax.swing.JButton ButtonLocalNetwork;
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonMainMenu;
    private javax.swing.JButton ButtonMyProfile;
    private javax.swing.JButton ButtonOnePlayer;
    private javax.swing.JButton ButtonP1;
    private javax.swing.JButton ButtonP2;
    private javax.swing.JButton ButtonP3;
    private javax.swing.JButton ButtonP4;
    private javax.swing.JButton ButtonP5;
    private javax.swing.JButton ButtonP6;
    private javax.swing.JButton ButtonP7;
    private javax.swing.JButton ButtonP8;
    private javax.swing.JButton ButtonP9;
    private javax.swing.JButton ButtonPlayAgain;
    private javax.swing.JButton ButtonPlayers;
    private javax.swing.JButton ButtonQuit;
    private javax.swing.JButton ButtonQuitResult;
    private javax.swing.JButton ButtonRecords;
    private javax.swing.JButton ButtonRefresh;
    private javax.swing.JButton ButtonSamePC;
    private javax.swing.JButton ButtonSignup;
    private javax.swing.JButton ButtonStartGame;
    private javax.swing.JButton ButtonTwoPlayers;
    private javax.swing.JPanel CreateGamePanel;
    private javax.swing.JPanel GameBoardPanel;
    private javax.swing.JPanel GameModePanel;
    private javax.swing.JPanel GameResultPanel;
    private javax.swing.JPanel JoinGamePanel;
    private javax.swing.JLabel LabelCurrentTurn;
    private javax.swing.JLabel LabelCurrentTurnValue;
    private javax.swing.JLabel LabelDraws;
    private javax.swing.JLabel LabelHistory;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogo2;
    private javax.swing.JLabel LabelLosses;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelPlayer1;
    private javax.swing.JLabel LabelPlayer2;
    private javax.swing.JLabel LabelTmp;
    private javax.swing.JLabel LabelTotalGames;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JLabel LabelWaitingOpponent;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JLabel LabelWins;
    private javax.swing.JPanel LocalNetworkPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel MainMenuPanel;
    private javax.swing.JPanel MyProfilePanel;
    private javax.swing.JPasswordField PasswordFieldPassword;
    private javax.swing.JPanel RecordsPanel;
    private javax.swing.JScrollPane ScrollPaneHistoryTable;
    private javax.swing.JTable TableActivePlayer;
    private javax.swing.JTable TableHistory;
    private javax.swing.JTextField TextFieldUsername;
    private javax.swing.JPanel TwoPlayersPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
