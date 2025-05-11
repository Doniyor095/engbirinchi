package lesson10;

import java.io.*;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyLogHandler extends Handler {
    @Override
    public void publish(LogRecord record) {
        try (FileWriter writer = new FileWriter("src/concurency/lesson10/app.log", true)) {
            String mess = "%s : %s : %s : %s\n".formatted(new Date(), record.getLevel(), Thread.currentThread().getName(), record.getMessage());
            writer.write(mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getLevel().intValue() >= Level.ALL.intValue();
    }
}
