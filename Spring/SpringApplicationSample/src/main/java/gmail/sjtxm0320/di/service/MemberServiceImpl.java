package gmail.sjtxm0320.di.service;

import di.dto.MemberDTO;
import di.entity.MemberEntity;
import di.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

//final 속성으로 만들어진 속성들에 동일한 자료형의 bean이 있으면
//생성자를 이용해서 자동 주입
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	//Service는 Repository를 주입받아서 사용
	//setter 메서드를 생성해주고
	//동일한 자료형의 bean이 있으면 자동으로 주입
	//@Autowired
	private final MemberRepository memberRepository;
	
	@Override
	public MemberDTO findById(String id) {
		//Repository에 필요한 매개변수 생성
		
		//Repository 메서드 호출
		MemberEntity memberEntity = 
				memberRepository.findById(id);
		
		//Controller에게 전달할 데이터를 생성
		MemberDTO memberDTO = MemberDTO.builder()
				.id(memberEntity.getId())
				.password(memberEntity.getPassword())
				.nickname(memberEntity.getNickname())
				.build();
		
		return memberDTO;
	}

}



