package baby.lignin.controller;

import baby.lignin.model.ChatMessage;
import baby.lignin.service.ChatService;
import baby.lignin.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

// TODO : @RestController 수정
@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
//            chatService.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다");
        }
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//        redisPublisher.publish(chatService.sendMessage(message), message);
    }
}
