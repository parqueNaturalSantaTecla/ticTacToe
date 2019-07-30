class Coordinate extends WithConsoleModel{

	private int row;

	private int column;

	Coordinate() {
	}

	Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	Direction getDirection(Coordinate coordinate) {
		if (this.inHorizontal(coordinate)) {
			return Direction.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return Direction.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return Direction.MAIN_DIAGONAL;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return null;
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
			WithConsoleModel.console.writeln(title);
			this.row = WithConsoleModel.console.readInt("Row: ") - 1;
			this.column = WithConsoleModel.console.readInt("Column: ") - 1;
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
		return this.getDirection(coordinate) != null;
	}

	boolean equals(Coordinate coordinate) {
		return this.column == coordinate.column && this.row == coordinate.row;
	}

}
