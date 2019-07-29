class Turn {

//	private final int PLAYERS = 2;

	private int value;
	
	private Player player;

	Turn(Player player) {
		this.value = 0;
		this.player = player;
	}

	void change() {
		this.value = this.getOtherValue();
	}

	int getValue() {
		return this.value;
	}

	int getOtherValue() {
		return (this.value + 1) % this.PLAYERS;
	}

//	int getPlayers() {
//		return this.PLAYERS;
//	}

}
