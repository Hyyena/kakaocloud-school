package gmail.sjtxm0320.javaweb221230.service;

import gmail.sjtxm0320.javaweb221230.Domain.MemberVO;
import gmail.sjtxm0320.javaweb221230.Domain.persistence.MemberDAO;
import gmail.sjtxm0320.javaweb221230.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
    private static MemberService service;

    // DAO 변수
    private final MemberDAO memberDAO;

    private MemberServiceImpl() {
        memberDAO = MemberDAO.getInstance();
    }

    public static MemberService getInstance() {
        if (service == null) {
            service = new MemberServiceImpl();
        }
        return service;
    }

    @Override
    public MemberDTO login(String mid, String mpw) {
        MemberDTO dto = null;

        MemberVO vo = memberDAO.login(mid, mpw);

        // vo를 dto로 변환
        if (vo != null) {
            dto = new MemberDTO();
            dto.setMid(vo.getMid());
            dto.setMname(vo.getMname());
        }

        return dto;
    }
}
