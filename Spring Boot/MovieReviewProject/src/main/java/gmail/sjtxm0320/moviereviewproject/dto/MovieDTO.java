package gmail.sjtxm0320.moviereviewproject.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long mno;
    private String title;

    // builder()라는 메서드를 이용해서 생성할 때 기본으로 사용
    @Builder.Default
    private List<MovieImageDTO> imageDTOList = new ArrayList<>();
}
