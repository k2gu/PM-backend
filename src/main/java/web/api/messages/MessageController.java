package web.api.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.api.actor.Employee;
import web.db.datamodel.Actor;
import web.db.repositories.MessagesRepository;
import web.db.repositories.actor.ActorRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MessageController {
    @Autowired
    MessagesRepository messagesRepository;
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/messages")
    public List<Message> getEmployeeMessages(@RequestParam(value = "id") int id) {
        List<Message> messageList = new ArrayList<>();
        List<web.db.datamodel.Message> messagesData = messagesRepository.getActorsMessages(id);
        for (web.db.datamodel.Message message : messagesData) {
            Actor sender = actorRepository.getOne(message.getFromActorId());
            Employee senderEmployee = new Employee(sender.getActorId(), sender.getName());
            messageList.add(new Message(message.getMessageId(), message.getToActorId(), senderEmployee,
                    message.getTimeStampString(), message.getMessage()));
        }
        return messageList;
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMessage(@RequestBody Message message) {
        messagesRepository.addMessage(message.getFrom().getId(), message.getTo(), message.getMessage());
    }

    @RequestMapping(value = "/removeMessage")
    public void removeMessage(@RequestParam(value = "id") int messageId) {
        messagesRepository.removeMessage(messageId);
    }
}
