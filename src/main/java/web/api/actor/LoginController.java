package web.api.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
    public LoginResponse getEmployeeDetails(@RequestBody Credentials credentials) throws HttpClientErrorException.Unauthorized {
        //TODO Integer actorIdToLogIn = credentialsRepository.getActorIdWith512Hash(credentials.getUsername(), credentials.getPassword());
        Integer actorIdToLogIn = credentialsRepository.getActorIdWithPlainTextPassword(credentials.getUsername(), credentials.getPassword());
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
        if (actorIdToLogIn != null) {
            return constructLoginResponse(actorIdToLogIn);
        } else {

            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Failed to authenticate the user");
        }
    }

    private LoginResponse constructLoginResponse(Integer actorIdToLogIn) {
        LoginResponse response = new LoginResponse();
        //TODO generate sessionID
        response.setSessionId("54908324i0ejfiohfjlsfesfe");
        response.setEmployeeId(actorIdToLogIn);
        response.setName(actorRepository.getEmployeeName(actorIdToLogIn));
        boolean isManager = actorRepository.getActorTypeId(actorIdToLogIn) == 2;
        response.setIsManager(isManager);
        return response;
    }
}
