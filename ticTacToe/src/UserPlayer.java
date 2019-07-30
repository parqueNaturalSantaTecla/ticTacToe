class UserPlayer extends Player {

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	void put() {
		TicTacToeCoordinate coordinate = new TicTacToeCoordinate();
		Error error;
		do {
			error = null;
			coordinate.read("Enter a coordinate to put a token:");
			if (!this.board.isEmpty(coordinate)) {
				error = Error.NOT_EMPTY;
				error.writeln();
			}
		} while (error != null);
		this.board.put(coordinate, this.token);
	}

	@Override
	void move() {
		TicTacToeCoordinate originCoordinate = new TicTacToeCoordinate();
		Error error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!this.board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
				error.writeln();
			}
		} while (error != null);
		TicTacToeCoordinate targetCoordinate = new TicTacToeCoordinate();
		do {
			error = null;
			targetCoordinate.read("Enter a coordinate to put a token:");
			if (originCoordinate.equals(targetCoordinate)) {
				error = Error.SAME_COORDINATES;
				error.writeln();
			} else if (!this.board.isEmpty(targetCoordinate)) {
				error = Error.NOT_EMPTY;
				error.writeln();
			}
		} while (error != null);
		this.board.move(originCoordinate, targetCoordinate);
	}

}
