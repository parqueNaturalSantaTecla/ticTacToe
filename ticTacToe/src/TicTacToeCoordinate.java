import java.util.Random;

class TicTacToeCoordinate extends Coordinate {

	static final int DIMENSION = 3;

	TicTacToeCoordinate() {
		super();
	}

	TicTacToeCoordinate(int row, int column) {
		super(row, column);
	}

	Direction getDirection(TicTacToeCoordinate coordinate) {
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
		return this.row + this.column == TicTacToeCoordinate.DIMENSION - 1;
	}

	void read(String title) {
		do {
			super.read(title);
		} while (!this.isValid());
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < TicTacToeCoordinate.DIMENSION && this.column >= 0
				&& this.column < TicTacToeCoordinate.DIMENSION;
	}

	void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(TicTacToeCoordinate.DIMENSION);
		this.column = random.nextInt(TicTacToeCoordinate.DIMENSION);
	}

}
