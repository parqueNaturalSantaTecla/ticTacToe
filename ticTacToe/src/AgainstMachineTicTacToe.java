class AgainstMachineTicTacToe extends TicTacToe {

	@Override
	protected Player[] createPlayers(Board board) {
		Player[] players = new Player[Board.PLAYERS];
		players[0] = new UserPlayer(board, Token.values()[0]);
		players[1] = new MachinePlayer(board, Token.values()[1]);
		return players;
	}

	public static void main(String[] args) {
		new AgainstMachineTicTacToe().play();
	}

}
