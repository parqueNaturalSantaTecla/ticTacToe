class TicTacToeCoordinate extends Coordinate {

	static final int DIMENSION = 3;

	TicTacToeCoordinate() {
		super();
	}

	TicTacToeCoordinate(int row, int column) {
		super(row, column);
	}

	boolean inDirection(TicTacToeCoordinate coordinate) {
		return this.getDirection(coordinate) != null;
	}

	Direction getDirection(TicTacToeCoordinate coordinate) {
		Direction direction = super.getDirection(coordinate);
		if (direction != null) {
			return direction;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return null;
	}

	private boolean inInverseDiagonal() {
		return this.row + this.column == TicTacToeCoordinate.DIMENSION - 1;
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < TicTacToeCoordinate.DIMENSION && this.column >= 0
				&& this.column < TicTacToeCoordinate.DIMENSION;
	}

	void read(String title) {
		do {
			super.read(title);
		} while (!this.isValid());
	}

}
