package gmail.sjtxm0320.boardproject.service;

import gmail.sjtxm0320.boardproject.domain.Board;
import gmail.sjtxm0320.boardproject.domain.Member;
import gmail.sjtxm0320.boardproject.dto.BoardDTO;
import gmail.sjtxm0320.boardproject.dto.PageRequestDTO;
import gmail.sjtxm0320.boardproject.dto.PageResponseDTO;

public interface BoardService {
    // 게시글 등록
    Long register(BoardDTO dto);

    // 게시글 목록 보기
    PageResponseDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    // 게시글 상세 보기
    BoardDTO get(Long bno);

    // 게시글 번호를 가지고 댓글 삭제
    void removeWithReplies(Long bno);

    // 게시글 수정
    Long modify(BoardDTO dto);

    // DTO -> Entity 변환 메서드
    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder().email(dto.getAuthorEmail()).build();

        Board board = Board.builder()
            .bno(dto.getBno())
            .title(dto.getTitle())
            .content(dto.getContent())
            .author(member)
            .build();

        return board;
    }

    // Entity -> DTO 변환 메서드
    default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {
        BoardDTO dto = BoardDTO.builder()
            .bno(board.getBno())
            .title(board.getTitle())
            .content(board.getContent())
            .regDate(board.getRegDate())
            .modDate(board.getModDate())
            .authorEmail(member.getEmail())
            .authorName(member.getName())
            .replyCount(replyCount.intValue())
            .build();

        return dto;
    }
}
