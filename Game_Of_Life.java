import java.util.Scanner;
import java.util.Arrays;


 public class Game_Of_Life
 {
 	private char[][] gameBoard;
 	private char[][] glider = {{' ','*',' '},
 							   {' ','*','*'},
 							   {'*',' ','*'}
 							  };
	/* constructor */
 	public Game_Of_Life()
 	{
		//assume gameboard is 10 x 10
		gameBoard = new char[10][10];
      //gameBoard2 = new char [10][10];
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the Game of Life!");
      System.out.println("Press S to stop");
      //gameBoard.putGlider;
      //gameBoard.life;
      //putGlider(r,c);
      //life(r,c);
      //System.out.println("There are "+gameBoard2.total+" cells.");
      
	}

	/*
	 * prints a glider
	 */
	private void printGlider()
	{
		for(int i = 0; i < glider.length; i++)
		{
			for(int j = 0; j < glider[i].length; j++)
			{
				System.out.print(glider[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * put a glider into the gameboard starting at row r
	 * column c
	 * Note: There is no error checking for edges!!!
	 */
	public void putGlider(int r, int c)
	{
		System.out.println("Putting glider at: "+r+","+c);
		int gliderRow = 0;
		int gliderCol;
		for(int i= r-1; i < ((r-1)+glider.length); i++)
		{
			gliderCol = 0;
			for(int j =c-1; j < ((c-1)+glider.length); j++)
			{
				gameBoard[i][j] = glider[gliderRow][gliderCol++];
			}
			//advance to next row in glider matrix
			gliderRow++;
		}
		//print the board
		printBoard();
		
		//TODO : Count the neighbors 
      
		
	}

	/*
	 * print the game board
	 */
	public void printBoard()
	{
		System.out.println("Printing the game board");

		for(int i =0; i < gameBoard.length; i++)
		{
			for(int j = 0; j< gameBoard[i].length; j++)
			{
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * count the neighbors 
	 * no error checking 
	 */
	 
	 public static int countNeighbors(int r, int c, int i, int j, Boolean[][] gameBoard) 
	 { 
		int count = 0; 
		//This method must have a designated target
      // Scans whole board
      //Will be removed
      
            //scans the 3x3 region by saying that i cannot be 2 points back but can be 1 point back
               for (i = r; (i > gameBoard[r-2].length && i < gameBoard[r+2].length); i++)
               {
                  for (j = c; (j > gameBoard[c-2].length && j < gameBoard[c+2].length); j++)
                  {
                     if ((gameBoard[i].length == '*') || ( gameBoard[j].length == '*'))
                     {
                        count++;                        
                        }
                     }
                  }
                  return count--;
               }		
	 
    public void Sleeper(long sleepTime)
	throws InterruptedException
   {
		//default sleep for one second
		sleepTime = 3000;
		Thread.sleep(sleepTime);
			
		}
      
	

  
 public static Boolean[][] Life(Boolean[][] gameBoard, int newRows, int newCols) 
 {

    Boolean[][] gameBoard2 = new Boolean[newRows][];
    for (int row = 0; row < newRows; row++) 
    {
        gameBoard2[row] = Arrays.copyOf(gameBoard[row], newCols);
    }

    for (int row = 0; row < newRows; row++) 
    {
        for (int col = 0; col < newCols; col++) 
        {

            int count = countNeighbors(row, col, newRows, newCols, gameBoard);

            if ((count < 2) || (count > 3)) 
            {
                gameBoard2[row][col] = false;
            }

            if (count == 2) 
            {
                gameBoard2[row][col] = gameBoard[row][col];
            }

            if (count == 3) 
            {
                gameBoard2[row][col] = true;
            }
        }
    }
    return gameBoard2;
}         
      
  /*
   private int countTotal()
   {
      int total;
       for(r = 0; r < gameBoard.length; r++)
		{
			for(c = 0; c < gameBoard[r].length; c++)
			{
            if((gameBoard2[r] =='*')||(gameBoard2[c] == '*'))
            {
               total++;
            }
         }
      }
      return total;
   }
  */
 }
