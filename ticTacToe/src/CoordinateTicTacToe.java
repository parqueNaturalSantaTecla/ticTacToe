class CoordinateTicTacToe extends Coordinate {

	static final int DIMENSION = 3;

	CoordinateTicTacToe() {
		super();
	}

	CoordinateTicTacToe(int row, int column) {
		super(row, column);
	}

	boolean isValid() {
		return this.row >= 0 && this.row < CoordinateTicTacToe.DIMENSION && this.column >= 0
				&& this.column < CoordinateTicTacToe.DIMENSION;
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
