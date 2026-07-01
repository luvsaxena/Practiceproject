package slacknotification.message;

public abstract class Message {

    String messageId;

    String conversationId;

    String threadId;

    MessageType messageType;

    public abstract String getMessageType();

}
