package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.db.datamodel.ActorType;

@Repository
public interface ActorTypeRepository extends JpaRepository<ActorType, Integer> {

}
