package web.db.repositories.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.InPosition;

import java.util.List;

@Repository
public interface InPositionRepository extends JpaRepository<InPosition, Integer> {

    @Query(value = "SELECT position_id FROM in_position WHERE actor_id=:id", nativeQuery = true)
    List<Integer> findPositionIdByActorId(@Param("id") int id);

    @Query(value = "SELECT in_position_id FROM in_position WHERE actor_id=:employeeId AND position_id=:positionId", nativeQuery = true)
    int findInPositionIdByEmployeeIdAndPositionId(@Param("employeeId")int employeeId, @Param("positionId")int positionId);

    @Query(value = "SELECT position_id FROM in_position WHERE in_position_id=:id", nativeQuery = true)
    int findPositionIdByInPositionID(@Param("id") int inPositionId);

    @Query(value = "SELECT in_position_id FROM in_position WHERE actor_id=:id", nativeQuery = true)
    List<Integer> findInPositionIdByActorId(@Param("id") int employeeId);
}
