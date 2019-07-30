class MachinePlayer extends Player {

	MachinePlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	void put() {
		TicTacToeCoordinate coordinate = new TicTacToeCoordinate();
		Error error;
		do {
			error = null;
			coordinate.random();
			if (!board.isEmpty(coordinate)) {
				error = Error.NOT_EMPTY;
			}
		} while (error != null);
		board.put(coordinate, this.token);
	}

	@Override
	void move() {
		TicTacToeCoordinate originCoordinate = new TicTacToeCoordinate();
		Error error;
		do {
			error = null;
			originCoordinate.random();
			if (!board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
			}
		} while (error != null);
		TicTacToeCoordinate targetCoordinate = new TicTacToeCoordinate();
		do {
			error = null;
			targetCoordinate.random();
			if (originCoordinate.equals(targetCoordinate)) {
				error = Error.SAME_COORDINATES;
			} else if (!board.isEmpty(targetCoordinate)) {
				error = Error.NOT_EMPTY;
			}
		} while (error != null);
		board.move(originCoordinate, targetCoordinate);
	}

}
