package web.api.accounting;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static web.api.accounting.Vacation.getVacations;
import static web.api.accounting.Work.getWorkHours;

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
    public void reportHours(@RequestBody Work workUnit) {
        //TODO
    }

    @RequestMapping(value = "/requestVacation", method = RequestMethod.POST)
    public void requestVacation(@RequestBody Vacation vacation) {
        //TODO
    }

    @RequestMapping("/reportedHourReview")
    public List<Work> getReportedHoursToReview(@RequestParam(value = "managerId") int id) {
        //TODO
        return getWorkHours();
    }

    @RequestMapping("/requestedVacationReview")
    public List<Vacation> getRequestedVacationsToReview(@RequestParam(value = "managerId") int id) {
        //TODO
        return getVacations();
    }

    @RequestMapping("/vacationTypes")
    public List<String> getVacationTypes() {
        //TODO
        //return vacationTypeRepository.findAll();
        return new ArrayList<>();
    }
}
