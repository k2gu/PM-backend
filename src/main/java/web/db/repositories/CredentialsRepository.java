package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
    @Query(value = "SELECT actor_id FROM credentials WHERE username=:username AND hash256=:password", nativeQuery = true)
    Integer getActorIdWith256Hash(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT actor_id FROM credentials WHERE username=:username AND hash512=:password", nativeQuery = true)
    Integer getActorIdWith512Hash(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT salt FROM credentials WHERE username=:username", nativeQuery = true)
    String getPasswordSalt(@Param("username") String username);
}
