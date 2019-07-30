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

	boolean inDirection(Coordinate coordinate) {
		return this.getDirection(coordinate) != null;
	}

	Direction getDirection(Coordinate coordinate) {
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
		return this.row + this.column == Coordinate.DIMENSION - 1;
	}

	private boolean isValid() {
		return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
				&& this.column < Coordinate.DIMENSION;
	}

	 protected void read(String title) {
		do {
			super.read(title);
		} while (!this.isValid());
	}

	void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(Coordinate.DIMENSION);
		this.column = random.nextInt(Coordinate.DIMENSION);
	}

}
