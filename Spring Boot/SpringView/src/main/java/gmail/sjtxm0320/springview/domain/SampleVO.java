package gmail.sjtxm0320.springview.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SampleVO {
    private Long sno;
    private String first;
    private String last;

    private LocalDateTime regTime;
}
