class Coordinate {

	static final int DIMENSION = 3;

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

	boolean isValid() {
		return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
				&& this.column < Coordinate.DIMENSION;
	}

	void read(String title) {
		do {
			Console console = new Console();
			console.writeln(title);
			this.row = console.readInt("Row: ");
			this.column = console.readInt("Column: ");
		} while (!this.isValid());
	}

}
