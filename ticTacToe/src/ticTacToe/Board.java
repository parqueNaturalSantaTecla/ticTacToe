package ticTacToe;

import santaTecla.utils.Direction;
import santaTecla.utils.WithConsoleModel;

class Board extends WithConsoleModel {

	static final char EMPTY = '-';

	private Coordinate[][] coordinates;

	Board() {
		this.coordinates = new Coordinate[Turn.PLAYERS][Coordinate.DIMENSION];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.coordinates[i][j] = null;
			}
		}
	}

	void write() {
		WithConsoleModel.console.writeln("-----------------------------------------------------");
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			WithConsoleModel.console.write("| ");
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.getToken(new Coordinate(i, j)) == null) {
					WithConsoleModel.console.write(Board.EMPTY);
				} else {
					this.getToken(new Coordinate(i, j)).write();
				}
				WithConsoleModel.console.write(" | ");
			}
			WithConsoleModel.console.writeln();
		}
		WithConsoleModel.console.writeln("-----------------------------------------------------");
	}

	private Token getToken(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Token.values()[i];
				}
			}
		}
		return null;
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		Token token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(Coordinate coordinate, Token token) {
		int i = 0;
		while (this.coordinates[token.ordinal()][i] != null) {
			i++;
		}
		this.coordinates[token.ordinal()][i] = coordinate;
	}

	private void remove(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(Token token) {
		Coordinate[] coordinates = this.coordinates[token.ordinal()];
		if (this.numberOfCoordinates(coordinates) < Coordinate.DIMENSION) {
			return false;
		}
		if (!coordinates[0].inDirection(coordinates[1])) {
			System.out.println("No est�n en direcci�n");
			return false;
		}
		Direction direction = coordinates[0].getDirection(coordinates[1]);
		for (int i = 1; i < coordinates.length - 1; i++) {
			if (direction != coordinates[i].getDirection(coordinates[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private int numberOfCoordinates(Coordinate[] coordinates) {
		int count = 0;
		for (int i = 0; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

	boolean isCompleted() {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, null);
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		return this.getToken(coordinate) == token;
	}

}
