package baby.lignin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//@Service
public class RedisPublisher {
    // 메시지를 Redis 서버로 발행한다.
    // 설정한 redisTemplate을 주입하고 발행을 위한 메서드를 구현한다.
    // topic에 구독자(subscriber)가 있는 경우, 발행자(publisher)가 메시지를 발행하면 구독자에게 메시지가 전달된다.
//    private final RedisTemplate<String, Object> redisTemplate;
//
//    public void publish(ChannelTopic topic, ChatMessage message) {
//        redisTemplate.convertAndSend(topic.getTopic(), message);
//    }
}
