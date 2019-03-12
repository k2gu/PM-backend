package web.api.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.db.repositories.CredentialsRepository;
import web.db.repositories.actor.ActorRepository;

@RestController
public class LoginController {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    CredentialsRepository credentialsRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse getEmployeeDetails(@RequestBody Credentials credentials) {
        LoginResponse response = new LoginResponse();
        Integer actorIdToLogIn = credentialsRepository.getActorId(credentials.getUsername(), credentials.getPassword());
        if (actorIdToLogIn != null) {
            response.setMessage("OK");
            response.setResponseCode(200);
            //TODO generate sessionID
            response.setSessionId("54908324i0ejfiohfjlsfesfe");
            response.setEmployeeId(actorIdToLogIn);
            response.setName(actorRepository.getEmployeeName(actorIdToLogIn));
            boolean isManager = actorRepository.getActorTypeId(actorIdToLogIn) == 2;
            response.setIsManager(isManager);

        } else {
            response.setMessage("Failed to authenticate the user");
            response.setResponseCode(401);
        }
        return response;
    }
}
