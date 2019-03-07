package web.db.repositories;

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
}
