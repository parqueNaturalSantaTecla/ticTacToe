class TicTacToe extends Console {

	public static void main(String[] args) {
		new TicTacToe().exec();
	}

	final int PLAYERS = 2;

	int turn = 0;

	final int DIMENSION = 3;
	
	final int COORDINATES = 2;

	int[][][] board = new int[PLAYERS][DIMENSION][];

	final String EMPTY_TOKEN = "-";

	final String[] TOKENS = new String[] { "O", "X" };

	final String[] ERRORS = new String[] { "The coordinates is not empty", "There is not a token of yours",
			"The origin and target coordinatess are the same" };
	
	final int NOT_ERROR = -1;
	
	final int NOT_EMPTY = 0;
	
	final int NOT_OWNER = 1;
	
	final int SAME_SQUARE = 2;
	
	final int HORIZONTAL = 0;

	final int VERTICAL = 1;

	final int MAIN_DIAGONAL = 2;

	final int INVERSE_DIAGONAL = 3;

	final int NOT_DIRECTION = -1;
	
	final int X = 0;
	
	final int Y = 1;

	void exec() {
		writeln("----- TIC TAC TOE -----");
		drawBoard();
		do {
			if (!isCompleted()) {
				put();
			} else {
				move();
			}
			changeTurn();
			drawBoard();
		} while (!isTicTacToe(otherTurn()));
		writeWin();
	}

	private int otherTurn() {
		if (turn == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	private void changeTurn() {
		turn = otherTurn();
	}

	private void put() {
		int[] coordinates = new int[COORDINATES];
		int error;
		do {
			error = NOT_ERROR;
			coordinates[X] = readInt("Enter a row to put a token:");
			coordinates[Y] = readInt("Enter a column to put a token:");
			if (!isEmpty(coordinates)) {
				error = NOT_EMPTY;
				write(ERRORS[error]);
			}
		} while (error != NOT_ERROR);
		putOnBoard(coordinates);
	}

	private void putOnBoard(int[] coordinates) {
		int i = 0;
		while (board[turn][i] != null) {
			i++;
		}
		board[turn][i] = coordinates;
	}

	private void move() {
		int[] originCoordinates = new int[COORDINATES];
		int error;
		do {
			error = NOT_ERROR;
			originCoordinates[X] = readInt("Enter a row to remove a token:");
			originCoordinates[Y] = readInt("Enter a column to remove a token:");
			if (!isOccupied(originCoordinates)) {
				error = NOT_OWNER;
				write(ERRORS[error]);
			}
		} while (error != NOT_ERROR);
		int[] targetCoordinates = new int[COORDINATES];
		do {
			error = NOT_ERROR;
			targetCoordinates[X] = readInt("Enter a row to put a token:");
			targetCoordinates[Y] = readInt("Enter a column to put a token:");
			if (originCoordinates[0] == targetCoordinates[0] && originCoordinates[1] == targetCoordinates[1]) {
				error = SAME_SQUARE;
				write(ERRORS[error]);
			} else if (!isEmpty(targetCoordinates)) {
				error = NOT_EMPTY;
				write(ERRORS[error]);
			}
		} while (error != NOT_ERROR);
		remove(originCoordinates);
		putOnBoard(targetCoordinates);
	}

	private boolean isOccupied(int[] originCoordinates) {
		return getToken(originCoordinates) == TOKENS[turn];
	}

	private void remove(int[] coordinates) {
		for (int i = 0; i < PLAYERS; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (board[i][j] != null && board[i][j][X] == coordinates[X] && board[i][j][Y] == coordinates[Y]) {
					board[i][j] = null;
				}
			}
		}
	}

	private boolean isCompleted() {
		for (int i = 0; i < PLAYERS; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (board[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	private void drawBoard() {
		writeln("-------------");
		for (int i = 1; i <= DIMENSION; i++) {
			write("| ");
			for (int j = 1; j <= DIMENSION; j++) {
				if (getToken(new int[] { i, j }) == null) {
					write(EMPTY_TOKEN);
				} else {
					write(getToken(new int[] { i, j }));
				}
				write(" | ");
			}
			writeln();
		}
		writeln("-------------");
	}

	String getToken(int[] coordinates) {
		if (coordinates == null) {
			return null;
		}
		for (int i = 0; i < PLAYERS; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (board[i][j] != null && board[i][j][X] == coordinates[X] && board[i][j][Y] == coordinates[Y]) {
					return TOKENS[i];
				}
			}
		}
		return null;
	}

	private boolean isEmpty(int[] coordinates) {
		for (int i = 0; i < PLAYERS; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (board[i][j] != null && board[i][j][X] == coordinates[X] && board[i][j][Y] == coordinates[Y]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isTicTacToe(int turn) {
		int[][] playerCoordinates = board[turn];
		if (numberOfCoordinates(playerCoordinates) < DIMENSION) {
			return false;
		}

		int direction = getDirection(playerCoordinates[0], playerCoordinates[1]);
		if (direction == NOT_DIRECTION) {
			return false;
		}
		return direction == getDirection(playerCoordinates[1], playerCoordinates[2] );
	}

	private int getDirection(int[] leftCoordinates, int[] rightCoordinates) {
		if (inHorizontal(leftCoordinates, rightCoordinates)) {
			return HORIZONTAL;
		}
		if (inVertical(leftCoordinates, rightCoordinates)) {
			return VERTICAL;
		}
		if (inMainDiagonal(leftCoordinates) && inMainDiagonal(rightCoordinates)) {
			return MAIN_DIAGONAL;
		}
		if (inInverseDiagonal(leftCoordinates) && inInverseDiagonal(rightCoordinates)) {
			return INVERSE_DIAGONAL;
		}
		return NOT_DIRECTION;
	}

	private boolean inInverseDiagonal(int[] coordinates) {
		return coordinates[X] + coordinates[Y] == DIMENSION - 1;
	}

	private boolean inMainDiagonal(int[] coordinates) {
		return coordinates[X] - coordinates[Y] == 0;
	}

	private boolean inVertical(int[] leftCoordinates, int[] rightCoordinates) {
		return leftCoordinates[Y] == rightCoordinates[Y];
	}

	private boolean inHorizontal(int[] leftCoordinates, int[] rightCoordinates) {
		return leftCoordinates[X] == rightCoordinates[X];
	}

	private int numberOfCoordinates(int[][] playerCoordinates) {
		int count = 0;
		for (int i = 0; i < playerCoordinates.length; i++) {
			if (playerCoordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

	private void writeWin() {
		writeln("Player " + TOKENS[otherTurn()] + " Win!! :-)");
	}
}