class Coordinate extends WithConsoleModel {

	protected int row;

	protected int column;

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
		return null;
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
		WithConsoleModel.console.writeln(title);
		this.row = WithConsoleModel.console.readInt("Row: ") - 1;
		this.column = WithConsoleModel.console.readInt("Column: ") - 1;
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
