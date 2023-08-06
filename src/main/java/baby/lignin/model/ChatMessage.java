package baby.lignin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType {
        ENTER, TALK // 입장, 채팅
    }

    private MessageType type;   // 메시지 타입
    private String roomId;      // 방번호
    private String sender;      // 메시지 보낸 사람
    private String userId;
    private String profile;
    private String message;     // 메시지
}
