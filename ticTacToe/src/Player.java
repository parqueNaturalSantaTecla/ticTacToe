class Player {

	private Board board;
	
	private Token token;

	Player(Board board, Token token) {
		this.board = board;
		this.token = token;
	}

	void put() {
		CoordinateTicTacToe coordinate = new CoordinateTicTacToe();
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!this.board.isEmpty(coordinate));
		this.board.put(coordinate, this.token);
	}

	void move() {
		CoordinateTicTacToe coordinate = new CoordinateTicTacToe();
		CoordinateTicTacToe originCoordinate = new CoordinateTicTacToe();
		do {
			originCoordinate.read("Enter a coordinate to remove a token:");
		} while (!this.board.isOccupied(originCoordinate, this.token));
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!this.board.isEmpty(coordinate));
		this.board.move(originCoordinate, coordinate);
	}

	Token getToken() {
		return this.token;
	}

}
