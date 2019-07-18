package ticTacToe;
import santaTecla.utils.Coordinate;

class CoordinateTicTacToe extends Coordinate {

	static final int DIMENSION = 3;

	CoordinateTicTacToe() {
		super();
	}

	CoordinateTicTacToe(int row, int column) {
		super(row, column);
	}

	Direction getDirection(CoordinateTicTacToe coordinate) {
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
		return this.row + this.column == CoordinateTicTacToe.DIMENSION - 1;
	}

	private boolean inMainDiagonal() {
		return this.row - this.column == 0;
	}

	private boolean inVertical(CoordinateTicTacToe coordinate) {
		return this.column == coordinate.column;
	}

	private boolean inHorizontal(CoordinateTicTacToe coordinate) {
		return this.row == coordinate.row;
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < CoordinateTicTacToe.DIMENSION && this.column >= 0
				&& this.column < CoordinateTicTacToe.DIMENSION;
	}

	void read(String title) {
		do {
			this.console.writeln(title);
			this.row = this.console.readInt("Row: ");
			this.column = this.console.readInt("Column: ");
		} while (!this.isValid());
	}

}
