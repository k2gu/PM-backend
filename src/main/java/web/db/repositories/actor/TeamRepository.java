package web.db.repositories.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT name FROM team WHERE team_id=:id", nativeQuery = true)
    String getTeamName(@Param("id") int teamID);

    @Query(value = "SELECT team_id FROM team WHERE name=:name", nativeQuery = true)
    int getTeamId(@Param("name") String name);
}
