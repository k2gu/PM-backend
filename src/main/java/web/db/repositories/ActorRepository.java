package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}

