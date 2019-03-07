package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query(value = "SELECT * FROM actor WHERE actor_type_id=1 OR actor_type_id=2",
            nativeQuery = true)
    public List<Actor> getAllEmployees();


    @Query(value = "SELECT * FROM actor WHERE actor_type_id=3", nativeQuery = true)
    List<Actor> getClientRepresentatives();
}

