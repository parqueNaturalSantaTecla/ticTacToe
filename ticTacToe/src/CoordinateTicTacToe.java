public class CoordinateTicTacToe extends Coordinate {

	static final int DIMENSION = 3;

	CoordinateTicTacToe() {
		super();
	}

	CoordinateTicTacToe(int row, int column) {
		super(row, column);
	}

	Direction getDirection(CoordinateTicTacToe coordinate) {
		Direction direction = super.getDirection(new Coordinate(coordinate.row, coordinate.column));
		if (direction != null) {
			return direction;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return null;
	}

	private boolean inInverseDiagonal() {
		return this.row + this.column == CoordinateTicTacToe.DIMENSION - 1;
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < CoordinateTicTacToe.DIMENSION && this.column >= 0
				&& this.column < CoordinateTicTacToe.DIMENSION;
	}

	void read(String title) {
		do {
			super.read(title);
		} while (!this.isValid());
	}

}
