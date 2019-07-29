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
		this.turn = new Turn(this.players);
	}

	private void play() {
		Console console = new Console();
		console.writeln("-------------------- TIC TAC TOE --------------------");
		this.board.write();
		do {
			if (!this.board.isCompleted()) {
				this.turn.getPlayer().put();
			} else {
				this.turn.getPlayer().move();
			}
			this.turn.change();
			this.board.write();
		} while (!this.board.isTicTacToe(this.turn.getOtherPlayer().getToken()));
		int otherValue = this.turn.getOtherValue();
		this.turn.getOtherPlayer().writeWin(Token.values()[otherValue]);
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}