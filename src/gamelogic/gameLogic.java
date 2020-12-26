
package gamelogic;

import java.util.Random;

/*cpuplay */
public class gameLogic {
    
    String [][] gameBoard = new String [3][3];
    String playerTurn = "X" ;
    Random m = new Random() ;
    int m1 = m.nextInt(9);
    int m2 = m.nextInt(9);
    public static int counter =0 ;
    
    public void checkPlayerTurn(){
        if (playerTurn.equals("X")){
            //System.out.println("playerxturn");
            playerTurn = "O";
        }
        else if (playerTurn.equals("O")){
            //System.out.println("player o turn");
            playerTurn = "X";
        }
    }
    
    public void playerXwins(){
        //player x wins
    }
    
    public void playerOwins(){
        //player o wins
    }
    
    public void gameDraw (){
        //System.out.println("game draw");
    }
    
    public void checkWin(){
        if (gameBoard[0][0].equals("X")&&gameBoard[0][0].equals(gameBoard[0][1])&&gameBoard[0][1].equals(gameBoard[0][2])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[1][0].equals("X")&&gameBoard[1][0].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[1][2])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[2][0].equals("X")&&gameBoard[2][0].equals(gameBoard[2][1])&&gameBoard[2][1].equals(gameBoard[2][2])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[0][0].equals("X")&&gameBoard[0][0].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[2][2])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[2][0].equals("X")&&gameBoard[2][0].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[0][2])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[0][0].equals("X")&&gameBoard[0][0].equals(gameBoard[1][0])&&gameBoard[0][1].equals(gameBoard[2][0])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[0][1].equals("X")&&gameBoard[0][1].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[2][1])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[0][2].equals("X")&&gameBoard[0][2].equals(gameBoard[1][2])&&gameBoard[1][2].equals(gameBoard[2][2])){
            playerXwins();
            clearBoard();
        }
        else if (gameBoard[0][0].equals("O")&&gameBoard[0][0].equals(gameBoard[0][1])&&gameBoard[0][1].equals(gameBoard[0][2])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[1][0].equals("O")&&gameBoard[1][0].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[1][2])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[2][0].equals("O")&&gameBoard[2][0].equals(gameBoard[2][1])&&gameBoard[2][1].equals(gameBoard[2][2])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[0][0].equals("O")&&gameBoard[0][0].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[2][2])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[2][0].equals("O")&&gameBoard[2][0].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[0][2])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[0][0].equals("O")&&gameBoard[0][0].equals(gameBoard[1][0])&&gameBoard[0][1].equals(gameBoard[2][0])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[0][1].equals("O")&&gameBoard[0][1].equals(gameBoard[1][1])&&gameBoard[1][1].equals(gameBoard[2][1])){
            playerOwins();
            clearBoard();
        }
        else if (gameBoard[0][2].equals("O")&&gameBoard[0][2].equals(gameBoard[1][2])&&gameBoard[1][2].equals(gameBoard[2][2])){
            playerOwins();
            clearBoard();
        }
        else if (/*static counter = 9*/){
            gameDraw();
            //static counter = 9 ;
        }
    }
    public void clearBoard() {
    for (int i = 0 ; i<3 ;i++){
        for (int y = 0 ; y<3;y++){
            gameBoard[i][y]=" ";
        }
    }
}
    
}
