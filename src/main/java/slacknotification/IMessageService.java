package slacknotification;

import slacknotification.message.Message;

public interface IMessageService {

    void sendMessage(String fromUserId, String conversationId, Message message);

}
