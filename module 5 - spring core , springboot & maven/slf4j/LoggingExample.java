package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    // A logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Log messages at different levels
        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARNING message. Something might be wrong.");
        logger.error("This is an ERROR message. An unexpected error occurred!");

        try {
            int result = 10 / 0; // This will cause an ArithmeticException
        } catch (Exception e) {
            logger.error("An exception occurred during division: {}", e.getMessage(), e);
        }

        logger.info("Logging example finished.");
    }
}
