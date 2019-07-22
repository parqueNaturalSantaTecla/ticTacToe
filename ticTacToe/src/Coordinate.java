class Coordinate {
	
	final String[] DIRECTION = {"VERTICAL", "HORIZONTAL", "MAIN_DIAGONAL", "INVERSE_DIAGONAL"};

	final int DIMENSION = 3;

	private int row;

	private int column;

	Coordinate() {
	}

	Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	String getDirection(Coordinate coordinate) {
		if (this.inHorizontal(coordinate)) {
			return this.DIRECTION[0];
		}
		if (this.inVertical(coordinate)) {
			return this.DIRECTION[1];
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return this.DIRECTION[2];
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return this.DIRECTION[3];
		}
		return null;
	}

	private boolean inInverseDiagonal() {
		return this.row + this.column == this.DIMENSION - 1;
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
			this.row = console.readInt("Row: ");
			this.column = console.readInt("Column: ");
		} while (!this.isValid());
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < this.DIMENSION && this.column >= 0
				&& this.column < this.DIMENSION;
	}

	int getRow() {
		return this.row;
	}

	int getColumn() {
		return this.column;
	}

}
