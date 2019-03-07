package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.db.datamodel.InTeam;

@Repository
public interface InTeamRepository extends JpaRepository<InTeam, Integer> {
}


