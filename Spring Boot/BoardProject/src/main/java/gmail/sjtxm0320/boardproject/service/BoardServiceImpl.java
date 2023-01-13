package gmail.sjtxm0320.boardproject.service;

import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gmail.sjtxm0320.boardproject.domain.Board;
import gmail.sjtxm0320.boardproject.domain.Member;
import gmail.sjtxm0320.boardproject.dto.BoardDTO;
import gmail.sjtxm0320.boardproject.dto.PageRequestDTO;
import gmail.sjtxm0320.boardproject.dto.PageResponseDTO;
import gmail.sjtxm0320.boardproject.persistence.BoardRepository;
import gmail.sjtxm0320.boardproject.persistence.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public Long register(BoardDTO dto) {
        log.info("Service: " + dto);

        Board board = dtoToEntity(dto);
        boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public PageResponseDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        // Entity를 DTO로 변경하는 람다 인스턴스 생성
        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));

        // 목록 보기 요청 처리
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(
            pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResponseDTO<>(result, fn);
    }

    public BoardDTO get(Long bno) {
        Object result = boardRepository.getBoardByBno(bno);
        Object[] arr = (Object[])result;

        return entityToDTO((Board)arr[0], (Member)arr[1], (Long)arr[2]);
    }

    // 2가지가 연쇄적으로 삭제되기 때문에 트랜잭션을 적용해야 한다.
    @Transactional
    public void removeWithReplies(Long bno) {
        // 댓글 삭제
        replyRepository.deleteByBno(bno);

        // 게시글 삭제
        boardRepository.deleteById(bno);
    }

    @Transactional
    public Long modify(BoardDTO dto) {
        // JPA에서는 삽입과 수정 메서드가 동일하다.
        // upsert(있으면 수정, 없으면 삽입)를 하고자 하는 경우 save를 호출하면 되지만
        // update를 하고자 하면 데이터가 있는지 확인한 후 수행하는 것이 좋다.

        // 데이터 존재 여부 확인
        Optional<Board> board = boardRepository.findById(dto.getBno());

        // 데이터가 존재하지 않는 경우
        if (dto.getBno() == null || board.isEmpty()) {
            return 0L;
        }

        // 데이터가 존재하는 경우
        board.get().changeTitle(dto.getTitle());
        board.get().changeContent(dto.getContent());

        boardRepository.save(board.get());

        return board.get().getBno();
    }
}
