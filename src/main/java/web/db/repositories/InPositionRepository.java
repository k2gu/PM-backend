package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.db.datamodel.InPosition;

@Repository
public interface InPositionRepository extends JpaRepository<InPosition, Integer> {
}
