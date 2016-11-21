package GravityGolfGame;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BadConfigFormatException extends IOException {
	public BadConfigFormatException() {
		super();
		writeToLog();
	}

	public BadConfigFormatException(String msg) {
		super(msg);
		writeToLog();
	}

	public BadConfigFormatException(String msg, IOException cause) {
		super(msg, cause);
		writeToLog();
	}

	private void writeToLog() {
		try {
			FileWriter fw = new FileWriter("log.txt", true);
			printStackTrace(new PrintWriter(fw));
			fw.close();
		} catch (IOException e) {
			// Well this is ironic, just skip I guess
		}
	}
    
    public BadConfigFormatException(Exception ex) {
        super(ex);
    }
}
