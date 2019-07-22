class Player {
	
	static final String[] ERROR = {"The square is not empty", "There is not a token of yours", "The origin and target squares are the same"};

	private String token;

	Player(String token) {
		this.token = token;
	}

	void put(Board board) {
		Coordinate coordinate = new Coordinate();
		String error;
		do {
			error = null;
			coordinate.read("Enter a coordinate to put a token:");
			if (!board.isEmpty(coordinate)) {
				error = Player.ERROR[0];
				new Console().write(error);
			}
		} while (error != null);
		board.put(coordinate, this.token);
	}

	void move(Board board) {
		Coordinate originCoordinate = new Coordinate();
		Console console = new Console();
		String error;
		do {
			error = null;
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!board.isOccupied(originCoordinate, this.token)) {
				error = Player.ERROR[1];
				console.write(error);
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			error = null;
			targetCoordinate.read("Enter a coordinate to put a token:");
			if (originCoordinate.equals(targetCoordinate)) {
				error = Player.ERROR[2];
				console.write(error);
			} else if (!board.isEmpty(targetCoordinate)) {
				error = Player.ERROR[0];
				console.write(error);
			}
		} while (error != null);
		board.move(originCoordinate, targetCoordinate);
	}
	
	void writeWin() {
		Console console = new Console();
		console.write(token);
		console.writeln(" Player: You win!!! :-)");
	}

	String getToken() {
		return this.token;
	}

}
