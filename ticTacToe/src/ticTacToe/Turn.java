package ticTacToe;

class Turn {

	static final int PLAYERS = 2;

	private int value;
	
	private Player[] players;

	Turn(Player[] players) {
		this.value = 0;
		this.players = players;
	}

	void change() {
		this.value = this.getOtherValue();
	}

	private int getOtherValue() {
		return (this.value + 1) % Turn.PLAYERS;
	}
	
	Player getPlayer() {
		return this.players[this.value];
	}
	
	Player getOtherPlayer() {
		return this.players[this.getOtherValue()];
	}

}
