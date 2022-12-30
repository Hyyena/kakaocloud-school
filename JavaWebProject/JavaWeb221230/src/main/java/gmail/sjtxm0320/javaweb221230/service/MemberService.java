package gmail.sjtxm0320.javaweb221230.service;

import gmail.sjtxm0320.javaweb221230.dto.MemberDTO;

public interface MemberService {
    // 로그인 처리를 위한 메서드
    public MemberDTO login(String mid, String mpw);
}
