import java.util.Scanner;
import java.util.Arrays;


 public class Game_Of_Life
 {
 	public static char[][] gameBoard;
 	public static char[][] gameBoard2;
 	public static char[][] pattern;
 	private static char[][] glider = {{' ','*',' '},
 							   		{' ',' ','*'},
 							   		{'*','*','*'}
 							  		};
 	private static char[][] tumbler = {{' ','*','*',' ','*','*',' '},
					   					{' ','*','*',' ','*','*',' '},
			   							{' ',' ','*',' ','*',' ',' '},
					   					{'*',' ','*',' ','*',' ','*'},
					   					{'*',' ','*',' ','*',' ','*'},
					   					{'*','*',' ',' ',' ','*','*'}
					  					};
 	private static char[][] exploder = {{'*',' ','*',' ','*'},
										{'*',' ',' ',' ','*'},
										{'*',' ',' ',' ','*'},
										{'*',' ',' ',' ','*'},
										{'*',' ','*',' ','*'},
										};
 			
 			
	/* constructor */
 	public Game_Of_Life()
 	{
		//assume gameboard is 10 x 10
 		gameBoard = new char[20][20];
 		gameBoard2 = new char [20][20];
      
      
      //Life = LIFE;
      //gameBoard.life;
      //putGlider(r,c);
      //life(r,c);
      //System.out.println("There are "+gameBoard2.total+" cells.");
      
	}
 	public static void main(String[] args)throws InterruptedException
    {
 	   int x=0;
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
             x=1;
             //Game_Of_Life.newBoard(glider);
             break;
          }
          case "Tumbler":
          {
             GAME.printTumbler();
             System.out.println(O);
             //Game_Of_Life.newBoard(tumbler);
             x=2;
             break;
          }
          case "Exploder":
          {
             GAME.printExploder();
             System.out.println(O);
             //Game_Of_Life.newBoard(exploder);
             x=3;
             break;
          }
       }
       System.out.println("Enter first cordinate.");
       int first = input.nextInt();
       System.out.println("Enter second cordinate.");
       int second = input.nextInt();
       System.out.println("To start, please press A");
       char A = input.next().charAt(0);
       if((A =='a')||(A=='A'))
       {
     	  GAME.setBoard(x,first,second);
 	      while(true)
 	      {
 	         
 	    	 GAME.Life();
 	    	 GAME.printBoard();
 	         
 	         // fix sleeper, get the dashboard to print the glider, everything else should be downhill        
 	         //System.out.println("Total number of cells are " + GAME.total);
 	         System.out.print("There are "+ GAME.countTotal() + " cells!");
 	    	  //GAME.printBoard();
 	    	  
 	    	  
 	    	  /*
 	         System.out.println("Press S to stop. Press C to continue.");
 	         char S = input.next().charAt(0);
 	         
 	         if((S=='s')||(S=='S'))
 	         {
 	            System.out.println("Game has ended!");
 	            break;
 	         }
 	        */
 	    	 GAME.Sleeper(1000);
          }
 	      
       }
    
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
	
	public static char[][] putGlider(char [][] x,int r, int c)
	{
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
		return x;
	}
	public static char[][] putTumbler(char [][] x,int r, int c)
	{
		int tumblerRow = 0;
		int tumblerCol;
		for(int i= r-1; i < ((r-1)+tumbler.length); i++)
		{
			tumblerCol = 0;
			for(int j =c-1; j < ((c-1)+tumbler.length); j++)
			{
				gameBoard[i][j] = tumbler[tumblerRow][tumblerCol++];
			}
			//advance to next row in glider matrix
			tumblerRow++;
		}
		//print the board
		return x;
	}
	public static char[][] putExploder(char[][] x,int r, int c)
	{
		int exploderRow = 0;
		int exploderCol;
		for(int i= r-1; i < ((r-1)+exploder.length); i++)
		{
			exploderCol = 0;
			for(int j =c-1; j < ((c-1)+exploder.length); j++)
			{
				gameBoard[i][j] = tumbler[exploderRow][exploderCol++];
			}
			//advance to next row in glider matrix
			exploderRow++;
		}
		//print the board
		return x;
	}

	/*
	 * print the game board
	 */
	public static void printBoard()
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
	//setter
	
	//call as setBoard
	public void setBoard(int x, int y, int z)
	{
		switch(x)
		{
		case 1:
		 {
			 gameBoard = putGlider(gameBoard ,y,z);
			 printBoard();
			 break;
		 }
		case 2:
		 {
			 gameBoard = putTumbler(gameBoard ,y,z);
			 printBoard();
			 break;
		 }
		case 3:
		 {
			 gameBoard = putExploder(gameBoard ,y,z);
			 printBoard();
			 break;
		 }
		}	
	}
	 public static void newBoard()
	 {
		 //put shape into gameboard
		 //print it
		 //  gameboard=life(gaemboard)
		 //my life would take the gameboard, apply rules and print it after rules had been applied
		 //then it would return the new gameboard
		 //gameBoard2=Life(gameBoard2);
		 //gameBoard=Life(gameBoard);
		 //stp 1 print gameboard
		 //System.out.println(gameBoard);
		 //apply life
		 //print the new board 
		 //iterate all of the inital board and set each element equal to the new element 
		 //in the new board 
		// gameBoard2.length(Boolean Life);
		 //gameBoard=gameBoard2; 
	 }
	 
	 
	 public static int countNeighbors(int r, int c) 
	 { 
		int count = 0; 
		//This method must have a designated target
		// Scans whole board
		//Will be removed
		//scans the 3x3 region by saying that i cannot be 2 points back but can be 1 point back
				  if((!isEdge(r,c))&&(gameBoard[r-1][c-1]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r-1][c]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r-1][c+1]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r][c-1]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r][c+1]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r+1][c-1]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r+1][c]=='*'))
				  {
					  count++;
				  }
				  if((!isEdge(r,c))&&(gameBoard[r+1][c+1]=='*'))
				  {
					  count++;  
				  }
				  return count;
		}	
	 public static boolean isEdge( int r, int c)
	  {
		//is it in an edge ?
		if((r == 0) || (r == gameBoard.length-1) || (c == 0) || (c == gameBoard.length-1))
		  return true;
	    else
		  return false;
	  }

	 
    public void Sleeper(long sleepTime)
	throws InterruptedException
   {
		//default sleep for one second
		sleepTime = 1000;
		Thread.sleep(sleepTime);
			
		}
      
	
    
    public void Life() 
    {
		 int r;
		 int c;
		 /*
		 for(r = 0; r < gameBoard2.length; r++)
			{
				for(c = 0; c < gameBoard2[r].length; c++)
				{
	            gameBoard2[r][c]=gameBoard[r][c];
				}
	         }
	         */
	       for (int row = 0; row < gameBoard.length; row++) 
	       {
	           for (int col = 0; col < gameBoard[row].length; col++) 
	           {
	               int count = countNeighbors(row, col);
	               /*
	               if(gameBoard2[row][col]=='*')
	               {
	            	   count--;
	               }
	               */
	               if ((count < 2) || (count > 3)) 
	               {
	                   gameBoard2[row][col] = ' ';
	               }
	               if(count == 2)
	               {
	            	   gameBoard2[row][col] = gameBoard[row][col];
	               }
	               if (count == 3)
	               {
	            	   gameBoard2[row][col] = '*';
	               }
	           }
	       }
	       //converts gameBoard2 back to gameBoard
	       for(r = 0; r < gameBoard.length; r++)
			 {
				for(c = 0; c < gameBoard[r].length; c++)
				 {
				      gameBoard[r][c]=gameBoard2[r][c];   
				 }
			 } 	
   }    
  /*
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
*/ 
   public int countTotal()
   {
      int total = 0;
      int r;
      int c;
       for(r = 0; r < gameBoard.length; r++)
		{
			for(c = 0; c < gameBoard[r].length; c++)
			{
            if(gameBoard[r][c]=='*')
            {
               total++;
            }
         }
      }
      return total;
   }
   
  }
