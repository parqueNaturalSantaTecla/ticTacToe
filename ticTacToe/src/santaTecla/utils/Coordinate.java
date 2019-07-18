package santaTecla.utils;

public class Coordinate extends WithConsoleModel{

	protected int row;

	protected int column;

	public Coordinate() {
	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

}
