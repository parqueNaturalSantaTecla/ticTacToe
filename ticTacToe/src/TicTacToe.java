class TicTacToe extends Console {

	final String empty = "-";

	final int players = 2;

	final int dimension = 3;

	final String[] tokens = new String[] { "O", "X" };

	final String[] errors = new String[] { "The square is not empty", "There is not a token of yours",
			"The origin and target squares are the same" };

	int turn;

	int[][][] board;

	public static void main(String[] args) {
		new TicTacToe().exec();
	}

	void exec() {
		this.turn = 0;
		this.board = new int[this.players][this.dimension][2];
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
		} while (!this.isTicTacToe(this.otherTurn()));
		this.writeWin();
	}

	private int otherTurn() {
		if (turn == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	private void changeTurn() {
		if (this.turn == 0) {
			this.turn = 1;
		} else {
			this.turn = 0;
		}
	}

	private void move() {
		int[] originSquare = new int[2];
		int error;
		do {
			error = -1;
			originSquare[0] = readInt("Enter a row to remove a token:");
			originSquare[1] = readInt("Enter a column to remove a token:");
			if (!this.isOccupied(originSquare)) {
				error = 1;
				this.write(this.errors[error]);
			}
		} while (error != -1);
		int[] targetSquare = new int[2];
		do {
			error = -1;
			targetSquare[0] = readInt("Enter a row to put a token:");
			targetSquare[1] = readInt("Enter a column to put a token:");
			if (originSquare[0] == targetSquare[0] && originSquare[1] == targetSquare[1]) {
				error = 2;
				this.write(this.errors[error]);
			} else if (!this.isEmpty(targetSquare)) {
				error = 0;
				this.write(this.errors[error]);
			}
		} while (error != -1);
		this.remove(originSquare);
		this.putOnBoard(targetSquare);
	}

	private boolean isOccupied(int[] originSquare) {
		return this.getToken(originSquare) == this.tokens[this.turn];
	}

	private void remove(int[] square) {
		for (int i = 0; i < this.players; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (this.board[i][j][0] != 0 && this.board[i][j][0] == square[0] && this.board[i][j][1] == square[1]) {
					this.board[i][j][0] = 0;
					this.board[i][j][1] = 0;
				}
			}
		}
	}

	private void put() {
		int[] square = new int[2];
		int error;
		do {
			error = -1;
			square[0] = this.readInt("Enter a row to put a token:");
			square[1] = this.readInt("Enter a column to put a token:");
			if (!this.isEmpty(square)) {
				error = 0;
				this.write(this.errors[error]);
			}
		} while (error != -1);
		this.putOnBoard(square);
	}

	private void putOnBoard(int[] square) {
		int i = 0;
		while (this.board[this.turn][i][0] != 0) {
			i++;
		}
		this.board[this.turn][i][0] = square[0];
		this.board[this.turn][i][1] = square[1];
	}

	private boolean isCompleted() {
		for (int i = 0; i < this.players; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (this.board[i][j][0] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void drawBoard() {
		this.writeln("-------------");
		for (int i = 1; i <= this.dimension; i++) {
			this.write("| ");
			for (int j = 1; j <= this.dimension; j++) {
				if (this.getToken(new int[] { i, j }) == null) {
					this.write(this.empty);
				} else {
					this.write(this.getToken(new int[] { i, j }));
				}
				this.write(" | ");
			}
			this.writeln();
		}
		this.writeln("-------------");
	}

	String getToken(int[] square) {
		if (square[0] == 0 || square[1] == 0) {
			return null;
		}
		for (int i = 0; i < this.players; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (this.board[i][j][0] != 0 && this.board[i][j][0] == square[0] && this.board[i][j][1] == square[1]) {
					return this.tokens[i];
				}
			}
		}
		return null;
	}

	private boolean isEmpty(int[] square) {
		for (int i = 0; i < this.players; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (this.board[i][j][0] == square[0] && this.board[i][j][1] == square[1]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isTicTacToe(int turn) {
		int[][] allSquares = this.board[turn];
		if (this.numberOfCoordinates(allSquares) < this.dimension) {
			return false;
		}

		int direction = this.getDirection(new int[][] { allSquares[0], allSquares[1] });
		if (direction == -1) {
			return false;
		}
		return direction == this.getDirection(new int[][] { allSquares[1], allSquares[2] });
	}

	private int getDirection(int[][] squares) {
		if (this.inHorizontal(squares)) {
			return 1;
		}
		if (this.inVertical(squares)) {
			return 2;
		}
		if (this.inMainDiagonal(squares[0]) && this.inMainDiagonal(squares[1])) {
			return 3;
		}
		if (this.inInverseDiagonal(squares[0]) && this.inInverseDiagonal(squares[0])) {
			return 4;
		}
		return 0;
	}

	private boolean inInverseDiagonal(int[] square) {
		return square[0] + square[1] == this.dimension - 1;
	}

	private boolean inMainDiagonal(int[] square) {
		return square[0] - square[1] == 0;
	}

	private boolean inVertical(int[][] squares) {
		return squares[0][1] == squares[1][1];
	}

	private boolean inHorizontal(int[][] squares) {
		return squares[0][0] == squares[1][0];
	}

	private int numberOfCoordinates(int[][] squares) {
		int count = 0;
		for (int i = 0; i < squares.length; i++) {
			if (squares[i][0] != 0) {
				count++;
			}
		}
		return count;
	}

	private void writeWin() {
		this.writeln("Player " + this.tokens[this.otherTurn()] + " Win!! :-)");
	}
}