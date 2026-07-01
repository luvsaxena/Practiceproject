package slacknotification.conversation;

import slacknotification.User;

import java.util.List;

public class Thread extends Conversation{

    List<User> participants;

    List<User> subscribers;

    String parentConversationId;

    public String getThreadId() {
        return conversationId;
    }

    public  boolean shouldSendNotification(){
        return false;
    }


}
