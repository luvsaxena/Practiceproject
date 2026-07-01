package slacknotification.conversation;

public abstract class Conversation {

    String conversationId;

    public  boolean shouldSendNotification(){
        return true;
    }

    public void addMessage(Message message){

    }
}
