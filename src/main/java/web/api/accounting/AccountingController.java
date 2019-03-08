package web.api.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.api.actor.Client;
import web.api.actor.Employee;
import web.api.actor.Team;
import web.db.datamodel.Actor;
import web.db.datamodel.InTeam;
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
                Employee employee = getShortVersionEmployeeByActorId(employeeId);
                convertedList.add(new Work(workUnit.getWorkUnitId(), employee, workType, workUnit.getTimeSpent(), new Team(teamName, client),
                        positionName, workUnit.getTasknumber(), workUnit.getDescription()));
            }
        }

        return convertedList;
    }

    private Employee getShortVersionEmployeeByActorId(int actorId) {
        Actor actorEmployee = actorRepository.getOne(actorId);
        return new Employee(actorId, actorEmployee.getName());
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
        List<Integer> inPositionIds = inPositionRepository.findInPositionIdByActorId(workUnit.getWorker().getId());

        //TODO kust ma team millises positionis tehtud?
        // int inPositionId = inPositionRepository.findInPositionIdByEmployeeIdAndPositionId(workUnit.getWorker(), correctPositionId);

        int teamId = teamRepository.getTeamId(workUnit.getTeam().getName());
        int inTeamId = inTeamRepository.getInTeamIdByActorAndTeamId(workUnit.getWorker().getId(), teamId);
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

        vacationRepository.addVacation(vacation.getRequester().getId(), vacationTypeId, stringToDate(vacation.getFromDate()),
                stringToDate(vacation.getToDate()), vacation.getDescription());
    }

    @RequestMapping("/requestedVacations")
    public List<Vacation> getRequestedVacations(@RequestParam(value = "id") int id) {
        List<Vacation> vacations = new ArrayList<>();
        List<web.db.datamodel.Vacation> vacationsModel = vacationRepository.getEmployeeVacations(id);

        for (web.db.datamodel.Vacation vacation : vacationsModel) {
            String type = vacationTypeRepository.getVacationTypeName(vacation.getVacationTypeId());

            Employee requester = getShortVersionEmployeeByActorId(id);
            vacations.add(new Vacation(vacation.getVacationId(),
                    vacation.getReviewerId(),
                    requester,
                    type,
                    vacation.getApproved(),
                    dateToString(vacation.getFromDate()),
                    dateToString(vacation.getToDate()),
                    vacation.getDescription()));
        }

        return vacations;
    }


    private String dateToString(Date date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    @RequestMapping("/vacationTypes")
    public List<String> getVacationTypes() {
        return vacationTypeRepository.getVacationTypes();
    }

    @RequestMapping("/reportedHourReview")
    public List<Work> getReportedHoursToReview(@RequestParam(value = "managerId") int id) {
        List<Work> workToReview = new ArrayList<>();
        List<Actor> mySubordinates = actorRepository.getSubordinates(id);
        for (Actor actor : mySubordinates) {
            List<Integer> inPositionIds = inPositionRepository.findInPositionIdByActorId(actor.getActorId());
            for (int inPositionId : inPositionIds) {
                List<web.db.datamodel.WorkUnit> workUnits = workRepository.getReportedWorkInPositionToReview(inPositionId);
                int positionId = inPositionRepository.findPositionIdByInPositionID(inPositionId);
                String positionName = positionsRepository.findPositionName(positionId);
                for (WorkUnit workUnit : workUnits) {
                    String workType = workTypeRepository.getWorkTypeName(workUnit.getWorkTypeId());
                    int teamId = inTeamRepository.getTeamId(workUnit.getInTeamId());
                    String teamName = teamRepository.getTeamName(teamId);
                    Actor actorClient = getClientByTeam(teamId);
                    Client client = actorClient == null ? null : new Client(actorClient.getActorId(), actorClient.getName());
                    Employee employee = getShortVersionEmployeeByActorId(actor.getActorId());
                    workToReview.add(new Work(workUnit.getWorkUnitId(), employee, positionName, workUnit.getTimeSpent(), new Team(teamName, client),
                            workType, workUnit.getTasknumber(), workUnit.getDescription()));
                }
            }
        }

        return workToReview;
    }

    @RequestMapping("/requestedVacationReview")
    public List<Vacation> getRequestedVacationsToReview(@RequestParam(value = "managerId") int id) {
        List<Vacation> vacations = new ArrayList<>();
        List<Actor> mySubordinates = actorRepository.getSubordinates(id);
        for (Actor subordinate : mySubordinates) {
            List<web.db.datamodel.Vacation> vacationsModel = vacationRepository.getEmployeeVacationsToReview(subordinate.getActorId());
            for (web.db.datamodel.Vacation vacation : vacationsModel) {
                String vacationType = vacationTypeRepository.getVacationTypeName(vacation.getVacationTypeId());
                Actor actorEmployee = actorRepository.getOne(vacation.getRequestedByActor());
                Employee requester = new Employee(actorEmployee.getActorId(), actorEmployee.getName(), null, getTeams(actorEmployee.getActorId()),
                        actorEmployee.getScore(), actorEmployee.getIdentificator(), actorEmployee.getIban());
                vacations.add(new Vacation(vacation.getVacationId(), requester, vacationType,
                        dateToString(vacation.getFromDate()), dateToString(vacation.getToDate()), vacation.getDescription()));
            }
        }
        return vacations;
    }

    private List<Team> getTeams(int actorId) {
        List<InTeam> teamsModel = inTeamRepository.getInTeamByActorId(actorId);
        List<Team> teams = new ArrayList<>();
        for (InTeam inTeam : teamsModel) {
            String teamName = teamRepository.getTeamName(inTeam.getTeamId());
            Actor clientActor = getClientByTeam(inTeam.getTeamId());
            Client client = new Client(clientActor.getActorId(), clientActor.getName(), clientActor.getIdentificator(), clientActor.getScore());
            teams.add(new Team(teamName, client));
        }
        return teams;
    }

    @RequestMapping("/addActionToVacation")
    public void addActionToVacation(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "approved") boolean isApproved,
                                    @RequestParam(value = "vacationId") int vacationId) {
        vacationRepository.addActionToVacation(id, isApproved, vacationId);
    }

    @RequestMapping("/addActionToWorkUnit")
    public void addActionToWorkUnit(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "approved") boolean isApproved,
                                    @RequestParam(value = "workUnitId") int workId) {
        workRepository.addActionToWork(id, isApproved, workId);
    }

    @RequestMapping("/workCategories")
    public List<String> getWorkCategories() {
        return workTypeRepository.getWorkTypeNames();
    }
}
