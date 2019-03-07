package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Positions;

@Repository
public interface PositionsRepository extends JpaRepository<Positions, Integer> {

   @Query(value = "SELECT position_title FROM position WHERE position_id=:id",
            nativeQuery = true)
    String findPositionName(@Param("id") int id);
}
