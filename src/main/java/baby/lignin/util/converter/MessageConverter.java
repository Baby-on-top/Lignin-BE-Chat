package baby.lignin.util.converter;

import baby.lignin.entity.MessageEntity;
import baby.lignin.model.ChatMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageConverter {
    public static MessageEntity to(ChatMessage message) {
        return MessageEntity.builder().
                roomId(message.getRoomId()).
                sender(message.getSender()).
                profile(message.getProfile()).
                message(message.getMessage()).
                userId(message.getUserId()).
                build();
    }
}
