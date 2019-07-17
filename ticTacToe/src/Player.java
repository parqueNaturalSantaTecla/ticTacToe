class Player {

	private Token token;

	Player(Token token) {
		this.token = token;
	}

	void put(Board board) {
		Coordinate coordinate = new Coordinate();
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!board.isEmpty(coordinate));
		board.put(coordinate, this.token);
	}

	void move(Board board) {
		Coordinate coordinate = new Coordinate();
		Coordinate originCoordinate = new Coordinate();
		do {
			originCoordinate.read("Enter a coordinate to remove a token:");
		} while (!board.isOccupied(originCoordinate, this.token));
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!board.isEmpty(coordinate));
		board.move(originCoordinate, coordinate);
	}

	Token getToken() {
		return this.token;
	}

}
