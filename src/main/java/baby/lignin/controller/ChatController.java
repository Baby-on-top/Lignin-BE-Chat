package baby.lignin.controller;

import baby.lignin.model.ChatMessage;
import baby.lignin.service.ChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

// TODO : @RestController 수정
@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatServiceImpl chatServiceImpl;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
//            chatService.enterChatRoom(message.getRoomId());
        }
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        chatServiceImpl.saveMessage(message);
//        redisPublisher.publish(chatService.sendMessage(message), message);
    }
}
