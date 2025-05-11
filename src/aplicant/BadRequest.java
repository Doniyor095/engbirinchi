package aplicant;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super("Bad requast" + message);
    }
}
