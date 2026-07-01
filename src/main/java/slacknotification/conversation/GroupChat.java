package slacknotification.conversation;

import slacknotification.User;
import slacknotification.message.Message;

import java.util.List;

public class GroupChat extends Conversation{

    List<User> users;

    List<Message> messages;
}
