class Player {

	private Token token;

	Player(Token token) {
		this.token = token;
	}

	void put(Board board) {
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

	void move(Board board) {
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

	Token getToken() {
		return this.token;
	}

}
