class TicTacToe {

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Turn.PLAYERS];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			this.players[i] = new Player(Token.values()[i], this.board);
		}
		this.turn = new Turn();
	}

	private void play() {
		Console console = new Console();
		console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		do {
			if (!this.board.isCompleted()) {
				this.players[this.turn.getValue()].put();
			} else {
				this.players[this.turn.getValue()].move();
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