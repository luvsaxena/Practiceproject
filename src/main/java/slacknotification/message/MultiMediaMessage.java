package slacknotification.message;

public class MultiMediaMessage extends Message {

    String mediaUrl;

    @Override
    public String getMessageType() {
        return MessageType.MULTIMEDIA.name();
    }
}
