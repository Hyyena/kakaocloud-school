package gmail.sjtxm0320.guestbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gmail.sjtxm0320.guestbook.domain.GuestBook;
import gmail.sjtxm0320.guestbook.dto.GuestBookDTO;
import gmail.sjtxm0320.guestbook.dto.PageRequestDTO;
import gmail.sjtxm0320.guestbook.dto.PageResponseDTO;
import gmail.sjtxm0320.guestbook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class JSONController {
    private final GuestBookService guestBookService;

    @GetMapping("/guestbook/list.json")
    public PageResponseDTO<GuestBookDTO, GuestBook> list(PageRequestDTO pageRequestDTO) {
        return guestBookService.getList(pageRequestDTO);
    }
}
