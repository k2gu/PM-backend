package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Vacation;

import java.util.Date;
import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Integer> {

    @Query(value = "INSERT INTO message (requested_by_actor_id, vacation_type_id, from_date, to_date, description) " +
            "VALUES (:requester_id, :vacation_type_id, :from_date, :to_date, :description)", nativeQuery = true)
    void addVacation(@Param("requester_id") int id, @Param("vacation_type_id") int vacation_type_id, @Param("from_date") Date from_date,
                     @Param("to_date") Date to_date, @Param("description") String description);

    @Query(value = "SELECT * FROM vacation WHERE requested_by_actor_id=:id", nativeQuery = true)
    List<Vacation> getEmployeeVacations(@Param("id") int id);
}
