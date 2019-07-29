class Coordinate {

	static final int NOT_DIRECTION = -1;
	static final int VERTICAL = 0;
	static final int HORIZONTAL = 1;
	static final int MAIN_DIAGONAL = 2;
	static final int INVERSE_DIAGONAL = 3;

	private int row;

	private int column;

	Coordinate() {
	}

	Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	int getDirection(Coordinate coordinate) {
		if (this.inHorizontal(coordinate)) {
			return Coordinate.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return Coordinate.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return Coordinate.MAIN_DIAGONAL;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Coordinate.INVERSE_DIAGONAL;
		}
		return Coordinate.NOT_DIRECTION;
	}

	private boolean inInverseDiagonal() {
		return this.row + this.column == Board.DIMENSION - 1;
	}

	private boolean inMainDiagonal() {
		return this.row - this.column == 0;
	}

	private boolean inVertical(Coordinate coordinate) {
		return this.column == coordinate.column;
	}

	private boolean inHorizontal(Coordinate coordinate) {
		return this.row == coordinate.row;
	}

	void read(String title) {
		do {
			Console console = new Console();
			console.writeln(title);
			this.row = console.readInt("Row: ") - 1;
			this.column = console.readInt("Column: ") - 1;
		} while (!this.isValid());
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < Board.DIMENSION && this.column >= 0 && this.column < Board.DIMENSION;
	}

	int getRow() {
		return this.row;
	}

	int getColumn() {
		return this.column;
	}

	boolean inDirection(Coordinate coordinate) {
		return this.getDirection(coordinate) != Coordinate.NOT_DIRECTION;
	}

	public boolean equals(Coordinate coordinate) {
		return this.column == coordinate.column && this.row == coordinate.row;
	}

}
