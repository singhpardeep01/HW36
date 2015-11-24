import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out


public class Concentration {
    
    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"loo", "goo", "boo", "moo", "hoo", "yoo", "poo", "foo"};     //list of unique Strings used for Tile vals
    private static int _numRows = 4;
    
    
    //insert constructor and methods here
    public Concentration() {
	//_words = {"loo", "goo", "boo", "moo", "hoo", "yoo", "poo", "foo"};
	_numberFaceUp = 0;
	changePositon();
	int counter = 0;
	for (Tile[] x : _board) {
	    for (Tile y : x) {
		_board[x][y] = _words[counter];
		if ( (y % 0) == 1) {
		    counter++;
		}
	    }
	}
    }
    
    public void changePosition() {
	for (Tile[] x : _board) {
	    for (Tile y : x) {
		swap(x,y,(int) (Math.random() * 4), (int) (Math.random() * 4) );
	    }
	}
    }    
    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public void printWords() {
	for (int x = 0; x < _board.length; x++) {//goes through 1st dimension seperating by next line
	    System.out.println("");
	    for (int y = 0; y < _board[x].length; y++) {//goes through 2nd dimension seperating by tabs
		System.out.print(_board[x][y] + "\t");
	    }
	}
	System.out.println("");
	// *** YOUR IMPLEMENTATION HERE ***
    }
    //swaps the two words given the row and column of each
    public void swap(int row1, int column1, int row2, int column2) {
	Title old = _board[row1][column1];//stores one of the words
	_board[row1][column1] = _board[row2][column2];//sets 1st word to 2nd word
	_board[row2][column2] = old;//sets 2nd word to old 1st word
    }
    
    public void play() {
	printWords();//prints the words
	System.out.println("Row of first word");
	int row1 = Integer.parseInt( Keyboard.readString() );//sets row of first word
	System.out.println("Column of first word");
	int column1 = Integer.parseInt( Keyboard.readString() );//sets column of first word
	System.out.println("Row of second word");
	int row2 = Integer.parseInt( Keyboard.readString() );//sets row of second word
	System.out.println("Column of second word");
	int column2 = Integer.parseInt( Keyboard.readString() );//sets column of seocnd word
	try {
	    swap(row1,column1,row2,column2);//checks to make sure there is no index out of bound errors
	}
	catch (IndexOutOfBoundsException e) {
	    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
	}//if there is one it sends a message 
	printWords();//then reprints the original words
    }
    
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	game.play();
    }
    
}//end class Concentration
	
	
	
