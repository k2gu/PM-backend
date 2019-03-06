package web.api.actor;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse getEmployeeDetails(@RequestBody Credentials credentials) {
        LoginResponse response = new LoginResponse();
        if (credentials.getUsername().equals("admin")) {
            response.setMessage("OK");
            response.setResponseCode(200);
            response.setSessionId("54908324i0ejfiohfjlsfesfe");
            response.setEmployeeId(1);
            response.setIsManager(false);

        } else if (credentials.getUsername().startsWith("a")) {
            response.setMessage("OK");
            response.setResponseCode(200);
            response.setSessionId("mangerid123");
            response.setEmployeeId(225);
            response.setIsManager(true);
        } else {
            response.setMessage("Failed to authenticate the user");
            response.setResponseCode(401);
        }
        return response;
    }
}
