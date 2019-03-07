package web.api.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.api.actor.Client;
import web.api.actor.Team;
import web.db.datamodel.Actor;
import web.db.datamodel.WorkUnit;
import web.db.repositories.VacationRepository;
import web.db.repositories.VacationTypeRepository;
import web.db.repositories.WorkRepository;
import web.db.repositories.WorkTypeRepository;
import web.db.repositories.actor.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AccountingController {
    @Autowired
    WorkRepository workRepository;
    @Autowired
    WorkTypeRepository workTypeRepository;
    @Autowired
    InPositionRepository inPositionRepository;
    @Autowired
    PositionsRepository positionsRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    InTeamRepository inTeamRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    VacationTypeRepository vacationTypeRepository;
    @Autowired
    VacationRepository vacationRepository;

    @RequestMapping("/reportedHours")
    public List<Work> getReportedHours(@RequestParam(value = "id") int employeeId) {
        List<Work> convertedList = new ArrayList<>();
        List<Integer> inPositionIds = inPositionRepository.findInPositionIdByActorId(employeeId);
        for (int inPositionId : inPositionIds) {
            List<web.db.datamodel.WorkUnit> workUnits = workRepository.getReportedWorkInPosition(inPositionId);
            int positionId = inPositionRepository.findPositionIdByInPositionID(inPositionId);
            String positionName = positionsRepository.findPositionName(positionId);
            for (WorkUnit workUnit : workUnits) {
                String workType = workTypeRepository.getWorkTypeName(workUnit.getWorkTypeId());
                int teamId = inTeamRepository.getTeamId(workUnit.getInTeamId());
                String teamName = teamRepository.getTeamName(teamId);
                Actor actorClient = getClientByTeam(teamId);
                Client client = actorClient == null ? null : new Client(actorClient.getActorId(), actorClient.getName());
                convertedList.add(new Work(employeeId, workType, workUnit.getTimeSpent(), new Team(teamName, client),
                        positionName, workUnit.getTasknumber(), workUnit.getDescription()));
            }
        }

        return convertedList;
    }

    private Actor getClientByTeam(int teamID) {
        List<Actor> clientRepresentatives = actorRepository.getClientRepresentatives();
        List<Integer> teamMembers = inTeamRepository.getTeamMembers(teamID);
        for (Actor actor : clientRepresentatives) {
            if (teamMembers.contains(actor.getActorId())) {
                return actor;
            }
        }
        return null;
    }

    @RequestMapping(value = "/reportHours", method = RequestMethod.POST)
    public void reportHours(@RequestBody Work workUnit) {
        List<Integer> inPositionIds = inPositionRepository.findPositionIdByActorId(workUnit.getWorker());

        //TODO kust ma team millises positionis tehtud?
        // int inPositionId = inPositionRepository.findInPositionIdByEmployeeIdAndPositionId(workUnit.getWorker(), correctPositionId);

        int teamId = teamRepository.getTeamId(workUnit.getTeam().getName());
        int inTeamId = inTeamRepository.getInTeamIdByActorAndTeamId(workUnit.getWorker(), teamId);
        int workTypeId = workTypeRepository.getWorkTypeId(workUnit.getCategory());

        workRepository.addWorkUnit(workTypeId, inPositionIds.get(0), inTeamId, stringToDate(workUnit.getDate()), workUnit.getHoursSpent(),
                workUnit.getTaskID(), workUnit.getDescription());
    }

    private Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @RequestMapping(value = "/requestVacation", method = RequestMethod.POST)
    public void requestVacation(@RequestBody Vacation vacation) {
        int vacationTypeId = vacationTypeRepository.getVacationTypIdByName(vacation.getType());

        vacationRepository.addVacation(vacation.getRequester(), vacationTypeId, stringToDate(vacation.getFromDate()),
                stringToDate(vacation.getToDate()), vacation.getDescription());
    }

    @RequestMapping("/requestedVacations")
    public List<Vacation> getRequestedVacations(@RequestParam(value = "id") int id) {
        List<web.db.datamodel.Vacation> vacationsModel = vacationRepository.getEmployeeVacations(id);
        return null;
    }


    @RequestMapping("/vacationTypes")
    public List<String> getVacationTypes() {
        return vacationTypeRepository.getVacationTypes();
    }

    @RequestMapping("/reportedHourReview")
    public List<Work> getReportedHoursToReview(@RequestParam(value = "managerId") int id) {
        //TODO
        return null;
    }

    @RequestMapping("/requestedVacationReview")
    public List<Vacation> getRequestedVacationsToReview(@RequestParam(value = "managerId") int id) {
        //TODO
        return null;
    }
}
