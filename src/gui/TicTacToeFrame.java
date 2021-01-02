package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import gamelogic.GameLogic;
import java.awt.Dimension;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import media.Soundtrack;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class TicTacToeFrame extends javax.swing.JFrame {

    public static Font FONT_ZORQUE;
    public static CardLayout cards;
    DefaultTableModel tableModel;
    String infoStatus = "";
    String[] infoStatusData = null;

    String gameMode;
    String myMark;
    int moveNumber;
    String whosTurn;
    String opponent;
    int playAgain;
    int isGameCreated;
    int isGameJoined;
    int isConnected;
    int isGameEnded;
    int isTableClicked;

    int profile;

    Socket s;
    InputStreamReader isr;
    BufferedReader br;
    PrintStream ps;
    String LoggedUsername;
    String gameId;
    int isLoginPressed;
    DefaultListModel listModel;

    String currentTurn;
    GameLogic gameLogic;

    // Adaptive font size
    float FONT_SIZE_144;
    float FONT_SIZE_120;
    float FONT_SIZE_100;
    float FONT_SIZE_72;
    float FONT_SIZE_60;
    float FONT_SIZE_32;

    Soundtrack soundtrack;
    Thread th;

    public TicTacToeFrame() {
        setUndecorated(true);
        setBackground(new Color(33, 33, 33));
        setVisible(true);
        setAutoRequestFocus(true);
        setResizable(false);
        listModel = new DefaultListModel();

        initComponents();

        isConnected = 0;
        isTableClicked = 0;
        th = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (isConnected == 0) {
                        try {
                            s = new Socket("127.0.0.1", 6610);
                            isr = new InputStreamReader(s.getInputStream());
                            br = new BufferedReader(isr);
                            ps = new PrintStream(s.getOutputStream());
                            isConnected = 1;
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            isConnected = 0;
                        }
                    }

                }
            }
        });
        th.start();

        gameMode = "single";
        myMark = "X";
        whosTurn = "X";
        opponent = "";
        playAgain = 0;
        moveNumber = 0;
        isGameCreated = 0;
        isGameJoined = 0;
        isGameEnded = 0;

        profile = 0;

        soundtrack = new Soundtrack();
        soundtrack.backgroundMusic();

        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize(width, height);

        // Login
        isLoginPressed = 0;
        LoggedUsername = "";
        gameId = "";

        // Adaptive font size
        FONT_SIZE_144 = width * 144 / 1920;
        FONT_SIZE_120 = width * 120 / 1920;
        FONT_SIZE_100 = width * 100 / 1920;
        FONT_SIZE_72 = width * 72 / 1920;
        FONT_SIZE_60 = width * 60 / 1920;
        FONT_SIZE_32 = width * 32 / 1920;
        int boardBoxSize = width * 100 / 1920;

        cards = (CardLayout) parentPanel.getLayout();
        gameLogic = new GameLogic();
        currentTurn = "X";

        try {
            InputStream is = new BufferedInputStream(getClass().getResourceAsStream("resources/zorque.ttf"));
            FONT_ZORQUE = Font.createFont(Font.TRUETYPE_FONT, is);
            listModel.removeAllElements();

            // Login
            LoginPanel.setBackground(new Color(33, 33, 33));
            LabelLogo.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_144));
            LabelLogo.setForeground(new Color(198, 40, 40));
            LabelUsername.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_60));
            LabelPassword.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_60));
            ButtonLogin.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonLogin.setForeground(new Color(46, 125, 50));
            ButtonSignup.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonSignup.setForeground(new Color(63, 81, 181));
            ButtonLogin.setOpaque(false);
            ButtonLogin.setContentAreaFilled(false);
            ButtonLogin.setBorderPainted(false);
            ButtonSignup.setOpaque(false);
            ButtonSignup.setContentAreaFilled(false);
            ButtonSignup.setBorderPainted(false);
            TextFieldUsername.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_32));
            PasswordFieldPassword.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_32));
            TextFieldUsername.requestFocus();

            // Main Menu
            MainMenuPanel.setBackground(new Color(33, 33, 33));
            LabelLogo2.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_144));
            LabelLogo2.setForeground(new Color(198, 40, 40));
            ButtonStartGame.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonStartGame.setForeground(new Color(63, 81, 181));
            ButtonProfile.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonProfile.setForeground(new Color(63, 81, 181));
            ButtonQuit.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
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
            ButtonOnePlayer.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonOnePlayer.setForeground(new Color(63, 81, 181));
            ButtonTwoPlayers.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonTwoPlayers.setForeground(new Color(63, 81, 181));
            ButtonArrowGameMode.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_100));
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
            ButtonSamePC.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonSamePC.setForeground(new Color(63, 81, 181));
            ButtonLocalNetwork.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonLocalNetwork.setForeground(new Color(63, 81, 181));
            ButtonArrowTwoPlayers.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_100));
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
            ButtonCreateGame.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonCreateGame.setForeground(new Color(63, 81, 181));
            ButtonJoinGame.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonJoinGame.setForeground(new Color(63, 81, 181));
            ButtonArrowLocalNetwork.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_100));
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
            LabelWelcome.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonArrowMyProfile.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_100));
            ButtonArrowMyProfile.setForeground(new Color(198, 40, 40));
            LabelTotalGames.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelWins.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelLosses.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelDraws.setFont(FONT_ZORQUE.deriveFont(48f));
            LabelWins.setForeground(new Color(46, 125, 50));
            LabelLosses.setForeground(new Color(198, 40, 40));
            LabelDraws.setForeground(new Color(63, 81, 181));
            LabelHistory.setFont(FONT_ZORQUE.deriveFont(48f));
            TableHistory.getTableHeader().setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_32));
            TableHistory.getTableHeader().setForeground(new Color(33, 33, 33));
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            cellRenderer.setBackground(new Color(33, 33, 33));
            cellRenderer.setForeground(new Color(158, 158, 158));
            TableHistory.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
            TableHistory.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
            TableHistory.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
            TableHistory.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
            TableHistory.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
            ButtonArrowMyProfile.setOpaque(false);
            ButtonArrowMyProfile.setContentAreaFilled(false);
            ButtonArrowMyProfile.setBorderPainted(false);
            tableModel = (DefaultTableModel) TableHistory.getModel();

            // Game Board
            GameBoardPanel.setBackground(new Color(33, 33, 33));
            PanelBoard.setOpaque(false);
            ButtonP1.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP1.setSize(boardBoxSize, boardBoxSize);
            ButtonP2.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP2.setSize(boardBoxSize, boardBoxSize);
            ButtonP3.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP3.setSize(boardBoxSize, boardBoxSize);
            ButtonP4.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP4.setSize(boardBoxSize, boardBoxSize);
            ButtonP5.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP5.setSize(boardBoxSize, boardBoxSize);
            ButtonP6.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP6.setSize(boardBoxSize, boardBoxSize);
            ButtonP7.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP7.setSize(boardBoxSize, boardBoxSize);
            ButtonP8.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP8.setSize(boardBoxSize, boardBoxSize);
            ButtonP9.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_120));
            ButtonP9.setSize(boardBoxSize, boardBoxSize);
            ButtonForfit.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonForfit.setForeground(new Color(198, 40, 40));
            LabelPlayer1.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelPlayer2.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelX.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelX.setForeground(new Color(63, 81, 181));
            LabelO.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelO.setForeground(new Color(198, 40, 40));
            LabelRecord.setForeground(new Color(158, 158, 158));
            LabelRecord.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonRecord.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonRecord.setForeground(new Color(79, 79, 79));
            LabelCurrentTurn.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelCurrentTurnValue.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelCurrentTurnValue.setForeground(new Color(63, 81, 181));
            ButtonForfit.setOpaque(false);
            ButtonForfit.setContentAreaFilled(false);
            ButtonForfit.setBorderPainted(false);
            ButtonRecord.setOpaque(false);
            ButtonRecord.setContentAreaFilled(false);
            ButtonRecord.setBorderPainted(false);

            // Join Game
            JoinGamePanel.setBackground(new Color(33, 33, 33));
            ButtonJoin.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonJoin.setForeground(new Color(46, 125, 50));
            ButtonSearch.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonSearch.setForeground(new Color(63, 81, 181));
            ListAvailableGames.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_60));
            ListAvailableGames.setBackground(new Color(33, 33, 33));
            ListAvailableGames.setForeground(new Color(158, 158, 158));
            ListAvailableGames.setSelectionBackground(new Color(33, 33, 33));
            ListAvailableGames.setSelectionForeground(new Color(46, 125, 50));
            ListAvailableGames.setOpaque(false);
            ListAvailableGames.setVisibleRowCount(5);
            jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
            ListAvailableGames.setBorder(BorderFactory.createEmptyBorder());
            LabelAvailableGames.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            LabelAvailableGames.setForeground(new Color(198, 40, 40));
            ButtonArrowJoinGame.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_100));
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

            // Game Result
            GameResultPanel.setBackground(new Color(33, 33, 33));
            ButtonPlayAgain.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonPlayAgain.setForeground(new Color(46, 125, 50));
            ButtonMainMenu.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonMainMenu.setForeground(new Color(63, 81, 181));
            ButtonQuitResult.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
            ButtonQuitResult.setForeground(new Color(198, 40, 40));
            LabelTmp.setFont(FONT_ZORQUE.deriveFont(FONT_SIZE_72));
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
        jPanel3 = new javax.swing.JPanel();
        ButtonLogin = new javax.swing.JButton();
        LabelPassword = new javax.swing.JLabel();
        PasswordFieldPassword = new javax.swing.JPasswordField();
        ButtonSignup = new javax.swing.JButton();
        LabelLogo = new javax.swing.JLabel();
        LabelUsername = new javax.swing.JLabel();
        TextFieldUsername = new javax.swing.JTextField();
        LabelLoginSatus = new javax.swing.JLabel();
        MainMenuPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ButtonProfile = new javax.swing.JButton();
        ButtonQuit = new javax.swing.JButton();
        ButtonStartGame = new javax.swing.JButton();
        LabelLogo2 = new javax.swing.JLabel();
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
        JoinGamePanel = new javax.swing.JPanel();
        ButtonArrowJoinGame = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ButtonJoin = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ButtonSearch = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel5 = new javax.swing.JPanel();
        LabelAvailableGames = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListAvailableGames = new javax.swing.JList<>();
        ProfilePanel = new javax.swing.JPanel();
        ButtonArrowMyProfile = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        LabelWins = new javax.swing.JLabel();
        LabelDraws = new javax.swing.JLabel();
        LabelWelcome = new javax.swing.JLabel();
        LabelTotalGames = new javax.swing.JLabel();
        LabelLosses = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableHistory = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        LabelHistory = new javax.swing.JLabel();
        GameBoardPanel = new javax.swing.JPanel();
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
        jPanel1 = new javax.swing.JPanel();
        ButtonForfit = new javax.swing.JButton();
        LabelCurrentTurn = new javax.swing.JLabel();
        LabelPlayer2 = new javax.swing.JLabel();
        LabelCurrentTurnValue = new javax.swing.JLabel();
        LabelX = new javax.swing.JLabel();
        LabelO = new javax.swing.JLabel();
        LabelPlayer1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        LabelRecord = new javax.swing.JLabel();
        ButtonRecord = new javax.swing.JButton();
        GameResultPanel = new javax.swing.JPanel();
        ButtonPlayAgain = new javax.swing.JButton();
        ButtonMainMenu = new javax.swing.JButton();
        ButtonQuitResult = new javax.swing.JButton();
        LabelTmp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parentPanel.setBackground(new java.awt.Color(33, 33, 33));
        parentPanel.setLayout(new java.awt.CardLayout());

        LoginPanel.setBackground(new java.awt.Color(30, 30, 30));
        LoginPanel.setFocusable(false);
        LoginPanel.setNextFocusableComponent(TextFieldUsername);

        jPanel3.setOpaque(false);

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

        LabelPassword.setForeground(new java.awt.Color(158, 158, 158));
        LabelPassword.setText("Password");

        PasswordFieldPassword.setBackground(new java.awt.Color(158, 158, 158));
        PasswordFieldPassword.setForeground(new java.awt.Color(33, 33, 33));
        PasswordFieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        PasswordFieldPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PasswordFieldPassword.setMinimumSize(new java.awt.Dimension(80, 50));
        PasswordFieldPassword.setPreferredSize(new java.awt.Dimension(80, 50));

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

        LabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        LabelLogo.setForeground(new java.awt.Color(158, 158, 158));
        LabelLogo.setText("TicTacToe");

        LabelUsername.setForeground(new java.awt.Color(158, 158, 158));
        LabelUsername.setText("Username");

        TextFieldUsername.setBackground(new java.awt.Color(158, 158, 158));
        TextFieldUsername.setForeground(new java.awt.Color(33, 33, 33));
        TextFieldUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        TextFieldUsername.setMinimumSize(new java.awt.Dimension(80, 50));
        TextFieldUsername.setNextFocusableComponent(PasswordFieldPassword);
        TextFieldUsername.setPreferredSize(new java.awt.Dimension(80, 50));

        LabelLoginSatus.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LabelLoginSatus.setForeground(new java.awt.Color(198, 40, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ButtonLogin)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(ButtonSignup))
                    .addComponent(TextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelLoginSatus)
                    .addComponent(LabelLogo)
                    .addComponent(LabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelLogo)
                .addGap(130, 130, 130)
                .addComponent(LabelUsername)
                .addGap(15, 15, 15)
                .addComponent(TextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(LabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(LabelLoginSatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin)
                    .addComponent(ButtonSignup))
                .addContainerGap())
        );

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(LoginPanel, "LoginCard");

        jPanel4.setOpaque(false);

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

        LabelLogo2.setBackground(new java.awt.Color(255, 255, 153));
        LabelLogo2.setForeground(new java.awt.Color(158, 158, 158));
        LabelLogo2.setText("TicTacToe");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelLogo2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelLogo2)
                .addGap(130, 130, 130)
                .addComponent(ButtonStartGame)
                .addGap(64, 64, 64)
                .addComponent(ButtonProfile)
                .addGap(62, 62, 62)
                .addComponent(ButtonQuit)
                .addContainerGap())
        );

        javax.swing.GroupLayout MainMenuPanelLayout = new javax.swing.GroupLayout(MainMenuPanel);
        MainMenuPanel.setLayout(MainMenuPanelLayout);
        MainMenuPanelLayout.setHorizontalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainMenuPanelLayout.setVerticalGroup(
            MainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMenuPanelLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
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
        ButtonArrowGameMode.setText("<html>←</html>");
        ButtonArrowGameMode.setMargin(new java.awt.Insets(15, 30, 15, 30));
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
                .addContainerGap(423, Short.MAX_VALUE)
                .addGroup(GameModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonTwoPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonOnePlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(422, Short.MAX_VALUE))
            .addGroup(GameModePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowGameMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        GameModePanelLayout.setVerticalGroup(
            GameModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameModePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ButtonArrowGameMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 270, Short.MAX_VALUE)
                .addComponent(ButtonOnePlayer)
                .addGap(60, 60, 60)
                .addComponent(ButtonTwoPlayers)
                .addContainerGap(265, Short.MAX_VALUE))
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
        ButtonArrowTwoPlayers.setText("<html>←</html>");
        ButtonArrowTwoPlayers.setMargin(new java.awt.Insets(15, 30, 15, 30));
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
                    .addComponent(ButtonArrowTwoPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TwoPlayersPanelLayout.createSequentialGroup()
                        .addContainerGap(414, Short.MAX_VALUE)
                        .addGroup(TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonLocalNetwork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonSamePC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        TwoPlayersPanelLayout.setVerticalGroup(
            TwoPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TwoPlayersPanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowTwoPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(ButtonLocalNetwork)
                .addGap(65, 65, 65)
                .addComponent(ButtonSamePC)
                .addContainerGap(265, Short.MAX_VALUE))
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
        ButtonArrowLocalNetwork.setText("<html>←</html>");
        ButtonArrowLocalNetwork.setMargin(new java.awt.Insets(15, 30, 15, 30));
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
                .addComponent(ButtonArrowLocalNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LocalNetworkPanelLayout.setVerticalGroup(
            LocalNetworkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocalNetworkPanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowLocalNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonCreateGame)
                .addGap(65, 65, 65)
                .addComponent(ButtonJoinGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(LocalNetworkPanel, "LocalNetworkCard");

        ButtonArrowJoinGame.setForeground(new java.awt.Color(158, 158, 158));
        ButtonArrowJoinGame.setText("<html>←</html>");
        ButtonArrowJoinGame.setMargin(new java.awt.Insets(15, 30, 15, 30));
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

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler3);

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
        jPanel2.add(ButtonJoin);
        jPanel2.add(filler2);

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
        jPanel2.add(ButtonSearch);
        jPanel2.add(filler1);

        jPanel5.setOpaque(false);

        LabelAvailableGames.setText("Available Games");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ListAvailableGames.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "                    ", "                    ", "                    ", "                    ", "                    " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListAvailableGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListAvailableGames);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(LabelAvailableGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelAvailableGames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JoinGamePanelLayout = new javax.swing.GroupLayout(JoinGamePanel);
        JoinGamePanel.setLayout(JoinGamePanelLayout);
        JoinGamePanelLayout.setHorizontalGroup(
            JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addGroup(JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonArrowJoinGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JoinGamePanelLayout.createSequentialGroup()
                        .addContainerGap(80, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JoinGamePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JoinGamePanelLayout.setVerticalGroup(
            JoinGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoinGamePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowJoinGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
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
        ButtonArrowMyProfile.setText("<html>←</html>");
        ButtonArrowMyProfile.setMargin(new java.awt.Insets(15, 30, 15, 30));
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

        jPanel7.setOpaque(false);

        LabelWins.setForeground(new java.awt.Color(158, 158, 158));
        LabelWins.setText("Wins : 5");

        LabelDraws.setForeground(new java.awt.Color(158, 158, 158));
        LabelDraws.setText("Draws : 2");

        LabelWelcome.setForeground(new java.awt.Color(158, 158, 158));
        LabelWelcome.setText("Welcome Username!");

        LabelTotalGames.setForeground(new java.awt.Color(158, 158, 158));
        LabelTotalGames.setText("Total Games : 10");

        LabelLosses.setForeground(new java.awt.Color(158, 158, 158));
        LabelLosses.setText("Losses : 3");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelTotalGames)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(LabelWins)
                        .addGap(130, 130, 130)
                        .addComponent(LabelDraws)
                        .addGap(110, 110, 110)
                        .addComponent(LabelLosses)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelWelcome)
                .addGap(39, 39, 39)
                .addComponent(LabelTotalGames)
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelWins)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelLosses)
                        .addComponent(LabelDraws)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        TableHistory.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        TableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Opponent", "Game ID", "Date", "Winner", "Record"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableHistory.setOpaque(false);
        TableHistory.setPreferredSize(new java.awt.Dimension(375, 300));
        TableHistory.setRowHeight(50);
        TableHistory.getTableHeader().setReorderingAllowed(false);
        TableHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableHistoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableHistory);
        if (TableHistory.getColumnModel().getColumnCount() > 0) {
            TableHistory.getColumnModel().getColumn(0).setResizable(false);
            TableHistory.getColumnModel().getColumn(1).setResizable(false);
            TableHistory.getColumnModel().getColumn(2).setResizable(false);
            TableHistory.getColumnModel().getColumn(3).setResizable(false);
            TableHistory.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel8.setOpaque(false);

        LabelHistory.setForeground(new java.awt.Color(158, 158, 158));
        LabelHistory.setText("History");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelHistory)
                .addContainerGap())
        );

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfilePanelLayout.createSequentialGroup()
                        .addComponent(ButtonArrowMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfilePanelLayout.setVerticalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addComponent(ButtonArrowMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        parentPanel.add(ProfilePanel, "ProfileCard");

        PanelBoard.setBackground(new java.awt.Color(158, 158, 158));
        PanelBoard.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        PanelBoard.setLayout(new java.awt.GridLayout(3, 3, 5, 5));

        ButtonP1.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP1.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP1ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP1);

        ButtonP2.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP2.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP2ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP2);

        ButtonP3.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP3.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP3ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP3);

        ButtonP4.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP4.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP4ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP4);

        ButtonP5.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP5.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP5ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP5);

        ButtonP6.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP6.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP6ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP6);

        ButtonP7.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP7.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP7ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP7);

        ButtonP8.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP8.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP8ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP8);

        ButtonP9.setBackground(new java.awt.Color(158, 158, 158));
        ButtonP9.setForeground(new java.awt.Color(33, 33, 33));
        ButtonP9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonP9ActionPerformed(evt);
            }
        });
        PanelBoard.add(ButtonP9);

        jPanel1.setOpaque(false);

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

        LabelCurrentTurn.setForeground(new java.awt.Color(158, 158, 158));
        LabelCurrentTurn.setText("Current Turn");

        LabelPlayer2.setForeground(new java.awt.Color(158, 158, 158));
        LabelPlayer2.setText("Player 2");

        LabelCurrentTurnValue.setForeground(new java.awt.Color(158, 158, 158));
        LabelCurrentTurnValue.setText("X");

        LabelX.setText("X");

        LabelO.setText("O");

        LabelPlayer1.setForeground(new java.awt.Color(158, 158, 158));
        LabelPlayer1.setText("Player 1");

        jPanel6.setOpaque(false);

        LabelRecord.setText("Record");

        ButtonRecord.setText("off");
        ButtonRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRecordMouseExited(evt);
            }
        });
        ButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelCurrentTurnValue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ButtonForfit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelCurrentTurn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPlayer1)
                    .addComponent(LabelX))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPlayer2)
                    .addComponent(LabelO))
                .addGap(82, 82, 82)
                .addComponent(LabelCurrentTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelCurrentTurnValue)
                .addGap(73, 73, 73)
                .addComponent(ButtonForfit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout GameBoardPanelLayout = new javax.swing.GroupLayout(GameBoardPanel);
        GameBoardPanel.setLayout(GameBoardPanelLayout);
        GameBoardPanelLayout.setHorizontalGroup(
            GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(PanelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        GameBoardPanelLayout.setVerticalGroup(
            GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameBoardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GameBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(161, Short.MAX_VALUE)
                .addComponent(ButtonPlayAgain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(ButtonMainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(ButtonQuitResult)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTmp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GameResultPanelLayout.setVerticalGroup(
            GameResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameResultPanelLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(LabelTmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
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
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonStartGameMouseEntered

    private void ButtonStartGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStartGameMouseExited
        ButtonStartGame.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonStartGameMouseExited

    private void ButtonProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonProfileMouseEntered
        ButtonProfile.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonProfileMouseEntered

    private void ButtonProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonProfileMouseExited
        ButtonProfile.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonProfileMouseExited

    private void ButtonQuitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitMouseEntered
        ButtonQuit.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonQuitMouseEntered

    private void ButtonQuitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitMouseExited
        ButtonQuit.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonQuitMouseExited

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
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonOnePlayerMouseEntered

    private void ButtonOnePlayerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOnePlayerMouseExited
        ButtonOnePlayer.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonOnePlayerMouseExited

    private void ButtonTwoPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseEntered
        ButtonTwoPlayers.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonTwoPlayersMouseEntered

    private void ButtonTwoPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTwoPlayersMouseExited
        ButtonTwoPlayers.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonTwoPlayersMouseExited

    private void ButtonArrowGameModeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseEntered
        ButtonArrowGameMode.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonArrowGameModeMouseEntered

    private void ButtonArrowGameModeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowGameModeMouseExited
        ButtonArrowGameMode.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowGameModeMouseExited

    private void ButtonLocalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkActionPerformed
        gameMode = "network";
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonLocalNetworkActionPerformed

    private void ButtonArrowTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowTwoPlayersActionPerformed
        cards.show(parentPanel, "GameModeCard");
    }//GEN-LAST:event_ButtonArrowTwoPlayersActionPerformed

    private void ButtonSamePCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseEntered
        ButtonSamePC.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonSamePCMouseEntered

    private void ButtonSamePCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSamePCMouseExited
        ButtonSamePC.setForeground(new Color(63, 81, 181));

    }//GEN-LAST:event_ButtonSamePCMouseExited

    private void ButtonArrowTwoPlayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTwoPlayersMouseEntered
        ButtonArrowTwoPlayers.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonArrowTwoPlayersMouseEntered

    private void ButtonArrowTwoPlayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowTwoPlayersMouseExited
        ButtonArrowTwoPlayers.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowTwoPlayersMouseExited

    private void ButtonLocalNetworkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseEntered
        ButtonLocalNetwork.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonLocalNetworkMouseEntered

    private void ButtonLocalNetworkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLocalNetworkMouseExited
        ButtonLocalNetwork.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonLocalNetworkMouseExited

    private void ButtonJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinGameActionPerformed
        ButtonSearch.doClick();
        cards.show(parentPanel, "JoinGameCard");

    }//GEN-LAST:event_ButtonJoinGameActionPerformed

    private void ButtonCreateGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseEntered
        ButtonCreateGame.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonCreateGameMouseEntered

    private void ButtonCreateGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateGameMouseExited
        ButtonCreateGame.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonCreateGameMouseExited

    private void ButtonArrowLocalNetworkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseEntered
        ButtonArrowLocalNetwork.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseEntered

    private void ButtonArrowLocalNetworkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkMouseExited
        ButtonArrowLocalNetwork.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowLocalNetworkMouseExited

    private void ButtonJoinGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseEntered
        ButtonJoinGame.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonJoinGameMouseEntered

    private void ButtonJoinGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinGameMouseExited
        ButtonJoinGame.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonJoinGameMouseExited

    private void ButtonArrowLocalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowLocalNetworkActionPerformed
        cards.show(parentPanel, "TwoPlayersCard");
    }//GEN-LAST:event_ButtonArrowLocalNetworkActionPerformed

    private void ButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProfileActionPerformed
        profile = 1;
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String infoStatus = "";
                    String[] infoStatusData;
                    ps.println("profile." + LoggedUsername);
                    infoStatus = br.readLine();
                    infoStatusData = infoStatus.split("[.]");
                    if (infoStatusData[0].equals("profile") && infoStatusData[1].equalsIgnoreCase(LoggedUsername)) {
                        LabelWelcome.setText("Welcome " + infoStatusData[1] + " !");
                        LabelTotalGames.setText("Total Games : " + String.valueOf(infoStatusData[2]));
                        LabelWins.setText("Wins : " + String.valueOf(infoStatusData[3]));
                        LabelLosses.setText("Losses : " + String.valueOf(infoStatusData[4]));
                        LabelDraws.setText("Draws : " + String.valueOf(infoStatusData[5]));
                    }
                    while (profile == 1) {
                        int i = 0;
                        infoStatus = br.readLine();
                        infoStatusData = infoStatus.split("[.]");
                        if (infoStatusData[0].equals("profile")) {
                            tableModel.insertRow(0, new Object[]{infoStatusData[1], infoStatusData[2], infoStatusData[3], infoStatusData[4], infoStatusData[5]});
                        }
                        i++;
                    }
                } catch (Exception e) {
                    isConnected = 0;
                    System.out.println("Server isn't found!");
                }

            }
        });
        th.start();
        cards.show(parentPanel, "ProfileCard");
    }//GEN-LAST:event_ButtonProfileActionPerformed

    private void ButtonArrowMyProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseEntered
        ButtonArrowMyProfile.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonArrowMyProfileMouseEntered

    private void ButtonArrowMyProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileMouseExited
        ButtonArrowMyProfile.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowMyProfileMouseExited

    private void ButtonArrowMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowMyProfileActionPerformed
        cards.show(parentPanel, "MainMenuCard");
        profile = 0;
    }//GEN-LAST:event_ButtonArrowMyProfileActionPerformed

    private void ProfilePanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ProfilePanelAncestorAdded
    }//GEN-LAST:event_ProfilePanelAncestorAdded

    private void ButtonP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP2ActionPerformed
        if (ButtonP2.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP2.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP2.setForeground(new Color(198, 40, 40));
                }
                ButtonP2.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".2");
                        System.out.println("MovePlayed");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP2ActionPerformed

    private void ButtonP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP4ActionPerformed
        if (ButtonP4.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP4.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP4.setForeground(new Color(198, 40, 40));
                }
                ButtonP4.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".4");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP4ActionPerformed

    private void ButtonP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP6ActionPerformed
        if (ButtonP6.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP6.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP6.setForeground(new Color(198, 40, 40));
                }
                ButtonP6.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".6");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP6ActionPerformed

    private void ButtonForfitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonForfitMouseEntered
        ButtonForfit.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonForfitMouseEntered

    private void ButtonForfitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonForfitMouseExited
        ButtonForfit.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonForfitMouseExited

    private void ButtonForfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonForfitActionPerformed
        gameLogic.clearBoard();
        if (gameMode.equals("network")) {
            if (myMark.equals("X")) {
                ps.println("winner." + gameId + ".O");
            } else {
                ps.println("winner." + gameId + ".X");
            }

        }
    }//GEN-LAST:event_ButtonForfitActionPerformed

    private void ButtonArrowJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameActionPerformed
        // TODO add your handling code here:
        cards.show(parentPanel, "LocalNetworkCard");
    }//GEN-LAST:event_ButtonArrowJoinGameActionPerformed

    private void ButtonPlayAgainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseEntered
        ButtonPlayAgain.setForeground(new Color(67, 160, 70));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonPlayAgainMouseEntered

    private void ButtonPlayAgainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPlayAgainMouseExited
        ButtonPlayAgain.setForeground(new Color(46, 125, 50));
    }//GEN-LAST:event_ButtonPlayAgainMouseExited

    private void ButtonPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPlayAgainActionPerformed
        // TODO add your handling code here:
        gameLogic.clearBoard();
        whosTurn = "X";

        if (isGameJoined == 1) {
            isGameJoined = 0;
            isGameEnded = 0;
            ButtonJoinGame.doClick();
        } else if (isGameCreated == 1) {
            isGameCreated = 0;
            isGameEnded = 0;
            ButtonCreateGame.doClick();
        }
    }//GEN-LAST:event_ButtonPlayAgainActionPerformed

    private void ButtonMainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseEntered
        ButtonMainMenu.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonMainMenuMouseEntered

    private void ButtonMainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMainMenuMouseExited
        ButtonMainMenu.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonMainMenuMouseExited

    private void ButtonMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMainMenuActionPerformed
        gameLogic.clearBoard();
        whosTurn = "X";
        isGameCreated = 0;
        isGameJoined = 0;
        gameId = "";
        cards.show(parentPanel, "MainMenuCard");
    }//GEN-LAST:event_ButtonMainMenuActionPerformed

    private void ButtonQuitResultMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseEntered
        ButtonQuitResult.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonQuitResultMouseEntered

    private void ButtonQuitResultMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQuitResultMouseExited
        ButtonQuitResult.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonQuitResultMouseExited

    private void ButtonQuitResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitResultActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ButtonQuitResultActionPerformed

    private void ButtonP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP7ActionPerformed
        if (ButtonP7.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP7.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP7.setForeground(new Color(198, 40, 40));
                }
                ButtonP7.setText(currentTurn);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".7");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP7ActionPerformed

    private void ButtonP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP5ActionPerformed
        if (ButtonP5.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP5.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP5.setForeground(new Color(198, 40, 40));
                }
                ButtonP5.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".5");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP5ActionPerformed

    private void ButtonOnePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOnePlayerActionPerformed
        gameMode = "single";
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonOnePlayerActionPerformed

    private void ButtonP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP3ActionPerformed
        if (ButtonP3.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP3.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP3.setForeground(new Color(198, 40, 40));
                }
                ButtonP3.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".3");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP3ActionPerformed

    private void ButtonCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateGameActionPerformed
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isGameEnded == 0) {
                    try {
                        String infoStatus = "";
                        String[] infoStatusData;
                        if (isGameCreated == 0) {
                            ps.println("createGame." + LoggedUsername);
                            infoStatus = br.readLine();
                            infoStatusData = infoStatus.split("[.]");
                            if (infoStatusData[0].equals("createGame") && infoStatusData[2].equalsIgnoreCase(LoggedUsername)) {
                                gameId = infoStatusData[1];
                                LabelPlayer1.setText(LoggedUsername);
                                LabelPlayer2.setText("Waiting...");
                                disableGameBoard();
                                cards.show(parentPanel, "GameBoardCard");
                                myMark = "X";
                                isGameCreated = 1;
                            }
                        } else {
                            infoStatus = br.readLine();
                            infoStatusData = infoStatus.split("[.]");
                            if (infoStatusData[0].equals("startGame") && infoStatusData[1].equals(gameId)) {
                                LabelPlayer2.setText(infoStatusData[2]);
                                opponent = infoStatusData[2];
                                enableGameBoard();
                                cards.show(parentPanel, "GameBoardCard");
                            } else if (infoStatusData[0].equals(gameId) && infoStatusData[1].equals("whosturn")) {
                                System.out.println("WhosTurn = " + infoStatusData[2]);
                                whosTurn = infoStatusData[2];
                                if (whosTurn.equals("O")) {
                                    LabelCurrentTurnValue.setText("O");
                                    LabelCurrentTurnValue.setForeground(new Color(198, 40, 40));
                                } else {
                                    LabelCurrentTurnValue.setText("X");
                                    LabelCurrentTurnValue.setForeground(new Color(63, 81, 181));
                                }
                            } else if (infoStatusData[0].equals("moveplayed") && infoStatusData[1].equals(gameId)) {
                                String mark = infoStatusData[2];
                                String place = infoStatusData[3];
                                if (place.equals("1")) {
                                    ButtonP1.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP1.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP1.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("2")) {
                                    ButtonP2.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP2.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP2.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("3")) {
                                    ButtonP3.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP3.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP3.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("4")) {
                                    ButtonP4.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP4.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP4.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("5")) {
                                    ButtonP5.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP5.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP5.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("6")) {
                                    ButtonP6.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP6.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP6.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("7")) {
                                    ButtonP7.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP7.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP7.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("8")) {
                                    ButtonP8.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP8.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP8.setForeground(new Color(198, 40, 40));
                                    }
                                } else if (place.equals("9")) {
                                    ButtonP9.setText(mark);
                                    if (mark.equals("X")) {
                                        ButtonP9.setForeground(new Color(63, 81, 181));
                                    } else {
                                        ButtonP9.setForeground(new Color(198, 40, 40));
                                    }
                                }
                                // Check win
                                String whoWins = gameLogic.checkWin("network");
                                if (!whoWins.equals("none")) {
                                    System.out.println(whoWins);
                                    ps.println("winner." + gameId + "." + whoWins);
                                }
                                // Show Result Screen
                            } else if (infoStatusData[0].equals("winner") && infoStatusData[1].equals(gameId)) {
                                cards.show(parentPanel, "GameResultCard");
                                if (infoStatusData[2].equals(LoggedUsername)) {
                                    LabelTmp.setText("Congratulations " + LoggedUsername + ", You Won ^_^");
                                } else if (infoStatusData[2].equals(opponent)) {
                                    LabelTmp.setText("Sorry " + LoggedUsername + ", You Lost :(");
                                } else if (infoStatusData[2].equals("draw")) {
                                    LabelTmp.setText("Game ended with a Draw !");
                                }
                                isGameEnded = 1;
                            }
                        }

                    } catch (Exception e) {
                        isConnected = 0;
                        System.out.println("Server isn't found!");
                    }
                }
            }
        });
        th.start();
    }//GEN-LAST:event_ButtonCreateGameActionPerformed

    private void ButtonSamePCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSamePCActionPerformed
        // TODO add your handling code here:
        gameMode = "samepc";
        cards.show(parentPanel, "GameBoardCard");
    }//GEN-LAST:event_ButtonSamePCActionPerformed

    private void ButtonJoinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseEntered
        ButtonJoin.setForeground(new Color(67, 160, 71));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonJoinMouseEntered

    private void ButtonJoinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseExited
        ButtonJoin.setForeground(new Color(46, 125, 50));
    }//GEN-LAST:event_ButtonJoinMouseExited

    private void ButtonSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMouseEntered
        ButtonSearch.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonSearchMouseEntered

    private void ButtonSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMouseExited
        ButtonSearch.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonSearchMouseExited

    private void ButtonArrowJoinGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameMouseEntered
        ButtonArrowJoinGame.setForeground(new Color(229, 57, 53));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonArrowJoinGameMouseEntered

    private void ButtonArrowJoinGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonArrowJoinGameMouseExited
        ButtonArrowJoinGame.setForeground(new Color(198, 40, 40));
    }//GEN-LAST:event_ButtonArrowJoinGameMouseExited

    private void ButtonSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMousePressed
        ButtonSearch.setForeground(new Color(159, 168, 218));
    }//GEN-LAST:event_ButtonSearchMousePressed

    private void ButtonSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSearchMouseReleased
        ButtonSearch.setForeground(new Color(121, 134, 203));
    }//GEN-LAST:event_ButtonSearchMouseReleased

    private void ButtonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinActionPerformed
        // TODO add your handling code here:
        if (!ListAvailableGames.getSelectedValue().isEmpty()) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isGameEnded == 0) {
                        try {
                            String infoStatus = "";
                            String[] infoStatusData;
                            if (isGameJoined == 0) {
                                ps.println("join." + LoggedUsername + "." + ListAvailableGames.getSelectedValue());
                                infoStatus = br.readLine();
                                infoStatusData = infoStatus.split("[.]");
                                if (infoStatusData[0].equals("join") && infoStatusData[2].equals(LoggedUsername)) {
                                    LabelPlayer1.setText(infoStatusData[3]);
                                    LabelPlayer2.setText(infoStatusData[2]);
                                    gameId = infoStatusData[1];
                                    cards.show(parentPanel, "GameBoardCard");
                                    myMark = "O";
                                    isGameJoined = 1;
                                    opponent = infoStatusData[3];
                                }
                            } else {
                                infoStatus = br.readLine();
                                infoStatusData = infoStatus.split("[.]");
                                if (infoStatusData[0].equals(gameId) && infoStatusData[1].equals("whosturn")) {
                                    whosTurn = infoStatusData[2];
                                    if (whosTurn.equals("O")) {
                                        LabelCurrentTurnValue.setText("O");
                                        LabelCurrentTurnValue.setForeground(new Color(198, 40, 40));
                                    } else {
                                        LabelCurrentTurnValue.setText("X");
                                        LabelCurrentTurnValue.setForeground(new Color(63, 81, 181));
                                    }
                                } else if (infoStatusData[0].equals("moveplayed") && infoStatusData[1].equals(gameId)) {
                                    String mark = infoStatusData[2];
                                    String place = infoStatusData[3];
                                    if (place.equals("1")) {
                                        ButtonP1.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP1.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP1.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("2")) {
                                        ButtonP2.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP2.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP2.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("3")) {
                                        ButtonP3.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP3.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP3.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("4")) {
                                        ButtonP4.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP4.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP4.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("5")) {
                                        ButtonP5.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP5.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP5.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("6")) {
                                        ButtonP6.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP6.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP6.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("7")) {
                                        ButtonP7.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP7.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP7.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("8")) {
                                        ButtonP8.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP8.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP8.setForeground(new Color(198, 40, 40));
                                        }
                                    } else if (place.equals("9")) {
                                        ButtonP9.setText(mark);
                                        if (mark.equals("X")) {
                                            ButtonP9.setForeground(new Color(63, 81, 181));
                                        } else {
                                            ButtonP9.setForeground(new Color(198, 40, 40));
                                        }
                                    }
                                    // Show Result
                                } else if (infoStatusData[0].equals("winner") && infoStatusData[1].equals(gameId)) {
                                    cards.show(parentPanel, "GameResultCard");
                                    if (infoStatusData[2].equals(LoggedUsername)) {
                                        LabelTmp.setText("Congratulations " + LoggedUsername + ", You Won ^_^");
                                    } else if (infoStatusData[2].equals(opponent)) {
                                        LabelTmp.setText("Sorry " + LoggedUsername + ", You Lost :(");
                                    } else if (infoStatusData[2].equals("draw")) {
                                        LabelTmp.setText("Game ended with a Draw !");
                                    }
                                    isGameEnded = 1;
                                }
                            }

                        } catch (Exception e) {
                            isConnected = 0;
                            System.out.println("Server isn't found!");
                        }
                    }
                }
            });
            th.start();
        }
    }//GEN-LAST:event_ButtonJoinActionPerformed

    private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchActionPerformed
        // TODO add your handling code here:
        listModel.removeAllElements();
        listModel.setSize(5);
        for (int i = 0; i < 5; i++) {
            listModel.add(i, "             ");
        }
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String infoStatus = "";
                    String[] infoStatusData = null;
                    ps.println("getGames.get");
                    infoStatus = br.readLine();
                    if (infoStatus.indexOf(".") != infoStatus.length() - 1) {
                        infoStatusData = infoStatus.split("[.]");
                        System.out.println(infoStatus);
                        if (infoStatusData[0].equals("getGames")) {
                            if (infoStatusData.length > 1) {
                                for (int i = 0; i < infoStatusData.length; i++) {
                                    if (i > 0) {
                                        if (i > 5) {
                                            listModel.add(i - 1, infoStatusData[i]);
                                        } else {
                                            listModel.set(i - 1, infoStatusData[i]);
                                        }
                                    }
                                }
                            }
                            ListAvailableGames.setModel(listModel);
                        }
                    }

                } catch (Exception e) {
                    isConnected = 0;
                    e.printStackTrace();
                    System.out.println("Server isn't found!");
                }
            }
        });
        th.start();
    }//GEN-LAST:event_ButtonSearchActionPerformed

    private void ButtonP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP1ActionPerformed
        if (ButtonP1.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP1.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP1.setForeground(new Color(198, 40, 40));
                }
                ButtonP1.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".1");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP1ActionPerformed

    private void ButtonP8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP8ActionPerformed
        if (ButtonP8.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP8.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP8.setForeground(new Color(198, 40, 40));
                }
                ButtonP8.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".8");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP8ActionPerformed

    private void ButtonP9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonP9ActionPerformed
        if (ButtonP9.getText().isEmpty()) {
            if (gameMode.equals("samepc")) {
                currentTurn = gameLogic.checkPlayerTurn();
                if (currentTurn.equals("X")) {
                    ButtonP9.setForeground(new Color(63, 81, 181));
                } else {
                    ButtonP9.setForeground(new Color(198, 40, 40));
                }
                ButtonP9.setText(currentTurn);
                gameLogic.checkWin(gameMode);
            } else if (gameMode.equals("network")) {
                try {
                    if (whosTurn.equals(myMark)) {
                        ps.println("gaming." + gameId + ".moveplayed." + myMark + ".9");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ButtonP9ActionPerformed

    private void ButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignupActionPerformed
        String username = TextFieldUsername.getText();
        String password = new String(PasswordFieldPassword.getPassword());
        if (!username.isEmpty() && !password.isEmpty()) {
            TextFieldUsername.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
            PasswordFieldPassword.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
            LabelLoginSatus.setText("");
            if (isLoginPressed == 0) {
                isLoginPressed = 1;
                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String infoStatus = "";
                            String[] infoStatusData;
                            ps.println("signup." + username + "." + password);
                            infoStatus = br.readLine();
                            infoStatusData = infoStatus.split("[.]");
                            if (infoStatusData[0].equals("signup") && infoStatusData[1].equals("created")) {
                                cards.show(parentPanel, "MainMenuCard");
                                LoggedUsername = username;
                            } else {
                                LabelLoginSatus.setText("* Username already exists, please choose different username");
                                Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
                                TextFieldUsername.setBorder(border);
                            }
                            isLoginPressed = 0;
                        } catch (Exception e) {
                            isConnected = 0;
                            System.out.println("Server isn't found!");
                            LabelLoginSatus.setText("* Can't connect to server");
                            isLoginPressed = 0;
                        }
                    }
                });
                th.start();
            }
        } else if (username.isEmpty() && password.isEmpty()) {
            Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
            TextFieldUsername.setBorder(border);
            LabelLoginSatus.setText("* username and password can't be empty");
            PasswordFieldPassword.setBorder(border);
        } else if (username.isEmpty() && !password.isEmpty()) {
            Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
            TextFieldUsername.setBorder(border);
            LabelLoginSatus.setText("* username can't be empty");
            PasswordFieldPassword.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
        } else if (!username.isEmpty() && password.isEmpty()) {
            Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
            LabelLoginSatus.setText("* password can't be empty");
            PasswordFieldPassword.setBorder(border);
            TextFieldUsername.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
        }
    }//GEN-LAST:event_ButtonSignupActionPerformed

    private void ButtonSignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignupMouseExited
        ButtonSignup.setForeground(new Color(63, 81, 181));
    }//GEN-LAST:event_ButtonSignupMouseExited

    private void ButtonSignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignupMouseEntered
        ButtonSignup.setForeground(new Color(121, 134, 203));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonSignupMouseEntered

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed

        String username = TextFieldUsername.getText();
        String password = new String(PasswordFieldPassword.getPassword());
        if (!username.isEmpty() && !password.isEmpty()) {
            TextFieldUsername.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
            PasswordFieldPassword.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
            LabelLoginSatus.setText("");
            if (isLoginPressed == 0) {
                isLoginPressed = 1;
                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String infoStatus = "";
                            String[] infoStatusData;
                            ps.println("login." + username + "." + password);
                            infoStatus = br.readLine();
                            infoStatusData = infoStatus.split("[.]");
                            if (infoStatusData[0].equals("login") && infoStatusData[1].equals("correct")) {
                                cards.show(parentPanel, "MainMenuCard");
                                LoggedUsername = username;
                            } else {
                                LabelLoginSatus.setText("* Wrong username or password");
                                Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
                                TextFieldUsername.setBorder(border);
                                PasswordFieldPassword.setBorder(border);
                            }
                            isLoginPressed = 0;
                        } catch (Exception e) {
                            isConnected = 0;
                            System.out.println("Server isn't found!");
                            LabelLoginSatus.setText("* Can't connect to server");
                            isLoginPressed = 0;
                        }
                    }
                });
                th.start();
            }
        } else if (username.isEmpty() && password.isEmpty()) {
            Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
            TextFieldUsername.setBorder(border);
            LabelLoginSatus.setText("* username and password can't be empty");
            PasswordFieldPassword.setBorder(border);
        } else if (username.isEmpty() && !password.isEmpty()) {
            Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
            TextFieldUsername.setBorder(border);
            LabelLoginSatus.setText("* username can't be empty");
            PasswordFieldPassword.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
        } else if (!username.isEmpty() && password.isEmpty()) {
            Border border = BorderFactory.createLineBorder(new Color(198, 40, 40), 3);
            LabelLoginSatus.setText("* password can't be empty");
            PasswordFieldPassword.setBorder(border);
            TextFieldUsername.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));
        }
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void ButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseExited
        ButtonLogin.setForeground(new Color(46, 125, 50));
    }//GEN-LAST:event_ButtonLoginMouseExited

    private void ButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseEntered
        ButtonLogin.setForeground(new Color(67, 160, 71));
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonLoginMouseEntered

    private void ButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordActionPerformed
        // TODO add your handling code here:
        if (ButtonRecord.getText().equals("off")) {
            ps.println("record.1." + gameId + "." + LoggedUsername);
            ButtonRecord.setText("on");
            ButtonRecord.setForeground(new Color(198, 40, 40));
        } else {
            ps.println("record.0." + gameId + "." + LoggedUsername);
            ButtonRecord.setText("off");
            ButtonRecord.setForeground(new Color(97, 97, 97));
        }
    }//GEN-LAST:event_ButtonRecordActionPerformed

    private void ButtonRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordMouseEntered
        if (ButtonRecord.getText().equals("off")) {
            ButtonRecord.setForeground(new Color(117, 117, 117));
        } else {
            ButtonRecord.setForeground(new Color(229, 57, 53));
        }
        soundtrack.onHoverMusic();
    }//GEN-LAST:event_ButtonRecordMouseEntered

    private void ButtonRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordMouseExited
        if (ButtonRecord.getText().equals("off")) {
            ButtonRecord.setForeground(new Color(79, 79, 79));
        } else {
            ButtonRecord.setForeground(new Color(198, 40, 40));
        }
    }//GEN-LAST:event_ButtonRecordMouseExited

    private void TableHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableHistoryMouseClicked
        new Thread() {
            @Override
            public void run() {
                JTable target = (JTable) evt.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                int isRecorded = Integer.parseInt(tableModel.getValueAt(row, 4).toString());
                String gameId = tableModel.getValueAt(row, 1).toString();
                if (isRecorded == 1) {
                    ps.println("getRecord." + gameId + "." + LoggedUsername);
                    try {
                        infoStatus = br.readLine();
                        infoStatusData = infoStatus.split("[.]");
                        disableGameBoard();
                        LabelPlayer1.setText(infoStatusData[1]);
                        LabelPlayer2.setText(infoStatusData[2]);
                        LabelCurrentTurnValue.setText("X");
                        cards.show(parentPanel, "GameBoardCard");
                        for (int i = 1; i < infoStatusData.length; i++) {
                            if (infoStatusData[i].equals("X1") || infoStatusData[i].equals("O1")) {
                                if (infoStatusData[i].equals("X1")) {
                                    ButtonP1.setText("X");
                                    ButtonP1.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP1.setText("O");
                                    ButtonP1.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X2") || infoStatusData[i].equals("O2")) {
                                if (infoStatusData[i].equals("X2")) {
                                    ButtonP2.setText("X");
                                    ButtonP2.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP2.setText("O");
                                    ButtonP2.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X3") || infoStatusData[i].equals("O3")) {
                                if (infoStatusData[i].equals("X3")) {
                                    ButtonP3.setText("X");
                                    ButtonP3.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP3.setText("O");
                                    ButtonP3.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X4") || infoStatusData[i].equals("O4")) {
                                if (infoStatusData[i].equals("X4")) {
                                    ButtonP4.setText("X");
                                    ButtonP4.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP4.setText("O");
                                    ButtonP4.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X5") || infoStatusData[i].equals("O5")) {
                                if (infoStatusData[i].equals("X5")) {
                                    ButtonP5.setText("X");
                                    ButtonP5.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP5.setText("O");
                                    ButtonP5.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X6") || infoStatusData[i].equals("O6")) {
                                if (infoStatusData[i].equals("X6")) {
                                    ButtonP6.setText("X");
                                    ButtonP6.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP6.setText("O");
                                    ButtonP6.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X7") || infoStatusData[i].equals("O7")) {
                                if (infoStatusData[i].equals("X7")) {
                                    ButtonP7.setText("X");
                                    ButtonP7.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP7.setText("O");
                                    ButtonP7.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X8") || infoStatusData[i].equals("O8")) {
                                if (infoStatusData[i].equals("X8")) {
                                    ButtonP8.setText("X");
                                    ButtonP8.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP8.setText("O");
                                    ButtonP8.setForeground(new Color(198, 40, 40));
                                }

                            } else if (infoStatusData[i].equals("X9") || infoStatusData[i].equals("O9")) {
                                if (infoStatusData[i].equals("X9")) {
                                    ButtonP9.setText("X");
                                    ButtonP9.setForeground(new Color(63, 81, 181));
                                } else {
                                    ButtonP9.setText("O");
                                    ButtonP9.setForeground(new Color(198, 40, 40));
                                }
                            }
                            Thread.sleep(1000);
                        }
                        if (infoStatusData[3].equals(infoStatusData[1])) {
                            LabelTmp.setText(infoStatusData[1] + " has won the game ^_^");
                            cards.show(parentPanel, "GameResultCard");
                        }
                        else if(infoStatusData[3].equals(infoStatusData[2]))
                        {
                            LabelTmp.setText(infoStatusData[2] + " has won the game ^_^");
                            cards.show(parentPanel, "GameResultCard");
                        }
                        else
                        {
                            LabelTmp.setText("Game has been ended with a Draw!");
                            cards.show(parentPanel, "GameResultCard");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

        }.start();
    }//GEN-LAST:event_TableHistoryMouseClicked

    public void disableGameBoard() {
        ButtonP1.setEnabled(false);
        ButtonP2.setEnabled(false);
        ButtonP3.setEnabled(false);
        ButtonP4.setEnabled(false);
        ButtonP5.setEnabled(false);
        ButtonP6.setEnabled(false);
        ButtonP7.setEnabled(false);
        ButtonP8.setEnabled(false);
        ButtonP9.setEnabled(false);
        ButtonRecord.setEnabled(false);
    }

    public void enableGameBoard() {
        ButtonP1.setEnabled(true);
        ButtonP2.setEnabled(true);
        ButtonP3.setEnabled(true);
        ButtonP4.setEnabled(true);
        ButtonP5.setEnabled(true);
        ButtonP6.setEnabled(true);
        ButtonP7.setEnabled(true);
        ButtonP8.setEnabled(true);
        ButtonP9.setEnabled(true);
        ButtonRecord.setEnabled(true);
    }

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
            java.util.logging.Logger.getLogger(TicTacToeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton ButtonRecord;
    private javax.swing.JButton ButtonSamePC;
    public static javax.swing.JButton ButtonSearch;
    private javax.swing.JButton ButtonSignup;
    private javax.swing.JButton ButtonStartGame;
    private javax.swing.JButton ButtonTwoPlayers;
    private javax.swing.JPanel GameBoardPanel;
    private javax.swing.JPanel GameModePanel;
    private javax.swing.JPanel GameResultPanel;
    private javax.swing.JPanel JoinGamePanel;
    private javax.swing.JLabel LabelAvailableGames;
    private javax.swing.JLabel LabelCurrentTurn;
    public static javax.swing.JLabel LabelCurrentTurnValue;
    private javax.swing.JLabel LabelDraws;
    private javax.swing.JLabel LabelHistory;
    private javax.swing.JLabel LabelLoginSatus;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogo2;
    private javax.swing.JLabel LabelLosses;
    private javax.swing.JLabel LabelO;
    private javax.swing.JLabel LabelPassword;
    public static javax.swing.JLabel LabelPlayer1;
    public static javax.swing.JLabel LabelPlayer2;
    private javax.swing.JLabel LabelRecord;
    public static javax.swing.JLabel LabelTmp;
    private javax.swing.JLabel LabelTotalGames;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JLabel LabelWins;
    private javax.swing.JLabel LabelX;
    private javax.swing.JList<String> ListAvailableGames;
    private javax.swing.JPanel LocalNetworkPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel MainMenuPanel;
    private javax.swing.JPanel PanelBoard;
    private javax.swing.JPasswordField PasswordFieldPassword;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTable TableHistory;
    private javax.swing.JTextField TextFieldUsername;
    private javax.swing.JPanel TwoPlayersPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
