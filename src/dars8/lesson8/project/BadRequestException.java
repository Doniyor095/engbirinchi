package concurency.lesson8.project;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super("Bad request | Caused by :" + message);
    }
}
