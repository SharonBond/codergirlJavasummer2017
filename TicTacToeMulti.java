import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class TicTacToeMulti
{

    static char placeholder = '.'; 
    static Scanner keyboard = new Scanner (System.in); 

    public static void drawBoard(char[][] board)

    { out.println(); 
        for (int a= 0; a<3; a++)
        { out.println(" " + board[a][0] + " | " + board[a][1] + " | "  + board[a][2]); 
        } 
        out.println(); 

    } 

    public static char [][] createEmptyBoard()

    {char [][] gameBoard = new char [3][3]; 
        for (int x = 0; x <3; x ++)
        { for (int y = 0; y<3; y++)
                gameBoard[x][y] = placeholder;
        }
        return gameBoard; 

    }
    public static boolean isWin(char[][] board)


    { 
        if (isHorizontalwin(board) == true)
        {return true; }
        if (isVerticalWin(board) == true)
        { return true;} 

        if (isDiagonalWin(board) == true)
        {return true;}
        return false;   
    }

    public static boolean isFull(char[][]board)


    {for (int x = 0; x<3; x++)
        { for (int y = 0; y<3; y++)
            { if    (board[x][y] == placeholder)
                { return false; } } }
        return true; 
    } 

    public static boolean isHorizontalwin(char [][] board)
 
    { for (int x = 0; x <3; x ++)

        { if ((board [x][0] == board [x][1]) && (board [x][0] == board [x][2] )&& (board [x][0] != placeholder))
            { return true; } 

        }   
        return false; 
    }

    public static boolean isVerticalWin (char[][]board)

    { for (int y = 0; y<3; y++)
        { if ((board [0][y] == board [1][y]) && (board [0][y] == board [2][y] )&& (board [0][y] != placeholder))
            { return true; } 

        }   
        return false; 
    }

    public static boolean isDiagonalWin(char[][] board)

    { 
        if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board [0][0] != placeholder))
        { return true; } 
        if ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board [0][2] != placeholder))
        { return true; } 
        return false; 

    } 

    public static void printWelcome()
    { 
        out.println("Welcome to Tic Tac Toe!"); 
        out.println("To play, enter a number for which box to play in.");
        out.println("1  2  3"); 
        out.println("4  5  6"); 
        out.println("7  8  9"); 
        out.println(); 


    } 

    public static void printOptions()
    {   out.println("We can do this one of three ways:"); 
        out.println("For normal two player, press 1.");
        out.println("To play against the computer, press 2.");
        out.println("For mystery two player, press 3.");

        
        

     boolean wrongChoice = true; 
      do{
        int option = keyboard.nextInt();
      if (option == 1)
        { out.println("A good option for those with a buddy. Grab one and come back to play.");
            innerGame1();
            wrongChoice = false;} 
        else if (option == 2)
        { out.println("Fun without friends. I'll be your friend."); 
            innerGame2(); 
          wrongChoice = false; 
        } 
        else if( option == 3)
        { out.println("Daring! \n(I'm hyping it up a bit. It really isn't that exciting)");
        out.println("\nGrab a partner and get ready to play."); 
            innerGame3();
            wrongChoice = false; }
            else 
          {  out.println("Not an option, try again");
          wrongChoice = true; }
      } while (wrongChoice == true);

    }
    
    public static boolean wantsToPlayAgain()
    { out.println("Do you want to play again? Type yes or no?"); 
        boolean repeat = false; 
        do
        {
            String again = keyboard.nextLine(); 
            if( again.equals( "yes"))

            {repeat = false; 
                return true;} 
            if (again.equals("no"))
            {repeat = false; 
                return false;}
            if ((!again.equals("no")) && (!again.equals("yes")))
                repeat = true; 

        } while( repeat = true); 
        return false; 
    }

    public static char getTokenAtPosition(int position, char[][]board)
    { 
        int row = (position -1)/3; 
        int col = (position -1) %3 ; 
        return board [row][col]; 
    } 

    public static void placeToken (int position, char [][]board, boolean isXturn)
 

    { int row = (position -1)/3; 
        int col = (position -1) %3 ; 
        if (isXturn == true)
        { board[row][col] = 'x'; 
        } 
        else 
        { board [row][col] = 'o'; 
        } 

    } 

    public static void placeToken2 (int position, char [][]board, boolean isXturn, char [] player)

    {
        char player1 = player [0]; 
        char player2 = player [1]; 

        int row = (position -1)/3; 
        int col = (position -1) %3 ; 
        if (isXturn == true)
        { board[row][col] = player1; 
        } 
        else 
        { board [row][col] = player2; 
        } 

    }

    public static void getPositionandPlaceToken (char [][] board, boolean isXTurn)


    {int position = 0; 
        boolean repeat = true; 

        do{ 
            if (isXTurn==true)
            {out.println("X, where would you like to go?");
            } 
            else //it is O's turn
            { out.println("O, where would you like to go?");
            } 
            position = keyboard.nextInt();
            keyboard.nextLine(); 
            if( position < 1 || position > 9 )
            {out.println("Please pick again, try 1 - 9");
                repeat = true; 
            }   
            else if (position >= 1 && position <= 9)
            { 
                if (getTokenAtPosition(position, board) != placeholder)

                {out.println(position + " has been taken. Try again."); 
                    repeat = true; } 
                else 
                { repeat = false; } 

            }       
            else 
            {
                repeat = false; 
            } 
        }while (repeat == true);

        placeToken(position, board, isXTurn); 
    }       

    public static void getPositionandPlaceToken2 (char [][] board, boolean isXTurn, char [] player)
   

    {int position = 0; 
        boolean repeat = true; 
        char player1 = player [0]; 
        char player2 = player [1]; 

        do{ 
            if (isXTurn==true)
            {out.println(player1 + "  where would you like to go?");
            } 
            else //it is O's turn
            { out.println(player2 + " where would you like to go?");
            } 
            position = keyboard.nextInt();
            keyboard.nextLine(); 
            if( position < 1 || position > 9 )
            {out.println("Please pick again, try 1 - 9");
                repeat = true; 
            }   
            else if (position >= 1 && position <= 9)
            { 
                if (getTokenAtPosition(position, board)!= placeholder)

                {out.println(position + " has been taken. Try again."); 
                    repeat = true; } 
                else 
                { repeat = false; } 

            }       
            else 
            {
                repeat = false; 
            } 
        }while (repeat == true);

        placeToken2(position, board, isXTurn, player); 
    }

    public static void innerGame1 ()
    { 

        int xWins = 0; 
        int oWins = 0; 
        int draws = 0; 
        boolean doesXStart = true; 
        boolean isXTurn = doesXStart; 

    

        do 
        {  
            boolean gameStillGoing = true; 

            isXTurn = doesXStart; 
          
            doesXStart = !doesXStart;
            char [][] thisGame = createEmptyBoard(); 

            drawBoard(thisGame); 

            do { 

      
                getPositionandPlaceToken (thisGame, isXTurn); 
                drawBoard(thisGame); 

                if (isWin(thisGame)== true)
                { 
                    if (isXTurn == true)
                    { xWins++;
                        out.println("Good job X... we'll add that win to your score."); 
                        gameStillGoing = false; 
                    } 
                    else 
                    {out.println("Way to go, O! What a show!"); 
                        oWins++;
                        gameStillGoing = false;  } 

                } 
                else if (isFull(thisGame)== true)
                { out.println("No winners, no losers. We call this a draw."); 
                    draws++; 
                    gameStillGoing = false; 
                } 
                else 
                { 
                    isXTurn = !isXTurn;         
                    

                }} while (gameStillGoing ==true); 
            out.println("Score: x = " + xWins + ", O = " + oWins + ", draws = " + draws); 
        } while (wantsToPlayAgain()== true); 
    } 

    public static void innerGame3 ()
    { 
        boolean firstPlayer = true; 
        boolean secondPlayer = true; 
        int first; 
        int second; 
        char player1; 
        char player2; 
        do{

            out.println("Player one, pick a number between 1 and 223");
             first = keyboard.nextInt(); 
            first = first + 23;
            

            if (first ==46)
            {
                out.println("No. Pick a different one.");
                firstPlayer = true; 
            }
            else 
            firstPlayer = false; 
            player1 = (char) first; 
        }while (firstPlayer==true); 

        
        do {
        out.println("Player two, pick a number between 1 and 223");
        second = keyboard.nextInt(); 
        second = second + 23; 
         if (second == 46)
         {out.println("No. Pick something else"); 
            secondPlayer = true; 
        } 
        else if (second == first)
            { out.println("Don't pick the same as Player One"); 
                secondPlayer = true; 
            }
         else 
         {secondPlayer = false;}
        
        player2 = (char) second; 
        
        } while (secondPlayer == true); 
         
         
        char players [] = { player1, player2} ; 
        out.println("Player 1, you are represented by " + player1+ "."); 
        out.println("Player 2, you are represented by " + player2+"."); 

        int xWins = 0; 
        int oWins = 0; 
        int draws = 0; 
        boolean doesXStart = true; 
        boolean isXTurn = doesXStart; 

        printWelcome(); 

        do 
        { 
            boolean gameStillGoing = true; 

            isXTurn = doesXStart; 
            //int count = 0
            doesXStart = !doesXStart;
            char [][] thisGame = createEmptyBoard(); 

            drawBoard(thisGame); 

            do { 

                
                getPositionandPlaceToken2 (thisGame, isXTurn, players); 
                drawBoard(thisGame); 

                if (isWin(thisGame)== true)
                { 
                    if (isXTurn == true)
                    { xWins++;
                        out.println("Good job " + player1 + "... we will add that win to your score."); 
                        gameStillGoing = false; 
                    } 
                    else 
                    {out.println("Nice " + player2 + ". That is a win in your column."); 
                        oWins++;
                        gameStillGoing = false;  } 

                } 
                else if (isFull(thisGame)== true)
                { out.println("No winners, no losers. We call this a draw."); 
                    draws++; 
                    gameStillGoing = false; 
                } 
                else 
                { 
                    isXTurn = !isXTurn;         
                    

                }} while (gameStillGoing ==true); 
            out.println("Score: " + player1 +  "= " + xWins + "," + player2 +  "= " + oWins + ", draws = " + draws); 
        } while (wantsToPlayAgain()== true); 
    } 

    public static void placeToken3 (int position, char [][]board, boolean isXturn)
 

    { int row = (position -1)/3; 
        int col = (position -1) %3 ; 
        if (isXturn == true)
        { board[row][col] = 'x'; 
        } 
        else 
        { board[row][col] = 'o'; 
        } 
    } 

    public static void innerGame2 ()
    { 

        int xWins = 0; 
        int oWins = 0; 
        int draws = 0; 
        boolean doesXStart = true; 
        boolean isXTurn = doesXStart; 

      
        do 
        { 
            boolean gameStillGoing = true; 

            isXTurn = doesXStart; 
           
            doesXStart = !doesXStart;
            char [][] thisGame = createEmptyBoard(); 

            drawBoard(thisGame); 

            do { 
                getPositionandPlaceToken3 (thisGame, isXTurn); 
                drawBoard(thisGame); 

                if (isWin(thisGame)== true)
                { 
                    if (isXTurn == true)
                    { xWins++;
                        out.println("Good job X... we'll add that win to your score."); 
                        gameStillGoing = false; 
                    } 
                    else 
                    {out.println("Computer dominates!"); 
                        oWins++;
                        gameStillGoing = false;  } 

                } 
                else if (isFull(thisGame)== true)
                { out.println("No winners, no losers. We call this a draw."); 
                    draws++; 
                    gameStillGoing = false; 
                } 
                else 
                { 
                    isXTurn = !isXTurn;         
                   

                }} while (gameStillGoing ==true); 
            out.println("Score: x = " + xWins + ", O = " + oWins + ", draws = " + draws); 
        } while (wantsToPlayAgain()== true); 
    } 


    public static void getPositionandPlaceToken3 (char [][] board, boolean isXTurn)
  
    {int position = 0; 
        boolean repeat = true; 
        Random pick= new Random (System.currentTimeMillis()); 

        do{ 
            if (isXTurn==true)
           
            {out.println("X, where would you like to go?");
                position = keyboard.nextInt();
                keyboard.nextLine(); 
            }
            else 
            { out.println("Computer's turn");
            if (emptySpot(board))
                  {position = pick.nextInt(9); 
                  out.println(position);
                  } 
                else 
                {
                position = computerPickASpotAsLogicallyAsPossible(board); 
                out.println(position);
                  
                }
            } 
            
            
            if( position < 1 || position > 9 )
            {out.println("Please pick again, try 1 - 9");
                repeat = true; 
            }   
            else if (position >= 1 && position <= 9)
            { 
                if (getTokenAtPosition(position, board) != placeholder)

                {out.println(position + " has been taken. Try again."); 
                    repeat = true; } 
                else 
                { repeat = false; } 

            }       
            else 
            {
                repeat = false; 
            } 

        }while (repeat == true);

        placeToken3(position, board, isXTurn); 
    }   

    public static void main (String[] args)
    {printWelcome(); 
        
        printOptions(); 
        out.println("Goodbye!");   
    }

    public static int almostVerticalWin(char [][]board)
    { for (int x = 0; x <3; x ++)
        {for (int y=0; y<3; y++)
            { if (board[0][y]==('x') && board[1][y]==('x') && board[2][y] ==placeholder) 
                { if (y==0)
                    { return 7;} 
                    if (y==1)
                    { 
                      return 8;} 
                    if (y==2)
                    {return 9;} 

                }
                else if (board[0][y] ==('x') && board[2][y] ==('x')&& board [1][y] ==placeholder) 
                {
                    if (y==0)
                    { 
                      return 4;
                      
                    } 
                    if (y==1)
                    { 
                      return 5;
                      
                    } 
                    if (y==2)
                    {return 6;} 
               
                }
                else if  (board[1][y] ==('x') && board[2][y] ==('x')&& board [0][y] ==placeholder)
                { 
                    if (y==0)
                    { return 1;} 
                    if (y==1)
                    { return 2;} 
                    if (y==2)
                    {return 3;} 

                  
                }
            }
        }
        return computerNotBlocking(board); 
        
    }

    public static int almostHorizontalWin(char [][] board)

    { 
      for (int x = 0; x <3; x ++)
        {for (int y=0; y<3; y++)
            {if (board [x][0]==('x') && board [x][1] ==('x') && board [x][2] ==placeholder) 
                {
                    if (x==0)
                    { return 3;}
                    if (x==1)
                    { return 6;}
                    if (x==2)
                    { return 9;}
           

                }

                else if (board [x][1] ==('x') && board [x][2] ==('x') && board [x][0] ==placeholder)
                {
                    if (x==0)
                    { return 1;}
                    if (x==1)
                    { 
                      
                      return 4;}
                    if (x==2)
                    { return 7;}
                    

                }
                else if (board [x][0]==('x') && board [x][2] ==('x') && board [x][1] ==placeholder)
                {
                    if (x==0)
                    { return 2;}
                    if (x==1)
                    { return 5;}
                    if (x==2)
                    { return 8;}

                   
                }}}return computerNotBlocking(board); }

    public static int almostDiagonalWin(char[][] board)

    { 
        if (board[0][0] ==('x') && board[1][1]==('x')&& board [2][2] ==placeholder)
        {
            return 9;
        }
        else if  (board[0][0] ==('x') && board[2][2] ==('x') && board [1][1] ==placeholder)
        {return 5; 
        }
        else if (board [1][1]==('x') && board [2][2]==('x') && board [0][0] ==placeholder)
        {return 1; 
        }       
        else  if (board[0][2]==('x') &&  board[1][1]==('x') && board [2][0] ==placeholder)
        {return 7; 
        }
        else if (board[0][2] ==('x') && board[2][0]==('x') && board [1][1] ==placeholder)
        {return 5;
        }
        else if (board [2][0] ==('x') && board [1][1] ==('x') && board [0][2] ==placeholder)
        {
            return 3; 
        }   
        return computerNotBlocking(board); 
    }   

    public static int computerPickASpotAsLogicallyAsPossible (char [][] board)
    {

       
         if (checkHorizontalWin(board))
        {   
            return almostHorizontalWin (board);} 

     else if (checkVertWin (board))
{
            return almostVerticalWin (board); }
            
               else    if (checkDiagonalWin (board))
{
            return almostDiagonalWin (board); }

        else 
        {return computerNotBlocking(board);} 

    } 

    public static boolean checkVertWin(char [][]board)
    { for (int y=0; y<3; y++)
        { if ((board[0][y] ==('x') && board[1][y]==('x') && board[2][y]==placeholder)
            ||(board[0][y] ==('x') && board[2][y] ==('x') && board[1][y]==placeholder) || 
            (board[1][y] ==('x') && board[2][y] ==('x') && board[0][y]==placeholder))
            { 
              return true;
            } 
        } 
        
        return false; 
    } 

    public static boolean checkHorizontalWin(char [][] board)

    { for (int x = 0; x <3; x ++)
        {if ((board [x][0] ==('x') && board [x][1] ==('x') && board [x][2] == placeholder ) 
        ||(board [x][1] ==('x') && board [x][2] ==('x') && board [x][0] == placeholder )  
        || 
            (board [x][0] ==('x') && board [x][2] ==('x')&& board [x][1] == placeholder )  )
            { return true;} 
        }return false; 
    }

    public static boolean checkDiagonalWin(char[][] board)
   
    { 
        if ((board[0][0] ==('x') && board[1][1] ==('x')&& board [2][2] == placeholder )  
        || (board[0][0] ==('x') && board[2][2] ==('x')&& board [1][1] == placeholder )  
        || (board [1][1]==('x') && board [2][2]==('x')&& board [0][0] == placeholder ) )
        { return true; } 
        if ((board[0][2] ==('x') &&  board[1][1]==('x')&& board [2][0] == placeholder ) 
        || (board[0][2] ==('x') && board[2][0]==('x')&& board [1][1] == placeholder ) 
        ||(board [2][0]==('x') && board [1][1]==('x')&& board [0][2] == placeholder ) )
        { return true; } 
        return false; 

    }   

    public static int selectPosition(char [][] board)
    { for (int x = 0; x<board.length; x++)
        { for (int y = 0; y<board.length; y++)

            {
                if (board[x][y] == board[0][0])
                { int position = 1;
                    return position; } 
                else if (board[x][y] == board[0][1])
                {int position = 2;
                    return position; } 
                else if (board [x][y] == board[0][2])
                {int position = 3;
                    return position; } 
                else  if (board [x][y] == board [1][0])
                { int position = 4;
                    return position; } 
                else   if (board [x][y] == board [1][1])
                { int position = 5;
                    return position; } 
                else   if (board [x][y] == board [1][2])
                {int position = 6;
                    return position; } 
                else   if (board [x][y] == board [2][0])
                { int position = 7;
                    return position; } 
                else   if (board [x][y] == board [2][1])
                { int position = 8;
                    return position; } 
                else  if (board [x][y] == board [2][2])
                {int position = 9;
                    return position; } 

            } 
        }

        return computerNotBlocking(board); 
    }       
    public static boolean emptySpot(char [][] board) 
    {
    
    for (int x = 0; x < board.length; x ++)
    {
        for (int y = 0; y< board.length; y ++)
        {
            if(board [x][y] != placeholder)
            { 
                return false;
            }
    }}
    return true;  
}
    
    
    public static int computerNotBlocking(char [][] board)
    { 
      for (int x = 0; x<board.length; x++)
        { for (int y = 0; y<board.length; y++)
            { if (board[x][y] == placeholder)
                {
                    if (board[x][y] == board[0][0])
                    { int position = 1;
                        return position; } 
                    else if (board[x][y] == board[0][1])
                    {int position = 2;
                        return position; } 
                    else if (board [x][y] == board[0][2])
                    {int position = 3;
                        return position; } 
                    else  if (board [x][y] == board [1][0])
                    { int position = 4;
                    
                        return position; } 
                    else   if (board [x][y] == board [1][1])
                    { int position = 5;
                        return position; } 
                    else   if (board [x][y] == board [1][2])
                    {int position = 6;
                        return position; } 
                    else   if (board [x][y] == board [2][0])
                    { int position = 7;
                        return position; } 
                    else   if (board [x][y] == board [2][1])
                    { int position = 8;
                        return position; } 
                    else  if (board [x][y] == board [2][2])
                    {int position = 9;
                        return position; } 

                } 
            }

        }
        return 0; 

    }       

}
    