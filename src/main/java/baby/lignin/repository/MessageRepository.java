package baby.lignin.repository;

import baby.lignin.entity.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<MessageEntity, String> {
    List<MessageEntity> findAllByRoomId(String roomId);
}
