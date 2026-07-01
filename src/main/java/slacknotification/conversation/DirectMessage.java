package slacknotification.conversation;

import slacknotification.message.Message;

import java.util.List;

public class DirectMessage extends Conversation{

    String fromUserId;

    String toUserId;

    List<Message> messages;
}
