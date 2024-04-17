package HW6_Java_model;

import java.util.*;

public class ChatServer {

    ChatHistory chatHistory = new ChatHistory();
    Map<String, List<User>> blockListByUser = new HashMap<>();
    List<User> userList = new ArrayList<>();

    public void sendMessage(Message message) {
        chatHistory.addMessage(message);
        message.getRecipients().forEach(user -> {
            if (isSenderBlockedByRecipient(message.getSender().getUserId(), user.getUserId())) {
                System.out.println(message.getSender().getUserId() + " (Sender), cannot send message to " + user.getUserId() + ".");
                return;
            }
            // send message
            user.receiveMessage(message.getMessageContent(), message.getSender().getUserId());
        });
    }

    public void blockUser(User requester, User toBeBlocked) {
        if (!blockListByUser.containsKey(requester.getUserId())) {
            blockListByUser.put(requester.getUserId(), new ArrayList<>());
        }
        blockListByUser.get(requester.getUserId()).add(toBeBlocked);
    }

    private boolean isSenderBlockedByRecipient(String senderUserId, String recipient) {
        if (!blockListByUser.containsKey(recipient)) {
            return false;
        }
        // check if the sender is in the blocked list of recipient
        return blockListByUser.get(recipient).stream().anyMatch(user -> user.getUserId().equalsIgnoreCase(senderUserId));
    }

    public void registerUser(User user) {
        if (isRegisteredUser(user.getUserId())) {
            return;
        }
        userList.add(user);
    }

    public void unregisterUser(String userId) {
        userList.removeIf(user -> user.getUserId().equalsIgnoreCase(userId));
    }

    public boolean isRegisteredUser(String userId) {
        return userList.stream().anyMatch(user -> user.getUserId().equalsIgnoreCase(userId));
    }

    public void removeRecentChatHistory() {
        if (chatHistory.chatHistory.isEmpty()){
            return;
        }
        // remove the last chat history
        chatHistory.chatHistory.remove(chatHistory.chatHistory.size() - 1);
    }

    public List<Message> getUserChatHistory(String userId) {
        return chatHistory.getChatHistoryForUser(userId);
    }
}