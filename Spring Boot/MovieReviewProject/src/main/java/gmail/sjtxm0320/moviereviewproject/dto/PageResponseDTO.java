package gmail.sjtxm0320.moviereviewproject.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResponseDTO<DTO, EN> {
    private List<DTO> dtoList;

    private int totalPage;
    private int page;
    private int size;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    private List<Integer> pageList;

    public PageResponseDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber();
        this.size = pageable.getPageSize();

        int tmpEnd = (int)(Math.ceil(page / 10.0)) * 10;
        start = tmpEnd - 9;
        prev = start > 1;
        end = Math.min(totalPage, tmpEnd);
        next = totalPage > tmpEnd;
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
