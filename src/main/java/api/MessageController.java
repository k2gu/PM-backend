package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static api.Message.getMockedMessagesList;

@RestController
public class MessageController {

    @RequestMapping("/messages")
    public List<Message> getEmployeeMessages(@RequestParam (required = true, value = "id") String id) {
        return getMockedMessagesList();
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMessage() {
        //TODO
    }

    @RequestMapping(value = "/removeMessage", method = RequestMethod.POST)
    public void removeMessage() {
        //TODO
    }
}
