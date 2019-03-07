package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.WorkUnit;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<WorkUnit, Integer> {

    @Query(value = "SELECT * FROM work_unit WHERE in_position_id=:id", nativeQuery = true)
    List<WorkUnit> getReportedWorkInPosition(@Param("id") int inPositionId);

    @Query(value = "INSERT INTO work_unit (work_type_id, in_position_id, in_team_id, done_date, time_spent, task_number, description) " +
            "VALUES(:work_type_id, :in_position_id, :in_team_id, :date_done, :time_spent, :task_number, :description)", nativeQuery = true)
    void addWorkUnit(@Param("work_type_id") int workTypeId, @Param("in_position_id") int inPositionId, @Param("in_team_id") int inTeamId,
                     @Param("date_done") Date doneDate, @Param("time_spent") double timeSpent, @Param("task_number") String taskNumber,
                     @Param("description") String description);

    //TODO
    @Query(value = "SELECT `Type` FROM work_type WHERE work_type_id=:id", nativeQuery = true)
    String getWorkToReview(@Param("id") int managerId);
}



