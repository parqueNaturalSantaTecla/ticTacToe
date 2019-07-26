class Direction {

	static final Direction VERTICAL = new Direction(0);
	static final Direction HORIZONTAL = new Direction(1);
	static final Direction MAIN_DIAGONAL = new Direction(2);
	static final Direction INVERSE_DIAGONAL = new Direction(3);
	
	private int value;
	
	private Direction(int value) {
		this.value = value;
	}
}
