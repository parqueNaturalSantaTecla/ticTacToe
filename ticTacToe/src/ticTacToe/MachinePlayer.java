package ticTacToe;

import java.util.Random;

class MachinePlayer extends Player {

	MachinePlayer(Board board, Token token) {
		super(board, token);
	}

	void put() {
		Coordinate coordinate = new Coordinate();
		do {
			coordinate = this.createCoordinate();
		} while (!this.board.isEmpty(coordinate));
		this.board.put(coordinate, this.token);
	}

	private Coordinate createCoordinate() {
		Random random = new Random(System.currentTimeMillis());
		int row = random.nextInt(Coordinate.DIMENSION);
		int column = random.nextInt(Coordinate.DIMENSION);
		return new Coordinate(row, column);
	}

	void move() {
		Coordinate coordinate = new Coordinate();
		Coordinate originCoordinate = new Coordinate();
		do {
			originCoordinate = this.createCoordinate();
		} while (!this.board.isOccupied(originCoordinate, this.token));
		do {
			coordinate = this.createCoordinate();
		} while (!this.board.isEmpty(coordinate));
		this.board.move(originCoordinate, coordinate);
	}

}
