package ticTacToe;

import santaTecla.utils.Console;

enum Token {

	TOKEN_X('X'), 
	TOKEN_O('O');

	private char initial;

	private Token(char initial) {
		this.initial = initial;
	}

	void write() {
		new Console().write(this.initial);
	}
	
}
