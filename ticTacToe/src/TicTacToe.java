public class TicTacToe extends WithConsoleModel{

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Board.PLAYERS];
		for (int i = 0; i < Board.PLAYERS; i++) {
			this.players[i] = new Player(this.board, Token.values()[i]);
		}
		this.turn = new Turn(this.players);
	}

	private void play() {
		this.console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		do {
			if (!this.board.isCompleted()) {
				this.turn.put();
			} else {
				this.turn.move();
			}
			this.board.draw();
		} while (!this.board.isTicTacToe(this.turn.getToken()));
		this.console.writeln("You win!!! :-)");
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}