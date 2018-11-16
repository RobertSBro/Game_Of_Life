/*
 * a class for working with Gliders
 * Spring 2017 update
 * 
 */
import java.util.scanner;

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

	 public static void main (Strings[]args)
	 {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter 'start' to start and 'stop' to stop: ");
		String user = input.nextCharAt();
		while (
		if(user=='start')
		{
			
		}
		else if (user == 'stop')
		{
				
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
	 
	 private int countNeighbors(int r, int c) 
	 { 
		int count = 0;
		int r = 0;
		int c = 0;
		//This method must have a designated target
      // Scans whole board
      //Will be removed
      
            
            //scans the 3x3 region by saying that i cannot be 2 points back but can be 1 point back
               for(int i = r; i > gameboard[r-2].length; i < gameboard[r+2].length; i++;)
               {
                  for (int j = c; j > gameboard[c-2].length; j < gameboard[c+2].length; j++;)
                  {
                     if ((gameboard[i].length == '*') || ( gameboard[j].length == '*'))
                     {
                        count++;
                     }
                  }
	       }
		return count-1; 
		
	 }
    
    
    
    
   public void Sleeper(long sleepTime)
	{
		//default sleep for one second
		long sleepTime = 1000;

		//get commnd line time if entered
		if(args.length == 1)
		{
			sleepTime = Long.parseLong(args[0]);
		}

		//start sleep() example
		while(true)
		{	System.out.println("Sleeping ..... Ctrl-C to exit");
			try
			{
				Thread.sleep(sleepTime);
			}
			catch(Exception ex)
			{
				System.out.println("Exception:"+ex.getStackTrace());
			}
		}
	}
   
   
   public static boolean isEdge(char[][] w, int r, int c)
  {
	//it it in an edge ?
	if((r == 0) || (r == w.length-1) || (c == 0) || (c == w.length-1))
	  return true;
    else
	  return false;
  }

  public static boolean isTopEdge(int r, int c)
  {
    if(r == 0)
	  return true;
	else
	  return false;
  }

  public static boolean isBottomEdge(int r, char[][] w)
  {
    if(r == w.length-1)
	  return true;
	else
	  return false;
  }

  public static boolean isLeftEdge(int c)
  {
    if(c == 0)
	  return true;
	else
	  return false;
  }

  public static boolean isRightEdge(int c, char[][] w)
  {
    if(c == w.length-1)
	  return true;
	else
	  return false;
  }
  
  public boolean life ()
  {
      /*make a second array called 'gameboard2'
      This will allow us to transfer the living cells over to the new cells after making adjustments
      
      
      */
      gameBoard2 = new char[10][10];
      gameBoard2 = gameBoard;
      
      for(int r = 0; r < gameBoard.length; r++)
		{
			for(int c = 0; c < gameBoard[r].length; c++)
			{
           //call for count gameboard
           gameBoard[r][c].count;
               if(count==3)
               {
                  gameBoard2[r][c] = gameBoard1[r][c];
               }
               else if (count < 3)
               {
                  gameBoard2[r][c] == ' ';
               }
               else if (count > 3)
               {
                  gameBoard2[r][c] == ' ';
               }
         }
      }
  
  
  
  }
 } ///~
