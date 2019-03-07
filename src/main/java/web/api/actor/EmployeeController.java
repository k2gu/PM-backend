package web.api.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.db.datamodel.Actor;
import web.db.datamodel.ActorType;
import web.db.datamodel.InPosition;
import web.db.datamodel.Positions;
import web.db.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ActorTypeRepository actorTypeRepository;
    @Autowired
    PositionsRepository positionsRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    InPositionRepository inPositionRepository;
    @Autowired
    InTeamRepository inTeamRepository;

    @RequestMapping("/types")
    public List<ActorType> actorTypes() {
        return actorTypeRepository.findAll();
    }

    @RequestMapping("/employee")
    public List<Actor> employee() {
        return actorRepository.findAll();
    }

    @RequestMapping("/positions")
    public List<Positions> positions() {
        return positionsRepository.findAll();
    }

    @RequestMapping("/teams")
    public List<web.db.datamodel.Team> teams() {
        return teamRepository.findAll();
    }

    @RequestMapping("/inpositions")
    public List<InPosition> inPosition() {
        return inPositionRepository.findAll();
    }

    @RequestMapping("/inteams")
    public List<web.db.datamodel.InTeam> inTeam() {
        return inTeamRepository.findAll();
    }




    @RequestMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return getEmployees();
    }

    @RequestMapping("/employeeDetails")
    public Employee getEmployeeDetails(@RequestParam(required = true, value = "id") String id) {
        //TODO get employee by id
        Position myPosition = new Position(Position.JobTitle.SOFTWARE_ENGINEER, 100.0, 0.1);
        Position messagerPosition = new Position(Position.JobTitle.MANAGER, 200.0, 0.2);
        Client client = new Client("I am a .Client", "businessNumber", 99.8);
        Team team = new Team("web.api.actor.Team name", null, client);
        Employee employee = new Employee(1, "Employee Name Me", myPosition, team,
                65.9, "SSN58390384082", "IBAN4890859084504938054");
        return employee;
    }

    @RequestMapping(value = "/rateEmployee", method = RequestMethod.POST)
    public void setEmployeeRating(@RequestBody Map<Employee, Double> employeeScore) {
        //TODO
    }

    private List<Employee> getEmployees() {
        List<Employee> employeesList = new ArrayList<>();

        Position myPosition = new Position(Position.JobTitle.SOFTWARE_ENGINEER, 100.0, 0.1);
        Position messagerPosition = new Position(Position.JobTitle.MANAGER, 200.0, 0.2);
        Client client = new Client("I am a Client", "businessNumber", 99.8);
        Team team = new Team("web.api.actor.Team name", null, client);
        Employee employee1 = new Employee(1, "Employee Name Me", myPosition, team,
                65.9, "SSN58390384082", "IBAN4890859084504938054");
        Employee employee2 = new Employee(2, "Employee Name Messager", messagerPosition, team,
                70.8, "SSN94085904", "IBANk484853905854389053");
        for (int i = 0; i < 10; i++) {
            employee1.setId(100 + i);
            employee2.setId(200 + i);
            employeesList.add(employee1);
            employeesList.add(employee2);
        }
        return employeesList;
    }
}
