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
        Integer actorIdToLogIn = credentialsRepository.getActorIdWith512Hash(credentials.getUsername(), credentials.getPassword());
        return login(actorIdToLogIn);
    }

    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse getEmployeeDetailsWithSha256(@RequestBody Credentials credentials) {
        Integer actorIdToLogIn = credentialsRepository.getActorIdWith256Hash(credentials.getUsername(), credentials.getPassword());
        return login(actorIdToLogIn);
    }

    @RequestMapping("/salt")
    @ResponseBody
    public Credentials getSalt(@RequestParam("username") String username) {
        Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setSalt(credentialsRepository.getPasswordSalt(username));
        return credentials;
    }

    private LoginResponse login(Integer actorIdToLogIn) {
        LoginResponse response = new LoginResponse();
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
