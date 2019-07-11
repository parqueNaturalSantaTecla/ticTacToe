class Turn {

	private int value;

	Turn() {
		this.value = 0;
	}

	void changeTurn() {
		if (this.value == 0) {
			this.value = 1;
		} else {
			this.value = 0;
		}
	}

	int getValue() {
		return this.value;
	}

}
