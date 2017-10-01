import static java.lang.System.out;
import java.util.Scanner;

public class TicTacToe

{
    static char placeholder = '.'; 
    static Scanner keyboard = new Scanner (System.in); 

    public static void drawBoard(char[][] board)
    //for loop. Each line needs to print the whole row with the | separating them. Run 3 times, three rows. 
    { out.println(); 
        for (int a= 0; a<3; a++)
        { out.println(" " + board[a][0] + " | " + board[a][1] + " | "  + board[a][2]); 
        } 
        out.println(); 

    } 

    public static char [][] createEmptyBoard()
    //for loop in for loop to get table. Given the array name and return value.
    {char [][] gameBoard = new char [3][3]; 
        for (int x = 0; x <3; x ++)
        { for (int y = 0; y<3; y++)
                gameBoard[x][y] = placeholder;
        }
        return gameBoard; 

    }

    public static boolean isWin(char[][] board)
    //right now the last one is considered a draw even if it is a win - fixed by swapping order of checking to see if board was full and board had a win in the game method

    {// if isHorizontalwin, isVerticalWin, or isDiagonalWin are true, return true. 
        if (isHorizontalwin(board) == true)
        {return true; }
        if (isVerticalWin(board) == true)
        { return true;} 

        if (isDiagonalWin(board) == true)
        {return true;}
        return false;   
    }

    public static boolean isFull(char[][]board)
    //cycle through. true if no cells have a placeholder, they all have an x or y. 

    {for (int x = 0; x<3; x++)
        { for (int y = 0; y<3; y++)
            { if    (board[x][y] == placeholder)
                { return false; } } }
        return true; 
    } 

    public static boolean isHorizontalwin(char [][] board)
    //Cycle through the horizonal. row 1 is equal to row 2 and row 3.
    // And they can't be a placeholder. 
    { for (int x = 0; x <3; x ++)

        { if ((board [x][0] == board [x][1]) && (board [x][0] == board [x][2] )&& (board [x][0] != placeholder))
            { return true; } 

        }   
        return false; 
    }

    public static boolean isVerticalWin (char[][]board)
    //cycle through vertical. column 1 is equal to column 2 and 3.
    //and they can't be a placeholder.
    { for (int y = 0; y<3; y++)
        { if ((board [0][y] == board [1][y]) && (board [0][y] == board [2][y] )&& (board [0][y] != placeholder))
            { return true; } 

        }   
        return false; 
    }

    public static boolean isDiagonalWin(char[][] board)
    //spot 1-1 equals spot 2-2 which equals spot 3-3  
    // spot 1-3 equals spot 2-2 which equals spot 3-1
    // and they can't be placeholders
    { 
        if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board [0][0] != placeholder))
        { return true; } 
        if ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board [0][2] != placeholder))
        { return true; } 
        return false; 

    } 

    public static void printWelcome()
    { //given the welcome.
        out.println("Welcome to Tic Tac Toe!"); 
        out.println("To play, enter a number for which box to play in.");
        out.println("1  2  3"); 
        out.println("4  5  6"); 
        out.println("7  8  9"); 
        out.println("You'll need a buddy to play with so go grab your best gal or best guy. Ready to begin? Away we go!"); 
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
    { //given this code. Should be correct. Don't alter!
        int row = (position -1)/3; 
        int col = (position -1) %3 ; 
        return board [row][col]; 
    } 

    public static void placeToken (int position, char [][]board, boolean isXturn)
    //use above to figure row and column position. if x's turn place an x in that position. If o's turn 
    //put an o there. 

    { int row = (position -1)/3; 
        int col = (position -1) %3 ; 
        if (isXturn == true)
        { board[row][col] = 'x'; 
        } 
        else 
        { board [row][col] = 'o'; 
        } 

    } 

    public static void getPositionandPlaceToken (char [][] board, boolean isXTurn)
    //if it is X, ask X where they want to go. Same if 0. 
    //repeat if full - give error message
    //repeat if nonsense - give error message. Must be do/while loop.
    //given int position and placeToke(position, board, isXTurn). Don't mess with those. They aren't the problem.

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

    public static void game ()
    { // given the initial variables, the print welcome line, the fact that there are nested do loops, 
        //the gameStillgoing variable - dont mess with those. 

        int xWins = 0; 
        int oWins = 0; 
        int draws = 0; 
        boolean doesXStart = true; 
        boolean isXTurn = doesXStart; 

        printWelcome(); 

        do 
        { //establish turn, create the visual of the game. 
            boolean gameStillGoing = true; 

            isXTurn = doesXStart; 
            //int count = 0
            doesXStart = !doesXStart;
            char [][] thisGame = createEmptyBoard(); 

            drawBoard(thisGame); 

            do { // loop so that it calls methods ask where to go, places, to shows the board, 
                //consider if it is a win, whether or not it is still continuing to loop. Split them out by x and o so 
                // count will be consistent. 

                //FIX THIS METHOD - we aren't switching to o - FIXED!!
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
                    //out.println(isXTurn); - check to see if it is switching from true to false each time

                }} while (gameStillGoing ==true); 
            out.println("Score: x = " + xWins + ", O = " + oWins + ", draws = " + draws); 
        } while (wantsToPlayAgain()== true); 
    } 

    public static void main (String[] args)
    {game(); 
        out.println("Goodbye!");   

    }
    // testing
    // public static void main (String[] args)
    // {   char board [][] = new char [3][3];
        // board [0][0] ='x';
        // board [1][0] = 'x'; 
        // board [2][0] = 'x';
        // { if (isVerticalWin(board))
            // {out.println("Vert 0 good"); 
            // } 
            // else { out.println("Vert 0 bad"); 
            // } 
        // } 
        // board [0][0] = 'x'; 
        // board [1][0] = 'x'; 
        // board [2][0] = 'x'; 

        // if (isVerticalWin(board))
        // {out.println("Vert 1 good"); 
        // } 
        // else { out.println("Vert 1 bad"); 
        // } 
        // board [0][2] = 'x'; 
        // board [1][2] = 'x'; 
        // board [2][2] = 'x'; 

        // if (isVerticalWin(board))
        // {out.println("Vert 2 good"); 
        // } 
        // else { out.println("Vert 2 bad"); 
        // }
        // board [0][0] = 'x'; 
        // board [0][1] = 'x'; 
        // board [0][2] = 'x'; 

        // if (isHorizontalwin(board))
        // {out.println("Horiztontal 0 good"); 
        // } 
        // else { out.println("Horizontal 0 bad"); 
        // }   
        // board [1][0] = 'x'; 
        // board [1][1] = 'x'; 
        // board [1][2] = 'x'; 

        // if (isHorizontalwin(board))
        // {out.println("Horiztontal 1 good"); 
        // } 
        // else { out.println("Horizontal 1 bad"); 
        // }   
        // board [2][0] = 'x'; 
        // board [2][1] = 'x'; 
        // board [2][2] = 'x'; 

        // if (isHorizontalwin(board))
        // {out.println("Horiztontal 2 good"); 
        // } 
        // else { out.println("Horizontal 2 bad"); 
        // }
        // board [0][0] = 'x'; 
        // board [1][1] = 'x'; 
        // board [2][2] = 'x'; 

        // if (isDiagonalWin(board))
        // {out.println("Diag 1 good"); 
        // } 
        // else { out.println("Diag 1 bad"); 
        // }   
        // board [2][0] = 'x'; 
        // board [1][1] = 'x'; 
        // board [0][2] = 'x'; 

        // if (isDiagonalWin(board))
        // {out.println("Diag 2 good"); 
        // } 
        // else { out.println("Diag 2 bad"); 
        // }       
        // char [][]testboard = createEmptyBoard();
        // drawBoard(testboard);
        // int xWins=0; 
        // int oWins = 0; 
        // int draws=0; 
        // for (xWins = 0; xWins <5; xWins++    )
        // { for (oWins = 0; oWins <5; oWins++  )
            // {for (draws = 0; draws <5; draws++   )
                // {
                    // out.println("Score: x = " + xWins + ", O = " + oWins + ", draws = " + draws); 
                // }
            // }
           
        // }   if ((xWins ==5 )&& (oWins ==5 )&& (draws==5))
            // {out.println("wins are good"); } 
         
    // }
}
 