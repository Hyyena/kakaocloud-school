package gmail.sjtxm0320.javaweb221230.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gmail.sjtxm0320.javaweb221230.dto.MemberDTO;

class MemberServiceTest {
    private MemberDTO result;
    private MemberDTO test1;

    @Test
    public void serviceTest() {
        MemberService service = MemberServiceImpl.getInstance();

        result = service.login("user", "3333");
        test1 = service.login("user1", "3333");

        Assertions.assertEquals(result, test1);
    }
}
