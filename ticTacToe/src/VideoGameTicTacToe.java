class VideoGameTicTacToe extends TicTacToe {

	@Override
	protected void createPlayers(Board board) {
		this.players[0] = new UserPlayer(board, Token.values()[0]);
		this.players[1] = new MachinePlayer(board, Token.values()[1]);
	}

	public static void main(String[] args) {
		new VideoGameTicTacToe().play();
	}

}
