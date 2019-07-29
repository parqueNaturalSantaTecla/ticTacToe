class Turn {

	private final int PLAYERS;

	private int value;

	private Player[] players;

	Turn(int numberPlayers, Player[] players) {
		this.value = 0;
		this.players = players;
		this.PLAYERS = numberPlayers;
	}

	void change() {
		this.value = this.getOtherValue();
	}

	Player getPlayer() {
		return this.players[this.value];
	}

	int getOtherValue() {
		return (this.value + 1) % this.PLAYERS;
	}

	Player getOtherPlayer() {
		return this.players[this.getOtherValue()];
	}

}
