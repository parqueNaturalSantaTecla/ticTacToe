

import santaTecla.utils.WithConsoleModel;

public class TicTacToe extends WithConsoleModel{

	static final int PLAYERS = 2;

	private Board board;

	private char player;
	
	private int[] coordinates;

	TicTacToe() {
		this.board = new Board();
		this.coordinates = new int[2];
		this.player = 'X';
	}

	void play() {
		this.console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		for (int i = 0; i < TicTacToe.PLAYERS * Board.DIMENSION - 1; i++) {
			do {
				this.readCoordinates();
			} while (!this.board.put(this.coordinates[0], this.coordinates[1], this.player));
			this.changePlayer();
			this.board.draw();
		}
		if (!this.isWinner()) {
			do {
				this.readCoordinates();
			} while (!this.board.put(this.coordinates[0], this.coordinates[1], this.player));
			this.changePlayer();
			this.board.draw();
		}
		while (!this.isWinner()) {
			this.move();
			do {
				this.readCoordinates();
			} while (!this.board.put(this.coordinates[0], this.coordinates[1], this.player));
			this.changePlayer();
			this.board.draw();
		}
		if (this.isWinner()) {
			this.console.writeln("You win!! :-)");
		}
	}
	
	private void readCoordinates() {
		this.console.writeln("Enter a row and a column:");
		this.coordinates[0] = this.console.readInt("Row: ");
		this.coordinates[1] = this.console.readInt("Column: ");
	}

	private boolean isWinner() {
		boolean winner = this.checkRows() || this.checkColumns() || this.checkDiagonals();
		return winner;
	}

	private boolean checkRows() {
		for (int i = 0; i < Board.DIMENSION; i++) {
			if (this.checkRowCol(this.board.getChar(i, 0), this.board.getChar(i, 1), this.board.getChar(i, 2))) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumns() {
		for (int i = 0; i < Board.DIMENSION; i++) {
			if (this.checkRowCol(this.board.getChar(0, i), this.board.getChar(1, i), this.board.getChar(2, i))) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals() {
		if (this.checkRowCol(this.board.getChar(0, 0), this.board.getChar(1, 1), this.board.getChar(2, 2))) {
			return true;
		} else if (this.checkRowCol(this.board.getChar(0, 2), this.board.getChar(1, 1), this.board.getChar(2, 0))) {
			return true;
		}
		return false;
	}

	private boolean checkRowCol(char char1, char char2, char char3) {
		if (char1 != '-') {
			return (char1 == char2) && (char2 == char3);
		}
		return false;
	}

	private void changePlayer() {
		if (this.player == 'X') {
			this.player = 'O';
		} else {
			this.player = 'X';
		}
	}

	private void move() {
		do {
			this.console.writeln("Token to remove:");
			this.readCoordinates();			
		} while (!this.board.remove(this.coordinates[0], this.coordinates[1], this.player));
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}
}