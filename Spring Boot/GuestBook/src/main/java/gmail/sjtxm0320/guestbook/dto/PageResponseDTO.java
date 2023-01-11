package gmail.sjtxm0320.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

// 다른 종류의 Entity에서도 사용할 수 있도록 하기 위해 Generic 사용
// DTO는 결과를 출력할 때 사용할 데이터 클래스
// EN은 변환에 사용할 메서드를 소유한 클래스
@Data
public class PageResponseDTO<DTO, EN> {
    // 데이터 목록
    private List<DTO> dtoList;

    // 전체 페이지 개수
    private int totalPage;

    // 현재 페이지 번호
    private int page;

    // 하나의 페이지에 출력할 데이터 개수
    private int size;

    // 페이지 번호에서 시작하는 페이지 번호와 끝나는 페이지 번호
    private int start;
    private int end;

    // 이전과 다음 여부
    private boolean prev;
    private boolean next;

    // 페이지 번호 목록
    private List<Integer> pageList;

    // Page를 함수를 적용해 List로 변환해주는 메서드
    // Page 단위의 Entity를 받아서 DTO의 List로 변환
    public PageResponseDTO(Page<EN> result, Function<EN, DTO> fn) {
        // EN(Entity)과 DTTO(클래스 타입)을 변환해주는 함수를 매개변수로 받아서
        // DTO 타입의 List로 변환해주는 것
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        // 전체 페이지 개수
        totalPage = result.getTotalPages();

        // 페이지 목록 메서드 호출
        makePageList(result.getPageable());
    }

    // Paging 결과를 가지고 추가한 항목들을 계산해주는 메서드
    private void makePageList(Pageable pageable) {
        // 현재 페이지 번호
        // JPA는 페이지 번호가 0부터 시작하기 때문에 +1을 해준다.
        this.page = pageable.getPageNumber() + 1;

        // 페이지 당 데이터 개수
        this.size = pageable.getPageSize();

        // 임시로 마지막 페이지 ㅂ번호를 생성
        // 페이지 번호 10개 출력
        // 10으로 나누어서 소수가 있으면 올림을 하고, 곱하기 10
        int tempEnd = (int)(Math.ceil(page / 10.0)) * 10;

        // 시작하는 번호
        start = tempEnd - 9;

        // 이전 여부
        prev = start > 1;

        // 마지막 페이지 번호 계산
        end = Math.min(totalPage, tempEnd);

        // 다음 여부
        next = totalPage > tempEnd;

        // 페이지 번호 목록
        // start부터 end 까지를 스트림으로 만들어서 List로 변환
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }

}
