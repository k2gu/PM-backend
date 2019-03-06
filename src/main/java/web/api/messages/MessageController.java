package web.api.messages;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static web.api.messages.Message.getMockedMessagesList;

@RestController
public class MessageController {

    @RequestMapping("/messages")
    public List<Message> getEmployeeMessages(@RequestParam(required = true, value = "id") String id) {
        return getMockedMessagesList();
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMessage() {
        //TODO
    }

    @RequestMapping(value = "/removeMessage", method = RequestMethod.POST)
    public void removeMessage(@RequestBody Message message) {
        //TODO
    }
}
