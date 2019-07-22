public class TicTacToe extends WithConsoleModel{

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Turn.PLAYERS];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			this.players[i] = new Player(this.board, Token.values()[i]);
		}
		this.turn = new Turn(this.players);
	}

	private void play() {
		WithConsoleModel.console.writeln("----- TIC TAC TOE -----");
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