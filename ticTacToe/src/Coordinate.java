class Coordinate {

	final int NOT_DIRECTION = -1;
	final int VERTICAL = 0;
	final int HORIZONTAL = 1;
	final int MAIN_DIAGONAL = 2;
	final int INVERSE_DIAGONAL = 3;

	private final int DIMENSION;

	private int row;

	private int column;

	Coordinate(int dimension) {
		this.DIMENSION = dimension;
	}

	Coordinate(int dimension, int row, int column) {
		this(dimension);
		this.row = row;
		this.column = column;
	}

	int getDirection(Coordinate coordinate) {
		if (this.inHorizontal(coordinate)) {
			return this.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return this.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return this.MAIN_DIAGONAL;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return this.INVERSE_DIAGONAL;
		}
		return NOT_DIRECTION;
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
			this.row = console.readInt("Row: ") - 1;
			this.column = console.readInt("Column: ") - 1;
		} while (!this.isValid());
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < this.DIMENSION && this.column >= 0 && this.column < this.DIMENSION;
	}

	int getRow() {
		return this.row;
	}

	int getColumn() {
		return this.column;
	}

	boolean inDirection(Coordinate coordinate) {
		return this.getDirection(coordinate) != this.NOT_DIRECTION;
	}

}
