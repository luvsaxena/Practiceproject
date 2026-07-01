package slacknotification;

import slacknotification.conversation.Conversation;

import java.util.List;

public class User {

    String userId;

    List<Conversation> groupChats;

    List<Conversation> channels;
}
