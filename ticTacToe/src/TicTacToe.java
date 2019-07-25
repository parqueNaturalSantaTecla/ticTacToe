class TicTacToe {

	final int players = 2;

	final int dimension = 3;

	final int squares = 9;

	final String[] errors = new String[] { "The square is not empty", "", "" };

	int turn;

	int[] tokens;

	int[][] board;

	public static void main(String[] args) {
		new TicTacToe().exec();
	}

	void exec() {
		this.turn = 0;
		this.tokens = new int[2];
		this.board = new int[2][3];
		this.writeln("----- TIC TAC TOE -----");
		this.drawBoard();
		do {
			if (!this.isCompleted()) {
				this.put();
			} else {
				this.move();
			}
			this.changeTurn();
			this.drawBoard();
		} while (!this.isTicTacToe());
		this.writeWin();
	}

	private boolean isTicTacToe() {
		// TODO Auto-generated method stub
		return false;
	}

	private void changeTurn() {
		if (this.turn == 0) {
			this.turn = 1;
		} else {
			this.turn = 0;
		}
	}

	private void move() {
		// TODO Auto-generated method stub

	}

	private void put() {
		int square = 0;
		int error;
		do {
			error = -1;
			square = this.read("Enter a coordinate to put a token:");
			if (!this.isEmpty(square)) {
				error = 0;
				this.writeln(this.errors[error]);
			}
		} while (error != -1);
		for (int i = 0; i < this.dimension; i++) {
			if (this.board[this.turn][i] == 0) {
				this.board[this.turn][i] = square;
			}
		}
	}

	private boolean isEmpty(int square) {
		for (int i = 0; i < this.players; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (this.board[i][j] == square) {
					return false;
				}
			}
		}
		return true;
	}

	private int read(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isCompleted() {
		for (int i = 0; i < this.players; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (this.board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void drawBoard() {
		this.writeln("-------------");
		for (int i = 0; i < this.dimension; i++) {
			this.writeln("| ");
			for (int j = 0; j < this.dimension; j++) {
				this.writeln(this.board[i][j] + " | ");
			}
			this.writeln("");
		}
		this.writeln("-------------");
	}

	private void writeWin() {
		this.writeln("Player " + this.tokens[this.turn] + " Win!! :-");
	}

	private void writeln(String string) {
		System.out.println(string);
	}
}

// TicTacToe() {
// }
//
// void draw() {
// }
//
// String getToken(Coordinate coordinate) {
// return null;
// }
//
// private int getOrdinal(String token) {
// return 0;
// }
//
// void move(Coordinate originCoordinate, Coordinate coordinate) {
// }
//
// void put(Coordinate coordinate, String token) {
// }
//
// private void remove(Coordinate coordinate) {
// }
//
// boolean isTicTacToe(String token) {
// return false;
// }
//
// private int numberOfCoordinates(Coordinate[] coordinates) {
// return 0;
// }
//
// boolean isCompleted() {
// return false;
// }
//
// boolean isEmpty(Coordinate coordinate) {
// return false;
// }
//
// void isOccupied(Coordinate coordinate, String token) {
// }
