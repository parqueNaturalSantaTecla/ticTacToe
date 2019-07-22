class Player {

	private Token token;
	
	private Board board;

	Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	void put() {
		Coordinate coordinate = new Coordinate();
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
		Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
				error.write();
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
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
	
	void writeWin() {
		this.token.write();
		new Console().writeln(" Player: You win!!! :-)");
	}

	Token getToken() {
		return this.token;
	}

}
