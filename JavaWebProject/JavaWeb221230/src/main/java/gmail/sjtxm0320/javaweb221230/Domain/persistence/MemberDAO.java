package gmail.sjtxm0320.javaweb221230.Domain.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gmail.sjtxm0320.javaweb221230.Domain.MemberVO;

public class MemberDAO {
    private static MemberDAO dao;

    // 데이터베이스 접속 코드
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // 데이터베이스 사용을 위한 속성
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 데이터베이스 연결
    {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hyyena", "hyyena", "3359");
            System.out.println("Loaded Database");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    // 싱글톤 패턴을 위한 코드(Spring에서는 필요 없음)
    private MemberDAO() {
    }

    public static MemberDAO getInstance() {
        if (dao == null) {
            dao = new MemberDAO();
        }
        return dao;
    }

    // 로그인 처리를 위한 메서드
    // 아이디와 비밀번호를 받아서 처리한 후 회원 정보를 리턴
    public MemberVO login(String mid, String mpw) {
        MemberVO vo = null;

        try {
            // 수행할 SQL 생성
            String sql = "select * from tbl_member " + "where mid=? and mpw=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.setString(2, mpw);

            // SQL 실행
            rs = pstmt.executeQuery();

            if (rs.next()) {
                vo = new MemberVO();
                vo.setMid(rs.getString("mid"));
                vo.setMname(rs.getString("mname"));
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return vo;
    }
}
