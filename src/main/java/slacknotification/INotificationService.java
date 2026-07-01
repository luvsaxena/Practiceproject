package slacknotification;

import slacknotification.message.Message;

public interface INotificationService {

    void sendNotificationToEligibleUsers(String conversationId, Message message);

}

TextNotificationService
GroupChatNotificationService

        StrategyPattern
                DeliverNotificationStrategy
DeliverDMNotificationStrategy, DeliverGroupChatNotificationStrategy DeliverChannelNotificationStrategy

        UserNotificationPrefService


        shouldISendThisNotificationToThisUser