import java.util.Scanner;
import java.util.Arrays;


 public class Game_Of_Life
 {
 	public char[][] gameBoard;
 	public char[][] gameBoard2;
 	private char[][] glider = {{' ','*',' '},
 							   {' ','*','*'},
 							   {'*',' ','*'}
 							  };
 	private char[][] tumbler = {{' ','*','*',' ','*','*',' '},
			   					{' ','*','*',' ','*','*',' '},
	   							{' ',' ','*',' ','*',' ',' '},
			   					{'*',' ','*',' ','*',' ','*'},
			   					{'*',' ','*',' ','*',' ','*'},
			   					{'*','*',' ',' ',' ','*','*'}
			  					};
 	private char[][] exploder = {{'*',' ','*',' ','*'},
								{'*',' ',' ',' ','*'},
								{'*',' ',' ',' ','*'},
								{'*',' ',' ',' ','*'},
								{'*',' ','*',' ','*'},
								};
 			
 			
	/* constructor */
 	public Game_Of_Life()
 	{
		//assume gameboard is 10 x 10
 		gameBoard = new char[10][10];
 		gameBoard2 = new char [10][10];
      
      
      //Life = LIFE;
      //gameBoard.life;
      //putGlider(r,c);
      //life(r,c);
      //System.out.println("There are "+gameBoard2.total+" cells.");
      
	}

	/*
	 * prints a glider
	 */
	public void printGlider()
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
	public void printTumbler()
	{
		for(int i = 0; i < tumbler.length; i++)
		{
			for(int j = 0; j < tumbler[i].length; j++)
			{
				System.out.print(tumbler[i][j]);
			}
			System.out.println();
		}
	}
	public void printExploder()
	{
		for(int i = 0; i < exploder.length; i++)
		{
			for(int j = 0; j < exploder[i].length; j++)
			{
				System.out.print(exploder[i][j]);
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
    gameBoard = gameBoard2;
    return gameBoard;
}    
 /*
 	public void printBoard2()
 	{
		System.out.println("Next cycle");
		for(int i =0; i < gameBoard2.length; i++)
		{
			for(int j = 0; j< gameBoard2[i].length; j++)
			{
				System.out.print(gameBoard2[i][j]);
			}
			System.out.println();
		}
	}
 */
 
   public static void main(String[] args) throws InterruptedException
   {
      Game_Of_Life GAME = new Game_Of_Life();
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the Game of Life!");
      System.out.println("Please select an object");
      System.out.println("(Glider),(Exploder),(Tumbler)");
      String O = input.nextLine();
      switch(O)
      {
         case "Glider":
         {
            GAME.printGlider();
            System.out.println(O);
            //O=GAME.putGlider();
            break;
         }
         case "Tumbler":
         {
            GAME.printTumbler();
            System.out.println(O);
            //O=GAME.putTumbler();
            break;
         }
         case "Exploder":
         {
            GAME.printExploder();
            System.out.println(O);
            //O=GAME.putExploder();
            break;
         }
      }
      System.out.println("To start, please press A");
      char A = input.next().charAt(0);
      if((A =='a')||(A=='A'))
      {
    	  System.out.print(O);
	      while(true)
	      {
	         
	         //GAME.Sleeper(3000);
	         
	         // fix sleeper, get the dashboard to print the glider, everything else should be downhill        
	         //System.out.println("Total number of cells are " + GAME.total);
	         
	    	  GAME.printBoard();
	    	  
	    	  
	         System.out.println("Press S to stop. Press C to continue.");
	         char S = input.next().charAt(0);
	         /*
	         if((S=='s')||(S=='S'))
	         {
	            System.out.println("Game has ended!");
	            break;
	         }
	        
	         else if((S=='c')||(S=='C'))
	         {
		            System.out.println("Game has ended!");
		            break;
	         }
	         */
         }
      }
   
   }     
  /*
   public int countTotal(int r, int c, int i, int j, Boolean[][] gameBoard2)
   {
      int total;
       for(r = 0; r < gameBoard2.length; r++)
		{
			for(c = 0; c < gameBoard2[r].length; c++)
			{
            if((gameBoard2[r] == '*')||(gameBoard2[c] == '*'))
            {
               total++;
            }
         }
      }
      return total;
   }
   */
  }
