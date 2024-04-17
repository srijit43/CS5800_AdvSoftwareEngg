package HW6_Java_model;

import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private User sender;
    private List<User> recipients;
    private LocalDateTime sentTime;
    private String messageContent;

    public Message(User sender, List<User> recipients, LocalDateTime sentTime, String messageContent) {
        this.sender = sender;
        this.recipients = recipients;
        this.sentTime = sentTime;
        this.messageContent = messageContent;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public MessageMento takeSnapshot() {
        return new MessageMento(this.messageContent, this.sentTime);
    }

    public void restoreMessage(MessageMento messageMento) {
        this.messageContent = messageMento.getMessageContent();
        this.sentTime = messageMento.getSentTime();
    }

    public static class MessageMento {
        private LocalDateTime sentTime;
        private String messageContent;

        private MessageMento(String messageContent, LocalDateTime sentTime) {
            this.sentTime = sentTime;
            this.messageContent = messageContent;
        }

        private String getMessageContent() {
            return this.messageContent;
        }

        private LocalDateTime getSentTime() {
            return this.sentTime;
        }
    }
}