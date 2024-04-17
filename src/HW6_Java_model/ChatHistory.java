package HW6_Java_model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChatHistory implements IterableByUser {
    List<Message> chatHistory = new ArrayList<>();

    public void addMessage(Message message) {
        this.chatHistory.add(message);
    }

    public Message getRecentSentMessage() {
        if (chatHistory.isEmpty()) {
            return null;
        }
        return chatHistory.get(chatHistory.size() - 1);
    }

    public List<Message> getChatHistoryForUser(String userId) {
        return chatHistory.stream()
                .filter(message -> message.getSender().getUserId().equalsIgnoreCase(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        List<Message> allMessagesSentByTheUser = chatHistory.stream()
                .filter(message -> message.getSender().getUserId().equalsIgnoreCase(userToSearchWith.getUserId()))
                .collect(Collectors.toList());
        List<Message> allMessagesReceivedByTheUser = chatHistory.stream()
                .filter(message -> message.getRecipients().stream().anyMatch(user -> user.getUserId().equalsIgnoreCase(userToSearchWith.getUserId())))
                .collect(Collectors.toList());
        // merge
        allMessagesSentByTheUser.addAll(allMessagesReceivedByTheUser);
        return new MessageIterator(allMessagesSentByTheUser);
    }
}