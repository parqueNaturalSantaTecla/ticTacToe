class BoardTicTacToe extends TicTacToe {

	private UserPlayer[] userPlayers;

	BoardTicTacToe() {
		super();
		this.userPlayers = new UserPlayer[Turn.PLAYERS];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			this.userPlayers[i] = new UserPlayer(Token.values()[i], this.board);
		}
	}

	@Override
	void playRound() {
		do {
			if (!this.board.isCompleted()) {
				this.userPlayers[this.turn.getValue()].put();
			} else {
				this.userPlayers[this.turn.getValue()].move();
			}
			this.turn.change();
			this.board.draw();
		} while (!this.board.isTicTacToe(this.userPlayers[this.turn.getOtherValue()].getToken()));
		this.userPlayers[this.turn.getOtherValue()].getToken().write();
	}

	public static void main(String[] args) {
		new BoardTicTacToe().play();
	}

}
