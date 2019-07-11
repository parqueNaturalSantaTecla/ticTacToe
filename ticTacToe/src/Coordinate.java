class Coordinate {

	int row;

	int column;

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

	void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
