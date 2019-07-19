abstract class Player {

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

}
