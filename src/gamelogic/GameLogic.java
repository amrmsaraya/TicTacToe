package gamelogic;

import java.util.Random;
import gui.TicTacToeFrame;
import java.awt.Color;

/*cpuplay */
public class GameLogic {

    String[][] gameBoard = new String[3][3];
    String playerTurn = "X";
    Random m = new Random();
    int m1 = m.nextInt(9);
    int m2 = m.nextInt(9);
    public int counter = 0;

    public String checkPlayerTurn() {
        if (playerTurn.equals("X")) {
            playerTurn = "O";
            TicTacToeFrame.LabelCurrentTurnValue.setText(playerTurn);
            TicTacToeFrame.LabelCurrentTurnValue.setForeground(new Color(198, 40, 40));
            return "X";
        } else {
            playerTurn = "X";
            TicTacToeFrame.LabelCurrentTurnValue.setText(playerTurn);
            TicTacToeFrame.LabelCurrentTurnValue.setForeground(new Color(63, 81, 181));
            return "O";
        }
    }

    public void playerXwins() {
        TicTacToeFrame.cards.show(TicTacToeFrame.parentPanel, "GameResultCard");
        TicTacToeFrame.LabelTmp.setText("Winner is Player X!");
        clearBoard();
    }

    public void playerOwins() {
        TicTacToeFrame.cards.show(TicTacToeFrame.parentPanel, "GameResultCard");
        TicTacToeFrame.LabelTmp.setText("Winner is Player O!");
        clearBoard();
    }

    public void gameDraw() {
        TicTacToeFrame.cards.show(TicTacToeFrame.parentPanel, "GameResultCard");
        TicTacToeFrame.LabelTmp.setText("Game is tied :'(");
        clearBoard();
    }

    public void fillArray() {
        gameBoard[0][0] = TicTacToeFrame.ButtonP1.getText();
        gameBoard[0][1] = TicTacToeFrame.ButtonP2.getText();
        gameBoard[0][2] = TicTacToeFrame.ButtonP3.getText();
        gameBoard[1][0] = TicTacToeFrame.ButtonP4.getText();
        gameBoard[1][1] = TicTacToeFrame.ButtonP5.getText();
        gameBoard[1][2] = TicTacToeFrame.ButtonP6.getText();
        gameBoard[2][0] = TicTacToeFrame.ButtonP7.getText();
        gameBoard[2][1] = TicTacToeFrame.ButtonP8.getText();
        gameBoard[2][2] = TicTacToeFrame.ButtonP9.getText();
    }

    public String checkWin(String mode) {
        fillArray();
        counter++;
        if (gameBoard[0][0].equals("X") && gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][1].equals(gameBoard[0][2])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[1][0].equals("X") && gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[2][0].equals("X") && gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[0][0].equals("X") && gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[2][0].equals("X") && gameBoard[2][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[0][2])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[0][0].equals("X") && gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[0][0].equals(gameBoard[2][0])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[0][1].equals("X") && gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[0][2].equals("X") && gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[1][2].equals(gameBoard[2][2])) {
            if (mode.equals("samePC")) {
                playerXwins();
                return "X";
            } else if (mode.equals("network")) {
                return "X";
            }
        } else if (gameBoard[0][0].equals("O") && gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][1].equals(gameBoard[0][2])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[1][0].equals("O") && gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[2][0].equals("O") && gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[0][0].equals("O") && gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[2][0].equals("O") && gameBoard[2][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[0][2])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[0][0].equals("O") && gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[0][0].equals(gameBoard[2][0])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[0][1].equals("O") && gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (gameBoard[0][2].equals("O") && gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[1][2].equals(gameBoard[2][2])) {
            if (mode.equals("samePC")) {
                playerOwins();
                return "O";
            } else if (mode.equals("network")) {
                return "O";
            }
        } else if (counter >= 9) {
            if (mode.equals("samePC")) {
                gameDraw();
                return "draw";
            } else if (mode.equals("network")) {
                return "draw";
            }
        }
        return "none";
    }

    public void clearBoard() {
        TicTacToeFrame.ButtonP1.setText("");
        TicTacToeFrame.ButtonP2.setText("");
        TicTacToeFrame.ButtonP3.setText("");
        TicTacToeFrame.ButtonP4.setText("");
        TicTacToeFrame.ButtonP5.setText("");
        TicTacToeFrame.ButtonP6.setText("");
        TicTacToeFrame.ButtonP7.setText("");
        TicTacToeFrame.ButtonP8.setText("");
        TicTacToeFrame.ButtonP9.setText("");
        TicTacToeFrame.LabelPlayer1.setText("Player 1");
        TicTacToeFrame.LabelPlayer2.setText("Player 2");
        TicTacToeFrame.LabelCurrentTurnValue.setText("X");
        TicTacToeFrame.LabelCurrentTurnValue.setForeground(new Color(63, 81, 181));
        counter = 0;
    }

}
