class Error {

	static final Error NOT_EMPTY = new Error("The square is not empty");
	
	static final Error NOT_OWNER = new Error("There is not a token of yours");
	
	static final Error SAME_SQUARE = new Error("The origin and target squares are the same");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	void write() {
		new Console().writeln("ERROR!!! " + this.message);
	}
	
}
