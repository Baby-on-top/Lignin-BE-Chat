package baby.lignin.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateRequest {
    private String name;
    // TODO: workspaceId, boardId, userId 추가
}
