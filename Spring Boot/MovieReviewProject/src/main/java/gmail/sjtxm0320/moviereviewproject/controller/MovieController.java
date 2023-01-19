package gmail.sjtxm0320.moviereviewproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gmail.sjtxm0320.moviereviewproject.dto.MovieDTO;
import gmail.sjtxm0320.moviereviewproject.dto.PageRequestDTO;
import gmail.sjtxm0320.moviereviewproject.dto.PageResponseDTO;
import gmail.sjtxm0320.moviereviewproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/register")
    public void register() {
    }

    @PostMapping("/register")
    public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes) {
        log.info("movieDTO: " + movieDTO);

        Long mno = movieService.register(movieDTO);
        redirectAttributes.addFlashAttribute("message", mno + "Success to insert");

        return "redirect:/movie/list";
    }

    @GetMapping("/list")
    public void List(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO pageResponseDTO = movieService.getList(pageRequestDTO);
        model.addAttribute("result", pageResponseDTO);
    }
}
