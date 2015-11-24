// Team PJs -- Pardeep Singh, Jessica Yang
// APCS1 pd9
// HW36 -- Some Folks Call It a Memory
// 2015-11-23

import cs1.Keyboard; //if comfortable with Scanner, you may comment this out

public class Concentration {

	//instance variables
	private Tile[][] _board; //storage for 4x4 grid of Tiles.
	private int _numberFaceUp; //count of Tiles with faces visible
	private String[] _words = {
		"loo", "goo", "boo", "moo", "hoo", "yoo", "poo", "foo",
			"loo", "goo", "boo", "moo", "hoo", "yoo", "poo", "foo"
	}; //list of unique Strings used for Tile vals
	private static int _numRows = 4;


	// constructor
	public Concentration() {
		_numberFaceUp = 0;
		_board = new Tile[_numRows][_numRows];
		changePosition();
		int ctr = 0;
		for (int x = 0; x < _board.length; x++) {
			for (int y = 0; y < _board[x].length; y++) {
				_board[x][y] = new Tile(_words[ctr]);
				ctr++;
			}
		}
	}

	// changes position of the strings in _words
	public void changePosition() {
		for (int x = 0; x < 16; x++) {
			int y = (int)(Math.random() * 16);
			swap(x, y);
		}
	}

	// helper fxn for changePosition
	public void swap(int x, int y) {
		String tmp = _words[x];
		_words[x] = _words[y];
		_words[x] = tmp;
	}

	//postcond: prints each row of 2D integer array a on its own line
	//          uses a FOR loop
	public void printWords() {
		for (int x = 0; x < _board.length; x++) { //goes through 1st dimension seperating by next line
			System.out.println("");
			for (int y = 0; y < _board[x].length; y++) { //goes through 2nd dimension seperating by tabs
				System.out.print(_board[x][y] + "\t");
			}
		}
		System.out.println("");
	}

	//swaps the two words given the row and column of each
	public void swap(int row1, int column1, int row2, int column2) {
		Tile old = _board[row1][column1]; //stores one of the words
		_board[row1][column1] = _board[row2][column2]; //sets 1st word to 2nd word
		_board[row2][column2] = old; //sets 2nd word to old 1st word
	}

	public void play() {
		while (_numberFaceUp < 16) {
			printWords(); //prints the words
			System.out.println("Row of first word");
			int row1 = Keyboard.readInt(); //sets row of first word
			System.out.println("Column of first word");
			int column1 = Keyboard.readInt(); //sets column of first word
			_board[row1][column1].flip();
			printWords();
			System.out.println("Row of second word");
			int row2 = Keyboard.readInt(); //sets row of second word
			System.out.println("Column of second word");
			int column2 = Keyboard.readInt(); //sets column of seocnd word
			_board[row2][column2].flip();
			/*try {
  			swap(row1, column1, row2, column2); //checks to make sure there is no index out of bound errors
  		} catch (IndexOutOfBoundsException e) {
  			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
  		} //if there is one it sends a message*/
			printWords(); //then reprints the original words
			_board[row1][column1]._isFaceUp = _board[row1][column1].equals(_board[row2][column2]);
			_board[row2][column2]._isFaceUp = _board[row1][column1].equals(_board[row2][column2]);
		}
	}

	//DO NOT MODIFY main()
	public static void main(String[] args) {
		Concentration game = new Concentration();
		game.play();
	}

} //end class Concentration
