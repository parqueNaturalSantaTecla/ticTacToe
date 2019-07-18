package ticTacToe;
class DemoTicTacToe extends TicTacToe {

	@Override
	protected void createPlayers(Board board) {
		for (int i = 0; i < Board.PLAYERS; i++) {
			this.players[i] = new MachinePlayer(board, Token.values()[i]);
		}
	}

	public static void main(String[] args) {
		new DemoTicTacToe().play();
	}

}
