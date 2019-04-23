import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {


    Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void testSlf4j() {


        logger.info("start application.");

        // print internal state
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
//        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//        loggerContext.stop();
        logger.info("Exiting application.");
    }

}
