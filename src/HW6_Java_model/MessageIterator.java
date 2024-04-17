package HW6_Java_model;

import java.util.Iterator;
import java.util.List;

public class MessageIterator implements Iterator<Message> {

    private List<Message> specificUserMessage;
    private Iterator<Message> buffer;
    public MessageIterator(List<Message> messages) {
        this.specificUserMessage = messages;
        buffer = messages.iterator();
    }

    @Override
    public boolean hasNext() {
        return buffer.hasNext();
    }

    @Override
    public Message next() {
        Message currentMessage = buffer.next();
        return currentMessage;
    }
}