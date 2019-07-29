class TicTacToe {

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.turn = new Turn();
		this.board = new Board(this.turn.getPlayers());
		this.players = new Player[this.turn.getPlayers()];
		for (int i = 0; i < this.turn.getPlayers(); i++) {
			this.players[i] = new Player(i, this.board);
		}
	}

	private void play() {
		Console console = new Console();
		console.writeln("-------------------- TIC TAC TOE --------------------");
		this.board.write();
		do {
			if (!this.board.isCompleted()) {
				this.players[this.turn.getValue()].put();
			} else {
				this.players[this.turn.getValue()].move();
			}
			this.turn.change();
			this.board.write();
		} while (!this.board.isTicTacToe(this.players[this.turn.getOtherValue()].getToken()));
		int otherValue = this.turn.getOtherValue();
		this.players[otherValue].writeWin(this.board.getSymbol(otherValue));
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}