package web.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.db.datamodel.Message;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT * FROM message WHERE to_actor=:id AND is_read=0", nativeQuery = true)
    List<Message> getActorsMessages(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO message (from_actor, to_actor, message) VALUES (:from, :to, :message)", nativeQuery = true)
    void addMessage(@Param("from") int from, @Param("to") int to, @Param("message") String message);

    @Transactional
    @Modifying
    @Query(value = "UPDATE message SET is_read=true WHERE message_id=:id", nativeQuery = true)
    void removeMessage(@Param("id") int id);
}
