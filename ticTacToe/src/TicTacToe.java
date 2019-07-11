public class TicTacToe {

	final int PLAYERS = 2;

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[] { new Player(Token.TOKEN_O), new Player(Token.TOKEN_X) };
		this.turn = new Turn();
	}

	private void play() {
		Console console = new Console();
		console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		for (int i = 0; i < this.PLAYERS * CoordinateTicTacToe.DIMENSION - 1; i++) {
			this.players[this.turn.getValue()].put(this.board);
			this.turn.changeTurn();
			this.board.draw();
		}
		if (!this.isWinner()) {
			this.players[this.turn.getValue()].put(this.board);
			this.turn.changeTurn();
			this.board.draw();
			while (!this.isWinner()) {
				this.players[this.turn.getValue()].move(this.board);
				this.turn.changeTurn();
				this.board.draw();
			}
		}
		if (this.isWinner()) {
			console.writeln("You win!! :-)");
		}
	}

	private boolean isWinner() {
		boolean winner = this.checkRows() || this.checkColumns() || this.checkDiagonals();
		return winner;
	}

	private boolean checkRows() {
		for (int i = 0; i < CoordinateTicTacToe.DIMENSION; i++) {
			if (this.checkRowCol(this.board.getToken(new CoordinateTicTacToe(i, 0)), this.board.getToken(new CoordinateTicTacToe(i, 1)),
					this.board.getToken(new CoordinateTicTacToe(i, 2)))) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumns() {
		for (int i = 0; i < CoordinateTicTacToe.DIMENSION; i++) {
			if (this.checkRowCol(this.board.getToken(new CoordinateTicTacToe(0, i)), this.board.getToken(new CoordinateTicTacToe(1, i)),
					this.board.getToken(new CoordinateTicTacToe(2, i)))) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals() {
		if (this.checkRowCol(this.board.getToken(new CoordinateTicTacToe(0, 0)), this.board.getToken(new CoordinateTicTacToe(1, 1)),
				this.board.getToken(new CoordinateTicTacToe(2, 2)))) {
			return true;
		} else if (this.checkRowCol(this.board.getToken(new CoordinateTicTacToe(0, 2)),
				this.board.getToken(new CoordinateTicTacToe(1, 1)), this.board.getToken(new CoordinateTicTacToe(2, 0)))) {
			return true;
		}
		return false;
	}

	private boolean checkRowCol(Token token1, Token token2, Token token3) {
		if (token1 != null) {
			return (token1 == token2) && (token2 == token3);
		}
		return false;
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}
	
}