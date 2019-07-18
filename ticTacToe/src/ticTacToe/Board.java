package ticTacToe;

import santaTecla.utils.WithConsoleModel;

class Board extends WithConsoleModel{

	static final int PLAYERS = 2;

	static final char EMPTY = '-';

	private CoordinateTicTacToe[][] coordinates;

	Board() {
		this.coordinates = new CoordinateTicTacToe[2][3];
		for (int i = 0; i < Board.PLAYERS; i++) {
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				this.coordinates[i][j] = null;
			}
		}
	}

	void draw() {
		this.console.writeln("-------------");
		for (int i = 0; i < CoordinateTicTacToe.DIMENSION; i++) {
			this.console.write("| ");
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				if (this.getToken(new CoordinateTicTacToe(i, j)) == null) {
					this.console.write(Board.EMPTY);
				} else {
					this.getToken(new CoordinateTicTacToe(i, j)).write();
				}
				this.console.write(" | ");
			}
			this.console.writeln();
		}
		this.console.writeln("-------------");
	}

	Token getToken(CoordinateTicTacToe coordinate) {
		for (int i = 0; i < Board.PLAYERS; i++) {
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Token.values()[i];
				}
			}
		}
		return null;
	}

	void move(CoordinateTicTacToe originCoordinate, CoordinateTicTacToe coordinate) {
		Token token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(CoordinateTicTacToe coordinate, Token token) {
		int i = 0;
		while (this.coordinates[token.ordinal()][i] != null) {
			i++;
		}
		this.coordinates[token.ordinal()][i] = coordinate;
	}

	private void remove(CoordinateTicTacToe coordinate) {
		for (int i = 0; i < Board.PLAYERS; i++) {
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(Token token) {
		CoordinateTicTacToe[] coordinates = this.coordinates[token.ordinal()];
		if (this.numberOfCoordinates(coordinates) < CoordinateTicTacToe.DIMENSION) {
			return false;
		}
		Direction direction = coordinates[0].getDirection(coordinates[1]);
		if (direction == null) {
			return false;
		}
		return direction == coordinates[1].getDirection(coordinates[2]);
	}

	private int numberOfCoordinates(CoordinateTicTacToe[] coordinates) {
		int count = 0;
		for (int i = 0; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

	boolean isCompleted() {
		for (int i = 0; i < Board.PLAYERS; i++) {
			for (int j = 0; j < CoordinateTicTacToe.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmpty(CoordinateTicTacToe coordinate) {
		return this.isOccupied(coordinate, null);
	}

	boolean isOccupied(CoordinateTicTacToe coordinate, Token token) {
		return this.getToken(coordinate) == token;
	}

}
