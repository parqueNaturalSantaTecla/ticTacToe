class Coordinate extends WithConsoleModel{

	protected int row;

	protected int column;

	Coordinate() {
	}

	Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	int getRow() {
		return this.row;
	}

	int getColumn() {
		return this.column;
	}

}
