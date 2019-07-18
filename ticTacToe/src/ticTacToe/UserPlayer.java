package ticTacToe;

class UserPlayer extends Player {

	UserPlayer(Board board, Token token) {
		super(board, token);
	}

	void put() {
		Coordinate coordinate = new Coordinate();
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!this.board.isEmpty(coordinate));
		this.board.put(coordinate, this.token);
	}

	void move() {
		Coordinate coordinate = new Coordinate();
		Coordinate originCoordinate = new Coordinate();
		do {
			originCoordinate.read("Enter a coordinate to remove a token:");
		} while (!this.board.isOccupied(originCoordinate, this.token));
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!this.board.isEmpty(coordinate));
		this.board.move(originCoordinate, coordinate);
	}

}
