abstract class Player extends WithConsoleModel {

	protected Token token;

	protected Board board;

	Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}
	
	abstract void put();
	
	abstract void move();

	void writeWin(Token token) {
		token.write();
		WithConsoleModel.console.writeln(" Player: You win!!! :-)");
	}

	Token getToken() {
		return this.token;
	}

}
