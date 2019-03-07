package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Positions;

@Repository
public interface PositionsRepository extends JpaRepository<Positions, Integer> {
}
