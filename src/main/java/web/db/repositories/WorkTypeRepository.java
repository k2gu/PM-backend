package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.WorkType;

import java.util.List;

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkType, Integer> {

    @Query(value = "SELECT `Type` FROM work_type WHERE work_type_id=:id", nativeQuery = true)
    String getWorkTypeName(@Param("id") int typeId);

    @Query(value = "SELECT work_type_id FROM work_type WHERE `Type`=:category", nativeQuery = true)
    int getWorkTypeId(@Param("category") String category);

    @Query(value = "SELECT `Type` FROM work_type", nativeQuery = true)
    List<String> getWorkTypeNames();
}
