# Refactoring 
- Fix the provided code to compile and run it.
  > Need to fix the toUserMessageMap method of the MessageHelper class
- Refactor the UserMessageService class and provide how to improve

Code:

```java
// - Fix the provided code to compile and run it.
//  > Need to fix the toUserMessageMap method of the MessageHelper class
//- Refactor the UserMessageService class and  the toUserMessageMap method of the MessageHelper class

import java.util.*;
import java.util.stream.Collectors;

public class RefactoringMain {

    public static void main(String[] args) {
        UserMessageService service = new UserMessageService((map) -> {
        });
        service.setEmailSender((map) -> {
        });

        var userIds = Arrays.asList("1", null, "2", "1");
        String topicName = "Security Alert";
        String messageText = "Home is disarmed";

        service.sendMessage(userIds, topicName, messageText);
    }
}

interface FeedSender {
    void sendFeeds(Map<String, MessageDetails> userMessageMap);
}

interface EmailSender {
    void sendEmail(Map<String, MessageDetails> userMessageMap);
}

// Refactor class below
class UserMessageService {
    static boolean feedEnabled = true;
    FeedSender feedSender;
    EmailSender emailSender;
    
    public void sendMessage(List<String> userIds, String topicName, String message) {
        MessageHelper INSTANCE = MessageHelper.getInstance();
        Map<String, MessageDetails> userMessageMap = INSTANCE.toUserMessageMap(userIds, topicName, message);

        if (feedEnabled)
            sendFeeds(userMessageMap);
        else
            sendEmail(userMessageMap);
    }

    private void sendFeeds(Map<String, MessageDetails> userMessageMap) {
        feedSender.sendFeeds(userMessageMap);
    }

    private void sendEmail(Map<String, MessageDetails> userMessageMap) {
        emailSender.sendEmail(userMessageMap);
    }

    public UserMessageService(FeedSender feedSender) {
        this.feedSender = feedSender;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
}

class MessageHelper {
    private MessageHelper() {
    }

    public static MessageHelper getInstance() {
        return new MessageHelper();
    }

    // FIX ME
    public static Map<String, MessageDetails> toUserMessageMap(List<String> userIds, String topicName, String msg) {

        Map<String, MessageDetails> userIdAliasMap = userIds.stream()
                .flatMap(id -> {
                    MessageDetails message = new MessageDetails(topicName, msg);
                    UserMessage userMessage = new UserMessage(id, message);
                    return userMessage;
                })
                .collect(
                        Collectors.toMap(
                                u -> u.getUserId(),
                                u2 -> {
                                    return u2.getMessageDetails();
                                }
                        ));

        if (userIdAliasMap == null) {
            return Collections.emptyMap();
        }

        return userIdAliasMap;
    }

    static class UserMessage {

        private String userId;
        private MessageDetails messageDetails;

        public UserMessage(String userId, MessageDetails messageDetails) {
            this.userId = userId;
            this.messageDetails = messageDetails;
        }

        public MessageDetails getMessageDetails() {
            return messageDetails;
        }

        public String getUserId() {
            return userId;
        }
    }
}

class MessageDetails {
    private final String topic;
    private final String msgContent;

    MessageDetails(String topic, String msgContent) {
        this.topic = topic;
        this.msgContent = msgContent;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public String getTopic() {
        return topic;
    }
}

```