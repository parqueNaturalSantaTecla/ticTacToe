class Board {

	static final int PLAYERS = 2;

	static final char EMPTY = '-';

	private Coordinate[][] coordinates;

	Board() {
		this.coordinates = new Coordinate[2][3];
		for (int i = 0; i < Board.PLAYERS; i++) {
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
					this.getToken(new Coordinate(i, j)).write();
				}
				console.write(" | ");
			}
			console.writeln();
		}
		console.writeln("-------------");
	}

	Token getToken(Coordinate coordinate) {
		for (int i = 0; i < Board.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Token.values()[i];
				}
			}
		}
		return null;
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		Token token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(Coordinate coordinate, Token token) {
		int i = 0;
		while (this.coordinates[token.ordinal()][i] != null) {
			i++;
		}
		this.coordinates[token.ordinal()][i] = coordinate;
	}

	private void remove(Coordinate coordinate) {
		for (int i = 0; i < Board.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(Token token) {
		Coordinate[] coordinates = this.coordinates[token.ordinal()];
		if (this.numberOfCoordinates(coordinates) < Coordinate.DIMENSION) {
			return false;
		}
		Direction direction = coordinates[0].getDirection(coordinates[1]);
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
		for (int i = 0; i < Board.PLAYERS; i++) {
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

	boolean isOccupied(Coordinate coordinate, Token token) {
		return this.getToken(coordinate) == token;
	}

}
