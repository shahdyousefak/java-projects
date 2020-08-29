// -------------------------------------------------------
// Assignment 4
// Written by: Shahd Yousef, 40114313
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

//this is the driver program which includes the main method and all my static functions.


import java.util.Scanner;
public class LetUsPlay {
	
	
	

	//this static method returns an integer which returns the index of the array of which of the two players go first
	public static int ranPlayer() {
		return (int)(Math.random()*2);
	}

	//this method returns a 2 (which is added to energy units) if the player rolls a double) and a 0 if a double is not rolled
	//the player passed calls a method called isDouble in another class
	
	public static int doubleToss(Player play, Dice di) 
	{
		if(di.isDouble()) {
			
			System.out.println("\tCongratulations you rolled double " + di.getDie1() + ". Your energy went up by 2 units");
		
			play.setEnergy(play.getEnergy()+2);
			
			return 2;
			//return play.getEnergy();
		}
		
		return 0;
		
	}
	
	
	
	//this method called startWithZero checks if the player in the beginning of the round starts with 0 or less energy
	//if it does then it calls the rollDice method 3 times in order to try to gain energy units
	//returns the energy of the player = his old energy + the energy generated from the 3 dice tosses
	
	public static int startWithZero(Player play, Dice di, Board bgame) {
	
		if (play.getEnergy() <= 0) {
			System.out.println("\tYou're out of energy!!! You get three dice tosses! ");
		
			int eunits=0; // eunits keeps count of the energy units generated from the 3 tosses. should be between 0 and 6
			int sum=0;
			for(int i=0; i<3; i++) {
				sum=di.rollDice();
				if(doubleToss(play,di)==2) {
					eunits+=2;
				}
				
			}
			
			

			System.out.println("\t\tYou got " + eunits + " units of energy from three dice tosses.");
			System.out.println("\t\tYour energy is now " + play.getEnergy() + " units");
		
			if(play.getEnergy()<=0) {
				System.out.println("\t\tStill too weak to move.");
	
			}
			
			else
				{
				System.out.println("\tYou have energy to play this round now!");
				
				}
			
		}
		
		return play.getEnergy();		
		
	}
	
	
	public static boolean atFinalLevel(Player play, Board bgame) {
		

		if(play.getLevel()>=bgame.getLevel()) {
			
			
			
			System.out.println("\t!!! Sorry you need to stay where you are - that throw takes you off the grid and you lose 2 units of energy. ");
			play.setEnergy(play.getEnergy()-2);
		
			
			return true;
		}
		
	return false;
	
	
}
	
	//this method returns a boolean to see if the player is at an occupied location.
	//this method takes the player whose moving, the player whose already there, an object of type Board (the board game itself), and the player whose moving's initial x,y, and level.
	//validates input if 0 or 1
	//if 0: challenge. generates random number between 0 and 10. win from>6. Lose otherwise.
	//if 1: moves down a level/to (0,0) if at level 0.
	public static boolean atOccupiedLocation(Player play, Player other, Board bgame, int posx, int posy, int lev, int en) {
		
		Scanner key = new Scanner(System.in);
		int x;
		
		if(play.getLevel()==0 && play.getX()==0 && play.getY()==0) 
			return false;
			
		
		if(play.equals(other)) {
			
		System.out.println("Player " + other.getName() + " is at your new location \n What do you want to do?" );
	
		System.out.println("\t0 - Challenge and risk loosing 50% of your energy units if you lose or move to a new location and get 50% of other players energy units ");
		
		System.out.println("\t1 to move down one level or move to (0,0) if at level 0 and lose 2 energy units");
			
			x = key.nextInt();
			
			
			if(x!=1 && x!=0)
			{
				do {
					System.out.println("\tSorry but " + x + " is not a legal choice.");
					x = key.nextInt();
			
				}
			while(x!=1 && x!=0);
			
			}
			
			if(x==0) {
				int ran = (int) (Math.random()*11);
				if(ran<6) {
					
					System.out.println("\tOops! You lose the challenge :(.");

					play.setX(posx);
					play.setY(posy);
					play.setEnergy(play.getEnergy()/2);
					
				
				}
			
				else
				{
					System.out.println("\tBravo!! You won the challenge.");
				
					
					Player temp = new Player(lev,posx,posy);
					
					play.moveTo(other);
					
					other.moveTo(temp);
					
					
					System.out.println("\tYour energy is adjusted by " + bgame.getEnergyAdj(play.getLevel(),play.getX(),play.getX()) + " for landing at (" + play.getX() + "," + play.getY() + ") at level " + play.getLevel());
				
	
					int lost = other.getEnergy()/2;
					
					other.setEnergy(lost);
					
					play.setEnergy(play.getEnergy()+lost);
					
					
				
				}
			}
				
				else
				{
					if(lev==0) {
						play.setX(0);
						play.setY(0);
						play.setEnergy(en-2);
						
					}
					else
					{
						play.setX(posx);
						play.setY(posy);
						play.setLevel(lev-1);
						play.setEnergy(en-2);
						
					}
					
				}
				
					
					
					
				
			
			
			
			return true;
			
		}
		return false;
	}
	
	//returns a boolean if at (3,2) level 2 (in the case of the annotated example)
	//using a switch case
	
	public static boolean atSecondLastSquare(Player play, Board bgame, Dice di) {
		
		if(play.getX()==bgame.getSize()-1 && play.getY()==bgame.getSize()-2 && play.getLevel()==bgame.getLevel()-1) {
			
			int sum=0;
			sum = di.rollDice();
			
			System.out.println("\t" + play.getName() + " you rolled " + di);
			
			int x=0, y=0;
			
			int inx = play.getX();
			int iny = play.getY();			
			
			x = inx - sum/bgame.getSize();
				
			 y = iny - sum%bgame.getSize();
			 
			
		
			 int temp =0;
				
			 int t=0;
			
			 if(y<0)
					
				{
				 
				 
				
					temp = y;
					
					y = iny % (bgame.getSize()) ;
					
					x = temp + inx;
				
				
				}
				
					
			 
			play.setX(x);
			play.setY(y);
		
						 
			 play.setEnergy(play.getEnergy()+bgame.getEnergyAdj(2,x,y));
			
			 System.out.println("\tYour energy is adjusted by " + bgame.getEnergyAdj(2,x,y) + " for landing at (" + x + "," + y + ") at level " + 2);
			 
			 
			
			return true;
			
		}
		
		return false;
		
		
	}
	
	
	//method that calculates the position of the player.
	//calls other static methods from above/objects calling nonstatic method from other classes.
	
	public static void calcPos(Player play, Dice di, Board bgame, Player other) {
	
		
		int posx = play.getX();
		int posy = play.getY();
		int lev = play.getLevel();
		int en = play.getEnergy();
		
		//System.out.println(posx + " " + posy + " " + lev);
		int sum = 0;
		sum = di.rollDice();
		
		
		System.out.println("\t" + play.getName() + " you rolled " + di);
	
	
		doubleToss(play,di);
		
	
		
		int x, y;
	
		 x = play.getX() + sum/bgame.getSize();
	
		 y = play.getY()+ sum%bgame.getSize();
	
	
		 
		
		 int temp =0;

		
		 int t=0;
		
		 play.setX(x);
		 play.setY(y);
		 
		
		if(y>=bgame.getSize())
	
		{
		
			t = y;
			
			y = y%bgame.getSize();
		
			temp = x + t/bgame.getSize();
			
			x=temp;
		
			if(x>=bgame.getSize())
			
				{
				x = temp%bgame.getSize();
				play.setLevel(play.getLevel()+1);
				
				}
			
			play.setX(x);
			play.setY(y);
		
		}
	
	
		if(x>=bgame.getSize())
	
		{
		
			x = x%bgame.getSize();
		
			play.setLevel(play.getLevel()+1);
			play.setX(x);
			

		}
		
		
		if(atOccupiedLocation(play,other,bgame,posx,posy,lev,en))
		{
			

			System.out.println("Oops occupied!" );
			
			
		}
		
	
		else if (atFinalLevel(play,bgame))
			
		{
			play.setX(posx);
			
			play.setY(posy);
			
			play.setLevel(2);
			
			
		}
		
		
		
		
		else
		{
			
			play.setEnergy(play.getEnergy()+bgame.getEnergyAdj(play.getLevel(),x,y));
			
			System.out.println("\tYour energy is adjusted by " + bgame.getEnergyAdj(play.getLevel(),x,y) + " for landing at (" + x + "," + y + ") at level " + play.getLevel());
		
		}
		
	
	}
		
	//this method is called at the end of each round from the main and displays the results of the player's updates
	//also checks if theres a winner
	//if theres no, press any key to continue
		
	public static void endOfRound(Player p1, Player p2, Board bgame)
	{
		System.out.println("\nAt the end of this round: ");
		System.out.println("\t" + p1);
		System.out.println("\t" + p2);
		
		if(p1.won(bgame))
			{
			
			System.out.println("\nCongratulations!!! " + p1.getName() + " is the winner of this game!");
			System.exit(0);
			
			}
		else if(p2.won(bgame))
			{
			System.out.println("\nCongratulations!!! " + p2.getName() + " is the winner of this game! ");
			System.exit(0);
			}
		else
			System.out.print("Press any key to continue to next round ...");
		
	}
	
	
	public static void main(String [] args) {
		
		//display message
		System.out.println("\t* * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("\t - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("\t*                                           *");
		System.out.println("\t*    WELCOME to Nancy's 3D Warrior Game!    *");
		System.out.println("\t*                                           *");
		System.out.println("\t* * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("\t- - - - - - - - - - - - - - - - - - - - - - -\n");
		
		System.out.println("The default game board has 3 levels and each level has a 4x4 board.");
		System.out.println("You can use this default board size or change the size");
		System.out.println("\t0 to use the default board size");
		System.out.println("\t-1 to enter your own size");
		System.out.print("==> What do you want to do? ");
		
		Board game;
		Player p0;
		Player p1;
		Dice d = new Dice();
		
		
		
		//what I do below is calculate the dimensions of this array(game)
		//getting l and n through user input and validating
		
		Scanner key = new Scanner(System.in);
		int option = key.nextInt();

		int l = 0; // number of levels selected
		int n = 0; // size selected
	
		
		if(option!=0 && option!=-1)
		{	
			do {
				System.out.println("Sorry but " + option + " is not a legal choice. ");
				option = key.nextInt();
			}
		
			while(option!=0 && option != -1);
		}
		
		
		//option = -1
		if (option == -1)
			
		{
			
			System.out.print("How many levels would you like? (minimum size 3, max 10): ");
			
			l = key.nextInt();
			
			if(l<3||l>10) {
				do {
					System.out.println("Sorry but " + l + " is not a legal choice. ");
					l = key.nextInt();
				}
				while(l<3||l>10);
			}
			
			if(l>=3||l<=10)
			{
				System.out.println("\nWhat size do you want the nxn boards on each level to be?");
				System.out.println("Minimum size is 3x3, max is 10x10");
				System.out.print("==> Enter the value of n: ");
				
				n = key.nextInt();
				
				if(n<3 || n>10) {
					do {
						System.out.println("Sorry but " + n + " is not a legal choice. ");
						n = key.nextInt();
					}
					while(n<3 || n>10);
				}
				
				
				
				
			}
			
			
		}
		
		//once validated, I call the constructor according to what the user inputs
		System.out.println("\nYour 3D board has been set up and looks like this: ");

		if(option==-1)
			game = new Board(l,n);
		else
			game = new Board();
		
		
		System.out.println(game);
		
		//storing user input and placing this as an attribute in an object of type Player, then storing this player in an array
		//doing that twice
		
		System.out.print("What is player 0's name (one word only): ");
		String n0 = key.next();
		System.out.print("\nWhat is player 1's name (one word only): ");
		String n1 = key.next();
		
		p0 = new Player(n0);
		p1 = new Player(n1);
		
		Player [] p = new Player [2];
		p[0] = p0;
		p[1] = p1;
		
		
		
		//i can be either 0 or 1
		//if i=0, then p[i] is the first player, j is 1 (index of the second player)
		//if i=1, then p[i] holds the second player, so j should hold the first player p0.
		
		int i = ranPlayer(); // the index of the player chosen at random to go first
		// j is the other player who will go second
		// if the if case does not apply, that means i is 1. we will leave j to be 0 
		int j = 0; 
		// but if i = 0 then j should be 1
		if(i==0)
		{
		
		j=1;
		
		}
		
		System.out.println("\nThe game has started " + p[i].getName() + " goes first");
		System.out.println("=================================\n");
		
	
		String c;
		
		//while neither have won the game
		while(!p[0].won(game) && !p[1].won(game))
		{

			System.out.println("It is " + p[i].getName() + "'s turn");
			if(startWithZero(p[i],d,game) <= 0) {
				System.out.println("\tSorry, but you still have insufficient energy to move: " + p[i].getEnergy() + " energy units. Your turn is skipped. ");
				
			}
			
			else if(atSecondLastSquare(p[i], game, d)) {
				
				
			}
			else
			{
				calcPos(p[i], d, game, p[j]);
				
			}
			
			
			
			
			//////////
			
			
			System.out.println("It is " + p[j].getName() + "'s turn");
			if(startWithZero(p[j],d,game) <= 0) {
				System.out.println("\tSorry, but you still have insufficient energy to move: " + p[j].getEnergy() + " energy units. Your turn is skipped. ");
			}

			
			else if (atSecondLastSquare(p[j], game, d))
			{
				
			}
				
			else
				calcPos(p[j], d, game, p[i]);
				
			
			endOfRound(p[0],p[1], game);

			c = key.next();
		
			System.out.println("\n");
			
		}
		
		
	}
}
