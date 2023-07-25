package baby.lignin.controller;

import baby.lignin.model.request.RoomCreateRequest;
import baby.lignin.model.response.RoomInfoResponse;
import baby.lignin.service.ChatServiceImpl;
import baby.lignin.support.ApiResponse;
import baby.lignin.support.ApiResponseGenerator;
import baby.lignin.support.MessageCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: @RestController 로 수정
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/chat")
public class ChatRoomController {
    private final ChatServiceImpl chatService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms() {
        return "/chat/room";
    }

    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    @Operation(summary = "채팅방 목록 반환", description = "등록된 채팅방을 불러옵니다.")
    public ApiResponse<ApiResponse.SuccessBody<List<RoomInfoResponse>>> room() {
        return ApiResponseGenerator.success(chatService.findAllRoom(), HttpStatus.OK, MessageCode.SUCCESS);
    }

    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    @Operation(summary = "채팅방 생성", description = "채팅방 이름으로 채팅방을 생성합니다.")
    public ApiResponse<ApiResponse.SuccessBody<RoomInfoResponse>> createRoom(@RequestBody RoomCreateRequest request) {
        return ApiResponseGenerator.success(chatService.createRoom(request), HttpStatus.CREATED, MessageCode.RESOURCE_CREATED);
    }

    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    // 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    @Operation(summary = "채팅방 조회", description = "특정 채팅방을 조화합니다.")
    public ApiResponse<ApiResponse.SuccessBody<RoomInfoResponse>> roomInfo(@PathVariable String roomId) {
        return ApiResponseGenerator.success(chatService.findRoomById(roomId), HttpStatus.ACCEPTED, MessageCode.SUCCESS);
    }
}
