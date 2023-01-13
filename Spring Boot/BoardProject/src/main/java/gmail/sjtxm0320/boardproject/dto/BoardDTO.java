package gmail.sjtxm0320.boardproject.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;

    private String authorEmail;
    private String authorName;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private int replyCount;
}
