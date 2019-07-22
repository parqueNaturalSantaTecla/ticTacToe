package ticTacToe;

import santaTecla.utils.WithConsoleModel;

abstract class Player extends WithConsoleModel{

	protected Token token;
	
	protected Board board;

	Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	abstract void put();

	abstract void move();

	Token getToken() {
		return this.token;
	}
	
	void writeWin() {
		this.token.write();
		WithConsoleModel.console.writeln(" Player: You win!!! :-)");
	}

}
