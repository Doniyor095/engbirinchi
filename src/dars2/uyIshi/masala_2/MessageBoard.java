package dars2.uyIshi.masala_2;

public class MessageBoard {
    private String latestMessage = "";
    private boolean isActive = true;


    public void writeMessage(String message) {
        latestMessage = message;
    }

    public String readMessage() {
        return latestMessage;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
