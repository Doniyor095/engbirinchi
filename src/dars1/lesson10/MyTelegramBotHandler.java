package concurency.lesson10;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyTelegramBotHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        String mess = "%s : %s : %s : %s\n".formatted(new Date(), record.getLevel(), Thread.currentThread().getName(), record.getMessage());
        String req = """
                 {
                     "chat_id": "633442276",
                     "text": "%s"
                 }
                """.formatted(mess);

        try {
            HttpClient.newBuilder().build().send(
                    HttpRequest.newBuilder()
                            .header("Content-Type", "application/json")
                            .uri(new URI("https://api.telegram.org/bot7971917611:AAFV_elidXNVGHQbIPIekv0Qd88r3iOY_mQ/sendMessage"))
                            .POST(
                                    HttpRequest.
                                            BodyPublishers
                                            .ofString(req)
                            )
                            .build(),
                    HttpResponse.BodyHandlers
                            .ofString()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //send telegram bot
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
