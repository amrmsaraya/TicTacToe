package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.*;
import java.util.Vector;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import server.*;
import gamelogic.GameLogic;

public class TicTacToeFrame extends javax.swing.JFrame {

    public static Font FONT_ZORQUE;
    public static CardLayout cards;
    CreateServer createServer;
    JoinServer joinServer;
    GameLogic gameLogic;
    Vector<User> serverInfo;
    public static DefaultTableModel model;
    String currentTurn;

    public TicTacToeFrame() {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize(width, height);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
        setAutoRequestFocus(true);

        initComponents();

        cards = (CardLayout) parentPanel.getLayout();
        createServer = new CreateServer();
        gameLogic = new GameLogic();
        joinServer = new JoinServer(this);
        serverInfo = new Vector<User>();
        currentTurn = "X";
        model = new DefaultTableModel(new Object[]{"Username", "Ip Address"}, 0) {
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        TableAvailableServers.setModel(model);
        try {
            InputStream is = new BufferedInputStream(getClass().getResourceAsStream("resources/zorque.ttf"));
            FONT_ZORQUE = Font.createFont(Font.TRUETYPE_FONT, is);

            // Login
            LoginPanel.setBackground(new Color(33, 33, 33));
            LabelLogo.setFont(FONT_ZORQUE.deriveFont(144f));
            LabelLogo.setForeground(new Color(198, 40, 40));
            LabelUsername.setFont(FONT_ZORQUE.deriveFont(60f));
            LabelPassword.setFont(FONT_ZORQUE.deriveFont(60f));
            ButtonLogin.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonLogin.setForeground(new Color(46, 125, 50));
            ButtonSignup.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonSignup.setForeground(new Color(63, 81, 181));
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
            MainMenuPanel.setBackground(new Color(33, 33, 33));
            LabelLogo2.setFont(FONT_ZORQUE.deriveFont(144f));
            LabelLogo2.setForeground(new Color(198, 40, 40));
            ButtonStartGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonStartGame.setForeground(new Color(63, 81, 181));
            ButtonProfile.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonProfile.setForeground(new Color(63, 81, 181));
            ButtonQuit.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonQuit.setForeground(new Color(63, 81, 181));
            ButtonStartGame.setOpaque(false);
            ButtonStartGame.setContentAreaFilled(false);
            ButtonStartGame.setBorderPainted(false);
            ButtonProfile.setOpaque(false);
            ButtonProfile.setContentAreaFilled(false);
            ButtonProfile.setBorderPainted(false);
            ButtonQuit.setOpaque(false);
            ButtonQuit.setContentAreaFilled(false);
            ButtonQuit.setBorderPainted(false);

            // Game Modes
            GameModePanel.setBackground(new Color(33, 33, 33));
            ButtonOnePlayer.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonOnePlayer.setForeground(new Color(63, 81, 181));
            ButtonTwoPlayers.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonTwoPlayers.setForeground(new Color(63, 81, 181));
            ButtonArrowGameMode.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowGameMode.setForeground(new Color(198, 40, 40));
            ButtonOnePlayer.setOpaque(false);
            ButtonOnePlayer.setContentAreaFilled(false);
            ButtonOnePlayer.setBorderPainted(false);
            ButtonTwoPlayers.setOpaque(false);
            ButtonTwoPlayers.setContentAreaFilled(false);
            ButtonTwoPlayers.setBorderPainted(false);
            ButtonArrowGameMode.setOpaque(false);
            ButtonArrowGameMode.setContentAreaFilled(false);
            ButtonArrowGameMode.setBorderPainted(false);

            // Two Players Mode
            TwoPlayersPanel.setBackground(new Color(33, 33, 33));
            ButtonSamePC.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonSamePC.setForeground(new Color(63, 81, 181));
            ButtonLocalNetwork.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonLocalNetwork.setForeground(new Color(63, 81, 181));
            ButtonArrowTwoPlayers.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowTwoPlayers.setForeground(new Color(198, 40, 40));
            ButtonSamePC.setOpaque(false);
            ButtonSamePC.setContentAreaFilled(false);
            ButtonSamePC.setBorderPainted(false);
            ButtonLocalNetwork.setOpaque(false);
            ButtonLocalNetwork.setContentAreaFilled(false);
            ButtonLocalNetwork.setBorderPainted(false);
            ButtonArrowTwoPlayers.setOpaque(false);
            ButtonArrowTwoPlayers.setContentAreaFilled(false);
            ButtonArrowTwoPlayers.setBorderPainted(false);

            // Local Network Mode
            LocalNetworkPanel.setBackground(new Color(33, 33, 33));
            ButtonCreateGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonCreateGame.setForeground(new Color(63, 81, 181));
            ButtonJoinGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonJoinGame.setForeground(new Color(63, 81, 181));
            ButtonArrowLocalNetwork.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowLocalNetwork.setForeground(new Color(198, 40, 40));
            ButtonCreateGame.setOpaque(false);
            ButtonCreateGame.setContentAreaFilled(false);
            ButtonCreateGame.setBorderPainted(false);
            ButtonJoinGame.setOpaque(false);
            ButtonJoinGame.setContentAreaFilled(false);
            ButtonJoinGame.setBorderPainted(false);
            ButtonArrowLocalNetwork.setOpaque(false);
            ButtonArrowLocalNetwork.setContentAreaFilled(false);
            ButtonArrowLocalNetwork.setBorderPainted(false);

            // Profile
            ProfilePanel.setBackground(new Color(33, 33, 33));
            LabelWelcome.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowMyProfile.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowMyProfile.setForeground(new Color(198, 40, 40));
            LabelTotalGames.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelWins.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelLosses.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelDraws.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelWins.setForeground(new Color(46, 125, 50));
            LabelLosses.setForeground(new Color(198, 40, 40));
            LabelDraws.setForeground(new Color(63, 81, 181));
            LabelHistory.setFont(FONT_ZORQUE.deriveFont(48f));
            TableHistory.getTableHeader().setFont(FONT_ZORQUE.deriveFont(32f));
            TableHistory.getTableHeader().setForeground(new Color(33, 33, 33));
            ButtonArrowMyProfile.setOpaque(false);
            ButtonArrowMyProfile.setContentAreaFilled(false);
            ButtonArrowMyProfile.setBorderPainted(false);

            // Game Board
            GameBoardPanel.setBackground(new Color(33, 33, 33));
            PanelBoard.setOpaque(false);
            ButtonP1.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP2.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP3.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP4.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP5.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP6.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP7.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP8.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonP9.setFont(FONT_ZORQUE.deriveFont(120f));
            ButtonForfit.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonForfit.setForeground(new Color(198, 40, 40));
            LabelPlayer1.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelPlayer2.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelX.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelX.setForeground(new Color(63, 81, 181));
            LabelO.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelO.setForeground(new Color(198, 40, 40));
            LabelCurrentTurn.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelCurrentTurnValue.setFont(FONT_ZORQUE.deriveFont(72f));
            LabelCurrentTurnValue.setForeground(new Color(63, 81, 181));
            ButtonForfit.setOpaque(false);
            ButtonForfit.setContentAreaFilled(false);
            ButtonForfit.setBorderPainted(false);

            // Create Game
            CreateGamePanel.setBackground(new Color(33, 33, 33));
            LabelWaitingOpponent.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowCreateGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowCreateGame.setForeground(new Color(198, 40, 40));
            ButtonArrowCreateGame.setOpaque(false);
            ButtonArrowCreateGame.setContentAreaFilled(false);
            ButtonArrowCreateGame.setBorderPainted(false);

            // Join Game
            JoinGamePanel.setBackground(new Color(33, 33, 33));
            ButtonJoin.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonJoin.setForeground(new Color(46, 125, 50));
            ButtonSearch.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonSearch.setForeground(new Color(63, 81, 181));
            ButtonArrowJoinGame.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonArrowJoinGame.setForeground(new Color(198, 40, 40));
            ButtonJoin.setOpaque(false);
            ButtonJoin.setContentAreaFilled(false);
            ButtonJoin.setBorderPainted(false);
            ButtonSearch.setOpaque(false);
            ButtonSearch.setContentAreaFilled(false);
            ButtonSearch.setBorderPainted(false);
            ButtonArrowJoinGame.setOpaque(false);
            ButtonArrowJoinGame.setContentAreaFilled(false);
            ButtonArrowJoinGame.setBorderPainted(false);
            TableAvailableServers.getTableHeader().setFont(FONT_ZORQUE.deriveFont(32f));
            TableAvailableServers.getTableHeader().setForeground(new Color(33, 33, 33));
            TableAvailableServers.setFont(TicTacToeFrame.FONT_ZORQUE.deriveFont(32f));
            TableAvailableServers.setForeground(new Color(63, 81, 181));
            TableAvailableServers.setBackground(new Color(33, 33, 33));
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            TableAvailableServers.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            TableAvailableServers.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            ((DefaultTableCellRenderer) TableAvailableServers.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

            // Game Result
            GameResultPanel.setBackground(new Color(33, 33, 33));
            ButtonPlayAgain.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonPlayAgain.setForeground(new Color(46, 125, 50));
            ButtonMainMenu.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonMainMenu.setForeground(new Color(63, 81, 181));
            ButtonQuitResult.setFont(FONT_ZORQUE.deriveFont(72f));
            ButtonQuitResult.setForeground(new Color(198, 40, 40));
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
        ButtonProfile = new javax.swing.JButton();
        ButtonQuit = new javax.swing.JButton();
        GameModePanel = new javax.swing.JPanel();
        ButtonOnePlayer = new javax.swing.JButton();
        ButtonTwoPlayers = new javax.swing.JButton();
        ButtonArrowGameMode = new javax.swing.JButton();
        TwoPlayersPanel = new javax.swing.JPanel();
        ButtonSamePC = new javax.swing.JButton();
        ButtonLocalNetwork = new javax.swing.JButton();
        ButtonArrowTwoPlayers = new javax.swing.JButton();
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
        ButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAvailableServers = new javax.swing.JTable();
        ProfilePanel = new javax.swing.JPanel();
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
        ButtonForfit = new javax.swing.JButton();
        PanelBoard = new javax.swing.JPanel();
        ButtonP1 = new javax.swing.JButton();
        ButtonP2 = new javax.swing.JButton();
        ButtonP3 = new javax.swing.JButton();
        ButtonP4 = new javax.swing.JButton();
        ButtonP5 = new javax.swing.JButton();
        ButtonP6 = new javax.swing.JButton();
        ButtonP7 = new javax.swing.JButton();
        ButtonP8 = new javax.swing.JButton();
        ButtonP9 = new javax.swing.JButton();
        LabelX = new javax.swing.JLabel();
        LabelO = new javax.swing.JLabel();
        GameResultPanel = new javax.swing.JPanel();
        ButtonPlayAgain = new javax.swing.JButton();
        ButtonMainMenu = new javax.swing.JButton();
        ButtonQuitResult = new javax.swing.JButton();
        LabelTmp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parentPanel.setLayout(new java.awt.CardLayout());

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
        TextFieldUsername.setForeground(new java.awt.Color(33, 33, 33));
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
        PasswordFieldPassword.setForeground(new java.awt.Color(33, 33, 33));
        PasswordFieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        PasswordFieldPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PasswordFieldPassword.setMinimumSize(new java.awt.Dimension(80, 50));
        PasswordFieldPassword.setPreferredSize(new java.awt.Dimension(80, 50));

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(455, Short.MAX_VALUE)
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
                .addContainerGap(456, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LabelLogo)
                .addGap(190, 190, 190)
                .addComponent(LabelUsername)
                .addGap(15, 15, 15)
                .addComponent(TextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LabelPassword)
                .addGap(15, 15, 15)
                .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin)
                    .addComponent(ButtonSignup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(LoginPanel, "LoginCard");

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
        });
        ButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonStartGameActionPerformed(evt);
            }
        });

        ButtonProfile.setForeground(new java.awt.Color(158, 158, 158));
        ButtonProfile.setText("Profile");
        ButtonProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonProfileMouseExited(evt);
            }
        });
        ButtonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProfileActionPerformed(evt);
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
                .addContainerGap(492, Short.MAX_VALUE)
                .addGroup(MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelLogo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(493, Short.MAX_VALUE))
        );
        MainMenuPanelLayout.setVerticalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LabelLogo2)
                .addGap(183, 183, 183)
                .addComponent(ButtonStartGame)
                .addGap(64, 64, 64)
                .addComponent(ButtonProfile)
                .addGap(62, 62, 62)
                .addComponent(ButtonQuit)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        parentPanel.add(MainMenuPanel, "MainMenuCard");

        ButtonOnePlayer.setForeground(new java.awt.Color(158, 158, 158));
        ButtonOnePlayer.setText("One  Player");
        ButtonOnePlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonOnePlayerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonOnePlayerMouseExited(evt);
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

        ButtonSamePC.setForeground(new java.awt.Color(158, 158, 158));
        ButtonSamePC.setText("Same  PC ");
        ButtonSamePC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonSamePCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonSamePCMouseExited(evt);
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
        });
        ButtonLocalNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLocalNetworkActionPerformed(evt);
            }
        });

        ButtonArrowTwoPlayers.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowTwoPlayers.setText("<<");
        ButtonArrowTwoPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonArrowTwoPlayersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonArrowTwoPlayersMouseExited(evt);
            }
        });
        ButtonArrowTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArrowTwoPlayersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TwoPlayersPanelLayout = new javax.swing.GroupLayout(TwoPlayersPanel);
        TwoPlayersPanel.setLayout(TwoPlayersPanelLayout);
        TwoPlayersPanelLayout.setHorizontalGroup(
            TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TwoPlayersPanelLayout.createSequentialGroup()
                .addGroup(TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonArrowTwoPlayers)
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
                .addComponent(ButtonArrowTwoPlayers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonLocalNetwork)
                .addGap(65, 65, 65)
                .addComponent(ButtonSamePC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(TwoPlayersPanel, "TwoPlayersCard");

        ButtonCreateGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonCreateGame.setText("Create Game");
        ButtonCreateGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCreateGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCreateGameMouseExited(evt);
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

        ButtonSearch.setForeground(new java.awt.Color(158, 158, 158));
        ButtonSearch.setText("Search");
        ButtonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonSearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonSearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonSearchMouseReleased(evt);
            }
        });
        ButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchActionPerformed(evt);
            }
        });

        TableAvailableServers.setBackground(new java.awt.Color(33, 33, 33));
        TableAvailableServers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TableAvailableServers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "IP Address"
            }
        ));
        TableAvailableServers.setRowHeight(35);
        TableAvailableServers.setRowMargin(5);
        jScrollPane1.setViewportView(TableAvailableServers);

        javax.swing.GroupLayout JoinGamePanelLayout = new javax.swing.GroupLayout(JoinGamePanel);
        JoinGamePanel.setLayout(JoinGamePanelLayout);
        JoinGamePanelLayout.setHorizontalGroup(
            JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowJoinGame)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JoinGamePanelLayout.createSequentialGroup()
                        .addComponent(ButtonJoin)
                        .addGap(100, 100, 100)
                        .addComponent(ButtonSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JoinGamePanelLayout.setVerticalGroup(
            JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowJoinGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonJoin)
                    .addComponent(ButtonSearch))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        parentPanel.add(JoinGamePanel, "JoinGameCard");

        ProfilePanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ProfilePanelAncestorAdded(evt);
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

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWins)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelDraws)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelLosses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowMyProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(ScrollPaneHistoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 105, Short.MAX_VALUE))
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTotalGames)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfilePanelLayout.setVerticalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowMyProfile)
                .addGap(10, 10, 10)
                .addComponent(LabelWelcome)
                .addGap(65, 65, 65)
                .addComponent(LabelTotalGames)
                .addGap(34, 34, 34)
                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelWins)
                    .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelLosses)
                        .addComponent(LabelDraws)))
                .addGap(116, 116, 116)
                .addComponent(LabelHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneHistoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(ProfilePanel, "ProfileCard");

        LabelPlayer1.setForeground(new java.awt.Color(158, 158, 158));
        LabelPlayer1.setText("Player 1");

        LabelPlayer2.setForeground(new java.awt.Color(158, 158, 158));
        LabelPlayer2.setText("Player 2");

        LabelCurrentTurn.setForeground(new java.awt.Color(158, 158, 158));
        LabelCurrentTurn.setText("Current Turn");

        LabelCurrentTurnValue.setForeground(new java.awt.Color(158, 158, 158));
        LabelCurrentTurnValue.setText("X");

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

        PanelBoard.setBackground(new java.awt.Color(158, 158, 158));
        PanelBoard.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        PanelBoard.setLayout(new java.awt.GridLayout(3, 3, 5, 5));

        ButtonP1.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP1.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP1.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP1ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP1);

        ButtonP2.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP2.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP2.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP2ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP2);

        ButtonP3.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP3.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP3.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP3ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP3);

        ButtonP4.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP4.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP4.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP4ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP4);

        ButtonP5.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP5.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP5.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP5ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP5);

        ButtonP6.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP6.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP6.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP6ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP6);

        ButtonP7.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP7.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP7.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP7ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP7);

        ButtonP8.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP8.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP8.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP8ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP8);

        ButtonP9.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP9.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP9.setPreferredSize(new java.awt.Dimension(100, 100));
        ButtonP9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP9ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP9);

        LabelX.setText("X");

        LabelO.setText("O");

        javax.swing.GroupLayout GameBoardPanelLayout = new javax.swing.GroupLayout(GameBoardPanel);
        GameBoardPanel.setLayout(GameBoardPanelLayout);
        GameBoardPanelLayout.setHorizontalGroup(
            GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameBoardPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                                .addComponent(LabelO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                                .addComponent(LabelX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ButtonForfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelCurrentTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GameBoardPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelCurrentTurnValue)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        GameBoardPanelLayout.setVerticalGroup(
            GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameBoardPanelLayout.createSequentialGroup()
                        .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPlayer1)
                            .addComponent(LabelX))
                        .addGap(50, 50, 50)
                        .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPlayer2)
                            .addComponent(LabelO))
                        .addGap(109, 109, 109)
                        .addComponent(LabelCurrentTurn)
                        .addGap(18, 18, 18)
                        .addComponent(LabelCurrentTurnValue)
                        .addGap(67, 67, 67)
                        .addComponent(ButtonForfit))
                    .addComponent(PanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(GameBoardPanel, "GameBoardCard");

        ButtonPlayAgain.setForeground(new java.awt.Color(158, 158, 158));
        ButtonPlayAgain.setText("Play Again");
        ButtonPlayAgain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPlayAgainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPlayAgainMouseExited(evt);
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
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(ButtonPlayAgain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(ButtonMainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(ButtonQuitResult)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTmp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GameResultPanelLayout.setVerticalGroup(
            GameResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(LabelTmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
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
        ButtonStartGame.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonStartGameMouseEntered

    private void ButtonStartGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStartGameMouseExited
        ButtonStartGame.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonStartGameMouseExited

    private void ButtonProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonProfileMouseEntered
        ButtonProfile.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonProfileMouseEntered

    private void ButtonProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonProfileMouseExited
        ButtonProfile.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonProfileMouseExited

    private void ButtonQuitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitMouseEntered
        ButtonQuit.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonQuitMouseEntered

    private void ButtonQuitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitMouseExited
        ButtonQuit.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonQuitMouseExited

    private void ButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignupActionPerformed
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonSignupActionPerformed

    private void ButtonSignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignupMouseExited
        ButtonSignup.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonSignupMouseExited

    private void ButtonSignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignupMouseEntered
        ButtonSignup.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonSignupMouseEntered

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void ButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseExited
        ButtonLogin.setForeground(new Color(46, 125, 50));
    }//GEN-LAST:event_ButtonLoginMouseExited

    private void ButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseEntered
        ButtonLogin.setForeground(new Color(67, 160, 71));
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
        ButtonOnePlayer.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonOnePlayerMouseEntered

    private void ButtonOnePlayerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOnePlayerMouseExited
        ButtonOnePlayer.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonOnePlayerMouseExited

    private void ButtonTwoPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseEntered
        ButtonTwoPlayers.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonTwoPlayersMouseEntered

    private void ButtonTwoPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseExited
        ButtonTwoPlayers.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonTwoPlayersMouseExited

    private void ButtonArrowGameModeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseEntered
        ButtonArrowGameMode.setForeground(new Color(229, 57, 53));
    }//GEN-LAST:event_ButtonArrowGameModeMouseEntered

    private void ButtonArrowGameModeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseExited
        ButtonArrowGameMode.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowGameModeMouseExited

    private void ButtonLocalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkActionPerformed
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonLocalNetworkActionPerformed

    private void ButtonArrowTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowTwoPlayersActionPerformed
        cards.show(parentPanel, "GameModeCard");
    }//GEN-LAST:event_ButtonArrowTwoPlayersActionPerformed

    private void ButtonSamePCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseEntered
        ButtonSamePC.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonSamePCMouseEntered

    private void ButtonSamePCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseExited
        ButtonSamePC.setForeground(new Color(63, 81, 181));

    }//GEN-LAST:event_ButtonSamePCMouseExited

    private void ButtonArrowTwoPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTwoPlayersMouseEntered
        ButtonArrowTwoPlayers.setForeground(new Color(229, 57, 53));
    }//GEN-LAST:event_ButtonArrowTwoPlayersMouseEntered

    private void ButtonArrowTwoPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTwoPlayersMouseExited
        ButtonArrowTwoPlayers.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowTwoPlayersMouseExited

    private void ButtonLocalNetworkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseEntered
        ButtonLocalNetwork.setForeground(new Color(121, 134, 203));

    }//GEN-LAST:event_ButtonLocalNetworkMouseEntered

    private void ButtonLocalNetworkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseExited
        ButtonLocalNetwork.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonLocalNetworkMouseExited

    private void ButtonJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinGameActionPerformed
        cards.show(parentPanel, "JoinGameCard");
    }//GEN-LAST:event_ButtonJoinGameActionPerformed

    private void ButtonCreateGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseEntered
        ButtonCreateGame.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonCreateGameMouseEntered

    private void ButtonCreateGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseExited
        ButtonCreateGame.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonCreateGameMouseExited

    private void ButtonArrowLocalNetworkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseEntered
        ButtonArrowLocalNetwork.setForeground(new Color(229, 57, 53));
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseEntered

    private void ButtonArrowLocalNetworkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseExited
        ButtonArrowLocalNetwork.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseExited

    private void ButtonJoinGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseEntered
        ButtonJoinGame.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonJoinGameMouseEntered

    private void ButtonJoinGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseExited
        ButtonJoinGame.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonJoinGameMouseExited

    private void ButtonArrowLocalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkActionPerformed
        cards.show(parentPanel, "TwoPlayersCard");
    }//GEN-LAST:event_ButtonArrowLocalNetworkActionPerformed

    private void ButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProfileActionPerformed
        cards.show(parentPanel, "ProfileCard");
    }//GEN-LAST:event_ButtonProfileActionPerformed

    private void ButtonArrowMyProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseEntered
        ButtonArrowMyProfile.setForeground(new Color(229, 57, 53));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileMouseEntered

    private void ButtonArrowMyProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseExited
        ButtonArrowMyProfile.setForeground(new Color(198, 40, 40));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileMouseExited

    private void ButtonArrowMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileActionPerformed
        cards.show(parentPanel, "MainMenuCard");
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonArrowMyProfileActionPerformed

    private void ProfilePanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ProfilePanelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfilePanelAncestorAdded

    private void ButtonP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP2ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP2.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP2.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP2.setForeground(new Color(198, 40, 40));
            }
            ButtonP2.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP2ActionPerformed

    private void ButtonP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP4ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP4.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP4.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP4.setForeground(new Color(198, 40, 40));
            }
            ButtonP4.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP4ActionPerformed

    private void ButtonP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP6ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP6.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP6.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP6.setForeground(new Color(198, 40, 40));
            }
            ButtonP6.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP6ActionPerformed

    private void ButtonForfitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonForfitMouseEntered
        ButtonForfit.setForeground(new Color(229, 57, 53));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonForfitMouseEntered

    private void ButtonForfitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonForfitMouseExited
        ButtonForfit.setForeground(new Color(198, 40, 40));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonForfitMouseExited

    private void ButtonForfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonForfitActionPerformed
        // TODO add your handling code here:
        gameLogic.clearBoard();
        cards.show(parentPanel, "GameResultCard");
    }//GEN-LAST:event_ButtonForfitActionPerformed

    private void ButtonArrowJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonArrowJoinGameActionPerformed

    private void ButtonPlayAgainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseEntered
        ButtonPlayAgain.setForeground(new Color(67, 160, 70));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPlayAgainMouseEntered

    private void ButtonPlayAgainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseExited
        ButtonPlayAgain.setForeground(new Color(46, 125, 50));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPlayAgainMouseExited

    private void ButtonPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPlayAgainActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonPlayAgainActionPerformed

    private void ButtonMainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseEntered
        ButtonMainMenu.setForeground(new Color(121, 134, 203));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuMouseEntered

    private void ButtonMainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseExited
        ButtonMainMenu.setForeground(new Color(63, 81, 181));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuMouseExited

    private void ButtonMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMainMenuActionPerformed
        cards.show(parentPanel, "MainMenuCard");
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonMainMenuActionPerformed

    private void ButtonQuitResultMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseEntered
        ButtonQuitResult.setForeground(new Color(229, 57, 53));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultMouseEntered

    private void ButtonQuitResultMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseExited
        ButtonQuitResult.setForeground(new Color(198, 40, 40));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultMouseExited

    private void ButtonQuitResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitResultActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitResultActionPerformed

    private void ButtonP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP7ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP7.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP7.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP7.setForeground(new Color(198, 40, 40));
            }
            ButtonP7.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP7ActionPerformed

    private void ButtonP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP5ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP5.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP5.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP5.setForeground(new Color(198, 40, 40));
            }
            ButtonP5.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP5ActionPerformed

    private void ButtonOnePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOnePlayerActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonOnePlayerActionPerformed

    private void ButtonP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP3ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP3.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP3.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP3.setForeground(new Color(198, 40, 40));
            }
            ButtonP3.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP3ActionPerformed

    private void ButtonArrowCreateGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowCreateGameMouseEntered
        // TODO add your handling code here:
        ButtonArrowCreateGame.setForeground(new Color(229, 57, 53));
    }//GEN-LAST:event_ButtonArrowCreateGameMouseEntered

    private void ButtonArrowCreateGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowCreateGameMouseExited
        // TODO add your handling code here:
        ButtonArrowCreateGame.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowCreateGameMouseExited

    private void ButtonArrowCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowCreateGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonArrowCreateGameActionPerformed

    private void ButtonCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "CreateGameCard");
        createServer.create();
    }//GEN-LAST:event_ButtonCreateGameActionPerformed

    private void ButtonSamePCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSamePCActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonSamePCActionPerformed

    private void ButtonJoinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseEntered
        // TODO add your handling code here:
        ButtonJoin.setForeground(new Color(67, 160, 71));
    }//GEN-LAST:event_ButtonJoinMouseEntered

    private void ButtonJoinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseExited
        // TODO add your handling code here:
        ButtonJoin.setForeground(new Color(46, 125, 50));
    }//GEN-LAST:event_ButtonJoinMouseExited

    private void ButtonSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMouseEntered
        // TODO add your handling code here:
        ButtonSearch.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonSearchMouseEntered

    private void ButtonSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMouseExited
        // TODO add your handling code here:
        ButtonSearch.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonSearchMouseExited

    private void ButtonArrowJoinGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameMouseEntered
        // TODO add your handling code here:
        ButtonArrowJoinGame.setForeground(new Color(229, 57, 53));
    }//GEN-LAST:event_ButtonArrowJoinGameMouseEntered

    private void ButtonArrowJoinGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameMouseExited
        // TODO add your handling code here:
        ButtonArrowJoinGame.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowJoinGameMouseExited

    private void ButtonSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMousePressed
        // TODO add your handling code here:
        ButtonSearch.setForeground(new Color(159, 168, 218));
    }//GEN-LAST:event_ButtonSearchMousePressed

    private void ButtonSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMouseReleased
        // TODO add your handling code here:
        ButtonSearch.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonSearchMouseReleased

    private void ButtonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonJoinActionPerformed

    private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchActionPerformed
        // TODO add your handling code here:
        joinServer.search();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                serverInfo.setSize(0);
//                while (true) {
//                    if (joinServer.getSearchFinished() == true) {
//                        serverInfo = joinServer.getServerIpVector();
//                        for (User user : serverInfo) {
//                            System.out.println(user.getUsername());
//                            System.out.println(user.getIpAddress());
//                            model.addRow(new Object[]{user.getUsername(), user.getIpAddress()});
//                            model.fireTableDataChanged();
//                        }
//                        joinServer.setSearchFinished(false);
//                        break;
//                    }
//                }
//            }
//        }).start();
    }//GEN-LAST:event_ButtonSearchActionPerformed

    private void ButtonP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP1ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP1.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP1.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP1.setForeground(new Color(198, 40, 40));
            }
            ButtonP1.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP1ActionPerformed

    private void ButtonP8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP8ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP8.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP8.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP8.setForeground(new Color(198, 40, 40));
            }
            ButtonP8.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP8ActionPerformed

    private void ButtonP9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP9ActionPerformed
        // TODO add your handling code here:
        currentTurn = gameLogic.checkPlayerTurn();
        if (ButtonP9.getText().isEmpty()) {
            if (currentTurn.equals("X")) {
                ButtonP9.setForeground(new Color(63, 81, 181));
            } else {
                ButtonP9.setForeground(new Color(198, 40, 40));
            }
            ButtonP9.setText(currentTurn);
            gameLogic.checkWin();
        }
    }//GEN-LAST:event_ButtonP9ActionPerformed

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
    private javax.swing.JButton ButtonArrowTwoPlayers;
    private javax.swing.JButton ButtonCreateGame;
    private javax.swing.JButton ButtonForfit;
    private javax.swing.JButton ButtonJoin;
    private javax.swing.JButton ButtonJoinGame;
    private javax.swing.JButton ButtonLocalNetwork;
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonMainMenu;
    private javax.swing.JButton ButtonOnePlayer;
    public static javax.swing.JButton ButtonP1;
    public static javax.swing.JButton ButtonP2;
    public static javax.swing.JButton ButtonP3;
    public static javax.swing.JButton ButtonP4;
    public static javax.swing.JButton ButtonP5;
    public static javax.swing.JButton ButtonP6;
    public static javax.swing.JButton ButtonP7;
    public static javax.swing.JButton ButtonP8;
    public static javax.swing.JButton ButtonP9;
    private javax.swing.JButton ButtonPlayAgain;
    private javax.swing.JButton ButtonProfile;
    private javax.swing.JButton ButtonQuit;
    private javax.swing.JButton ButtonQuitResult;
    private javax.swing.JButton ButtonSamePC;
    public static javax.swing.JButton ButtonSearch;
    private javax.swing.JButton ButtonSignup;
    private javax.swing.JButton ButtonStartGame;
    private javax.swing.JButton ButtonTwoPlayers;
    private javax.swing.JPanel CreateGamePanel;
    private javax.swing.JPanel GameBoardPanel;
    private javax.swing.JPanel GameModePanel;
    private javax.swing.JPanel GameResultPanel;
    private javax.swing.JPanel JoinGamePanel;
    private javax.swing.JLabel LabelCurrentTurn;
    public static javax.swing.JLabel LabelCurrentTurnValue;
    private javax.swing.JLabel LabelDraws;
    private javax.swing.JLabel LabelHistory;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogo2;
    private javax.swing.JLabel LabelLosses;
    private javax.swing.JLabel LabelO;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelPlayer1;
    private javax.swing.JLabel LabelPlayer2;
    public static javax.swing.JLabel LabelTmp;
    private javax.swing.JLabel LabelTotalGames;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JLabel LabelWaitingOpponent;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JLabel LabelWins;
    private javax.swing.JLabel LabelX;
    private javax.swing.JPanel LocalNetworkPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel MainMenuPanel;
    private javax.swing.JPanel PanelBoard;
    private javax.swing.JPasswordField PasswordFieldPassword;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JScrollPane ScrollPaneHistoryTable;
    public static javax.swing.JTable TableAvailableServers;
    private javax.swing.JTable TableHistory;
    private javax.swing.JTextField TextFieldUsername;
    private javax.swing.JPanel TwoPlayersPanel;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
