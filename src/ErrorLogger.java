import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ErrorLogger {

    private static final Logger logger = Logger.getLogger("NumbersLogger");

    static void setUpErrorLogFile(File errorLogFile) {
        try {
            System.setErr(new PrintStream(new FileOutputStream(errorLogFile)));
        }
        catch (IOException ioe) {
            System.setErr(System.err);
        }
    }

    static void logError(NumbersException ne) {
        logger.log(Level.SEVERE, ne.toString() + "\n", ne);
    }
}
