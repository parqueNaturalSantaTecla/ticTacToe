package ticTacToe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import santaTecla.utils.WithConsoleModel;
import santaTecla.utils.YesNoDialog;

abstract class TicTacToe extends WithConsoleModel {
	
	private static final String EXTENSION = ".ttt";

	private static final String DIRECTORY = "/Users/Tamara/git/ticTacToe/partidas";

	private static File directory;
	
	private String gameName;

	static {
		TicTacToe.directory = new File(TicTacToe.DIRECTORY);
	}

	private Board board;

	protected Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Coordinate.DIMENSION];
		this.createPlayers(this.board);
		this.turn = new Turn(this.players);
	}

	protected abstract void createPlayers(Board board);

	protected void play() {
		this.console.writeln("----- TIC TAC TOE -----");
		this.board.draw();
		boolean newGame = new YesNoDialog().read("Do you want to start a new game?");
		if (!newGame) {
			console.writeln("These are all the saved games:");
			for (int i = 0; i < TicTacToe.directory.list().length; i++) {
				console.writeln(TicTacToe.directory.list()[i]);
			}
			int game = console.readInt("Which one do you want to open?");
			this.load(TicTacToe.directory.list()[game-1]);
			this.playGame();
		} else {
			this.playGame();
		}
		boolean saveGame = new YesNoDialog().read("Do you want to save the game?");
		if (saveGame) {
			for (int i = 0; i < TicTacToe.directory.list().length; i++) {
				console.writeln(TicTacToe.directory.list()[i]);
			}
			int game = console.readInt("Which one do you want to open?");
			this.load(TicTacToe.directory.list()[game-1]);
			this.playGame();
		}
	}
	
	protected void playGame() {
		do {
			if (!this.board.isCompleted()) {
				this.turn.put();
			} else {
				this.turn.move();
			}
			this.board.draw();
		} while (!this.board.isTicTacToe(this.turn.getToken()));
		this.console.writeln("You win!!! :-)");
	}

	private void load(String name) {
		this.gameName = name;
		File file = new File(TicTacToe.directory, this.gameName);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.turn.setValue(Integer.parseInt(bufferedReader.readLine()));
			this.board.load(bufferedReader);
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}