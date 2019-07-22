package santaTecla.utils;

public abstract class WithConsoleModel {

	protected static Console console;
	
	static {
		WithConsoleModel.console = new Console();
	}
	
}
