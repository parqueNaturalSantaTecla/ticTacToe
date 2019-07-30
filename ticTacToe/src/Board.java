import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Board extends WithConsoleModel {

	static final char EMPTY = '-';
	
	private Map<Integer, Set<TicTacToeCoordinate>> coordinates;

//	private TicTacToeCoordinate[][] coordinates;

	Board() {
		this.coordinates = new HashMap<Integer, Set<TicTacToeCoordinate>>();
//		this.coordinates = new TicTacToeCoordinate[Turn.PLAYERS][TicTacToeCoordinate.DIMENSION];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			this.coordinates.put(i, new HashSet<TicTacToeCoordinate>());
//			for (int j = 0; j < TicTacToeCoordinate.DIMENSION; j++) {
//				this.coordinates[i][j] = null;
//			}
		}
	}

	void write() {
		WithConsoleModel.console.writeln("-----------------------------------------------------");
		for (int i = 0; i < TicTacToeCoordinate.DIMENSION; i++) {
			WithConsoleModel.console.write("| ");
			for (int j = 0; j < TicTacToeCoordinate.DIMENSION; j++) {
				if (this.getToken(new TicTacToeCoordinate(i, j)) == null) {
					WithConsoleModel.console.write(Board.EMPTY);
				} else {
					this.getToken(new TicTacToeCoordinate(i, j)).write();
				}
				WithConsoleModel.console.write(" | ");
			}
			WithConsoleModel.console.writeln();
		}
		WithConsoleModel.console.writeln("-----------------------------------------------------");
	}

	private Token getToken(TicTacToeCoordinate coordinate) {
		for (Integer i: this.coordinates.keySet()) {
			for (TicTacToeCoordinate coordinate1: this.coordinates.get(i)) {
				if (coordinate1 != null && coordinate1.equals(coordinate)) {
					return Token.values()[i];
				}
			}
		}
//		for (int i = 0; i < Turn.PLAYERS; i++) {
//			for (int j = 0; j < TicTacToeCoordinate.DIMENSION; j++) {
//				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
//						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
//					return Token.values()[i];
//				}
//			}
//		}
		return null;
	}

	void move(TicTacToeCoordinate originCoordinate, TicTacToeCoordinate coordinate) {
		Token token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(TicTacToeCoordinate coordinate, Token token) {
		int i = 0;
		while (this.coordinates[token.ordinal()][i] != null) {
			i++;
		}
		this.coordinates[token.ordinal()][i] = coordinate;
	}

	private void remove(TicTacToeCoordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < TicTacToeCoordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	boolean isTicTacToe(Token token) {
		TicTacToeCoordinate[] coordinates = this.coordinates[token.ordinal()];
		if (this.numberOfCoordinates(coordinates) < TicTacToeCoordinate.DIMENSION) {
			return false;
		}
		if (!coordinates[0].inDirection(coordinates[1])) {
			System.out.println("No est�n en direcci�n");
			return false;
		}
		Direction direction = coordinates[0].getDirection(coordinates[1]);
		for (int i = 1; i < coordinates.length - 1; i++) {
			if (direction != coordinates[i].getDirection(coordinates[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private int numberOfCoordinates(TicTacToeCoordinate[] coordinates) {
		int count = 0;
		for (int i = 0; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

	boolean isCompleted() {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < TicTacToeCoordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmpty(TicTacToeCoordinate coordinate) {
		return this.isOccupied(coordinate, null);
	}

	boolean isOccupied(TicTacToeCoordinate coordinate, Token token) {
		return this.getToken(coordinate) == token;
	}

}
