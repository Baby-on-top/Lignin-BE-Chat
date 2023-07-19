package baby.lignin.service;

import baby.lignin.model.ChatRoom;
import baby.lignin.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
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
}
