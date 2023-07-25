package baby.lignin.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomInfoResponse {
    private String roomId;
    private String name;
    private String workspaceId;
    private String boardId;
    private LocalDateTime updatedAt;
}
