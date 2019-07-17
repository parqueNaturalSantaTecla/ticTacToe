public class TicTacToe {

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Board.PLAYERS];
		for (int i = 0; i < Board.PLAYERS; i++) {
			this.players[i] = new Player(this.board, Token.values()[i]);
		}
		this.turn = new Turn();
	}

	private void play() {
		Console console = new Console();
		console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		do {
			this.turn.changeTurn();
			if (!this.board.isCompleted()) {
				this.players[this.turn.getValue()].put();
			} else {
				this.players[this.turn.getValue()].move();
			}
			this.board.draw();
		} while (!this.board.isTicTacToe(this.players[this.turn.getValue()].getToken()));
		console.writeln("You win!!! :-)");
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}