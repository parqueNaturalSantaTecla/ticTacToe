class Token {

	static final Token TOKEN_X = new Token('X'); 
	
	static final Token TOKEN_O = new Token('O');

	private char initial;

	private Token(char initial) {
		this.initial = initial;
	}

	void write() {
		new Console().write(this.initial);
	}

	static Token[] values() {
		return new Token[] {new Token('X'), new Token('O')};
	}

	int ordinal() {
		for (int i = 0; i < Token.values().length; i++) {
			if (this.initial == Token.values()[i].initial) {
				return i;
			}
		}
		return 0;
	}

}
