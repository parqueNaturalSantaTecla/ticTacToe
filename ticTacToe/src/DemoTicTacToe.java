class DemoTicTacToe extends TicTacToe {

	@Override
	protected Player[] createPlayers(Board board) {
		Player[] players = new Player[Board.PLAYERS];
		for (int i = 0; i < Board.PLAYERS; i++) {
			players[i] = new MachinePlayer(board, Token.values()[i]);
		}
		return players;
	}

	public static void main(String[] args) {
		new DemoTicTacToe().play();
	}

}
