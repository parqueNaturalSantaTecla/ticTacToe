abstract class Player {

	protected Board board;
	
	protected Token token;

	Player(Board board, Token token) {
		this.board = board;
		this.token = token;
	}
	
	abstract void put();
	
	abstract void move();

	Token getToken() {
		return this.token;
	}

}
