package baby.lignin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("message")
public class MessageEntity {
    @Id
    private String _id;

    @Field("room_id")
    private String roomId;

    @Field("sender")
    private String sender;

    @Field("user_id")
    private String userId;

    @Field("message")
    private String message;

    @Field("profile")
    private String profile;

    @Field("created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    private Integer version;
}
