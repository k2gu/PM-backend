package web.api.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.db.repositories.MessagesRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MessageController {
    @Autowired
    MessagesRepository messagesRepository;

    @RequestMapping("/messages")
    public List<Message> getEmployeeMessages(@RequestParam(value = "id") int id) {
        List<Message> messageList = new ArrayList<>();
        List<web.db.datamodel.Message> messagesData = messagesRepository.getActorsMessages(id);
        for (web.db.datamodel.Message message : messagesData) {
            messageList.add(new Message(message.getMessageId(), message.getToActorId(), message.getFromActorId(),
                    message.getTimeStampString(), message.getMessage()));
        }
        return messageList;
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMessage(Message message) {
        messagesRepository.addMessage(message.getFrom(), message.getTo(), message.getMessage());
    }

    @RequestMapping(value = "/removeMessage")
    public void removeMessage(@RequestParam(value = "id") int messageId) {
        messagesRepository.removeMessage(messageId);
    }
}
