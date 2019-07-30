class TicTacToeCoordinate extends Coordinate {

	TicTacToeCoordinate() {
		super();
	}

	TicTacToeCoordinate(int row, int column) {
		super(row, column);
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
		return this.row + this.column == Board.DIMENSION - 1;
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < Board.DIMENSION && this.column >= 0 && this.column < Board.DIMENSION;
	}

	void read(String title) {
		do {
			super.read(title);
		} while (!this.isValid());
	}

}
