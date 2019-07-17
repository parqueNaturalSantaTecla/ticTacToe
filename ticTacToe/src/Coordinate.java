class Coordinate extends WithConsoleModel{

	static final int DIMENSION = 3;

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
		return this.row + this.column == Coordinate.DIMENSION - 1;
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

	private boolean isValid() {
		return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
				&& this.column < Coordinate.DIMENSION;
	}

	void read(String title) {
		do {
			this.console.writeln(title);
			this.row = this.console.readInt("Row: ");
			this.column = this.console.readInt("Column: ");
		} while (!this.isValid());
	}

	int getRow() {
		return this.row;
	}

	int getColumn() {
		return this.column;
	}

}
