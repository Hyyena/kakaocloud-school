package gmail.sjtxm0320.di.controller;

import di.service.MemberService;
import lombok.RequiredArgsConstructor;

//Controller는 다른 클래스에 주입되지 않기 때문에 
//템플릿 메서드 패턴을 사용하지 않음
@RequiredArgsConstructor
public class MemberController {
	//Service를 주입
	//@Autowired
	private final MemberService memberService;
	
	public void findById(String id) {
		System.out.println(memberService.findById(id));
	}
}
