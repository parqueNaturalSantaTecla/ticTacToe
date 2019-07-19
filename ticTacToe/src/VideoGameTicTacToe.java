class VideoGameTicTacToe extends TicTacToe {

	private UserPlayer userPlayer;

	private MachinePlayer machinePlayer;

	VideoGameTicTacToe() {
		super();
		this.userPlayer = new UserPlayer(Token.TOKEN_O, this.board);
		this.machinePlayer = new MachinePlayer(Token.TOKEN_X, this.board);
	}

	@Override
	void playRound() {
		do {
			if (!this.board.isCompleted()) {
				if (this.turn.getValue() == 0) {
					this.userPlayer.put();
				} else {
					this.machinePlayer.put();
				}
			} else {
				if (this.turn.getValue() == 0) {
					this.userPlayer.move();
				} else {
					this.machinePlayer.move();
				}
			}
			this.turn.change();
			this.board.draw();
		} while (!this.board.isTicTacToe(this.userPlayer.getToken())
				&& !this.board.isTicTacToe(this.machinePlayer.getToken()));
		if (this.turn.getOtherValue() == 0) {
			this.userPlayer.getToken().write();
		} else {
			this.machinePlayer.getToken().write();
		}
	}

	public static void main(String[] args) {
		new VideoGameTicTacToe().play();
	}

}
