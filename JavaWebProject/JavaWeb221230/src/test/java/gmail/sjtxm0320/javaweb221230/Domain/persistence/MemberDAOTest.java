package gmail.sjtxm0320.javaweb221230.Domain.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gmail.sjtxm0320.javaweb221230.Domain.MemberVO;

public class MemberDAOTest {
    @Test
    public void daoTest() {
        MemberDAO dao = MemberDAO.getInstance();
        System.out.println(dao);

        MemberVO result = dao.login("user", "3333");

        MemberVO test1 = dao.login("user", "3333");
        MemberVO test2 = dao.login("user", "3333");

        Assertions.assertEquals(result, test1);
        Assertions.assertEquals(result, test2);

        System.out.println(dao.login("user", "1111"));
        System.out.println(dao.login("1234", "3333"));
    }
}
