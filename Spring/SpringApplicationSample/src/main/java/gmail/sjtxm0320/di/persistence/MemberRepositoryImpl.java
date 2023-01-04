package gmail.sjtxm0320.di.persistence;

import di.entity.MemberEntity;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public MemberEntity findById(String id) {
		MemberEntity memberEntity = 
				MemberEntity.builder()
					.id("adam")
					.password("1234")
					.nickname("군계")
					.build();
		return memberEntity;
	}

}
