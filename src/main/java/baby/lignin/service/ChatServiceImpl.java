package baby.lignin.service;

import baby.lignin.entity.MessageEntity;
import baby.lignin.entity.RoomEntity;
import baby.lignin.model.ChatMessage;
import baby.lignin.model.request.RoomCreateRequest;
import baby.lignin.model.response.MessageResponse;
import baby.lignin.model.response.RoomInfoResponse;
import baby.lignin.repository.MessageRepository;
import baby.lignin.repository.RoomRepository;
import baby.lignin.util.converter.MessageConverter;
import baby.lignin.util.converter.RoomConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final RoomRepository roomRepository;
    private final MessageRepository messageRepository;

    public List<RoomInfoResponse> findAllRoom() {
        List<RoomInfoResponse> roomInfoResponses = new ArrayList<>();

        for (RoomEntity roomEntity : roomRepository.findAll()) {
            roomInfoResponses.add(RoomConverter.from(roomEntity));
        }

        Collections.reverse(roomInfoResponses);
        return roomInfoResponses;
    }

    public RoomInfoResponse createRoom(RoomCreateRequest roomCreateRequest) {
        RoomEntity roomEntity = RoomConverter.to(roomCreateRequest);
        roomRepository.save(roomEntity);
        return RoomConverter.from(roomRepository.findByRoomId(roomEntity.getRoomId()));
    }

    public RoomInfoResponse findRoomById(String roomId) {
        return RoomConverter.from(roomRepository.findByRoomId(roomId));
    }

    @Override
    public void saveMessage(ChatMessage message) {
        MessageEntity messageEntity = MessageConverter.to(message);
        messageRepository.save(messageEntity);
    }

    @Override
    public List<MessageResponse> findMessagesById(String roomId) {
        List<MessageResponse> messageResponses = new ArrayList<>();

        for (MessageEntity messageEntity: messageRepository.findAllByRoomId(roomId)) {
            messageResponses.add(MessageConverter.from(messageEntity));
        }
        return messageResponses;
    }

//    public ChannelTopic sendMessage(ChatMessage message) {
//        return chatRoomRepository.getTopic(message.getRoomId());
//    }
//
//    public void enterChatRoom(String roomId) {
//        chatRoomRepository.addChatRoom(roomId);
//    }
}
