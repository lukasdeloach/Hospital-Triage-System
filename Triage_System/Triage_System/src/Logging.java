
/**
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
import java.io.IOException;
import java.util.logging.*;
import java.util.logging.Level;

public class Logging {

    static Logger logger;
    public Handler fileHandler;
    Formatter plainText;

    private Logging() throws IOException {
        // instance the logger
        logger = Logger.getLogger(Logging.class.getName());
        // instance the filehandler
        fileHandler = new FileHandler("myLog.txt", true);
        // instance formatter, set formatting, and handler
        plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);

    }

    private static Logger getLogger() {
        if (logger == null) {
            try {
                new Logging();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }

    /**
     * This method is used to log the important movements of the User, most of these
     * are used in the ForumGUI when admitting a patient
     * 
     * @param level
     * @param msg
     */
    public static void log(Level level, String msg) {
        getLogger().log(level, msg);
        System.out.println(msg);
    }
}