package HW6_Java_model;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class User implements IterableByUser {
    private String userName;
    private String userId;

    private ChatServer mediator;

    private Message messageBuffer;
    Stack<Message.MessageMento> messageMentos = new Stack<>();

    public User(String name, String userId, ChatServer mediator) {
        this.userId = userId;
        this.userName = name;
        this.mediator = mediator;
    }

    public void setMediator(ChatServer mediator) {
        this.mediator = mediator;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void blockUser(User user) {
        mediator.blockUser(this, user);
    }

    public void sendMessage(String messageContent, List<User> recipients) {
        messageBuffer = new Message(this, recipients, LocalDateTime.now(), messageContent);
        mediator.sendMessage(messageBuffer);
        // memtos pattern
        messageMentos.add(messageBuffer.takeSnapshot());
    }

    public void undoMessage() {
        if (messageMentos.isEmpty()) {
            System.out.println(userId + " has no message to Undo");
            return;
        }
        mediator.removeRecentChatHistory();
        Message.MessageMento lastMessage = messageMentos.pop();
        messageBuffer.restoreMessage(lastMessage);
        System.out.println(userId + " undid message: " + messageBuffer.getMessageContent());
    }

    public void receiveMessage(String messageContent, String senderId) {
        System.out.println("Message from " + senderId + " is received by " + this.userId + ". Message is " + messageContent);
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return mediator.chatHistory.iterator(userToSearchWith);
    }

    public Iterator<Message> iterator() {
        return this.iterator(this);
    }
}