// -------------------------------------------------------
// Assignment 4
// Written by: Shahd Yousef, 40114313
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

public class Board {
	 // 5 attributes. all private to be manipulated in the methods
	private int[][][] board;
	private static final int MIN_LEVEL = 3;
	private static final int MIN_SIZE = 3;
	private int level;
	private int size;

	//default constuctor which calls the createBoard() with the set values for level and size
	public Board() {
		this.level = MIN_LEVEL; 
		this.size = MIN_SIZE;
		createBoard(level,size);
	}
	
	// parameterized constructor with passed values. Passes these to createBoard()
	public Board (int level, int x) {
		this.level=level;
		this.size=x;
		createBoard(level,size);
		
	}
	
	//private because this method is not called except within other methods in this class
	private void createBoard(int l, int x) {
		// the array board is created in the memory with the dimensions passed.
		board = new int[l][x][x];
		
		//iterates from 0 to the level passed.
		//incremented when the the board is full for one level
		int lev = 0;
		
		while(lev<l) {
			
			for(int xx=0; xx<x; xx++) {
				
				for (int y=0; y<x; y++) {
					
					//first spot in the game in each level is always 0.
					if(xx==0 && y==0)
						this.board[lev][xx][y] = 0;
					else if((xx+y+lev) % 3 == 0)
						this.board[lev][xx][y] = -3;
					else if ((xx+y+lev) % 5 == 0)
						this.board[lev][xx][y] = -2;
					else if ((xx+y+lev) % 7 == 0)
						this.board[lev][xx][y] = 2;
					else
						this.board[lev][xx][y] = 0;
				}
				
			}
			
			lev++;
			
		}
			
	}
	
	//accessor method for level
	public int getLevel() {
		return level;		
	}
	
	
	//accessor method for size
	public int getSize() {
		return size;
	}
	
	
	
	
	//method to return the energy adj in a specific spot on the entire board.
	public int getEnergyAdj(int l, int x, int y) {
		return board[l][x][y];
	}
	
	
	
	//prints the board in one concatenated String display
	//prints in same display as handout
	public String toString() {
		

		int lev=0;
		
		//note to self: don't put null for display instead of "" because it actually prints the word null before printing the rest
		String display = "";
		
		while(lev<level)
		{
			display += "\nLevel " + lev + "\n--------\n";
			
			for(int i=0; i<size; i++) {
				
				display+= "\t";
		
				for(int j=0; j<size; j++) {
				
					display += board[lev][i][j] + "\t";
					
			
				}
				display += "\n";
			
			}
			
			lev++;
		
		}
		return display;
		
	
	}
	
	
	
	
	
	
	
	
	//Test:
	/*public static void main(String [] args) {
		
		Board game = new Board();
		Board game2 = new Board(3,4);
	
		System.out.println(game.getLevel() + " " + game.getSize());
		System.out.println(game2.getLevel() + " " + game2.getSize());
		System.out.println(game2);
	
		System.out.println(game2.getEnergyAdj(0, 2, 3));
		
	 }*/
	
}


