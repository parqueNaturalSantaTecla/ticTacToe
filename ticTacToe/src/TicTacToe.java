class TicTacToe {
	
	private final int PLAYERS = 2;

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board(this.getPlayers());
		this.players = new Player[this.getPlayers()];
		for (int i = 0; i < this.getPlayers(); i++) {
			this.players[i] = new Player(i, this.board);
		}
		this.turn = new Turn(this.PLAYERS, this.players);
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
		this.turn.getOtherPlayer().writeWin(this.board.getSymbol(otherValue));
	}
	
	int getPlayers() {
		return this.PLAYERS;
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}