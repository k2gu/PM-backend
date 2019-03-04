package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static api.Vacation.getVacations;
import static api.Work.getWorkHours;

@RestController
public class AccountingController {

    @RequestMapping("/reportedHours")
    public List<Work> getReportedHours(@RequestParam(value = "id") String id) {
        return getWorkHours();
    }

    @RequestMapping("/requestedVacations")
    public List<Vacation> getRequestedVacations(@RequestParam(value = "id") String id) {
        return getVacations();
    }

    @RequestMapping(value = "/reportHours", method = RequestMethod.POST)
    public void reportHours(@RequestParam(value = "id") String id, @RequestParam(value = "workUnit") Work workUnit) {
        //TODO
    }

    @RequestMapping(value = "/requestVacation", method = RequestMethod.POST)
    public void requestVacation(@RequestParam(value = "id") String id, @RequestParam(value = "workUnit") Vacation vacation) {
        //TODO
    }
}
