package ticTacToe;

import santaTecla.utils.Console;

class Coordinate extends santaTecla.utils.Coordinate {

	static final int DIMENSION = 3;

	Coordinate() {
		super();
	}

	Coordinate(int row, int column) {
		super(row, column);
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
