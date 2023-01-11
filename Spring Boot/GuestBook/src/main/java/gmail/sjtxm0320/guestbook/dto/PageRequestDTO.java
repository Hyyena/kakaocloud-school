package gmail.sjtxm0320.guestbook.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private int page;
    private int size;

    public PageRequestDTO() {
        // 기본값 설정
        this.page = 1;
        this.size = 10;
    }

    // Repository에 전달할 Pageable 객체를 만들어주는 메서드
    public PageRequest getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
