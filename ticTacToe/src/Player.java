class Player {

	static final String[] ERRORS = new String[] { "The square is not empty", "There is not a token of yours",
			"The origin and target squares are the same" };

	static final int NOT_EMPTY = 0;
	static final int NOT_OWNER = 1;
	static final int SAME_COORDINATES = 2;

	private int token;
	
	private Board board;

	Player(int token, Board board) {
		this.token = token;
		this.board = board;
	}

	void put() {
		Coordinate coordinate = new Coordinate();
		String error;
		do {
			error = null;
			coordinate.read("Enter a coordinate to put a token:");
			if (!this.board.isEmpty(coordinate)) {
				error = Player.ERRORS[Player.NOT_EMPTY];
				new Console().writeln(error);
			}
		} while (error != null);
		this.board.put(coordinate, this.token);
	}

	void move() {
		Coordinate originCoordinate = new Coordinate();
		String error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!this.board.isOccupied(originCoordinate, this.token)) {
				error = Player.ERRORS[Player.NOT_OWNER];
				new Console().writeln(error);
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			error = null;
			targetCoordinate.read("Enter a coordinate to put a token:");
			if (originCoordinate.equals(targetCoordinate)) {
				error = Player.ERRORS[Player.SAME_COORDINATES];
				new Console().writeln(error);
			} else if (!this.board.isEmpty(targetCoordinate)) {
				error = Player.ERRORS[Player.NOT_EMPTY];
				new Console().writeln(error);
			}
		} while (error != null);
		this.board.move(originCoordinate, targetCoordinate);
	}

	void writeWin(char symbol) {
		new Console().writeln(symbol + " Player: You win!!! :-)");
	}

	int getToken() {
		return this.token;
	}

}
