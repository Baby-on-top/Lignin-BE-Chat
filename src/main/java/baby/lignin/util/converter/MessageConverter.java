package baby.lignin.util.converter;

import baby.lignin.entity.MessageEntity;
import baby.lignin.model.ChatMessage;
import baby.lignin.model.response.MessageResponse;
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

    public static MessageResponse from(MessageEntity messageEntity) {
        if (messageEntity == null) {
            return null;
        }

        return MessageResponse.builder().
                sender(messageEntity.getSender()).
                userId(messageEntity.getUserId()).
                profile(messageEntity.getProfile()).
                message(messageEntity.getMessage()).
                createdAt(messageEntity.getCreatedAt()).
                build();
    }
}
