class Player extends WithConsoleModel{

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
			if (!this.board.isEmpty(coordinate)) {
				error = Error.NOT_EMPTY;
				error.writeln();
			}
		} while (error != null);
		this.board.put(coordinate, this.token);
	}

	void move() {
		Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!this.board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
				error.writeln();
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
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

	void writeWin(Token token) {
		token.write();
		WithConsoleModel.console.writeln(" Player: You win!!! :-)");
	}

	Token getToken() {
		return this.token;
	}

}
