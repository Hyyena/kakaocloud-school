package gmail.sjtxm0320.oop;

import java.util.Date;

public class ConstructorMain {
    public static void main(String[] args) {
        // 인스턴스 생성
        Member member = new Member();

        member.setEmail("sjtxm0320@gmail.com");
        member.setPassword("1234");
        member.setMarried(true);
        member.setAge(27);

        // 오늘 날짜
        // member.setBirthday(new Date());

        // 1996년 4월 23일
        member.setBirthday(new Date(96, 5, 23));

        String[] nicknames = {"예나", "채원"};
        member.setNicknames(nicknames);

        System.out.println(member);

        // 초기화 메서드 생성
        Member member1 = new Member();
        member1.init("sjtxm0320@gmail.com", "1234", nicknames, new Date(), false, 27);
        System.out.println(member1);

        // 생성자를 이용한 초기화
        Member member2 = new Member("sjtxm0320@gmail.com", "1234", nicknames, new Date(), false, 27);
        System.out.println(member2);
    }
}
