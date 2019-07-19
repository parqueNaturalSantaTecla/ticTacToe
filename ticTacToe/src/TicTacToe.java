abstract class TicTacToe extends WithConsoleModel{

	protected Board board;

	protected Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.turn = new Turn();
	}

	void play() {
		WithConsoleModel.console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		this.playRound();
		WithConsoleModel.console.writeln(" Player: You win!!! :-)");
	}

	abstract void playRound();

}