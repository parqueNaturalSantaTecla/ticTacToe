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
		console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		do {
			if (!this.board.isCompleted()) {
				this.turn.getPlayer().put();
			} else {
				this.turn.getPlayer().move();
			}
			this.turn.change();
			this.board.draw();
		} while (!this.board.isTicTacToe(this.turn.getOtherPlayer().getToken()));
		this.turn.getOtherPlayer().writeWin();
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}