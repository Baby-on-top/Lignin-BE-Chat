package baby.lignin.util.converter;

import baby.lignin.entity.RoomEntity;
import baby.lignin.model.request.RoomCreateRequest;
import baby.lignin.model.response.RoomInfoResponse;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

@UtilityClass
public class RoomConverter {
    public static RoomEntity to(RoomCreateRequest roomCreateRequest) {
        // TODO : 생성된 randomRoomId 중복검사
        String randomRoomId = RandomStringUtils.randomAlphanumeric(8).toString();
        return RoomEntity.builder()
                .roomId(randomRoomId)
                .name(roomCreateRequest.getName())
                .build();
    }

    public static RoomInfoResponse from(RoomEntity roomEntity) {
        if (roomEntity == null) {
            return null;
        }

        return RoomInfoResponse.builder().
                roomId(roomEntity.getRoomId()).
                name(roomEntity.getName()).
                workspaceId(roomEntity.getWorkspaceId()).
                boardId(roomEntity.getBoardId()).
                updatedAt(roomEntity.getUpdatedAt()).
                build();
    }
}
