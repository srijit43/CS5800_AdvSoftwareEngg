package HW6_Java_driver;

import HW6_Java_model.ChatServer;
import HW6_Java_model.Message;
import HW6_Java_model.User;
import java.util.Arrays;
import java.util.Iterator;

public class Question1Driver {
    public static void main(String[] args) {

        ChatServer mediator = new ChatServer();

        User user1 = new User("Srijit Bhattacharya", "srjb", mediator);
        User user2 = new User("Rohan Sen", "rsen", mediator);
        User user3 = new User("Narendra Modi", "namo", mediator);


        // register all the users
        mediator.registerUser(user1);
        mediator.registerUser(user2);
        mediator.registerUser(user3);


        System.out.println("");

        // user two sends message to user1 and user3
        user2.sendMessage("Hi Srijit and Narendra", Arrays.asList(user3, user1));
        // user2 undo the message
        user2.undoMessage();

        System.out.println("");

        // user1 blocks user 3 from sending messages
        user1.blockUser(user3);
        // user 3 sending message to user 1 and 2
        user3.sendMessage("Hello! Srijit and Rohan!", Arrays.asList(user1, user2));
        // user 3 sending message to user 2
        user3.sendMessage("Hello! Rohan I hope everything is fine", Arrays.asList(user2));

        // user 2 sends message to user 1
        user2.sendMessage("Hey! Srijit!, come to Boston?", Arrays.asList(user1));

        System.out.println("");

        // to view chat history of user 3
        System.out.println("Chat History of User 3..");
        mediator.getUserChatHistory(user3.getUserId()).forEach(message -> {
            String[] userList = {""};
            message.getRecipients().forEach(user -> userList[0] = userList[0] + user.getUserName() + ",");
            System.out.println("Message: " + message.getMessageContent() + " , Recipents : " + userList[0]);
        });

        System.out.println("");
        System.out.println("Printing all the message sent and received by the user 3 (Narendra Modi)");
        Iterator<Message> messageIterator = user3.iterator();
        while(messageIterator.hasNext()) {
            System.out.println("(User3) Iterator >> " + messageIterator.next().getMessageContent());
        }

    }

}
