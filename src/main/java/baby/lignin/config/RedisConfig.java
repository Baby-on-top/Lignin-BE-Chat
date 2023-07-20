package baby.lignin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    // redis pub/sub 메시지 처리
    // redis를 경청하고 있다가 메시지 발행(publish)이 오면 listener가 처리한다.
    // RedisMessageListenerContainer : Redis Channel(Topic)로부터 메시지를 받고, 주입된 리스너들에게 비동기적으로 dispatch한다.
    // 발행된 메시지 처리를 위한 listener를 지정한다.
    @Bean
    public RedisMessageListenerContainer redisMessageListener(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }

    // pub/sub 통신에 사용할 RedisTemplate 설정
    // Serializer : Redis 서버에는 bytes 코드만 저장되기 때문에 key, value에 Serializer를 설정해준다.
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));  // Json 포맷으로 메시지를 교환하기 때문에
        return redisTemplate;
    }
}
