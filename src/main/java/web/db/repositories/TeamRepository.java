package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
