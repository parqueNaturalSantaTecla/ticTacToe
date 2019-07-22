package ticTacToe;

import java.util.Random;

import santaTecla.utils.Direction;

class Coordinate extends santaTecla.utils.Coordinate {

	static final int DIMENSION = 3;

	Coordinate() {
		super();
	}

	Coordinate(int row, int column) {
		super(row, column);
	}

	Direction getDirection(Coordinate coordinate) {
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
		return this.row + this.column == Coordinate.DIMENSION - 1;
	}

	protected void read(String title) {
		do {
			super.read(title);
		} while (!this.isValid());
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
				&& this.column < Coordinate.DIMENSION;
	}

	void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(Coordinate.DIMENSION);
		this.column = random.nextInt(Coordinate.DIMENSION);
	}

}
