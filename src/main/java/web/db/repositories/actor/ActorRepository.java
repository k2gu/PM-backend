package web.db.repositories.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query(value = "SELECT * FROM actor WHERE actor_type_id=1 OR actor_type_id=2",
            nativeQuery = true)
    List<Actor> getAllEmployees();

    @Query(value = "SELECT * FROM actor WHERE actor_type_id=3", nativeQuery = true)
    List<Actor> getClientRepresentatives();

    @Query(value = "SELECT * FROM actor WHERE reports_to_actor_id=:id", nativeQuery = true)
    List<Actor> getSubordinates(@Param("id") int managerId);

    @Query(value = "SELECT actor_name FROM actor WHERE actor_id=:id", nativeQuery = true)
    String getEmployeeName(@Param("id") int id);
}

