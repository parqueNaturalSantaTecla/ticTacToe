class Board {

	static final int EMPTY = 2;

	static final int DIMENSION = 3;
	
	static final char[] SYMBOLS = new char[] {'X', 'O', '-'};

	private Coordinate[][] coordinates;

	Board() {
		this.coordinates = new Coordinate[Turn.PLAYERS][Board.DIMENSION];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				this.coordinates[i][j] = null;
			}
		}
	}

	void write() {
		Console console = new Console();
		console.writeln("-----------------------------------------------------");
		for (int i = 0; i < Board.DIMENSION; i++) {
			console.write("| ");
			for (int j = 0; j < Board.DIMENSION; j++) {
				if (this.getToken(new Coordinate(i, j)) == Board.EMPTY) {
					console.write(Board.SYMBOLS[Board.EMPTY]);
				} else {
					console.write(Board.SYMBOLS[this.getToken(new Coordinate(i, j))]);
				}
				console.write(" | ");
			}
			console.writeln();
		}
		console.writeln("-----------------------------------------------------");
	}

	private int getToken(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return i;
				}
			}
		}
		return Board.EMPTY;
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		int token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(Coordinate coordinate, int token) {
		int i = 0;
		while (this.coordinates[token][i] != null) {
			i++;
		}
		this.coordinates[token][i] = coordinate;
	}

	private void remove(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(int token) {
		Coordinate[] coordinates = this.coordinates[token];
		if (this.numberOfCoordinates(coordinates) < Board.DIMENSION) {
			return false;
		}
		if (!coordinates[0].inDirection(coordinates[1])) {
			return false;
		}
		int direction = coordinates[0].getDirection(coordinates[1]);
		for (int i = 1; i < coordinates.length - 1; i++) {
			if (direction != coordinates[i].getDirection(coordinates[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private int numberOfCoordinates(Coordinate[] coordinates) {
		int count = 0;
		for (int i = 0; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

	boolean isCompleted() {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, Board.EMPTY);
	}

	boolean isOccupied(Coordinate coordinate, int token) {
		return this.getToken(coordinate) == token;
	}

}
