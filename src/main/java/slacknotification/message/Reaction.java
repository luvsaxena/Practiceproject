package slacknotification.message;

public class Reaction extends Message {
    @Override
    public String getMessageType() {
        return MessageType.REACTION.name();
    }
}
