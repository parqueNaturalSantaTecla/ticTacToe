class DemoTicTacToe extends TicTacToe {

	private MachinePlayer[] machinePlayers;

	DemoTicTacToe() {
		super();
		this.machinePlayers = new MachinePlayer[Turn.PLAYERS];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			this.machinePlayers[i] = new MachinePlayer(Token.values()[i], this.board);
		}
	}

	@Override
	void playRound() {
		do {
			if (!this.board.isCompleted()) {
				this.machinePlayers[this.turn.getValue()].put();
			} else {
				this.machinePlayers[this.turn.getValue()].move();
			}
			this.turn.change();
			this.board.draw();
		} while (!this.board.isTicTacToe(this.machinePlayers[this.turn.getOtherValue()].getToken()));
		this.machinePlayers[this.turn.getOtherValue()].getToken().write();
	}

	public static void main(String[] args) {
		new DemoTicTacToe().play();
	}

}
