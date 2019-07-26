class Player {

	private final String[] ERRORS = new String[] { "The square is not empty", "There is not a token of yours",
			"The origin and target squares are the same" };

	private final int NOT_EMPTY = 0;
	private final int NOT_OWNER = 1;
	private final int SAME_COORDINATES = 2;

	private int token;

	Player(int token) {
		this.token = token;
	}

	void put(Board board) {
		Coordinate coordinate = new Coordinate(board.getDimension());
		String error;
		do {
			error = null;
			coordinate.read("Enter a coordinate to put a token:");
			if (!board.isEmpty(coordinate)) {
				error = this.ERRORS[this.NOT_EMPTY];
				new Console().writeln(error);
			}
		} while (error != null);
		board.put(coordinate, this.token);
	}

	void move(Board board) {
		Coordinate originCoordinate = new Coordinate(board.getDimension());
		String error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!board.isOccupied(originCoordinate, this.token)) {
				error = this.ERRORS[this.NOT_OWNER];
				new Console().writeln(error);
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate(board.getDimension());
		do {
			error = null;
			targetCoordinate.read("Enter a coordinate to put a token:");
			if (originCoordinate.equals(targetCoordinate)) {
				error = this.ERRORS[this.SAME_COORDINATES];
				new Console().writeln(error);
			} else if (!board.isEmpty(targetCoordinate)) {
				error = this.ERRORS[this.NOT_EMPTY];
				new Console().writeln(error);
			}
		} while (error != null);
		board.move(originCoordinate, targetCoordinate);
	}

	void writeWin(char symbol) {
		new Console().writeln(symbol + " Player: You win!!! :-)");
	}

	int getToken() {
		return this.token;
	}

}
