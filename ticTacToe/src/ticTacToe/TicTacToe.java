package ticTacToe;

import santaTecla.utils.WithConsoleModel;

class TicTacToe extends WithConsoleModel{

	private Board board;
	
	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Turn.PLAYERS];
		this.turn = new Turn(this.players);
	}

	void play() {
		WithConsoleModel.console.writeln("----- TIC TAC TOE -----");
		int users = WithConsoleModel.console.readInt("Number of users [0-" + Turn.PLAYERS + "] ");
		for (int i = 0; i < users; i++) {
			this.players[i] = new UserPlayer(Token.values()[i], this.board);
		}
		for (int i = users; i < Turn.PLAYERS; i++) {
			this.players[i] = new MachinePlayer(Token.values()[i], this.board);
		}
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