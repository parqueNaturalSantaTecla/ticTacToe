package ticTacToe;

import santaTecla.utils.Console;

class Board {
	
	final char EMPTY = '-';

	private Token[][] squares;

	Board() {
		this.squares = new Token[3][3];
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.squares[i][j] = null;
			}
		}
	}

	void draw() {
		Console console = new Console();
		console.writeln("-------------");
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			console.write("| ");
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.squares[i][j] == null) {
					console.write(this.EMPTY);
				} else {
					this.squares[i][j].write();					
				}
				console.write(" | ");
			}
			console.writeln();
		}
		console.writeln("-------------");
	}

	Token getToken(Coordinate coordinate) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()];
	}

	void put(Coordinate coordinate, Token token) {
		this.squares[coordinate.getRow()][coordinate.getColumn()] = token;
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		this.put(coordinate, this.getToken(originCoordinate));
		this.remove(originCoordinate);
	}

	void remove(Coordinate coordinate) {
		this.squares[coordinate.getRow()][coordinate.getColumn()] = null;
	}

	boolean isEmpty(Coordinate coordinate) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()] == null;
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		return this.squares[coordinate.getRow()][coordinate.getColumn()] == token;
	}

}
