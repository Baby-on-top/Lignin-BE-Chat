package baby.lignin.service;

import baby.lignin.model.ChatMessage;
import baby.lignin.model.request.RoomCreateRequest;
import baby.lignin.model.response.RoomInfoResponse;

import java.util.List;

public interface ChatService {
    List<RoomInfoResponse> findAllRoom();

    RoomInfoResponse createRoom(RoomCreateRequest roomCreateRequest);

    RoomInfoResponse findRoomById(String roomId);

    void saveMessage(ChatMessage message);
}
