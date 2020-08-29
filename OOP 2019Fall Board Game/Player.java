// -------------------------------------------------------
// Assignment 4
// Written by: Shahd Yousef, 40114313
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

public class Player {
 
	//the 5 attributes of the Player class
	private String name;
	private int level;
	private int x;
	private int y;
	private int energy;
	
	//in all constructors, energy is set to 10 
	
	//default constructor
	public Player()
	{
		name = "";
		energy = 10;
		
	}
	
	// one parameter (String)-constructor. Sets passed String to name, energy to 10, and other 3 to 0
	public Player(String pname) {
		name = pname;
		energy = 10;
	}
	 // sets passed int values to level, x, and y respectively. 
	public Player (int level, int x, int y) {
		
		this.level = level;
		this.x = x;
		this.y = y;
		energy = 10;
		name = "";
		
	}
	
	//copy constructor. Copies attributes of the passed Player object to the attributes of the calling object
	public Player (Player human) {
		name = human.name;
		level = human.level;
		x = human.x;
		y = human.y;
		energy = human.energy;
		
	}
	
	//mutators for all 5 attributes
	public void setName(String newname) {
		name = newname;
	}
	
	public void setLevel(int newlev) {
		level = newlev;
	}
	
	public void setX(int newx) {
		x = newx;
	}
	
	public void setY(int newy) {
		y = newy;
	}
	
	public void setEnergy (int e) {
		energy = e;
	}
	
	
	//accessors for all 5 attributes
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	
	//passes a Player object and assigns level, x, and y of the passed object to the calling object
	public void moveTo(Player p) {
		
		level = p.level;
		x = p.x;
		y = p.y;
		
	
	}
	
	//returns true whether the calling object's location is the maximum value on the board
	//it gets the levels and size stored in the board b and compares it to the attributes of the calling object
	public boolean won(Board b) {
		if (b.getLevel()-1 == level && b.getSize()-1==(y) && b.getSize()-1==(x))
			return true;
		return false;
		
		}

	// checks if calling object is at the same position as the passed object. 
	// checks if the two players are in the same spot
	public boolean equals(Player p) {
		return (x==p.x && y==p.y && level==p.level);
	}
	
	
	// What will be printed when you print the name of the object
	public String toString() {
		return name + " is on level " + level + " at location (" + x + "," + y + ") and has " + energy + " units of energy. " ;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Test
	 * public static void main(String[] args) {
		
		Player adil = new Player();
		Player shahd = new Player("Shahd");
		Player jas = new Player(1,3,5);
		Player farah = new Player(shahd);
		
		Board game2 = new Board(3,4);
		
		System.out.println(adil);
		System.out.println(shahd);
		System.out.println(jas);
		System.out.println(farah);
		
		farah.setName("Farah");
		System.out.println(farah);
		System.out.println("New name is " + farah.getName());
		
		adil.moveTo(jas);
		System.out.println(adil);
		
		if(jas.equals(adil))
			System.out.println("Same spot!");
		else
			System.out.println("Not yet..");
		if(shahd.equals(adil))
			System.out.println("Same spot!");
		else
			System.out.println("Not yet..");
		
		adil.setX(4);
		adil.setY(4);
		adil.setLevel(3);
		if(adil.won(game2))
			System.out.println("Winner!");
		else
			System.out.println("not yet :(");
			
		
	}*/
	
}

