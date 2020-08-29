// -------------------------------------------------------
// Assignment 4
// Written by: Shahd Yousef, 40114313
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------


public class Dice {
// 2 attributes (instance variables) called die1 and die2
	private int die1;
	private int die2;
	
	
	//default constructor. initializes both to dices to 0
	public Dice() {
		
	}
	
	
	// accessor method that returns die1
	public int getDie1() {
		return die1;
	}
	
	
	//accessor method that returns die2
	public int getDie2() {
		return die2;
	}
	
	// rolling the dice stimulates die1 and die2 to get a new face, so we use the Math.random method
	// then, after we get 2 new values for die1 and die2 we return the sum
	public int rollDice() {
		die1 = (int) ((Math.random()*6)+1);
		die2 = (int) ((Math.random()*6)+1);
		
		return die1+die2;
	}
	
	//method checks if die1 and die2 are equal. returns true if they are, false if they are not
	public boolean isDouble() {
		return(die1==die2);
	}
	
	// everytime System.out.println(whatever object of the class created in the driver), it will be printed in this format
	public String toString() {
		return "Die1: " + die1 + " Die2: " + die2;
		
	}
	
	
	
	
	
	
	
	
	/*
	 Test
	  public static void main(String[] args) {
		
		Dice da = new Dice();
		Dice db = new Dice();
		da.rollDice();
		System.out.println(da.getDie1() + da.getDie2());
		System.out.println(da);
	}
		
		*/
		
	
	
	
	

}
