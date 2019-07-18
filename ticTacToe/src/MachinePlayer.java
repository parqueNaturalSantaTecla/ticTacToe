import java.util.Random;

class MachinePlayer extends Player{

	MachinePlayer(Board board, Token token) {
		super(board, token);
	}
	
	void put() {
		CoordinateTicTacToe coordinate = new CoordinateTicTacToe();
		do {
			coordinate = this.createCoordinate();
		} while (!this.board.isEmpty(coordinate));
		this.board.put(coordinate, this.token);
	}
	
	private CoordinateTicTacToe createCoordinate() {
		Random random = new Random(System.currentTimeMillis());
		int row = random.nextInt(CoordinateTicTacToe.DIMENSION);
		int column = random.nextInt(CoordinateTicTacToe.DIMENSION);
		return new CoordinateTicTacToe(row, column);
	}

	void move() {
		CoordinateTicTacToe coordinate = new CoordinateTicTacToe();
		CoordinateTicTacToe originCoordinate = new CoordinateTicTacToe();
		do {
			originCoordinate = this.createCoordinate();
		} while (!this.board.isOccupied(originCoordinate, this.token));
		do {
			coordinate = this.createCoordinate();
		} while (!this.board.isEmpty(coordinate));
		this.board.move(originCoordinate, coordinate);
	}

}
