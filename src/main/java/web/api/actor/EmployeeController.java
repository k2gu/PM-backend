package web.api.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.db.datamodel.*;
import web.db.datamodel.Position;
import web.db.repositories.actor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    PositionsRepository positionsRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    InPositionRepository inPositionRepository;
    @Autowired
    InTeamRepository inTeamRepository;

    @RequestMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return convertActorToEmployee(actorRepository.getAllEmployees());
    }

    private List<Employee> convertActorToEmployee(List<Actor> allEmployees) {
        List<Employee> employees = new ArrayList<>();
        for (Actor actor : allEmployees) {
            int id = actor.getActorId();
            String positionName = getPositionName(id);
            web.api.actor.Position position = new web.api.actor.Position(positionName);
            Employee employee = new Employee(actor.getActorId(), actor.getName(), position, null, actor.getScore(), actor.getIdentificator(), actor.getIban());
            employees.add(employee);
        }
        return employees;
    }

    @RequestMapping("/mySubordinates")
    public List<Employee> getMySubordinates(@RequestParam("id") int managerId) {
        return convertActorToEmployee(actorRepository.getSubordinates(managerId));
    }

    private String getPositionName(int id) {
        List<Integer> positionIds = inPositionRepository.findPositionIdByActorId(id);
        //TODO kui on mitu positionit
        return positionsRepository.findPositionName(positionIds.get(0));
    }

    @RequestMapping("/employeeDetails")
    public Employee getEmployeeDetails(@RequestParam(required = true, value = "id") int id) {
        Actor actor = actorRepository.getOne(id);
        String positionName = getPositionName(id);
        List<Integer> positionIds = inPositionRepository.findPositionIdByActorId(id);
        Position position = positionsRepository.getPositionById(positionIds.get(0));
        web.api.actor.Position convertedPosition = new web.api.actor.Position(positionName, position.getPricePerHour(),
                position.getSalaryCoef());
        List<InTeam> team = inTeamRepository.getInTeamByActorId(id);
        List<web.api.actor.Team> convertedTeam = addTeamNamesToTeam(team);
        return new Employee(actor.getActorId(), actor.getName(), convertedPosition, convertedTeam,
                actor.getScore(), actor.getIdentificator(), null);
    }

    private List<web.api.actor.Team> addTeamNamesToTeam(List<InTeam> team) {
        List<web.api.actor.Team> convertedTeams = new ArrayList<>();
        for (InTeam team1 : team) {
            String name = teamRepository.getTeamName(team1.getTeamId());
            Actor client = getClientByTeam(team1.getTeamId());
            Client convertedClient = client == null ? null : new Client(client.getActorId(), client.getName(),
                    client.getIdentificator(), client.getScore());
            convertedTeams.add(new web.api.actor.Team(name, convertedClient));
        }
        return convertedTeams;
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

    @RequestMapping(value = "/rateEmployee", method = RequestMethod.POST)
    public void setEmployeeRating(@RequestBody Map<Employee, Double> employeeScore) {
        //TODO
    }

    @RequestMapping(value = "/editDetails", method = RequestMethod.POST)
    public void editEmplpoyeeDetails(@RequestBody Employee employee) {
        //TODO
    }
}
