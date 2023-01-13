package gmail.sjtxm0320.boardproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gmail.sjtxm0320.boardproject.dto.PageRequestDTO;
import gmail.sjtxm0320.boardproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 기본 요청 생성
    @GetMapping({"/", "/board/list"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("기본 목록 보기 요청");
        model.addAttribute("result", boardService.getList(pageRequestDTO));

        return "board/list";
    }
}
