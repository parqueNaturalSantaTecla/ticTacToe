class UserPlayer extends Player {

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	void put() {
		TicTacToeCoordinate coordinate = new TicTacToeCoordinate();
		Error error;
		do {
			error = null;
			coordinate.read("Enter a coordinate to put a token:");
			if (!board.isEmpty(coordinate)) {
				error = Error.NOT_EMPTY;
				error.write();
			}
		} while (error != null);
		board.put(coordinate, this.token);
	}

	void move() {
		TicTacToeCoordinate originCoordinate = new TicTacToeCoordinate();
		Error error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
				error.write();
			}
		} while (error != null);
		TicTacToeCoordinate targetCoordinate = new TicTacToeCoordinate();
		do {
			error = null;
			targetCoordinate.read("Enter a coordinate to put a token:");
			if (originCoordinate.equals(targetCoordinate)) {
				error = Error.SAME_SQUARE;
				error.write();
			} else if (!board.isEmpty(targetCoordinate)) {
				error = Error.NOT_EMPTY;
				error.write();
			}
		} while (error != null);
		board.move(originCoordinate, targetCoordinate);
	}

}
