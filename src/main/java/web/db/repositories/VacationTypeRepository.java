package web.db.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationTypeRepository extends JpaRepository<String, Integer> {

    @Query(value = "SELECT `Type` FROM vacation_type", nativeQuery = true)
    List<String> getVacationTypes();


    @Query(value = "SELECT vacation_type_id FROM vacation_type WHERE `Type`=:name", nativeQuery = true)
    int getVacationTypIdByName(@Param("name") String name);
}
