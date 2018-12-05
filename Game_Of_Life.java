import java.util.Scanner;
import java.util.Arrays;
 public class Game_Of_Life
 {
	//Identifies variables, all are chars and statics
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
		//establishes values for gameBoard and gameBoard2
 		gameBoard = new char[20][20];
 		gameBoard2 = new char [20][20];      
	}
 	public static void main(String[] args)throws InterruptedException
    {
 		//x is an int for registery for the case switch of O
 	   int x=0;
 	   //gives the public class a name for itself
       Game_Of_Life GAME = new Game_Of_Life();
       //identifies scanner
       Scanner input = new Scanner(System.in);
       System.out.println("Welcome to the Game of Life!");
       //asks for input O between 3 available patterns
       System.out.println("Please select an object");
       System.out.println("(Glider),(Exploder),(Tumbler)");
       String O = input.nextLine();
       switch(O)
       {
          case "Glider":
          {
        	 //Prints the pattern
             GAME.printGlider();
             //Prints out what the user inputed
             System.out.println(O);
             //Registers x with a number 1-3. This is used for setBoard to know which is to be used
             x=1;
             break;
          }
          case "Tumbler":
          {
             GAME.printTumbler();
             System.out.println(O);
             x=2;
             break;
          }
          case "Exploder":
          {
             GAME.printExploder();
             System.out.println(O);
             x=3;
             break;
          }
       }
       // the program asks for 4 inputs, 3 ints, 1 char
       //first it asks for two cord to set where the pattern while be at
       System.out.println("Enter first cordinate.");
       int first = input.nextInt();
       System.out.println("Enter second cordinate.");
       int second = input.nextInt();
       //int sleep will be used for the sleeper
       System.out.println("How many times?");
       int sleep = input.nextInt();
       //asks consent to start, N to not start and skips the while loop
       System.out.println("To start, please press A. To stop, press N.");
       char A = input.next().charAt(0);
       if((A =='a')||(A=='A'))
       {
    	   //iff continued, GAME sets the board before the real content begins
     	  GAME.setBoard(x,first,second);
 	      while(true)
 	      {
 	         //processes changes using method Life
 	    	 GAME.Life();
 	    	 //Prints board
 	    	 GAME.printBoard();
 	         System.out.print("There are "+ GAME.countTotal() + " cells!");
 	    	 // Followed by a scanner if to continue or stop 
 	         System.out.println("Press S to stop. Press C to continue.");
 	         char S = input.next().charAt(0);
 	         //If S, prints out "Game has ended!" and ends the while loop
 	         if((S=='s')||(S=='S'))
 	         {
 	        	//ends the game
 	            System.out.println("Game has ended!");
 	            break;
 	         }
 	         else if((S=='c')||(S=='C'))
 	         {
 	         	//continues since there is no break which ends the program
 	         }
 	         //sleeper is set to go 'sleep' or int amount of times based on the user's input
 	         //NOTE: Sleeper is in the while loop and continues to operate with or withoute input for S
 	         //If input S is selected, sleeper is overrided
 	    	 GAME.Sleeper(sleep);
          }
       }
       else if ((A=='n')||(A=='N'))
       {
    	   System.out.println("Game aborted.");
       }
    }  
	// prints pattern
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
	/* putGlider is set as char [][] as it is also being inputted by a char and x,c
	 * Then puts the glider on the board based what the r and c says to start
	 * GameBoard copies it and the x is returned
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
	//same to putTumbler
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
	//same to putExploder
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

	//prints the game board
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
	//call as setBoard
	public void setBoard(int x, int y, int z)
	{
		//takes the register number and both y and z from the main to input where the pattern is set
		//Switch case is used
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
	 public static int countNeighbors(int r, int c) 
	 { 
		int count = 0; 
		//Scans the region around the designated cell in Life's for loops
		//First uses isEdge but starts with '!' to designate that it is not an edge
		//Cords based on the inputs of r and c are checked on hardwired locations with 8 ifs
		//NOTE: gameBoard[r][c] stand alone will not be including since we are not measuring the cell itself
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
		//True or false if this is acknowledged as an edge
		if((r == 0) || (r == gameBoard.length-1) || (c == 0) || (c == gameBoard.length-1))
		  return true;
	    else
		  return false;
	  }
    public void Sleeper(long sleepTime)
	throws InterruptedException
   {
		//default sleep for one second to allow the user see the change in time
		sleepTime = 1000;
		Thread.sleep(sleepTime);		
	}
    public void Life() 
    {
		 int r;
		 int c;
		 //Scans all of gameBoard which is set, then inputs changes onto the gameBoard2
	       for (int row = 0; row < gameBoard.length; row++) 
	       {
	           for (int col = 0; col < gameBoard[row].length; col++) 
	           {
	               int count = countNeighbors(row, col);
	               
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
 //scans the whole board and returns the number of '*' are in the board, that's it
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
