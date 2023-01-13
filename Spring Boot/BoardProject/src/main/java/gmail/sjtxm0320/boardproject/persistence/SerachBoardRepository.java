package gmail.sjtxm0320.boardproject.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gmail.sjtxm0320.boardproject.domain.Board;

interface SearchBoardRepository {
    Board search1();

    // 검색을 위한 메서드
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
