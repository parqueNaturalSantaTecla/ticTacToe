

public class Player {

	private Token token;

	Player(Token token) {
		this.token = token;
	}

	void put(Board board) {
		CoordinateTicTacToe coordinate = new CoordinateTicTacToe();
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!board.isEmpty(coordinate));
		board.put(coordinate, this.token);
	}

	void move(Board board) {
		CoordinateTicTacToe coordinate = new CoordinateTicTacToe();
		CoordinateTicTacToe originCoordinate = new CoordinateTicTacToe();
		do {
			originCoordinate.read("Enter a coordinate to remove a token:");
		} while (!board.isOccupied(originCoordinate, this.token));
		do {
			coordinate.read("Enter a coordinate to put a token:");
		} while (!board.isEmpty(coordinate));
		board.move(originCoordinate, coordinate);
	}
}
