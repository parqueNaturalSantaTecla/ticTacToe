class Board {
	
	final char EMPTY = '-';

	private Token[][] squares;

	Board() {
		this.squares = new Token[3][3];
		for (int i = 0; i < CoordinateTicTacToe.DIMENSION; i++) {
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				this.squares[i][j] = null;
			}
		}
	}

	void draw() {
		Console console = new Console();
		console.writeln("-------------");
		for (int i = 0; i < CoordinateTicTacToe.DIMENSION; i++) {
			console.write("| ");
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				if (this.squares[i][j] == null) {
					console.write(this.EMPTY);
				} else {
					this.squares[i][j].write();					
				}
				console.write(" | ");
			}
			console.writeln();
		}
		console.writeln("-------------");
	}

	Token getToken(CoordinateTicTacToe coordinate) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()];
	}

	void put(CoordinateTicTacToe coordinate, Token token) {
		this.squares[coordinate.getRow()][coordinate.getColumn()] = token;
	}

	void move(CoordinateTicTacToe originCoordinate, CoordinateTicTacToe coordinate) {
		this.put(coordinate, this.getToken(originCoordinate));
		this.remove(originCoordinate);
	}

	void remove(CoordinateTicTacToe coordinate) {
		this.squares[coordinate.getRow()][coordinate.getColumn()] = null;
	}

	boolean isEmpty(CoordinateTicTacToe coordinate) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()] == null;
	}

	boolean isOccupied(CoordinateTicTacToe coordinate, Token token) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()] == token;
	}

}
