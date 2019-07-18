abstract class TicTacToe extends WithConsoleModel{

	private Board board;

	protected Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[CoordinateTicTacToe.DIMENSION];
		this.createPlayers(this.board);
		this.turn = new Turn(this.players);
	}

	protected abstract void createPlayers(Board board);

	protected void play() {
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

}