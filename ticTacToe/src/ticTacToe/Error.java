package ticTacToe;

import santaTecla.utils.Console;

enum Error {

	NOT_EMPTY("The square is not empty"),
	NOT_OWNER("There is not a token of yours"),
	SAME_SQUARE("The origin and target squares are the same");
	
	private String message;
	
	Error(String message){
		this.message = message;
	}
	
	void write() {
		new Console().writeln("ERROR!!! " + this.message);
	}
	
}
