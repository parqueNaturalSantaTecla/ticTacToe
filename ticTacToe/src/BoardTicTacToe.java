class BoardTicTacToe extends TicTacToe {

	@Override
	protected void createPlayers(Board board) {
		for (int i = 0; i < Board.PLAYERS; i++) {
			this.players[i] = new UserPlayer(board, Token.values()[i]);
		}
	}

	public static void main(String[] args) {
		new BoardTicTacToe().play();
	}

}
