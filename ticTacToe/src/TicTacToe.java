class TicTacToe {

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.turn = new Turn();
		this.players = new Player[this.turn.players];
		for (int i = 0; i < this.turn.players; i++) {
			this.players[i] = new Player(Token.values()[i]);
		}
	}

	private void play() {
		Console console = new Console();
		console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		do {
			if (!this.board.isCompleted()) {
				this.players[this.turn.getValue()].put(this.board);
			} else {
				this.players[this.turn.getValue()].move(this.board);
			}
			this.turn.change();
			this.board.draw();
		} while (!this.board.isTicTacToe(this.players[this.turn.getOtherValue()].getToken()));
		this.players[this.turn.getOtherValue()].writeWin();
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}