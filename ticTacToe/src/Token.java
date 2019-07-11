enum Token {

	TOKEN_X('X'), 
	TOKEN_O('O');

	private char initial;

	Token(char initial) {
		this.initial = initial;
	}

	void write() {
		new Console().write(this.initial);
	}
	
}
