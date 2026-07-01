package slacknotification.conversation;

import slacknotification.User;
import slacknotification.message.Message;

import java.util.List;

public class Channel extends Conversation{

    List<User> users;

    List<Message> messages;

    boolean isPrivate;
}
