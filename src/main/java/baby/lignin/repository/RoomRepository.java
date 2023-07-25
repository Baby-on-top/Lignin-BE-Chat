package baby.lignin.repository;

import baby.lignin.entity.RoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<RoomEntity, String> {
    RoomEntity findByRoomId (String roomId);
}
