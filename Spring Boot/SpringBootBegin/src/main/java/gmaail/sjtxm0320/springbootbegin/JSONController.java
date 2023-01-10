package gmaail.sjtxm0320.springbootbegin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import gmaail.sjtxm0320.springbootbegin.dto.ParamDTO;

@RestController
// 공통된 URL
@RequestMapping("/api/v1/rest")
public class JSONController {
    private final Logger LOGGER = (Logger)LoggerFactory.getLogger(JSONController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info(" /hello 요청");
        
        return "Hello";
    }

    // Spring 4.3에서 추가된 요청 처리 어노테이션
    @GetMapping("/newhello")
    public String newHello() {
        return "New Hello";
    }

    @GetMapping("/product/{num}")
    public String getNum(@PathVariable("num") int num) {
        return "num: " + num;
    }

    @GetMapping("/param")
    public String getParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String organization = request.getParameter("organization");

        return "name: " + name + ", email: " + email + ", organization : " + organization;
    }

    @GetMapping("/param1")
    public String getParam(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("organization") String organization
    ) {
        return "name: " + name + ", email: " + email + ", organization : " + organization;
    }

    @GetMapping("/param2")
    public String getParam(
        ParamDTO paramDTO
    ) {
        return "name: " + paramDTO.getName() + ", email: " + paramDTO.getEmail() + ", organizatioin: "
            + paramDTO.getOrganization();
    }

    @PostMapping("/param")
    public String getPostParam(@RequestBody ParamDTO paramDTO) {
        return paramDTO.toString();
    }

    @PutMapping("param")
    public String getPutParam(@RequestBody ParamDTO paramDTO) {
        return paramDTO.toString();
    }

    @PutMapping("/param1")
    public ParamDTO getPutParam1(@RequestBody ParamDTO paramDTO) {
        return paramDTO;
    }

    @PutMapping("/param2")
    public ResponseEntity<ParamDTO> getPutParam2(@RequestBody ParamDTO paramDTO) {
        // 상태 코드를 설정해서 결과를 리턴하는 것이 가능하다.
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paramDTO);
    }

    @DeleteMapping("/prodcut/{num}")
    public String DeleteNum(@PathVariable("num") int num) {
        return "num: " + num;
    }

    @DeleteMapping("/product")
    public String DeleteParamNum(@RequestParam("num") int num) {
        return "num: " + num;
    }
}
