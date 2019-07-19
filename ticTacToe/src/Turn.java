class Turn {

	static final int PLAYERS = 2;

	private int value;

	Turn() {
		this.value = 0;
	}

	void change() {
		this.value = this.getOtherValue();
	}

	int getValue() {
		return this.value;
	}

	int getOtherValue() {
		return (this.value + 1) % Turn.PLAYERS;
	}

}
