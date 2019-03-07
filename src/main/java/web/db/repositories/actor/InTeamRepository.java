package web.db.repositories.actor;

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

    @Query(value = "SELECT team_id FROM in_team WHERE in_team_id=:id", nativeQuery = true)
    int getTeamId(@Param("id")int inTeamId);

    @Query(value = "SELECT in_team_id FROM in_team WHERE iteam_id=:teamId AND actor_id=:id", nativeQuery = true)
    int getInTeamIdByActorAndTeamId(@Param("id")int employeeId, @Param("teamId")int teamId);
}


