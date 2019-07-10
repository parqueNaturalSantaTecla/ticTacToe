

public class Board {
	
	static final int DIMENSION = 3;
	
	private char[][] coordinates;
	
	Board(){
		this.coordinates = new char[3][3];
		this.clear();
	}
	
	public void clear() {
		for (int i = 0; i < Board.DIMENSION; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				this.coordinates[i][j] = '-';
			}
		}
	}
	
	public void draw() {
		System.out.println("-------------");
		for (int i= 0; i < Board.DIMENSION; i++) {
			System.out.print("| ");
			for (int j = 0; j < Board.DIMENSION; j++) {
				System.out.print(this.coordinates[i][j] + " | ");				
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	
	public char getChar(int row, int column) {
		return this.coordinates[row][column];
	}
	
	boolean put(int row, int column, char player) {
		if (row >= 0 && row < Board.DIMENSION){
			if (column >= 0 && column < Board.DIMENSION) {
				if (this.coordinates[row][column] == '-') {
					this.coordinates[row][column] = player;
					return true;
				}
			}
		}
		return false;
	}

	public boolean remove(int row, int column, char player) {
		if (this.coordinates[row][column] == player) {
			this.coordinates[row][column] = '-';
			return true;
		}
		return false;
	}

}
