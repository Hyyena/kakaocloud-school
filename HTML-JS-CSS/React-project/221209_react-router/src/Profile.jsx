import { useParams } from "react-router-dom";

// 출력할 데이터 생성
const data = {
  hyyena: {
    name: "하이예나",
    description: "하이에나에서 따옴",
  },
  yena: {
    name: "예나",
    description: "오리",
  },
  chaewon: {
    name: "채원",
    description: "쌈무",
  },
};

const Profile = () => {
  // URL 파라미터 읽기
  const params = useParams();

  // 데이터 찾아오기
  // username이라는 파라미터를 찾아온다.
  const profile = data[params.username];
  return (
    <div>
      <h1>User Profile</h1>
      {profile ? (
        <div>
          <h2>{profile.name}</h2>
          <p>{profile.description}</p>
        </div>
      ) : (
        <p>❌ User Not Found ❌</p>
      )}
    </div>
  );
};

export default Profile;
