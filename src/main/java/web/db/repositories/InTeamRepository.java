package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.InTeam;

import java.util.List;

@Repository
public interface InTeamRepository extends JpaRepository<InTeam, Integer> {

    @Query(value = "SELECT * FROM in_team WHERE actor_id=:id", nativeQuery = true)
    List<InTeam> getTeamByActorId(@Param("id") int id);

    @Query(value = "SELECT actor_id FROM in_team WHERE team_id=:id", nativeQuery = true)
    List<Integer> getTeamMembers(@Param("id") int teamID);
}


