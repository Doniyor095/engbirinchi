package concurency.lesson10;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.*;


public class Main {
    static Logger logger = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {

//
//        Properties prop = new Properties();
//        prop.setProperty("java.util.logging.ConsoleHandler.level", "ALL");
//        prop.setProperty(".level", "ALL");
//        System.setProperties(prop);
//        logger.setUseParentHandlers(false);
//        logger.log(Level.FINE, "My fine message");
//        logger.log(Level.INFO, "My info message");
//        logger.log(Level.SEVERE, "My error message");
//        logger.log(Level.ALL, "My all message");
//        logger.log(Level.OFF, "My off message");
//        logger.log(Level.CONFIG, "My config message");
//
//        logger.info("My info message {}");
//        logger.config("My config message");


        fileHandler();

    }


    private static void custom() {
        MyLogHandler myLogHandler = new MyLogHandler();
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.addHandler(myLogHandler);
        logger.log(Level.INFO, "My custom info message");
        logger.log(Level.FINE, "My custom fine message");
    }


    private static void fileHandler() {
        logger.setUseParentHandlers(false);
        //            FileHandler fileHandler = new FileHandler("/Users/macbookpro/Documents/olmossoft/g53_m4/src/concurency/lesson10/app.log", true);
//            MyLogHandler myLogHandler = new MyLogHandler();
//            ConsoleHandler consoleHandler= new ConsoleHandler();
        MyTelegramBotHandler myTelegramBotHandler = new MyTelegramBotHandler();
        myTelegramBotHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(myTelegramBotHandler);
        logger.setLevel(Level.ALL);
        logger.log(Level.INFO, "My custom info message");
        logger.log(Level.FINE, "My custom fine message");

    }
}




