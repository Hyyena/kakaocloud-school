package gmail.sjtxm0320.boardproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmail.sjtxm0320.boardproject.dto.BoardDTO;
import gmail.sjtxm0320.boardproject.dto.PageRequestDTO;
import gmail.sjtxm0320.boardproject.dto.PageResponseDTO;

@SpringBootTest
class BoardServiceImplTest {
    @Autowired
    private BoardService boardService;

    // 등록 테스트
    @Test
    public void registerTest() {
        BoardDTO dto = BoardDTO.builder()
            .title("Register Test")
            .content("Testing")
            .authorEmail("user1@gmail.com") // 현재 데이터베이스에 존재하는 회원 이메일
            .build();

        Long bno = boardService.register(dto);
        System.out.println(bno);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResponseDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        System.out.println(result);
    }

    @Test
    public void testGet() {
        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);

        System.out.println(boardDTO);
    }

    @Test
    public void testDelete() {
        boardService.removeWithReplies(509L);
    }

    @Test
    public void testUpdate() {
        BoardDTO dto = BoardDTO.builder().bno(99L).title("Change Title").content("Change Content").build();

        System.out.println(boardService.modify(dto));
    }
}
