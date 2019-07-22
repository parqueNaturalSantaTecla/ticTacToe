class Board {
	
	static final String[] TOKENS = {"O", "X"};

	static final char EMPTY = '-';

	private Coordinate[][] coordinates;

	Board() {
		this.coordinates = new Coordinate[2][3];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.coordinates[i][j] = null;
			}
		}
	}

	void draw() {
		Console console = new Console();
		console.writeln("-------------");
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			console.write("| ");
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.getToken(new Coordinate(i, j)) == null) {
					console.write(Board.EMPTY);
				} else {
					console.write(this.getToken(new Coordinate(i, j)));
				}
				console.write(" | ");
			}
			console.writeln();
		}
		console.writeln("-------------");
	}

	String getToken(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Board.TOKENS[i];
				}
			}
		}
		return null;
	}

	private int getOrdinal(String token) {
		for (int i = 0; i < Board.TOKENS.length; i++) {
			if (token == Board.TOKENS[i]) {
				return i;
			}			
		}
		return -1;
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		String token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(Coordinate coordinate, String token) {
		int i = 0;
		while (this.coordinates[this.getOrdinal(token)][i] != null) {
			i++;
		}
		this.coordinates[this.getOrdinal(token)][i] = coordinate;
	}

	private void remove(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(String token) {
		Coordinate[] coordinates = this.coordinates[this.getOrdinal(token)];
		if (this.numberOfCoordinates(coordinates) < Coordinate.DIMENSION) {
			return false;
		}
		String direction = coordinates[0].getDirection(coordinates[1]);
		if (direction == null) {
			return false;
		}
		return direction == coordinates[1].getDirection(coordinates[2]);
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
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, null);
	}

	boolean isOccupied(Coordinate coordinate, String token) {
		return this.getToken(coordinate) == token;
	}

}
