package gmail.sjtxm0320.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmail.sjtxm0320.guestbook.domain.GuestBook;
import gmail.sjtxm0320.guestbook.dto.GuestBookDTO;
import gmail.sjtxm0320.guestbook.dto.PageRequestDTO;
import gmail.sjtxm0320.guestbook.dto.PageResponseDTO;

@SpringBootTest
class GuestServiceImplTest {
    @Autowired
    private GuestBookService guestBookService;

    @Test
    public void testRegister() {
        GuestBookDTO dto = GuestBookDTO.builder()
            .title("Sample Title")
            .content("Sample Content")
            .writer("Hyyyena")
            .build();
        System.out.println(guestBookService.register(dto));
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<GuestBookDTO, GuestBook> result = guestBookService.getList(pageRequestDTO);

        for (GuestBookDTO dto : result.getDtoList()) {
            System.out.println(dto);
        }
    }

    @Test
    public void testListInformation() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<GuestBookDTO, GuestBook> result = guestBookService.getList(pageRequestDTO);

        // 데이터 확인
        // 데이터 목록
        System.out.println(result.getDtoList());

        // 페이지 목록
        System.out.println(result.getTotalPage());

        // 이전 여부
        System.out.println(result.isPrev());

        // 다음 여부
        System.out.println(result.isNext());
    }
}
