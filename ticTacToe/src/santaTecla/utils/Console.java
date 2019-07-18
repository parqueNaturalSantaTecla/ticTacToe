package santaTecla.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Console {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = this.bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("characte string");
			}
		} while (!ok);
		return input;
	}

	String readString() {
		return this.readString("");
	}

	int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("integer");
			}
		} while (!ok);
		return input;
	}

	char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("character");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return charValue;
	}

	void writeln() {
		System.out.println();
	}

	void write(String string) {
		System.out.print(string);
	}

	void writeln(String string) {
		System.out.println(string);
	}

	void write(char character) {
		System.out.print(character);
	}

	void writeError(String format) {
		System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
	}

}
