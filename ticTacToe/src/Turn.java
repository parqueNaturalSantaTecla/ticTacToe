class Turn {

	private int value;

	private Player[] players;

	Turn(Player[] players) {
		this.value = 0;
		this.players = players;
	}

	void put() {
		this.changeTurn();
		this.players[value].put();
	}

	void move() {
		this.changeTurn();
		this.players[value].move();
	}

	private void changeTurn() {
		if (this.value == 0) {
			this.value = 1;
		} else {
			this.value = 0;
		}
	}

	Token getToken() {
		return this.players[value].getToken();
	}

}
