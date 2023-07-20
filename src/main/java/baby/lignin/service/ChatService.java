package baby.lignin.service;

import baby.lignin.model.ChatMessage;
import baby.lignin.model.ChatRoom;
import baby.lignin.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAllRoom() {
        return chatRoomRepository.findAllRoom();
    }

    public ChatRoom createRoom(String name) {
        return chatRoomRepository.createChatRoom(name);
    }

    public ChatRoom findById(String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }

    public ChannelTopic sendMessage(ChatMessage message) {
        return chatRoomRepository.getTopic(message.getRoomId());
    }

    public void enterChatRoom(String roomId) {
        chatRoomRepository.addChatRoom(roomId);
    }
}
