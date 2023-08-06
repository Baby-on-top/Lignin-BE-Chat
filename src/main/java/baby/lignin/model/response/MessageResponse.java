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
public class MessageResponse {
    private String sender;
    private String userId;
    private String profile;
    private String message;
    private LocalDateTime createdAt;
}