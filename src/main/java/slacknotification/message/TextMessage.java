package slacknotification.message;

public class TextMessage extends Message {

    String text;

    @Override
    public String getMessageType() {
        return MessageType.TEXT.name();
    }
}
